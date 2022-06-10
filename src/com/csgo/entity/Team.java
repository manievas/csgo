package com.csgo.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
	
	//Attributes
	private String name;
	
	private String side;
	
	private List<Player> players;

	//Constructor
	public Team(List<Player> players, String name, String side) {	
		
		this.players = new ArrayList<Player>();
		this.players = players;
		this.name = name;
		this.side = side;
	}

	//Methods
	public List<Player> getPlayers() {
		return this.players;
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
	
	public String getSide()	{
		return this.side;
	}
	
	public void setSide(String side) {
		this.side = side;
	}
}
