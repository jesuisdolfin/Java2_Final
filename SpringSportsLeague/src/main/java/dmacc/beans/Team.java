package dmacc.beans;

import java.util.ArrayList;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "my_teams")
public class Team {

	// Properties
	@Id
	@GeneratedValue
	private long id;
	private String teamName;
	private int teamWins;
	//private ArrayList<Player> playerList = new ArrayList<Player>();

	// Constructors
	public Team(String teamName, int teamWins) {
		super();
		this.teamName = teamName;
		this.teamWins = teamWins;

	}

	public Team(String teamName, int teamWins, ArrayList<Player> playerList) {
		super();
		this.teamName = teamName;
		this.teamWins = teamWins;
	}

	public Team() {
		super();
	}

	// Getters and Setters
	public long getId() {
		return this.id;
	}

	public void setId(long Id) {
		this.id = Id;
	}

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

//	public ArrayList<Player> getPlayerList() {
//		return playerList;
//	}
//
//	public void setPlayerList(ArrayList<Player> playerList) {
//		this.playerList = playerList;
//	}
//
//	public void insertPlayer(Player p) {
//		this.playerList.add(p);
//	}

	// toString
	@Override
	public String toString() {
		return "Team [teamName=" + teamName + ", teamWins=" + teamWins + ", teamSchedule=" + "]";
	}

}
