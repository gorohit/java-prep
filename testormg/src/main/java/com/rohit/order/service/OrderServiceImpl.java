package com.rohit.order.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.rohit.order.bean.ItemIn;
import com.rohit.order.bean.Levy;
import com.rohit.order.bean.OrderOut;
import com.rohit.order.bean.OrderRequest;
import com.rohit.order.bean.OrderResponse;
import com.rohit.order.dao.ItemDao;
import com.rohit.order.model.Item;

public class OrderServiceImpl implements OrderService {

	@Autowired
	ItemDao itemDao;

	@Override
	public OrderResponse createFinalOrder(OrderRequest orderRequest) {
		// TODO Auto-generated method stub

		OrderResponse orderResponse = new OrderResponse();
		List<OrderOut> lstOrderOut = new ArrayList<>();
		double finalTotal = 0;
		double finalTax = 0;

		List<ItemIn> lstItemIn = orderRequest.getLstItmeIn();
		for (ItemIn itemIn : lstItemIn) {
			long itemId = itemIn.getId();
			Item item = getItem(itemId);
			int quantity = itemIn.getQuantity();
			OrderOut orderOut = createOrderOut(item, quantity);
			lstOrderOut.add(orderOut);
			double total = orderOut.getTotal();
			finalTotal = finalTotal + total;
			double tax = orderOut.getTax();
			finalTax = finalTax + tax;
		}
		orderResponse.setLstOrderOut(lstOrderOut);
		orderResponse.setFinalTotal(finalTotal);
		orderResponse.setFinalTax(finalTax);
		orderResponse.setGrandTotal(finalTotal + finalTax);

		return orderResponse;
	}

	private Item getItem(long itemId) {
		Item item = null;
		try {
			item = itemDao.getItemDetails(itemId);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return item;
	}

	private OrderOut createOrderOut(Item item, int quantity) {
		String itemCategory = item.getItemCategory();
		double percent = Levy.valueOf(itemCategory).percent;
		long price = item.getItemPrice();
		double tax = ((price * percent) / 100) * quantity;
		OrderOut orderOut = new OrderOut();
		orderOut.setItemDescription(item.getItemDescription());
		long total = price * quantity;
		orderOut.setTotal(total);
		orderOut.setTax(tax);
		return orderOut;
	}

}
