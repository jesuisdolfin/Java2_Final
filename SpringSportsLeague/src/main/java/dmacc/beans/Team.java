package dmacc.beans;

import java.util.ArrayList;

import javax.persistence.Embeddable;

@Embeddable
public class Team {
	
	// Properties
	private String teamName;
	
	private int teamWins;
	
	private ArrayList<Team> teamSchedule;

	// Constructors
	public Team(String teamName, int teamWins, ArrayList<Team> teamSchedule) {
		super();
		this.teamName = teamName;
		this.teamWins = teamWins;
		this.teamSchedule = teamSchedule;
	}

	public Team() {
		super();
	}

	// Getters and Setters
	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public int getTeamWins() {
		return teamWins;
	}

	public void setTeamWins(int teamWins) {
		this.teamWins = teamWins;
	}

	public ArrayList<Team> getTeamSchedule() {
		return teamSchedule;
	}

	public void setTeamSchedule(ArrayList<Team> teamSchedule) {
		this.teamSchedule = teamSchedule;
	}

	// toString
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", teamWins=" + teamWins + ", teamSchedule=" + teamSchedule + "]";
	}
	
}
