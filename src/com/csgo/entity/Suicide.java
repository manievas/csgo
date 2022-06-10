package com.csgo.entity;

import com.csgo.counter.Counter;

public class Suicide extends Event{
	
	public Suicide(int value, Round round) {
		super(value, round);		
	}
	
    @Override
    public String toString() {
        return "Event: Suicide";
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.receiveCounter(this);
	}
    
}
