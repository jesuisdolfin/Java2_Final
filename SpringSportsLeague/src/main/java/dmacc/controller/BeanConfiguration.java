package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Player;
import dmacc.beans.Team;


@Configuration
public class BeanConfiguration {

	@Bean
	public Player player() {
		Team teambean = new Team();
		teambean.setTeamName("The team");
		teambean.setTeamWins(1000);
		teambean.setTeamSchedule(null);
		
		
		Player bean = new Player();
		bean.setPlayerName("Player Name");
		bean.setPlayerNumber(15);
		bean.setPlayerTeam(teambean);
		return bean;
	}
	
	@Bean
	
	public Team team() {
		Team bean = new Team();
		bean.setTeamName("The team");
		bean.setTeamWins(1000);
		bean.setTeamSchedule(null);
		return bean;
		
	}
}
