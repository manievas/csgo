package com.csgo.entity;

import com.csgo.counter.Counter;

public class Assist extends Event{
		
	public Assist(int value, Round round) {
		super(value, round);		
	}
	
    @Override
    public String toString() {
        return "Event: Assist";
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.receiveCounter(this);
	}
}
