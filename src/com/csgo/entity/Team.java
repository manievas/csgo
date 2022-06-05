package com.csgo.entity;

import java.util.List;

public class Team {
	
	//Attributes
	private String name;
	
	private List<Player> players;

	//Constructor
	public Team(List<Player> players, String name) {		
		this.players = players;
		this.name = name;
	}

	//Methods
	public List<Player> getPlayers() {
		return players;
	}

	public void addPlayers(Player player) {
		this.players.add(player);
	}

	public String getName()	{
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	

}
