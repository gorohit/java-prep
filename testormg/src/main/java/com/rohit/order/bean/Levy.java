package com.rohit.order.bean;

public enum Levy {

	A(10), B(20), C(0);

	public double percent;

	Levy(double p) {
		percent = p;
	}

	double showPercent() {
		return percent;
	}

}
