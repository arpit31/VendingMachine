package com.market.machine;

import java.util.List;

import com.market.machine.utility.Bucket;
import com.market.machine.utility.Coin;
import com.market.machine.utility.Item;

public interface VendingMachine {

	public void insertCoin(List<Coin> list);
	public int getProductPrice(Item item);
	public void selectProduct(Item item);
	public List<Coin> getRefund();
	public Bucket<Item, List<Coin>> getProductAndChange();
	public void reset();
	public List<Item> getProducts();
	public List<Coin> getCoins();
	public void displayProducts();
	public void setItemSelected(int selectedNo);
	public Item getItemSelected();
}
