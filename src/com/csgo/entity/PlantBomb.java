package com.csgo.entity;

import com.csgo.counter.Counter;
import com.csgo.counter.ParameterizedCounter;

public class PlantBomb extends Event {

	public PlantBomb(int value, Round round) {
		super(value, round);
	}

    @Override
    public String toString() {
        return "Event: PlantBomb";
    }

	@Override
	public int receiveCounter(Counter counter, ParameterizedCounter f) {
		return counter.receiveCounter(this, f);
	}
}
