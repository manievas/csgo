package com.csgo.entity;

import com.csgo.counter.Counter;

public class Assist extends Event{
	
	private int count;
	
	private int score;
	
	public Assist(int value, Player player, int count) {
		super(value, player);			
		
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
        return "Event: Assist - Score: " + getScore();
    }

	@Override
	public int receiveCounter(Counter counter) {
		// TODO Auto-generated method stub
		return counter.count(this);
	}
}
