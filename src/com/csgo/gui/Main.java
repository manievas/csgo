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
		int p, t, t1_wins = 0, t2_wins = 0, duration = 0;	
		
		//Objects
		String team_name = null, side = null, event_type = null;

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
		Map map = null;
		
		//Lists
		List<Player> players = null;
		List<Team> teams = null;
		List<Team> winners = null;
		
		//Instances
		EventValidator EventValidator = new EventValidator();
		RoundValidator RoundValidator = new RoundValidator();
		
		//Start
		System.out.println("-----------------------------------------------");
		System.out.println("-Input Data -----------------------------------");
		System.out.println("-----------------------------------------------");
		
		System.out.println(" ");
		//Team
		
		teams = new ArrayList<Team>();
		winners = new ArrayList<Team>();
		
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
		map = new Map(JOptionPane.showInputDialog("Ingrese el Mapa (INFERNO, DUST2, OVERPASS)"));
		game = new Game(JOptionPane.showInputDialog("Fecha del partido (DD-MM-YYYY)") , SystemParameter.status_start_game, map);
		
		map = null;
		
		do {
			if (game.getRounds().size() == SystemParameter.round_change_side_long)
			{
				//Change Side
				teams.get(0).changeSide(SystemParameter.tt_side);
				teams.get(1).changeSide(SystemParameter.ct_side);
				
			}
			
			//Round
			System.out.println("Creating Round");
			
			round = new Round(SystemParameter.status_start_round);
			
			//Event
			System.out.println("Entering Events");

			//Arranca eventos CT
			System.out.println("Round "+ (game.getRounds().size()+1) + "CT Events -------------------");
			
			for (Player pt1 : teams.get(0).getPlayers()) {
				
				event_type = JOptionPane.showInputDialog("Round: "+ (game.getRounds().size()+1) +" Player: "+ pt1.getName() + "   | Tipo de evento (KILL, TEAMKILL, DEATH, ASSIST, PLANTBOMB, DEFUSEBOMB, SUICIDE), para salir ingrese N: ");
				
				while (!event_type.equals(String.valueOf(SystemConstant.c_n))) {
					
					if (event_type.equals(SystemParameter.event_kill)) {
						kill = new Kill(SystemParameter.kill_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pt1, SystemParameter.event_kill)) {
							pt1.addEvent(kill);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de Muertes, el evento no se registrara");
						}
						
					}
					else if (event_type.equals(SystemParameter.event_assist)) {
						assist = new Assist(SystemParameter.assist_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pt1, SystemParameter.event_assist)) {
							pt1.addEvent(assist);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de Asistencias, el evento no se registrara");
						}
											
					}  
					else if (event_type.equals(SystemParameter.event_teamkill)) {
						teamKill = new TeamKill(SystemParameter.teamkill_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pt1, SystemParameter.event_teamkill)) {
							pt1.addEvent(teamKill);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de TeamKills, el evento no se registrara");
						}
						
					}
					else if (event_type.equals(SystemParameter.event_suicide)){
						suicide = new Suicide(SystemParameter.suicide_score, round);
						
						if (EventValidator.validateEvent(teams.get(0), pt1, SystemParameter.event_suicide)) {
							pt1.addEvent(suicide);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de suicidios, el evento no se registrara");
						}
						
					}		
					else if (event_type.equals(SystemParameter.event_plantbomb) && (teams.get(0).getSide() == SystemParameter.tt_side)){						
						plantBomb = new PlantBomb(SystemParameter.plant_bomb_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pt1, SystemParameter.event_plantbomb)) {
							pt1.addEvent(plantBomb);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de defusebomb, el evento no se registrara");
						}
					}
					else if (event_type.equals(SystemParameter.event_defusebomb) && (teams.get(0).getSide() == SystemParameter.ct_side)){		
						defuseBomb = new DefuseBomb(SystemParameter.defuse_bomb_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pt1, SystemParameter.event_defusebomb)) {
							pt1.addEvent(defuseBomb);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de defusebomb, el evento no se registrara");
						}
					}
					else if (event_type.equals(SystemParameter.event_death)){
						death = new Death(SystemParameter.death_score, round);	
						
						if (EventValidator.validateEvent(teams.get(0), pt1, SystemParameter.event_death)) {
							pt1.addEvent(death);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de deaths, el evento no se registrara");
						}
						
					}
					
					event_type = JOptionPane.showInputDialog("Round: "+ (game.getRounds().size()+1) +" Player: "+ pt1.getName() + "   | Tipo de evento (KILL, TEAMKILL, DEATH, ASSIST, PLANTBOMB, DEFUSEBOMB, SUICIDE), para salir ingrese N: ");
						
				} //end while (input_event == 'Y')

			}//for (Player pct : teams.get(0).getPlayers())
			
			//Arranca eventos TT
			System.out.println("Round "+ (game.getRounds().size()+1) + "TT Events -------------------");
			
			for (Player pt2 : teams.get(1).getPlayers()) {
				event_type = JOptionPane.showInputDialog("Round: "+ (game.getRounds().size()+1) +" Player: "+ pt2.getName() + "   | Tipo de evento (KILL, TEAMKILL, DEATH, ASSIST, PLANTBOMB, DEFUSEBOMB, SUICIDE), para salir ingrese N: ");
					
				while (!event_type.equals(String.valueOf(SystemConstant.c_n))) {
						
					if (event_type.equals(SystemParameter.event_kill)) {
						kill = new Kill(SystemParameter.kill_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), pt2, SystemParameter.event_kill)) {
							pt2.addEvent(kill);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de Muertes, el evento no se registrara");
						}
						
					}
					else if (event_type.equals(SystemParameter.event_assist)) {
						assist = new Assist(SystemParameter.assist_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), pt2, SystemParameter.event_assist)) {
							pt2.addEvent(assist);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de Asistencias, el evento no se registrara");
						}
											
					}
					else if (event_type.equals(SystemParameter.event_teamkill)) {
						teamKill = new TeamKill(SystemParameter.teamkill_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), pt2, SystemParameter.event_teamkill)) {
							pt2.addEvent(teamKill);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de TeamKills, el evento no se registrara");
						}
						
					}
					else if (event_type.equals(SystemParameter.event_suicide)){
						suicide = new Suicide(SystemParameter.suicide_score, round);
						
						if (EventValidator.validateEvent(teams.get(1), pt2, SystemParameter.event_suicide)) {
							pt2.addEvent(suicide);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de suicidios, el evento no se registrara");
						}
						
					}					
					else if (event_type.equals(SystemParameter.event_plantbomb) && (teams.get(1).getSide() == SystemParameter.tt_side)){		
						plantBomb = new PlantBomb(SystemParameter.plant_bomb_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), pt2, SystemParameter.event_plantbomb)) {
							pt2.addEvent(plantBomb);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de defusebomb, el evento no se registrara");
						}
					}
					else if (event_type.equals(SystemParameter.event_defusebomb) && (teams.get(1).getSide() == SystemParameter.ct_side)){		
						defuseBomb = new DefuseBomb(SystemParameter.defuse_bomb_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), pt2, SystemParameter.event_defusebomb)) {
							pt2.addEvent(defuseBomb);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de defusebomb, el evento no se registrara");
						}
					}
					else if (event_type.equals(SystemParameter.event_death)){
						death = new Death(SystemParameter.death_score, round);	
						
						if (EventValidator.validateEvent(teams.get(1), pt2, SystemParameter.event_death)) {
							pt2.addEvent(death);
						}
						else {
							 JOptionPane.showMessageDialog(null, "Ha alcanzado el limite de deaths, el evento no se registrara");
						}
						
					}

					event_type = JOptionPane.showInputDialog("Round: "+ (game.getRounds().size()+1) +" Player: "+ pt2.getName() + "   | Tipo de evento (KILL, TEAMKILL, DEATH, ASSIST, PLANTBOMB, DEFUSEBOMB, SUICIDE), para salir ingrese N: ");
				
				} 
			
			} 
			//End For Events
		
		    // Determinate who win round
			
			round.setWinner(RoundValidator.CalculateWinner(teams, round));

			round.setMVP(RoundValidator.CalculateMVP(round.getWinner(), round));
		
			round.endRound(SystemParameter.status_end_round);
			
			//printEvents(teams);
			
			System.out.println("MVP: " + round.getMVP().getName());
			System.out.println("Winner: " + round.getWinner().getName());
			
			
		
			
			
			
		    if (round.getWinner().getName().equals(teams.get(0).getName())) {
					
		    	t1_wins += 1;	    	
		    	
		    }
			else if (round.getWinner().getName().equals(teams.get(1).getName())) {
				
				t2_wins += 1;
				
			}
			
			System.out.println("SCORE: " + teams.get(0).getName() + "  " + t1_wins + " - " + t2_wins + "  " + teams.get(1).getName() );
			
			game.addRound(round);
			
			// Determinate if game was ended 
	
			if (game.getRounds().size() == SystemParameter.max_rounds_long_game) {
				
				System.out.println("Game Ended - TIE");
				duration = Integer.parseInt(JOptionPane.showInputDialog("Ingrese duracion (en MINUTOS)"));
				game.endGame(SystemParameter.status_end_game, duration);
				
				break;
			
			}
			else if (t1_wins == SystemParameter.rounds_win_long_game){
				
				System.out.println("Game Ended - " + teams.get(0).getName() + " WINS");
				duration = Integer.parseInt(JOptionPane.showInputDialog("Ingrese duracion (en MINUTOS)"));
				game.endGame(SystemParameter.status_end_game, duration);

				break;

			}				
			
			else if (t2_wins == SystemParameter.rounds_win_long_game){

				System.out.println("Game Ended - "+ teams.get(1).getName() +" WINS");
				duration = Integer.parseInt(JOptionPane.showInputDialog("Ingrese duracion (en MINUTOS)"));
				game.endGame(SystemParameter.status_end_game, duration);

				break;

			}	
					
			System.out.println("End Round");
			
			System.out.println("Next Round");

		} while (true);

		GlobalVariables.gameEnded = SystemConstant.c_y;
		
		printEvents(teams);
		printScore(teams);

		System.out.println("End program");
	
	}
	
	private static void printEvents(List<Team> teams){
		
		System.out.println("Print Events ----------------");
		
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
		
		
	}
	
	//PREGUNTAR A GONZA PORQUE VERGA ME PIDE EL ESTATI
    public static void printScore(List<Team> teams){
    	
    	System.out.println("Print Score");
		for (Team st : teams) {
			
			for (Player sp : st.getPlayers() ) {
				System.out.println(sp.getName());
				System.out.println("Kills: " + PlayerValidator.CalculateScore(sp, SystemParameter.event_kill));	
				System.out.println("Assists: " + PlayerValidator.CalculateScore(sp, SystemParameter.event_assist));	
				System.out.println("Teamkills: " + PlayerValidator.CalculateScore(sp, SystemParameter.event_teamkill));	
				System.out.println("Suicides: " + PlayerValidator.CalculateScore(sp, SystemParameter.event_suicide));	
				System.out.println("PlantBomb: " + PlayerValidator.CalculateScore(sp, SystemParameter.event_plantbomb));
				System.out.println("DefuseBomb: " + PlayerValidator.CalculateScore(sp, SystemParameter.event_defusebomb));
				System.out.println("Total: " + PlayerValidator.CalculateScore(sp, SystemParameter.event_all));	
				
			}
			
		}
    }
    
    //mvp por ronda

}
