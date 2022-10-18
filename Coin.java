package com.market.machine.utility;

import java.util.ArrayList;
import java.util.List;

public enum Coin {
quarter(25),dime(10),nickel(5),penny(1);
	private int value;

	private Coin(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}

	public static List<Coin> parseCoins(String coins){
        String[] numberCoinsInText = coins.split(",");
        
        List<Coin> enteredCoins=new ArrayList<>();
        for(int index=0;index<numberCoinsInText.length;index++){
        	switch(numberCoinsInText[index]){
        	case "1":
        		enteredCoins.add(Coin.penny);
        		break;
        	case "5":
        		enteredCoins.add(Coin.nickel);
        		break;
        	case "10":
        		enteredCoins.add(Coin.dime);
        		break;
        	case "25":
        		enteredCoins.add(Coin.quarter);
        		break;
        	}
        		
        	
        }
        return enteredCoins;
    }
	
}
