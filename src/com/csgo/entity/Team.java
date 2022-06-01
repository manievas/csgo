package com.csgo.entity;

import java.util.List;

public class Team {
	
	//Attributes
	
	private List<Player> players;

	//Constructor
	public Team(List<Player> players) {		
		this.players = players;
	}

	//Methods

	public List<Player> getPlayers() {
		return players;
	}

	public void addPlayers(Player player) {
		this.players.add(player);
	}


}
