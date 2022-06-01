package com.csgo.gui;

import javax.swing.JOptionPane;

import com.csgo.entity.Player;
import com.csgo.entity.Team;
import com.csgo.parameter.SystemParameter;

import java.util.ArrayList;
import java.util.List;


public class Main {
	
	public static void main(String[] args) {
		
		//Variables
		String name, nickname;
		int c, d;		
		Player player = null;	
		Team team = null;
		List<Player> players = null;
		List<Player> lista = null;
		
		
		players = new ArrayList<Player>();
		lista = new ArrayList<Player>();
		
        //Start
		System.out.println("-----------------------------------------------");
		System.out.println("Input Data ------------------------------------");
		System.out.println("-----------------------------------------------");
		
		System.out.println(" ");
		
		//Player
		System.out.println("Enter Players");
		
		;
		
		for (c=0; c< SystemParameter.players_per_team ; c++) {
			
			name = JOptionPane.showInputDialog("Player Name: ");
			nickname = JOptionPane.showInputDialog("Player NickName: ");
			
			player = new Player(name, nickname);		
			
			players.add(player);
			
		}
		
		team = new Team(players);
		
		
		lista = team.getPlayers();
		
		for (Player p : lista) {
			System.out.println(p.getName());
		}
		
	}
	
}
