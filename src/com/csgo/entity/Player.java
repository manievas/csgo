package com.csgo.entity;

import java.util.ArrayList;
import java.util.List;

import com.csgo.counter.AssistCounter;
import com.csgo.counter.DeathCounter;
import com.csgo.counter.DefuseBombCounter;
import com.csgo.counter.KillCounter;
import com.csgo.counter.PlantBombCounter;
import com.csgo.counter.SuicideCounter;
import com.csgo.counter.TeamKillCounter;

public class Player {

	//Attributes
	private String name;
	
	private String nickname;
	
	private List<Event> events;

	
	//Constructor
	public Player(String name, String nickname) {
		this.name = name;
		this.nickname = nickname;
		this.events = new ArrayList<Event>();
	}

    //Methods
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void addEvent(Event event) {
		this.events.add(event);
	}
	
	public List<Event> getEvents() {
		return this.events;
	}
	
	@Override
	public String toString(){
		return this.name;
	}
	
	public int getKillsValue() {
        return new KillCounter(this.events).doCount(k -> k.getValue());
    }

	public int getKillsCount() {
        return new KillCounter(this.events).doCount(k -> 1);
    }

	public int getAssistsValue() {
        return new AssistCounter(this.events).doCount(k -> k.getValue());
    }
	
	public int getAssistsCount() {
        return new AssistCounter(this.events).doCount(k -> 1);
	}
	
	public int getSuicideValue() {
        return new SuicideCounter(this.events).doCount(k -> k.getValue());
    }
	
	public int getSuicideCount() {
        return new SuicideCounter(this.events).doCount(k -> 1);
	}
	
	public int getTeamKillsValue() {
        return new TeamKillCounter(this.events).doCount(k -> k.getValue());
    }
	
	public int getTeamKillsCount() {
        return new TeamKillCounter(this.events).doCount(k -> 1);
	}
	
	public int getDefuseBombValue() {
        return new DefuseBombCounter(this.events).doCount(k -> k.getValue());
    }
	
	public int getDefuseBombCount() {
        return new DefuseBombCounter(this.events).doCount(k -> 1);
	}
	
	public int getPlantBombValue() {
        return new PlantBombCounter(this.events).doCount(k -> k.getValue());
    }
	
	public int getPlantBombCount() {
        return new PlantBombCounter(this.events).doCount(k -> 1);
	}
	
	public int getDeathsValue() {
        return new DeathCounter(this.events).doCount(k -> k.getValue());
    }
	
	public int getDeathsCount() {
        return new DeathCounter(this.events).doCount(k -> 1);
	}
	
}
