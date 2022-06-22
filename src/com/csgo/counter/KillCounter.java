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


public class KillCounter extends Counter {
	
	public KillCounter(List<Event> events) {
		super(events);
	}
	
	public int receiveCounter(Kill k, ParameterizedCounter f) {
		return f.getCountValue(k);
	}
	
	public int receiveCounter(Assist a, ParameterizedCounter f) {
		return 0;
	}
	
	public int receiveCounter(TeamKill tk, ParameterizedCounter f) {
		return 0;
	}
	
	public int receiveCounter(Suicide s, ParameterizedCounter f) {
		return 0;
	}
	
	public int receiveCounter(Death d, ParameterizedCounter f) {
		return 0;
	}
	
	public int receiveCounter(PlantBomb pb, ParameterizedCounter f) {
		return 0;
	}
	
	public int receiveCounter(DefuseBomb db, ParameterizedCounter f) {
		return 0;
	}
	
	
}


		
		