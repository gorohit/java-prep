package com.rohit.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rohit.order.bean.OrderRequest;
import com.rohit.order.bean.OrderResponse;
import com.rohit.order.service.OrderService;

@RestController
public class OrderManagementController {

	@Autowired
	OrderService orderService;

	// OrderService orderService = new OrderServiceImpl();

	@RequestMapping(value = "/orders", method = RequestMethod.POST, headers = "Accept=application/json")
	public OrderResponse createOrder(@RequestBody OrderRequest orderRequest) {
		return orderService.createFinalOrder(orderRequest);
	}
}