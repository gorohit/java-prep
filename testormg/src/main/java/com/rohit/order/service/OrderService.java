package com.rohit.order.service;

import com.rohit.order.bean.OrderRequest;
import com.rohit.order.bean.OrderResponse;

public interface OrderService {

	public OrderResponse createFinalOrder(OrderRequest orderRequest);

}
