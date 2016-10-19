package com.rohit.order.bean;

import java.util.List;

public class OrderRequest {
	private List<ItemIn> lstItmeIn;

	public List<ItemIn> getLstItmeIn() {
		return lstItmeIn;
	}

	public void setLstItmeIn(List<ItemIn> lstItmeIn) {
		this.lstItmeIn = lstItmeIn;
	}
}
