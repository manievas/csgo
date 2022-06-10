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
	public int receiveCounter(Kill k) {
		return 0;
	}

	@Override
	public int receiveCounter(Assist a) {
		return 1;
	}
	
	@Override
	public int receiveCounter(Death a) {
		return 0;
	}
	
	@Override
	public int receiveCounter(DefuseBomb a) {
		return 0;
	}
	
	@Override
	public int receiveCounter(PlantBomb a) {
		return 0;
	}
	
	@Override
	public int receiveCounter(Suicide a) {
		return 0;
	}
	
	@Override
	public int receiveCounter(TeamKill a) {
		return 0;
	}
	

}
