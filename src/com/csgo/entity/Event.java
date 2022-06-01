package com.csgo.entity;

import java.util.List;

public class Event {

	//Attributes
	private int assists;
	
	private int death;
	
	private int kills;
	
	private int mvp;
	
	private Player player;

	
	//Constructor
	public Event(int assists, int death, int kills, int mvp, Player player) {
		this.assists = assists;
		this.death = death;
		this.kills = kills;
		this.mvp = mvp;
		this.player = player;
	}

	//Methods
	public int getAssists() {
		return assists;
	}

	public void setAssists(int assists) {
		this.assists = assists;
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}

	public int getKills() {
		return kills;
	}

	public void setKills(int kills) {
		this.kills = kills;
	}

	public int getMvp() {
		return mvp;
	}

	public void setMvp(int mvp) {
		this.mvp = mvp;
	}

	public Player getPlayer() {
		return player;
	}

	public void setPlayer(Player player) {
		this.player = player;
	}
	
	
	
	
}
