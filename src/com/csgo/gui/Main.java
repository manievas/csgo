package com.csgo.gui;

//Standard Packages
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

//Customs Packages
import com.csgo.parameter.SystemParameter;
import com.csgo.entity.*;
import com.csgo.validator.*;

public class Main {
	
	public static void main(String[] args) {
		
		//Variables
		//Default
		int p, t;	
		char input_event = 'N';
		//char event_type;
		
		//Objects
		Player player = null;	
		Kill kill = null;
		Assist assist = null;
		Death death = null;
		Suicide suicide= null;
		TeamKill teamKill = null;
		PlantBomb plantBomb = null;
		DefuseBomb defuseBomb = null;
		Game game = null; 
		Round round = null;
		Team team = null;
		String team_name = null, side = null, event_type = null;
		
		//Lists
		List<Player> players = null;
		List<Team> teams = null;
		
		RoundInputValidator roundInputValidator = new RoundInputValidator();
		
        //Start
		System.out.println("-----------------------------------------------");
		System.out.println("-Input Data -----------------------------------");
		System.out.println("-----------------------------------------------");
		
		System.out.println(" ");
		//Team
		
		teams = new ArrayList<Team>();
		
		//Player
		System.out.println("Entering Players");
		
		for (t=0; t< SystemParameter.teams_per_game; t++) {
			players = new ArrayList<Player>();
			
			for (p=0; p< SystemParameter.players_per_team ; p++) {				
				player = new Player(JOptionPane.showInputDialog("Player Name: "), JOptionPane.showInputDialog("Player NickName: "));		
				players.add(player);					
			}
			
			if(t == 0) {
				team_name = JOptionPane.showInputDialog("CT name: ");
				side = SystemParameter.ct_name;			
				team = new Team(players, team_name, side);
				//Preguntar a gonza porque verga no puedo hacer clear o remove aca, sin que CT pierda la lista
				//Gonza: Se le haces un new libera la referencia de la lista vieja				
			}
			else {
				team_name = JOptionPane.showInputDialog("TT name: ");		
				side = SystemParameter.tt_name;
				team = new Team(players, team_name, side);				
			}
			
			teams.add(team);
			
		}
	
		//Game
		System.out.println("Creating Game");
		game = new Game(JOptionPane.showInputDialog("Fecha del partido (DD-MM-YYYY)") , SystemParameter.status_start_game);

		do {
			//Round
			System.out.println("Creating Round");
			System.out.println("CT size: "+teams.get(0).getPlayers().size());
			System.out.println("TT size: "+teams.get(1).getPlayers().size());
			
			round = new Round(SystemParameter.status_start_round);
			
			//Event
			System.out.println("Entering Events");

			//Arranca eventos CT
			System.out.println("Arranca eventos CT");
			
			for (Player pct : teams.get(0).getPlayers()) {
				input_event = JOptionPane.showInputDialog("¿Desea ingresar un evento para el jugador " + pct.getName() + " esta ronda? (Y/N): ").charAt(0);

				while (input_event == 'Y') {
					event_type = JOptionPane.showInputDialog("Tipo de evento (KILL, TEAMKILL, DEATH, ASSIST, PLANTBOMB, DEFUSEBOMB, SUICIDE): ");
					
					if (event_type.equals(SystemParameter.event_kill)) {
						kill = new Kill(SystemParameter.kill_score, round);	
						
						if (roundInputValidator.validateKills(teams.get(0))) {
							pct.addEvent(kill);
						}
						
					}
					else if (event_type.equals(SystemParameter.event_assist)) {
						assist = new Assist(SystemParameter.assist_score, round);	
						pct.addEvent(assist);					
					}
					else if (event_type.equals(SystemParameter.event_teamkill)) {
						teamKill = new TeamKill(SystemParameter.teamkill_score, round);	
						pct.addEvent(teamKill);
					}
					else if (event_type.equals(SystemParameter.event_suicide)){
						suicide = new Suicide(SystemParameter.suicide_score, round);	
						pct.addEvent(suicide);
					}					
					else if (event_type.equals(SystemParameter.event_defusebomb)){
						defuseBomb = new DefuseBomb(SystemParameter.defuse_bomb_score, round);	
						pct.addEvent(defuseBomb);
					}
					else if (event_type.equals(SystemParameter.event_death)){
						death = new Death(SystemParameter.death_score, round);	
						pct.addEvent(death);
					}
					
					input_event = JOptionPane.showInputDialog("¿Desea ingresar un evento para el jugador " + pct.getName() + " esta ronda? (Y/N): ").charAt(0);
			
				} //end while (input_event == 'Y')

			}//for (Player pct : teams.get(0).getPlayers())
			
			//Arranca eventos TT
			System.out.println("Arranca eventos TT");
			
			for (Player ptt : teams.get(1).getPlayers()) {
				input_event = JOptionPane.showInputDialog("¿Desea ingresar un evento para el jugador " + ptt.getName() + " esta ronda? (Y/N): ").charAt(0);

				while (input_event == 'Y') {
					event_type = JOptionPane.showInputDialog("Tipo de evento (KILL, TEAMKILL, DEATH, ASSIST, PLANTBOMB, DEFUSEBOMB, SUICIDE): ");
					
					if (event_type.equals(SystemParameter.event_kill)) {
						kill = new Kill(SystemParameter.kill_score, round);	
						ptt.addEvent(kill);
					}
					else if (event_type.equals(SystemParameter.event_assist)) {
						assist = new Assist(SystemParameter.assist_score, round);	
						ptt.addEvent(assist);					
					}
					else if (event_type.equals(SystemParameter.event_teamkill)) {
						teamKill = new TeamKill(SystemParameter.teamkill_score, round);	
						ptt.addEvent(teamKill);
					}
					else if (event_type.equals(SystemParameter.event_suicide)){
						suicide = new Suicide(SystemParameter.suicide_score, round);	
						ptt.addEvent(suicide);
					}					
					else if (event_type.equals(SystemParameter.event_plantbomb)){
						plantBomb = new PlantBomb(SystemParameter.plant_bomb_score, round);	
						ptt.addEvent(plantBomb);
					}
					else if (event_type.equals(SystemParameter.event_death)){
						death = new Death(SystemParameter.death_score, round);	
						ptt.addEvent(death);
					}
					
					input_event = JOptionPane.showInputDialog("¿Desea ingresar un evento para el jugador " + ptt.getName() + " esta ronda? (Y/N): ").charAt(0);
					
				} //end while (input_event == 'Y')
			
			} //for (Player ptt : teams.get(1).getPlayers()) {
			//End For Events
			
			
			// Determinate who wins round
			
			
			System.out.println("Kills: " + teams.get(0).getPlayers().get(0).getKillsCount());
			System.out.println("Assists: " + teams.get(0).getPlayers().get(0).getAssistsCount());
			System.out.println("Teamkills: " + teams.get(0).getPlayers().get(0).getTeamKillsCount());
			System.out.println("PlantBomb: " + teams.get(0).getPlayers().get(0).getPlantBombCount());
			System.out.println("DefuseBomb: " + teams.get(0).getPlayers().get(0).getDefuseBombCount());
			System.out.println("Suicides: " + teams.get(0).getPlayers().get(0).getSuicidesCount());
			System.out.println("Deaths: " + teams.get(0).getPlayers().get(0).getDeathsCount());
			
			
			game.addRound(round);
			
			// Determinate if game was ended 
	
			
			System.out.println("End Round");
			
			if (game.getRounds().size() == SystemParameter.max_rounds_long_game) {
				
				System.out.println("Game Ended - TIE");
				game.setStatus(SystemParameter.status_end_game);
				
				break;
			
			}
			else {
				System.out.println("Game Ended - NO TIE");
				
			}
			
		} while (true);

		System.out.println("End program");
		//System.out.println("End program");
		
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
		
		
		//¿Como se juega la ronda? (Reglas)
	  	  //CT y TT
		  // maximo de kills 
		  // maximo de asistencias 
		  // maximo de muertes
		  // maximo de suicidios
		  // maximo de teamkills
		  
			  
		
		//for (Event e : round.getEvents()) {	
		//	System.out.println(e);
		//}
	}
	
}
