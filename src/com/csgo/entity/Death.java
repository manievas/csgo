package com.csgo.entity;

public class Death extends Event {

	private Player player;
	
	private int score;
	
	public Death(int value, Player player) {
		super(value);		
		this.player = player;
		this.score = value;			
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	public int getScore(){
		return this.score;
	}
	
    @Override
    public String toString() {
        return "Death " + this.player.getName() + " Score: " + getScore();
    }
}
