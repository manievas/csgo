package Entity;

import java.util.Date;
import java.util.List;

public class Match {

	private Date date;
	
	private int duration;
	
	private String status;

	private Map map;
	
	private List<Round> rounds;
	
	
	//Constructor
	public Match(Date date, int duration, String status) {
		this.date = date;
		this.duration = duration;
		this.status = status;
	}

	//Methods	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public Map getMap() {
		return map;
	}
	
	public void setMap(Map map) {
		this.map = map;
	}

	
	public List<Round> getRounds(){
		return this.rounds;
	}
	
	public void addRound (Round round) {
		this.rounds.add(round);
	}
	
	
	
}
