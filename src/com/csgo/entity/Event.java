package com.csgo.entity;

import com.csgo.counter.Counter;

public abstract class Event {

	private int value;
		
	private Player player;
	
	//Constructor
	public Event(int value, Player player) {
		this.value = value;
		this.player = player;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}	
	
	
	abstract public int receiveCounter(Counter counter);
	
}
