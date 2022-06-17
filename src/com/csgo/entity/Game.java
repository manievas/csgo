package com.csgo.entity;

import java.util.ArrayList;
import java.util.List;

public class Game {

	private String date;
	
	private int duration;
	
	private String status;

	private Map map;
	
	private List<Round> rounds;
	
	//Constructor
	public Game(String date, String status, Map map) {
		this.date = date;
		this.status = status;		
		this.map = map;
		this.rounds = new ArrayList<Round>();
	}

	//Methods	
	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Map getMap() {
		return map;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}

	
	public List<Round> getRounds(){
		return this.rounds;
	}
	
	public void addRound (Round round) {
		this.rounds.add(round);
	}
	
	public void endGame(String status, int duration) {
		
		setStatus(status);
		setDuration(duration);
		
	}
	
	
	
}
