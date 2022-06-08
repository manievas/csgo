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

public abstract class Counter {
	
    private List<Event> events;
    
    

    public Counter(List<Event> events){
        this.events = events;
    }

    public int count(Kill k) {
		return 0;
	}
    
    public int count(Assist a) {
		return 0;
	}

    public int count(Death d) {
		return 0;
	}
    
    public int count(DefuseBomb db) {
		return 0;
	}
    
    public int count(PlantBomb pb) {
		return 0;
	}
    
    public int count(TeamKill tk) {
		return 0;
	}
    
    public int count(Suicide s) {
		return 0;
	}
    
    public int doCount() {
    	int count = 0;
    	for(Event e: events) {
            count += e.receiveCounter(this);
        }
    	
    	return count;
    }
    
}
