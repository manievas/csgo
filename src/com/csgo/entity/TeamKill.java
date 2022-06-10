package com.csgo.entity;

import com.csgo.counter.Counter;

public class TeamKill extends Event{
	
	public TeamKill(int value, Round round) {
		super(value, round);
	}

	@Override
    public String toString() {
        return "Event: TeamKill";
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.receiveCounter(this);
	}
}
