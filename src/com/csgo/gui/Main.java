package com.csgo.gui;

//Standard Packages
import javax.swing.JOptionPane;
import java.util.ArrayList;
import java.util.List;

//Customs Packages
import com.csgo.parameter.*;
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
		
		
		EventValidator EventValidator = new EventValidator();
		RoundValidator RoundValidator = new RoundValidator();
		

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
				side = SystemParameter.ct_side;			
				team = new Team(players, team_name, side);		
			}
			else {
				team_name = JOptionPane.showInputDialog("TT name: ");		
				side = SystemParameter.tt_side;
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
					
					event_type = JOptionPane.showInputDialog("Tipo de evento (KILL, TEAMKILL, DEATH, ASSIST, DEFUSEBOMB, SUICIDE): ");
					
					if (event_type.equals(SystemParameter.event_kill)) {
						kill = new Kill(SystemParameter.kill_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pct, SystemParameter.event_kill)) {
							pct.addEvent(kill);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de Muertes, el evento no se registrara");
						}
						
					}
					else if (event_type.equals(SystemParameter.event_assist)) {
						assist = new Assist(SystemParameter.assist_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pct, SystemParameter.event_assist)) {
							pct.addEvent(assist);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de Asistencias, el evento no se registrara");
						}
											
					}
					else if (event_type.equals(SystemParameter.event_teamkill)) {
						teamKill = new TeamKill(SystemParameter.teamkill_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pct, SystemParameter.event_teamkill)) {
							pct.addEvent(teamKill);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de TeamKills, el evento no se registrara");
						}
						
					}
					else if (event_type.equals(SystemParameter.event_suicide)){
						suicide = new Suicide(SystemParameter.suicide_score, round);
						
						if (EventValidator.validateEvent(teams.get(0), pct, SystemParameter.event_suicide)) {
							pct.addEvent(suicide);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de suicidios, el evento no se registrara");
						}
						
					}					
					else if (event_type.equals(SystemParameter.event_defusebomb)){
						defuseBomb = new DefuseBomb(SystemParameter.defuse_bomb_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pct, SystemParameter.event_defusebomb)) {
							pct.addEvent(defuseBomb);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de defusebomb, el evento no se registrara");
						}
					}
					else if (event_type.equals(SystemParameter.event_death)){
						death = new Death(SystemParameter.death_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pct, SystemParameter.event_death)) {
							pct.addEvent(death);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de deaths, el evento no se registrara");
						}
						
					}
					
					input_event = JOptionPane.showInputDialog("¿Desea ingresar un evento para el jugador " + pct.getName() + " esta ronda? (Y/N): ").charAt(0);
			
				} //end while (input_event == 'Y')

			}//for (Player pct : teams.get(0).getPlayers())
			
			//Arranca eventos TT
			System.out.println("Arranca eventos TT");
			
			for (Player ptt : teams.get(1).getPlayers()) {
				input_event = JOptionPane.showInputDialog("¿Desea ingresar un evento para el jugador " + ptt.getName() + " esta ronda? (Y/N): ").charAt(0);

				while (input_event == 'Y') {
					event_type = JOptionPane.showInputDialog("Tipo de evento (KILL, TEAMKILL, DEATH, ASSIST, PLANTBOMB, SUICIDE): ");
					
					if (event_type.equals(SystemParameter.event_kill)) {
						kill = new Kill(SystemParameter.kill_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), ptt, SystemParameter.event_kill)) {
							ptt.addEvent(kill);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de Muertes, el evento no se registrara");
						}
						
					}
					else if (event_type.equals(SystemParameter.event_assist)) {
						assist = new Assist(SystemParameter.assist_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), ptt, SystemParameter.event_assist)) {
							ptt.addEvent(assist);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de Asistencias, el evento no se registrara");
						}
											
					}
					else if (event_type.equals(SystemParameter.event_teamkill)) {
						teamKill = new TeamKill(SystemParameter.teamkill_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), ptt, SystemParameter.event_teamkill)) {
							ptt.addEvent(teamKill);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de TeamKills, el evento no se registrara");
						}
						
					}
					else if (event_type.equals(SystemParameter.event_suicide)){
						suicide = new Suicide(SystemParameter.suicide_score, round);
						
						if (EventValidator.validateEvent(teams.get(1), ptt, SystemParameter.event_suicide)) {
							ptt.addEvent(suicide);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de suicidios, el evento no se registrara");
						}
						
					}					
					else if (event_type.equals(SystemParameter.event_plantbomb)){
						plantBomb = new PlantBomb(SystemParameter.plant_bomb_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), ptt, SystemParameter.event_plantbomb)) {
							ptt.addEvent(plantBomb);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de defusebomb, el evento no se registrara");
						}
					}
					else if (event_type.equals(SystemParameter.event_death)){
						death = new Death(SystemParameter.death_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), ptt, SystemParameter.event_death)) {
							ptt.addEvent(death);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de deaths, el evento no se registrara");
						}
						
					}
					input_event = JOptionPane.showInputDialog("¿Desea ingresar un evento para el jugador " + ptt.getName() + " esta ronda? (Y/N): ").charAt(0);
					
				} //end while (input_event == 'Y')
			
			} //for (Player ptt : teams.get(1).getPlayers()) {
			//End For Events
			
			
			// Determinate who wins round
			
			
			System.out.println(teams.get(0).getPlayers().get(0).getName() + " Events");
			System.out.println("Kills: " + teams.get(0).getPlayers().get(0).getKillsCount());
			System.out.println("Assists: " + teams.get(0).getPlayers().get(0).getAssistsCount());
			System.out.println("Teamkills: " + teams.get(0).getPlayers().get(0).getTeamKillsCount());
			System.out.println("PlantBomb: " + teams.get(0).getPlayers().get(0).getPlantBombCount());
			System.out.println("DefuseBomb: " + teams.get(0).getPlayers().get(0).getDefuseBombCount());
			System.out.println("Suicides: " + teams.get(0).getPlayers().get(0).getSuicideCount());
			System.out.println("Deaths: " + teams.get(0).getPlayers().get(0).getDeathsCount());

			System.out.println(teams.get(0).getPlayers().get(1).getName() + " Events");
			System.out.println("Kills: " + teams.get(0).getPlayers().get(1).getKillsCount());
			System.out.println("Assists: " + teams.get(0).getPlayers().get(1).getAssistsCount());
			System.out.println("Teamkills: " + teams.get(0).getPlayers().get(1).getTeamKillsCount());
			System.out.println("PlantBomb: " + teams.get(0).getPlayers().get(1).getPlantBombCount());
			System.out.println("DefuseBomb: " + teams.get(0).getPlayers().get(1).getDefuseBombCount());
			System.out.println("Suicides: " + teams.get(0).getPlayers().get(1).getSuicideCount());
			System.out.println("Deaths: " + teams.get(0).getPlayers().get(1).getDeathsCount());
			
			System.out.println(teams.get(1).getPlayers().get(0).getName() + " Events");
			System.out.println("Kills: " + teams.get(1).getPlayers().get(0).getKillsCount());
			System.out.println("Assists: " + teams.get(1).getPlayers().get(0).getAssistsCount());
			System.out.println("Teamkills: " + teams.get(1).getPlayers().get(0).getTeamKillsCount());
			System.out.println("PlantBomb: " + teams.get(1).getPlayers().get(0).getPlantBombCount());
			System.out.println("DefuseBomb: " + teams.get(1).getPlayers().get(0).getDefuseBombCount());
			System.out.println("Suicides: " + teams.get(1).getPlayers().get(0).getSuicideCount());
			System.out.println("Deaths: " + teams.get(1).getPlayers().get(0).getDeathsCount());

			System.out.println(teams.get(1).getPlayers().get(1).getName() + " Events");
			System.out.println("Kills: " + teams.get(1).getPlayers().get(1).getKillsCount());
			System.out.println("Assists: " + teams.get(1).getPlayers().get(1).getAssistsCount());
			System.out.println("Teamkills: " + teams.get(1).getPlayers().get(1).getTeamKillsCount());
			System.out.println("PlantBomb: " + teams.get(1).getPlayers().get(1).getPlantBombCount());
			System.out.println("DefuseBomb: " + teams.get(1).getPlayers().get(1).getDefuseBombCount());
			System.out.println("Suicides: " + teams.get(1).getPlayers().get(1).getSuicideCount());
			System.out.println("Deaths: " + teams.get(1).getPlayers().get(1).getDeathsCount());
			
			
			System.out.println("End Round");
			
		    // Determinate who win round
			
			round.endRound(SystemParameter.status_end_round, RoundValidator.CalculateWinner(teams, round));
			
			game.addRound(round);
			
			// Determinate if game was ended 
	
			
			
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
