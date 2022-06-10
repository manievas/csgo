package com.csgo.validator;

import com.csgo.entity.Round;

import java.util.ArrayList;
import java.util.List;

import com.csgo.entity.Event;
import com.csgo.entity.Kill;
import com.csgo.entity.Player;
import com.csgo.entity.Team;


public class RoundValidator {
	
	public boolean validateKill(Round round, Event event) {
		
		int total_kills = 0;
		
		/*for(Event e : round.getEvents()) {
			
			//Ver como identificar cada evento en su subclase
			
			if(e instanceof Kill)
			{
				
			}
			
			 
			
			total_kills += e.getCount();
			
			if (total_kills > 5) {
				return false;
			}
			
		}*/

		
		return true;
		
	}
	/*
	public Round validateWinner(Round round) {
		
		round.setWinner(validateDefuse(round));
		
		round.setWinner(validateKills(round));
		
		return round;
	}
	
	/*private Team validateDefuse(Round round) {
		
		/*List<Event> eventos = new ArrayList<Event>();
		
		eventos = round.getEvents();
		
		for (Event ev : eventos) {
			
		// ver como detectar de la lista de eventos un evento de tipo Plant Bomb
			bomba_plantada = "Y";
			
		}
		
		if bomba_plantada == "Y" && round.getBomb().getStatus() != "DEFUSED"
				return true;
		else
			return false;
		
			*/
	/*	
		return round.getCT();
		
	}
	/*
	private Team validateKills(Round round) {
		
		int total_kills_ct = 0, total_kills_tt = 0;
		
		
		
		
		//evitar instanceof 
		
		/*
		for(Event e : round.getEvents()) {
			
			//Ver como identificar cada evento en su subclase
			
			if(e instanceof Kill)
			{
				
			}
			
			
			
			for (Player p_ct : round.getCT().getPlayers()) {
				if (e.Player == p_ct) {
					total_kills_ct += e.count;							
				}
			}
			
			
			for (Player p_tt : round.getTT().getPlayers()) {
				if (e.Player == p_tt) {
					total_kills_tt += e.count;
				}
			}
			
			if(total_kills_ct == 5) {
				return round.getCT();				
			}
			else if (total_kills_tt == 5){
				return round.getTT();										
			}
			else {
				return round.getTT();	
			}
			
		}*/
		/*return round.getTT();	
		
	}
*/	

}
