package com.csgo.entity;

import com.csgo.counter.Counter;
import com.csgo.counter.ParameterizedCounter;

public class DefuseBomb extends Event{
		
	public DefuseBomb(int value, Round round) {
		super(value, round);
	}
		
    @Override
    public String toString() {
        return "Event: DefuseBomb ";
    }

	@Override
	public int receiveCounter(Counter counter, ParameterizedCounter f) {
		return counter.receiveCounter(this, f);
	}
}
