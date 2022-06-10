package com.csgo.entity;

import com.csgo.counter.Counter;

public class PlantBomb extends Event {

	public PlantBomb(int value, Round round) {
		super(value, round);
	}

    @Override
    public String toString() {
        return "Event: PlantBomb";
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.receiveCounter(this);
	}
}
