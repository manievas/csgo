package com.csgo.validator;

import java.util.List;
import java.util.Objects;

import com.csgo.entity.*;
import com.csgo.parameter.SystemConstant;
import com.csgo.parameter.SystemParameter;

public class RoundValidator {

	public Team CalculateWinner(List<Team> teams, Round round) {
		
		Team countDeath = null, winner = null, bombStatus = null;
		
		bombStatus = BombStatus(teams, round);

		countDeath = CountDeaths(teams, round);

		if(bombStatus.getSide() == SystemParameter.tt_side)	{
			
			winner = bombStatus;
		
		} else {
			
			if (Objects.isNull(countDeath)) {
				
				for (Team t : teams) {
					
					if(t.getSide() == SystemParameter.ct_side) {
						
						winner = t;
						
					}
					
				}
				
			} else {
		
				winner = countDeath;
				
			}
			
		}
			
		
		return winner;
		
	}
	
	private Team CountDeaths(List<Team> teams, Round round){
		
		Team winner = null;
		
		int killCounter = SystemConstant.c_0;
		
		char allowCounter;
		
		for (Team t : teams) {
			
			for (Player p : t.getPlayers()) {
				
				allowCounter = SystemConstant.c_y;
				
				for (Event e : p.getEvents()) {
					
					if (e.getRound() == round) {
						
						if (allowCounter == SystemConstant.c_y) {
							
							killCounter += p.getKillsCount();
							allowCounter = SystemConstant.c_n;
								
						}
						
					}
					
					if (killCounter == SystemConstant.c_5) {
						
						winner = new Team (t.getPlayers(), t.getName(), t.getSide());
						break;
						
					}
					
				}
				
			}
			
			killCounter = 0;
			
		}
		
		return winner;
		
	}
	
	private Team BombStatus(List<Team> teams, Round round) {
		
		Team winner = null, tt = null;
		
		int bombPlanted = 0, bombDefused = 0;
				
		for (Team t : teams) {
		
			if (t.getSide() == SystemParameter.ct_side) {
				winner = new Team (t.getPlayers(), t.getName(), t.getSide());
			}
			
			for (Player p : t.getPlayers()) {
				
				for (Event e : p.getEvents()) {
					
					if (e.getRound() == round) {
						
						bombPlanted += p.getPlantBombCount();
						
						if (bombPlanted == SystemConstant.c_1) {
							tt = new Team (t.getPlayers(), t.getName(), t.getSide());
						}
						
						bombDefused += p.getDefuseBombCount();
					
						/*if ((bombDefused == SystemConstant.c_1)&&(bombPlanted == SystemConstant.c_1)) {
							winner = new Team (t.getPlayers(), t.getName(), t.getSide());
						}*/
					
					}
					
				}
				
			}
			
		}
		
		if ((bombPlanted == SystemConstant.c_1) && (bombDefused ==  SystemConstant.c_0)) {
			
			winner = new Team(tt.getPlayers(), tt.getName(), tt.getSide());
			
		}
		
		return winner;
		
	}


}
