package com.csgo.entity;

import com.csgo.counter.Counter;

public class TeamKill extends Event{
	
	private int count;
	
	private int score;
	
	public TeamKill(int value, Player player, int count) {
		super(value, player);
		this.count = count;		
		
		calculateScore(value, this.count);	
	}

	public void calculateScore(int count, int value){
		this.score = count * value;
	}
	
	public int getScore(){
		return this.score;
	}
	
    @Override
    public String toString() {
        return "Event: TeamKill - Score: " + getScore();
    }

	@Override
	public int receiveCounter(Counter counter) {
		return counter.count(this);
	}
}
