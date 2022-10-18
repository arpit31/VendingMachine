package com.market.machine.utility;

import java.util.HashMap;
import java.util.Map;

public class Inventory<T> {

	private Map<T,Integer> map=new HashMap<>();

	public Inventory() {
	}

	public Map<T, Integer> getMap() {
		return map;
	}

	public void setMap(Map<T, Integer> map) {
		this.map = map;
	}
	
	public void add(T key){
		if(map.get(key)!=null)
			map.put(key,map.get(key)+1);
		else
			map.put(key, 1);
	}
	
	public void deduct(T key){
		if(map.get(key)!=null)
			map.put(key, map.get(key)-1);
	}
	
	public boolean hasItem(T key){
		if(map.get(key) != null)
			return true;
		return false;
	}
	
	public void putItem(T item, int quantity){
	map.put(item, quantity);
	}
}
