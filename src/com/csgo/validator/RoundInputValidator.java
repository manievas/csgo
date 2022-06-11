package com.csgo.validator;

import com.csgo.entity.*;
import com.csgo.parameter.SystemConstant;
import com.csgo.parameter.SystemParameter;

public class RoundInputValidator {
		
	public boolean validateEvent(Team team, Player player, String event) {
		
		char result = 'Y';
			
		if (event == SystemParameter.event_kill) {
			result = validateKills(team, player);
		}		
		else if (event == SystemParameter.event_assist) {
			result = validateAssists(team, player);
		}
		
		else if (event == SystemParameter.event_suicide) {
			result = validateSuicide( player);
		}
		
		else if (event == SystemParameter.event_death) {
			result = validateDeaths(player);
		}	
		
		else if (event == SystemParameter.event_teamkill) {
			result = validateTeamKills(team, player);
		}	
		
		else if (event == SystemParameter.event_plantbomb) {
			result = validatePlantBomb(team, player);
		}	
		
		else if (event == SystemParameter.event_defusebomb) {
			result = validateDefuseBomb(team, player);
		}	
		
		//Evaluo los eventos
		if (result == 'Y') {
			
			return true;		
			
		} else {
			
			return false;			
		}
		
	}
	
	public char validateKills(Team team, Player player) {
		
		char result = 'Y';
		int count = 0;
			
		for (Player p : team.getPlayers() ) {
			
			if  (p.getKillsCount() < SystemParameter.max_kills_per_round) {
				
				count += p.getKillsCount();	
				
				if (p.getName().equals(player.getName()))
				{
					count += 1;					
					
				}
			
				if (count > SystemParameter.max_kills_per_round) {
					
					result = 'N';
					
				} 
				
			} else {
				
				result = 'N';
				
			}
			
		}

		return result;
		
	}
	
	public char validateAssists(Team team, Player player) {
		
		char result = 'Y';
		int count = 0;
			
		for (Player p : team.getPlayers() ) {
			
			if  (p.getAssistsCount() < SystemParameter.max_assists_per_round) {
				
				count += p.getAssistsCount();	
				
				if (p.getName().equals(player.getName()))
				{
					count += 1;					
					
				}
			
				if (count > SystemParameter.max_assists_per_round) {
					
					result = 'N';
					
				} 
				
			} else {
				
				result = 'N';
				
			}
			
		}

		return result;
		
	}
	
	public char validateSuicide(Player player) {
		
		char result = 'Y';
			
		if  (player.getSuicideCount() == SystemConstant.c_1) {
				
			result = 'N';
					
		} 

		return result;
		
	}
	
	public char validateTeamKills(Team team, Player player) {
		
		char result = 'Y';
		int count = 0;
			
		for (Player p : team.getPlayers() ) {
			
			if  (p.getTeamKillsCount() < SystemParameter.max_teamkills_per_round) {
				
				count += p.getTeamKillsCount();	
				
				if (p.getName().equals(player.getName()))
				{
					count += 1;					
					
				}
			
				if (count > SystemParameter.max_teamkills_per_round) {
					
					result = 'N';
					
				} 
				
			} else {
				
				result = 'N';
				
			}
			
		}

		return result;
		
	}
	
	public char validateDeaths(Player player) {
		
		char result = 'Y';
		
		if (player.getDeathsCount() == SystemConstant.c_1) {
				
			result = 'N';
					
		} 

		return result;
		
	}

	public char validatePlantBomb(Team team, Player player) {
		
		char result = 'Y';
		int count = 0;
			
		for (Player p : team.getPlayers() ) {
			
			if  (p.getPlantBombCount() < SystemParameter.max_plantbomb_per_round) {
				
				count += p.getPlantBombCount();	
				
				if (p.getName().equals(player.getName()))
				{
					count += 1;					
					
				}
			
				if (count > SystemParameter.max_plantbomb_per_round) {
					
					result = 'N';
					
				} 
				
			} else {
				
				result = 'N';
				
			}
			
		}

		return result;
		
	}

	public char validateDefuseBomb(Team team, Player player) {
		
		char result = 'Y';
		int count = 0;
			
		for (Player p : team.getPlayers() ) {
			
			if  (p.getDefuseBombCount() < SystemParameter.max_defusebomb_per_round) {
				
				count += p.getDefuseBombCount();	
				
				if (p.getName().equals(player.getName()))
				{
					count += 1;					
					
				}
			
				if (count > SystemParameter.max_defusebomb_per_round) {
					
					result = 'N';
					
				} 
				
			} else {
				
				result = 'N';
				
			}
			
		}

		return result;
		
	}

}
