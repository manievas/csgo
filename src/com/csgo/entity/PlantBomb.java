package com.csgo.entity;

import com.csgo.counter.Counter;

public class PlantBomb extends Event {

	private int score;
	
	public PlantBomb(int value, Player player) {
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
        return "Event: PlantBomb - Score: " + getScore();
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.count(this);
	}
}
