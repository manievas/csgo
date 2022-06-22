package com.csgo.entity;

import com.csgo.counter.Counter;
import com.csgo.counter.ParameterizedCounter;

public abstract class Event {

	private int value;
		
	private Round round;
	
	//Constructor
	public Event(int value, Round round) {
		this.value = value;
		this.round = round;
	}

	//Methods
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Round getRound() {
		return round;
	}

	public void setRound(Round round) {
		this.round = round;
	}	
	
	abstract public int receiveCounter(Counter counter, ParameterizedCounter f);
	
}
