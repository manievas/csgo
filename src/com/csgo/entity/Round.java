package com.csgo.entity;

import java.util.ArrayList;
import java.util.List;

public class Round {

	//Attributes
	private String status;

	private Team looser;
	
	private Team winner;
	
	private List<Team> teams;
	
	private List<Event> events;
	
	//Constructor
	public Round(List<Team> teams,  String status) {
		this.teams = teams;
		this.status = status;
		this.events = new ArrayList<Event>();
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

	public List<Event> getEvents() {
		return events;
	}

	public void addEvent(Event event) {
		this.events.add(event);
	}
		
	public void endRound(String status, Team looser, Team winner)	{
		this.status = status;
		this.looser = looser;
		this.winner = winner;
	}
	
	
	
	
}
