package com.csgo.entity;

import java.util.ArrayList;
import java.util.List;

import com.csgo.counter.*;

public class Round {

	//Attributes
	private String status;
	
	private Team winner;
	
	private TT tt;
	
	private CT ct;
	
	private List<Event> events;
	
	private Bomb bomb;
	
	//Constructor
	public Round(String status, CT ct, TT tt, Bomb bomb) {
		this.tt = tt;
		this.ct = ct;
		this.status = status;
		this.events = new ArrayList<Event>();
		this.bomb = bomb;
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
	
	public Bomb getBomb() {
		return this.bomb;
	}
	
	public void setBomb(String status) {
		this.bomb.setStatus(status);
	}
	
	
	public int getKillsCount() {
        return new KillCounter(this.events).doCount();
    }

	public int getAssistsCount() {
        return new AssistCounter(this.events).doCount();
	}
	
	public int getSuicidesCount() {
        return new SuicideCounter(this.events).doCount();
	}
	
	public int getTeamKillsCount() {
        return new TeamKillCounter(this.events).doCount();
	}
	
	public int getDefuseBombCount() {
        return new DefuseBombCounter(this.events).doCount();
	}
	
	public int getPlantBombCount() {
        return new PlantBombCounter(this.events).doCount();
	}
	
	public int getDeathsCount() {
        return new DeathCounter(this.events).doCount();
	}
	
	
}
