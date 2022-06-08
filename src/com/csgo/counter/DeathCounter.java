package com.csgo.counter;

import java.util.List;

import com.csgo.entity.Event;
import com.csgo.entity.Assist;
import com.csgo.entity.Kill;
import com.csgo.entity.DefuseBomb;
import com.csgo.entity.PlantBomb;
import com.csgo.entity.Death;
import com.csgo.entity.Suicide;
import com.csgo.entity.TeamKill;


public class DeathCounter extends Counter{
	
	public DeathCounter(List<Event> events) {
		super(events);
	}

	@Override
	public int count(Kill k) {
		return 0;
	}

	@Override
	public int count(Assist a) {
		return 0;
	}
	
	@Override
	public int count(Death a) {
		return 1;
	}
	
	@Override
	public int count(DefuseBomb a) {
		return 0;
	}
	
	@Override
	public int count(PlantBomb pb) {
		return 0;
	}
	
	@Override
	public int count(Suicide s) {
		return 0;
	}
	
	@Override
	public int count(TeamKill tk) {
		return 0;
	}
	
	

}
