package com.market.machine;

import java.util.List;
import java.util.Scanner;

import org.omg.Messaging.SyncScopeHelper;

import com.market.machine.utility.Bucket;
import com.market.machine.utility.Coin;
import com.market.machine.utility.Item;

public class MainClass {
	public static void main(String[] args) {
		VendingMachine vendingMachine = new VendingMachineImpl();
		vendingMachine.displayProducts();
		Scanner scanner = new Scanner(System.in);
		String selectedProduct = scanner.nextLine();
		vendingMachine.setItemSelected(Integer.parseInt(selectedProduct));
		System.out.println("Selected Item and it's cost is "+ vendingMachine.getItemSelected().name()+" "+vendingMachine.getItemSelected().getPrice());
		System.out.println("Insert Coins: ");
		System.out.println("Please insert either ");
		vendingMachine.getCoins().forEach(s-> System.out.print(s.getValue()+" "));
		String userEnteredCoins = scanner.nextLine();
		System.out.println("inserted coins are "+userEnteredCoins);
		vendingMachine.insertCoin(Coin.parseCoins(userEnteredCoins));
		Bucket<Item, List<Coin>> productAndChange= vendingMachine.getProductAndChange();
		System.out.println("Please collect item "+ productAndChange.getFirst().name());
		System.out.println(" and change ");
		productAndChange.getSecond().forEach(s-> System.out.print(s.getValue()+" "));
		
		//vendingMachine.insertCoin(coin);
		
		

	}
}