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

public class AssistCounter extends Counter{
	
	public AssistCounter(List<Event> events) {
		super(events);
	}

	@Override
	public int count(Kill k) {
		return 0;
	}

	@Override
	public int count(Assist a) {
		return 1;
	}
	
	@Override
	public int count(Death a) {
		return 0;
	}
	
	@Override
	public int count(DefuseBomb a) {
		return 0;
	}
	
	@Override
	public int count(PlantBomb a) {
		return 0;
	}
	
	@Override
	public int count(Suicide a) {
		return 0;
	}
	
	@Override
	public int count(TeamKill a) {
		return 0;
	}
	

}
