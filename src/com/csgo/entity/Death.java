package com.csgo.entity;

import com.csgo.counter.Counter;

public class Death extends Event {

	private int score;
	
	public Death(int value, Player player) {
		super(value, player);
		this.score = value;			
	}
	
	public int getScore(){
		return this.score;
	}
	
    @Override
    public String toString() {
        return "Event: Death - Score: " + getScore();
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.count(this);
	}
}
