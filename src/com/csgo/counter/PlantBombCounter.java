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


public class PlantBombCounter extends Counter {

	public PlantBombCounter(List<Event> events) {
		super(events);
	}

	@Override
	public int receiveCounter(Kill k) {
		return 0;
	}

	@Override
	public int receiveCounter(Assist a) {
		return 0;
	}

	@Override
	public int receiveCounter(Death d) {
		return 0;
	}
	
	@Override
	public int receiveCounter(DefuseBomb db) {
		return 0;
	}
	
	@Override
	public int receiveCounter(PlantBomb pb) {
		return 1;
	}
	
	@Override
	public int receiveCounter(Suicide s) {
		return 0;
	}
	
	@Override
	public int receiveCounter(TeamKill tk) {
		return 0;
	}
}