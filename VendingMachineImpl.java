package com.market.machine;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.market.machine.exception.NotFullPaidException;
import com.market.machine.exception.NotSufficientPaidException;
import com.market.machine.utility.Bucket;
import com.market.machine.utility.Coin;
import com.market.machine.utility.Inventory;
import com.market.machine.utility.Item;

public class VendingMachineImpl implements VendingMachine {
	
	private Inventory<Coin> coinInventory=new Inventory<Coin>();
	private Inventory<Item> itemInventory= new Inventory<>();
	private Item currentItem;
	private int totalCoins;
	private int currentAmountReceived=0;
	
	
	public Item getCurrentItem() {
		return currentItem;
	}

	public void setCurrentItem(Item currentItem) {
		this.currentItem = currentItem;
	}

	public VendingMachineImpl(){
		initialize();
	}

	private void initialize(){
		for(Coin c: Coin.values()){
		coinInventory.putItem(c, 10);
		totalCoins=totalCoins+(c.getValue()*10);
		}
		
		for(Item item:Item.values())
			itemInventory.putItem(item, 10);
	}
	
	

	@Override
	public int getProductPrice(Item item) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void selectProduct(Item item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Coin> getRefund() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Bucket<Item, List<Coin>> getProductAndChange() {
		int amountToReturn=currentAmountReceived-currentItem.getPrice();
		List<Coin> list=new ArrayList<Coin>();
		for(Coin coin: Coin.values()){
			int count=amountToReturn/coin.getValue();
			if(count>0){
			list.add(coin);
			amountToReturn=amountToReturn%coin.getValue();	
			}
		}
		itemInventory.deduct(currentItem);
		return new Bucket(currentItem,list);
	}

	@Override
	public void reset() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Item> getProducts() {
		return itemInventory.getMap().keySet().stream().collect(Collectors.toList());		 
	}

	@Override
	public void displayProducts() {		
	        System.out.println(" *********************************************");
	        System.out.println("     WELCOME TO THE VENDING MACHINE           ");
	        System.out.println(" *********************************************");
	        System.out.println("            Products available:               ");
	        System.out.println("                                              ");
	        getProducts().forEach(s-> {
	        	System.out.println(s);
	        });
	        System.out.println("Please select your product: ");
	}

	public void setItemSelected(int selected){
		setCurrentItem(getProducts().get(selected-1));
	}

	@Override
	public Item getItemSelected() {
		return currentItem;
	}
	
	public List<Coin> getCoins(){
		return coinInventory.getMap().keySet().stream().collect(Collectors.toList());
	}

	@Override
	public void insertCoin(List<Coin> list) {
		currentAmountReceived=totalCoins;
		list.forEach(s-> {
			coinInventory.add(s);
			totalCoins=totalCoins+s.getValue();
		});	
		currentAmountReceived=totalCoins-currentAmountReceived;
		if(getItemSelected().getPrice()>currentAmountReceived)
		{
			refund(list);
			throw new NotFullPaidException(getItemSelected().getPrice(),
					currentAmountReceived," Not Fully Paid Exception ");
		}
		
	}
	public void refund(List<Coin> list){
		list.forEach(s-> {
			coinInventory.deduct(s);
		});	
	}
}
