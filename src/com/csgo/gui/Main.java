package com.csgo.gui;

import javax.swing.JOptionPane;

import com.csgo.entity.Player;
import com.csgo.entity.Team;
import com.csgo.entity.Kill;
import com.csgo.entity.Round;
import com.csgo.parameter.SystemParameter;

import java.util.ArrayList;
import java.util.List;


public class Main {
	
	public static void main(String[] args) {
		
		//Variables
		//Default
		int c;	
		int kill_counter = 0;
		
		//Objects
		Player player = null;	
		Team team = null;
		Kill kill = null;
		Round round = null;
		
		//Lists
		List<Player> players = null;
		List<Team> teams = null;
		
		
		//Instance
		players = new ArrayList<Player>();
		teams = new ArrayList<Team>();
		
		
        //Start
		System.out.println("-----------------------------------------------");
		System.out.println("-Input Data -----------------------------------");
		System.out.println("-----------------------------------------------");
		
		System.out.println(" ");
		
		//Player
		System.out.println("Entering Players");
		
		
		for (c=0; c< SystemParameter.players_per_team ; c++) {
			
			player = new Player(JOptionPane.showInputDialog("Player Name: "), JOptionPane.showInputDialog("Player NickName: "));		
			
			players.add(player);
			
		}
		
		//Team
		team = new Team(players);
		
		teams.add(team);
		
		//Round
		System.out.println("Creating Round");
		
		round = new Round(teams, SystemParameter.status_start_round);
		
		//Event
		System.out.println("Entering Events");
		
		for (Player p : team.getPlayers()) {
		
			kill_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Kills que tuvo el jugador: " + p.getName() + " (0-5)"));
			
			if (kill_counter > 0) {
				kill = new Kill(SystemParameter.kill_score, p, kill_counter);	
				round.addKill(kill);
			}
			else {
				System.out.println("El jugador no tuvo kills");
			}
			
		}
		
		
		
		for (Kill k : round.getKills()) {
			System.out.println("Jugador: "+k.getPlayer() + " pts: "+ k.getScore());			
		}
		
		
		
	}
	
}
