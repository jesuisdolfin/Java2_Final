package dmacc.beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
@Table(name="my_players")
public class Player {

	// Properties
	@Id
	@GeneratedValue
	private long id;
	
	@Column(name="player_name")
	private String playerName;
	
	private int playerNumber;
	
	@Autowired
	private Team playerTeam;
	
	// Constructors
	public Player(long id, String playerName, int playerNumber, Team playerTeam) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.playerNumber = playerNumber;
		this.playerTeam = playerTeam;
	}

	public Player(String playerName, int playerNumber, Team playerTeam) {
		super();
		this.playerName = playerName;
		this.playerNumber = playerNumber;
		this.playerTeam = playerTeam;
	}

	public Player(String playerName, int playerNumber) {
		super();
		this.playerName = playerName;
		this.playerNumber = playerNumber;
	}
	
	public Player() {
		super();
	}

	// Getters and Setters
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public int getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(int playerNumber) {
		this.playerNumber = playerNumber;
	}

	public Team getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(Team playerTeam) {
		this.playerTeam = playerTeam;
	}

	// toString
	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", playerNumber=" + playerNumber + ", playerTeam="
				+ playerTeam + "]";
	}
	
}
