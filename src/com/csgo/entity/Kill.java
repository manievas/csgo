
package com.csgo.entity;

public class Kill extends Event{

	private Player player;
	
	private int count;
	
	private int score;
	
	public Kill(int value, Player player, int count) {
		super(value);		
		this.player = player;
		this.count = count;		
		
		calculateScore(value, this.count);	
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}

	public void calculateScore(int count, int value){
		this.score = count * value;
	}
	
	public int getScore(){
		return this.score;
	}
	
    @Override
    public String toString() {
        return this.player.getName().toString();
    }
	
	
	
}
