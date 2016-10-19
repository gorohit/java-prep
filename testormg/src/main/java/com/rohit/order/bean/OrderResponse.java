package com.rohit.order.bean;

import java.util.List;

public class OrderResponse {
	private List<OrderOut> lstOrderOut;
	private double finalTotal;
	private double finalTax;
	private double grandTotal;

	public double getGrandTotal() {
		return grandTotal;
	}

	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}

	public double getFinalTotal() {
		return finalTotal;
	}

	public void setFinalTotal(double finalTotal) {
		this.finalTotal = finalTotal;
	}

	public double getFinalTax() {
		return finalTax;
	}

	public void setFinalTax(double finalTax) {
		this.finalTax = finalTax;
	}

	public List<OrderOut> getLstOrderOut() {
		return lstOrderOut;
	}

	public void setLstOrderOut(List<OrderOut> lstOrderOut) {
		this.lstOrderOut = lstOrderOut;
	}
}
