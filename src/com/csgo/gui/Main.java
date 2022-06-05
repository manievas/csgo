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
		int p, r, t;	
		int kill_counter = 0, assist_counter = 0, teamkill_counter = 0;
		char he_died = 'N', he_suicided = 'N';
		
		//Objects
		Player player = null;	
		CT ct = null;
		TT tt = null;		
		Kill kill = null;
		Assist assist = null;
		Death death = null;
		Suicide suicide= null;
		Round round = null;
		TeamKill teamkill = null;
		Game game = null; 
		String team_name = null;
		
		//Lists
		List<Player> players = null;
		List<Team> teams = null;
		
		
		//Instance
		players = new ArrayList<Player>();
		
        //Start
		System.out.println("-----------------------------------------------");
		System.out.println("-Input Data -----------------------------------");
		System.out.println("-----------------------------------------------");
		
		System.out.println(" ");
		//Team
		
		
		
		//Player
		System.out.println("Entering Players");
		
		for (t=0; t< SystemParameter.teams_per_game; t++) {

			for (p=0; p< SystemParameter.players_per_team ; p++) {
				
				player = new Player(JOptionPane.showInputDialog("Player Name: "), JOptionPane.showInputDialog("Player NickName: "));		
				players.add(player);
				
			}
			
			if(t == 0) {
				team_name = JOptionPane.showInputDialog("CT name: ");						
				ct = new CT(players, team_name);
				players = null;
			}
			else {
				team_name = JOptionPane.showInputDialog("TT name: ");		
				tt = new TT(players, team_name);
				players = null;
			}
			
		}
	
	
		
		
		//Game
		System.out.println("Creating Game");
		game = new Game(JOptionPane.showInputDialog("Fecha del partido (DD-MM-YYYY)") , SystemParameter.status_start_game);

		
		for (r = 0; r < SystemParameter.max_rounds_long_game; r++) {
				
			//Round
			System.out.println("Creating Round");
			round = new Round(SystemParameter.status_start_round, ct, tt);
			
			//Event
			System.out.println("Entering Events");
			
			for (Player p2 : round.getCT().getPlayers()) {
			
				//Kills
				kill_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Kills que tuvo el jugador: " + p2.getName() + " (0-5)"));
				
				if (kill_counter > 0) {
					kill = new Kill(SystemParameter.kill_score, p2, kill_counter);	
					
					/*
					System.out.println("Accediendo a un evento en la lista list_event_test" + List_event_test.size() );
					
					for(Event e : round.getEvents()) {
						
						//Ver como identificar cada evento en su subclase
						if(e instanceof Kill){
							
							Kill kill_test = (Kill)e;
							System.out.println("Ingresa if(e instanceof Kill)" + kill_test.getScore() );
						}
						else {
							System.out.println("Ingresa Else");
						}
						
					}*/
					
					round.addEvent(kill);
				}
				else {
					System.out.println("El jugador no tuvo kills");
				}
				
				//Assists
				assist_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Assist que tuvo el jugador: " + p2.getName() + " (0-5)"));
				
				if (assist_counter > 0) {
					assist = new Assist(SystemParameter.assist_score, p2, assist_counter);	
					round.addEvent(assist);
				}
				else {
					System.out.println("El jugador no tuvo assist");
				}
				
				//Preguntarle a gonza porque el string no funca sin hacerle un charAt(0)
				
				//Death
				he_died = JOptionPane.showInputDialog("¿El jugador " + p2.getName() + " ha muerto esta ronda? (Y/N): ").charAt(0);
				
				if (he_died== 'Y') {
					death = new Death(SystemParameter.death_score, p2);	
					round.addEvent(death);
				}
				else {
					System.out.println("El jugador no ha muerto: "+he_died);
				}
				
				//Suicide
				he_suicided = JOptionPane.showInputDialog("¿El jugador " + p2.getName() + " se suicidó esta ronda? (Y/N): ").charAt(0);
				
				if (he_suicided == 'Y') {
					suicide = new Suicide(SystemParameter.suicide_score, p2);	
					round.addEvent(suicide);
				}
				else {
					System.out.println("El jugador no se ha suicidado: "+he_suicided);
				}
				
				//TeamKill
				teamkill_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de TeamKill del jugador " + p2.getName() + " (0-4)"));
				
				if (teamkill_counter > 0) {
					teamkill = new TeamKill(SystemParameter.teamkill_score, p2, teamkill_counter);	
					round.addEvent(teamkill);
				}
				else {
					System.out.println("El jugador no ha tenido teamkills");
				}
					
				for (Player p3 : round.getTT().getPlayers()) {
					
					//Kills
					kill_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Kills que tuvo el jugador: " + p3.getName() + " (0-5)"));
					
					if (kill_counter > 0) {
						kill = new Kill(SystemParameter.kill_score, p3, kill_counter);	
						
						/*
						System.out.println("Accediendo a un evento en la lista list_event_test" + List_event_test.size() );
						
						for(Event e : round.getEvents()) {
							
							//Ver como identificar cada evento en su subclase
							if(e instanceof Kill){
								
								Kill kill_test = (Kill)e;
								System.out.println("Ingresa if(e instanceof Kill)" + kill_test.getScore() );
							}
							else {
								System.out.println("Ingresa Else");
							}
							
						}*/
						
						round.addEvent(kill);
					}
					else {
						System.out.println("El jugador no tuvo kills");
					}
					
					//Assists
					assist_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de Assist que tuvo el jugador: " + p3.getName() + " (0-5)"));
					
					if (assist_counter > 0) {
						assist = new Assist(SystemParameter.assist_score, p3, assist_counter);	
						round.addEvent(assist);
					}
					else {
						System.out.println("El jugador no tuvo assist");
					}
					
					//Preguntarle a gonza porque el string no funca sin hacerle un charAt(0)
					
					//Death
					he_died = JOptionPane.showInputDialog("¿El jugador " + p3.getName() + " ha muerto esta ronda? (Y/N): ").charAt(0);
					
					if (he_died== 'Y') {
						death = new Death(SystemParameter.death_score, p3);	
						round.addEvent(death);
					}
					else {
						System.out.println("El jugador no ha muerto: "+he_died);
					}
					
					//Suicide
					he_suicided = JOptionPane.showInputDialog("¿El jugador " + p3.getName() + " se suicidó esta ronda? (Y/N): ").charAt(0);
					
					if (he_suicided == 'Y') {
						suicide = new Suicide(SystemParameter.suicide_score, p3);	
						round.addEvent(suicide);
					}
					else {
						System.out.println("El jugador no se ha suicidado: "+he_suicided);
					}
					
					//TeamKill
					teamkill_counter = Integer.parseInt(JOptionPane.showInputDialog("Cantidad de TeamKill del jugador " + p3.getName() + " (0-4)"));
					
					if (teamkill_counter > 0) {
						teamkill = new TeamKill(SystemParameter.teamkill_score, p3, teamkill_counter);	
						round.addEvent(teamkill);
					}
					else {
						System.out.println("El jugador no ha tenido teamkills");
					}
					
			} //End For Events
			
			// Round validation
			//com.csgo.validator de ronda
			
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
			
			
			//¿Como se juega la ronda? (Reglas)
		  	  //CT y TT
			  // maximo de kills 
			  // maximo de asistencias 
			  // maximo de muertes
			  // maximo de suicidios
			  // maximo de teamkills
			  
			  
			
			
		} //end For Rounds
		
		System.out.println("End program");
		//for (Event e : round.getEvents()) {	
		//	System.out.println(e);
		//}
		
	}
	
}
