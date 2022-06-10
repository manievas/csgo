package com.csgo.validator;

import com.csgo.entity.*;
import com.csgo.parameter.SystemParameter;

public class RoundInputValidator {

	public boolean validateKills(Team team) {
		
		char result = 'N';
		int count = 0;
		
		for (Player p : team.getPlayers() ) {
			
			if  (p.getKillsCount() < SystemParameter.max_kills_per_round) {
			
				if (p.getKillsCount() == 0)
				{
					count += 1;
					
				} else {
					
					count += p.getKillsCount();					
				
				}
			
				if (count < SystemParameter.max_kills_per_round) {
					
					result = 'Y';
					
				} 
				
			}
			
		}
		
		
		//PROBAR MAS DE UN JUGADOR Y PRESTAR ATENCION EN EL CAMBIO DE JUGADOR (QUE FUNCION EL P.GETKILLSCOUNT)
		
		if (result == 'Y') {
			
			return true;		
			
		} else {
			
			return false;			
		}
		
	}
	
	
}
