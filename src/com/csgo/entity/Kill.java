
package com.csgo.entity;

import com.csgo.counter.Counter;

public class Kill extends Event{
		
	public Kill(int value, Round round) {
		super(value, round);		
	}

    @Override
    public String toString() {
        return "Event: Kill";
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.receiveCounter(this);
	}
	
}
