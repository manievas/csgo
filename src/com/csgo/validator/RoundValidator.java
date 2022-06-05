package com.csgo.validator;

import com.csgo.entity.Round;
import com.csgo.entity.Event;
import com.csgo.entity.Kill;



public class RoundValidator {
	
	public boolean validateKill(Round round, Event event) {
		
		
		for(Event e : round.getEvents()) {
			
			//Ver como identificar cada evento en su subclase
			
			if(e instanceof Kill)
			{
				
			}
			
			
			
			
		}
		
		return true;
		
	}

}
