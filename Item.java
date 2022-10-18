package com.market.machine.utility;

public enum Item {
	Coke(25), Pepsi(25), Soda(45), CornChat(90), Beer(180);

	private int price;

	Item(int price) {
		this.price = price;
	}

	public int getPrice() {
		return price;
	}
}
