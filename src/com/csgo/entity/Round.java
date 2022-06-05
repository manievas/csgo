package com.csgo.entity;

import java.util.ArrayList;
import java.util.List;

public class Round {

	//Attributes
	private String status;
	
	private Team winner;
	
	private TT tt;
	
	private CT ct;
	
	private List<Event> events;
	
	//Constructor
	public Round(String status, CT ct, TT tt) {
		this.tt = tt;
		this.ct = ct;
		this.status = status;
		this.events = new ArrayList<Event>();
	}

	
	//Methods
	public Team getWinner() {
		return this.winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public TT getTT() {
		return this.tt;
	}

	public CT getCT() {
		return this.ct;
	}

	public List<Event> getEvents() {
		return this.events;
	}

	public void addEvent(Event event) {
		this.events.add(event);
	}
		
	public void endRound(String status, Team looser, Team winner)	{
		this.status = status;
		this.winner = winner;
	}
	
	
	
	
}
