package dmacc.beans;

import java.util.SortedMap;
import java.util.TreeMap;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.ui.ModelMap;

@Entity
@Table(name="my_roster")
public class Roster {

	// Properties
	@Id
	@GeneratedValue
	private long id;
	private String teamName;
	private int teamWins;
	//private String playerName;
	//private String playerNumber;
	
	// Sorted hashmap with key value pairs for playerName and playerNumber
	private ModelMap alphaMap = new ModelMap();
	
	// Constructor
	public Roster(String teamName, int teamWins, String playerName, String playerNumber) {
		super();
		this.teamName = teamName;
		this.teamWins = teamWins;
		//this.playerName = playerName;
		//this.playerNumber = playerNumber;
	}
	
	public Roster() {
		super();
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

//	public String getPlayerName() {
//		return playerName;
//	}
//
//	public void setPlayerName(String playerName) {
//		this.playerName = playerName;
//	}
//
//	public String getPlayerNumber() {
//		return playerNumber;
//	}
//
//	public void setPlayerNumber(String playerNumber) {
//		this.playerNumber = playerNumber;
//	}

	public ModelMap getAlphaMap() {
		return alphaMap;
	}

	public void setAlphaMap(ModelMap alphaMap) {
		this.alphaMap = alphaMap;
	}

	
	
}
