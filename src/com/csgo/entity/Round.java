package com.csgo.entity;

import java.util.ArrayList;
import java.util.List;

public class Round {

	//Attributes
	private String status;

	private Team looser;
	
	private Team winner;
	
	private List<Team> teams;
	
	private List<Kill> kills;
	
	//Constructor
	public Round(List<Team> teams,  String status) {
		this.teams = teams;
		this.status = status;
		this.kills = new ArrayList<Kill>();
		this.teams = new ArrayList<Team>();		
	}

	
	//Methods
	public Team getLooser() {
		return looser;
	}

	public void setLooser(Team looser) {
		this.looser = looser;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void addTeams(Team team) {
		this.teams.add(team);
	}

	public List<Kill> getKills() {
		return kills;
	}

	public void addKill(Kill kill) {
		this.kills.add(kill);
	}
	
	public void endRound(String status, Team looser, Team winner)	{
		this.status = status;
		this.looser = looser;
		this.winner = winner;
	}
	
	
	
	
}
