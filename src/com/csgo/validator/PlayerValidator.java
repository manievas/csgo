package com.csgo.validator;

import com.csgo.entity.Player;
import com.csgo.parameter.*;

public class PlayerValidator {

	public static void main(String[] args) {}
	
	public static int CalculateScore (Player player, String event) {
		
		int score = 0;
		
		if (event == SystemParameter.event_kill){
			score = player.getKillsValue();	
			
		} else if (event == SystemParameter.event_assist){
			score = player.getAssistsValue();	
			
		} else if (event == SystemParameter.event_teamkill){
			score = player.getTeamKillsValue();	
			
		} else if (event == SystemParameter.event_plantbomb){
			score = player.getPlantBombValue();	
			
		} else if (event == SystemParameter.event_defusebomb){
			score = player.getDefuseBombValue();	
			
		} else if (event == SystemParameter.event_suicide){
			score = player.getSuicideValue();	
			
		} else if (event == SystemParameter.event_all){
			score = player.getKillsValue() + 
					player.getAssistsValue() +
					player.getTeamKillsValue() +
					player.getPlantBombValue() +
					player.getDefuseBombValue() +
					player.getSuicideValue();
		}
		
		return score;
		
	}
	
}
