package dmacc.beans;

public class Player {

	// Properties
	private long id;
	
	private String playerName;
	
	private int playerNumber;
	
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
