package Entity;

import java.util.List;

public class Round {

	//Attributes
	private Team looser;
	
	private Team winner;
	
	private List<Team> teams;
	
	private List<Event> events;
	
	//Constructor
	public Round(Team looser, Team winner, List<Team> teams,  List<Event> events) {
		this.looser = looser;
		this.winner = winner;
		this.teams = teams;
		this.events = events;
	}

	
	//Methods
	public Team getLooser() {
		return looser;
	}

	public void setLooser(Team looser) {
		this.looser = looser;
	}

	public Team getWinner() {
		return winner;
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public void addTeams(Team team) {
		this.teams.add(team);
	}

	public List<Event> getEvents() {
		return events;
	}

	public void addEvents(Event event) {
		this.events.add(event);
	}
	
	
	
	
}
