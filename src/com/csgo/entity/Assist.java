package com.csgo.entity;

import com.csgo.counter.Counter;
import com.csgo.counter.ParameterizedCounter;

public class Assist extends Event{
		
	public Assist(int value, Round round) {
		super(value, round);		
	}
	
    @Override
    public String toString() {
        return "Event: Assist";
    }

	@Override
	public int receiveCounter(Counter counter, ParameterizedCounter f) {
		return counter.receiveCounter(this, f);
	}
}
