package dmacc.beans;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.beans.factory.annotation.Autowired;

@Embeddable
@Entity
@Table(name = "my_players")
public class Player {

	// Properties
	@Id
	@GeneratedValue
	private long id;
	private String playerName;
	private String playerNumber;
	private String playerTeam;

	// Constructors
	public Player(long id, String playerName, String playerNumber) {
		super();
		this.id = id;
		this.playerName = playerName;
		this.playerNumber = playerNumber;

	}

	public Player(String playerName, String playerNumber) {
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

	public String getPlayerNumber() {
		return playerNumber;
	}

	public void setPlayerNumber(String playerNumber) {
		this.playerNumber = playerNumber;
	}

	public String getPlayerTeam() {
		return playerTeam;
	}

	public void setPlayerTeam(String playerTeam) {
		this.playerTeam = playerTeam;
	}

	// toString
	@Override
	public String toString() {
		return "Player [id=" + id + ", playerName=" + playerName + ", playerNumber=" + playerNumber + ", playerTeam=";
	}

}
