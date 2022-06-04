package com.csgo.gui;

//Standard Packages
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

//Customs Packages
import com.csgo.parameter.SystemParameter;
import com.csgo.entity.*;

public class Main {
	
	public static void main(String[] args) {
		
		//Variables
		//Default
		int c, r;	
		int kill_counter = 0, assist_counter = 0, teamkill_counter = 0;
		char he_died = 'N', he_suicided = 'N';
		
		//Objects
		Player player = null;	
		Team team = null;
		Kill kill = null;
		Assist assist = null;
		Death death = null;
		Suicide suicide= null;
		Round round = null;
		TeamKill teamkill = null;
		Game game = null; 
		
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
	
		//Game
		System.out.println("Creating Game");
		game = new Game(JOptionPane.showInputDialog("Fecha del partido (DD-MM-YYYY)") , SystemParameter.status_start_game);

		
		for (r = 0; r < SystemParameter.max_rounds_long_game; r++) {
				
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
				
				//Preguntarle a gonza porque el string no funca sin hacerle un charAt(0)
				
				//Death
				he_died = JOptionPane.showInputDialog("¿El jugador " + p.getName() + " ha muerto esta ronda? (Y/N): ").charAt(0);
				
				if (he_died== 'Y') {
					death = new Death(SystemParameter.death_score, p);	
					round.addEvent(death);
				}
				else {
					System.out.println("El jugador no ha muerto: "+he_died);
				}
				
				//Suicide
				he_suicided = JOptionPane.showInputDialog("¿El jugador " + p.getName() + " se suicidó esta ronda? (Y/N): ").charAt(0);
				
				if (he_suicided == 'Y') {
					suicide = new Suicide(SystemParameter.suicide_score, p);	
					round.addEvent(suicide);
				}
				else {
					System.out.println("El jugador no se ha suicidado: "+he_suicided);
				}
				
				//TeamKill
				teamkill_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de TeamKill del jugador " + p.getName() + " (0-4)"));
				
				if (teamkill_counter > 0) {
					teamkill = new TeamKill(SystemParameter.teamkill_score, p, teamkill_counter);	
					round.addEvent(teamkill);
				}
				else {
					System.out.println("El jugador no ha tenido teamkills");
				}
				
			} //End For Events
			
			game.addRound(round);
			
			// Determinate if game was ended 

			System.out.println("End Round");
			
			
			if (game.getRounds().size() == SystemParameter.max_rounds_long_game) {
				
				System.out.println("Game Ended - TIE");
				game.setStatus(SystemParameter.status_end_game);
				
				break;
			
			}
			else {
				
			}
			
			
			//Quien gana la ronda?
			
			  //CT
			    //Player vivo, Mata a 5, Bomba no plantada
		        //Player vivo, bomba difuseada			
			    //Player vivo, Tiempo finalizado, bomba no plantada
			
			  //TT
			    //Player vivo, Mata a 5
			    //Bomba explota
			   
			  //
			
			
			
				
			// Si Contador de rondas (si cant rondas = 30)
				//Partido terminado = Empate
			 //Sino 
			    //Si rondas ganadas equipo A = 16
					//Partido terminado = Gano equipo A
			    //Si rondas ganadas equipo B = 16
			        //Partido terminado = Gano equipo B
				//Sino 
					//Jugar ronda
			
			
			//
			
		} //end For Rounds
		
		System.out.println("End program");
		//for (Event e : round.getEvents()) {	
		//	System.out.println(e);
		//}
		
	}
	
}
