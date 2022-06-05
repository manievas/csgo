package com.csgo.entity;

public class Bomb_Defused extends Event{
	
	private Player player;
	
	private int score;
	
	public Bomb_Defused(int value, Player player) {
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

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
}
