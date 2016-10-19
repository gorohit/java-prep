package com.rohit.order.dao;

import com.rohit.order.model.Item;

public interface ItemDao {
	public Item getItemDetails(long id) throws Exception;
}
