package com.csgo.parameter;

public class SystemParameter {

	//String
	public static String status_start_round = "INGAME";
	
	public static String status_end_round = "ENDED";
	
	public static String status_start_game = "INGAME";
			
    public static String status_end_game = "ENDED";
    
    public static String status_bomb_default = "NOT PLANTED";

    public static String status_bomb_planted = "PLANTED";

    public static String status_bomb_defused = "DEFUSED";
    
    public static String ct_name = "CT";
    
    public static String tt_name = "TT";    
    
    public static String event_kill = "KILL";    
    
    public static String event_assist = "ASSIST";    
    
    public static String event_teamkill = "TEAMKILL";    
    
    public static String event_suicide = "SUICIDE";    
    
    public static String event_plantbomb = "PLANTBOMB";    
    
    public static String event_defusebomb = "DEFUSEBOMB";
    
    public static String event_death = "DEATH";    

    //int
    public static int players_per_team = 1;
	
    public static int rounds_win_short_game = 9;

    public static int rounds_win_long_game = 16;

    public static int max_rounds_short_game = 16;
    
    public static int max_rounds_long_game = 2;

	public static int kill_score = 2;
	
	public static int assist_score = 1;
	
	public static int death_score = 0;
	
	public static int suicide_score = -2;
	
	public static int teamkill_score = -1;
	
	public static int plant_bomb_score = 2;
	
	public static int defuse_bomb_score = 2;
	
	public static int max_kills_per_round = 5;
	
	public static int max_assists_per_round = 5;
	
	public static int max_deaths_per_round = 5;
	
	public static int max_suicides_per_round = 5;
	
	public static int max_teamkills_per_round = 4;
	
	public static int teams_per_game = 2;
	
}
