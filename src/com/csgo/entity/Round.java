package com.csgo.entity;

public class Round {

	//Attributes
	private String status;
	
	private Team winner;

	//Constructor
	public Round(String status) {
		this.status = status;
	}
	
	//Methods
	public Team getWinner() {
		return this.winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
	public String getStatus() {
		return this.status;
	}

	public void endRound(String status, Team winner)	{
		this.status = status;
		this.winner = winner;
	}
	
}
