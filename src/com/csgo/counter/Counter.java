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

import com.csgo.parameter.SystemParameter;

public abstract class Counter {
	
    private List<Event> events;
    
    public Counter(List<Event> events){
        this.events = events;
    }

    public int receiveCounter(Kill k) {
		return 0;
	}
    
    public int receiveCounter(Assist a) {
		return 0;
	}

    public int receiveCounter(Death d) {
		return 0;
	}
    
    public int receiveCounter(DefuseBomb db) {
		return 0;
	}
    
    public int receiveCounter(PlantBomb pb) {
		return 0;
	}
    
    public int receiveCounter(TeamKill tk) {
		return 0;
	}
    
    public int receiveCounter(Suicide s) {
		return 0;
	}
    
    public int doCount() {
    	int count = 0;
    	
    	for(Event e: events) {
    		if ( e.getRound().getStatus() == SystemParameter.status_start_round) {
                count += e.receiveCounter(this);    			
    		}
        }
    	
    	return count;
    }
    
    
    
}
