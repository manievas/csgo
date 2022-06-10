package com.csgo.entity;

import com.csgo.counter.Counter;

public class DefuseBomb extends Event{
		
	public DefuseBomb(int value, Round round) {
		super(value, round);
	}
		
    @Override
    public String toString() {
        return "Event: DefuseBomb ";
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.receiveCounter(this);
	}
}
