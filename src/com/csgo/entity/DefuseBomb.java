package com.csgo.entity;

import com.csgo.counter.Counter;

public class DefuseBomb extends Event{
	
	private int score;
	
	public DefuseBomb(int value, Player player) {
		super(value, player);
		this.score = value;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
    @Override
    public String toString() {
        return "Event: DefuseBomb - Score: " + getScore();
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.count(this);
	}
}
