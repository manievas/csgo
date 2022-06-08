package com.csgo.entity;

import com.csgo.counter.Counter;

public class Suicide extends Event{
	
	private int score;
	
	public Suicide(int value, Player player) {
		super(value, player);	
		this.score = value;			
	}

	public int getScore(){
		return this.score;
	}
	
    @Override
    public String toString() {
        return "Event: Suicide - Score: " + getScore();
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.count(this);
	}
    
}
