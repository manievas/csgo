package com.csgo.entity;

import com.csgo.counter.Counter;

public class Death extends Event {

	
	public Death(int value, Round round) {
		super(value, round);	
	}
		
    @Override
    public String toString() {
        return "Event: Death";
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.receiveCounter(this);
	}
}
