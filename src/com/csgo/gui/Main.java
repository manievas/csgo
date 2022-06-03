package com.csgo.gui;

//Standard Packages
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

//Customs Packagees
import com.csgo.parameter.SystemParameter;
import com.csgo.entity.*;

public class Main {
	
	public static void main(String[] args) {
		
		//Variables
		//Default
		int c;	
		int kill_counter = 0, assist_counter = 0;
		String he_died = "N", he_suicided = "N";
		
		//Objects
		Player player = null;	
		Team team = null;
		Kill kill = null;
		Assist assist = null;
		Death death = null;
		Suicide suicide= null;
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
		
			//Kills
			kill_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Kills que tuvo el jugador: " + p.getName() + " (0-5)"));
			
			if (kill_counter > 0) {
				kill = new Kill(SystemParameter.kill_score, p, kill_counter);	
				round.addEvent(kill);
			}
			else {
				System.out.println("El jugador no tuvo kills");
			}
			
			//Assists
			assist_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Assist que tuvo el jugador: " + p.getName() + " (0-5)"));
			
			if (assist_counter > 0) {
				assist = new Assist(SystemParameter.assist_score, p, assist_counter);	
				round.addEvent(assist);
			}
			else {
				System.out.println("El jugador no tuvo assist");
			}
			
			//Death
			he_died = JOptionPane.showInputDialog("¿El jugador " + p.getName() + " ha muerto esta ronda? (Y/N): ");
			
			if (he_died == "Y") {
				death = new Death(SystemParameter.death_score, p);	
				round.addEvent(death);
			}
			else {
				System.out.println("El jugador no ha muerto");
			}
			
			//Suicide
			he_suicided = JOptionPane.showInputDialog("¿El jugador " + p.getName() + " se suicidó esta ronda? (Y/N): ");
			
			if (he_suicided == "Y") {
				suicide = new Suicide(SystemParameter.suicide_score, p);	
				round.addEvent(suicide);
			}
			else {
				System.out.println("El jugador no se ha suicidado");
			}
			
		}
		
		
		for (Event e : round.getEvents()) {	
			System.out.println(e);
		}
		
		
		
	}
	
}
