package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Player;
import dmacc.beans.Team;


@Configuration
public class BeanConfiguration {

	@Bean
	public Player player() {
		Player bean = new Player();
		bean.setPlayerName("Player Name");
		bean.setPlayerNumber(15);
		
		return bean;
	}
	
	@Bean
	public Team team() {
		Player pbean = new Player("bob smith",27);
		Team bean = new Team();
		bean.setTeamName("The team");
		bean.setTeamWins(1000);
		//bean.insertPlayer(pbean);
		return bean;
		
	}
}
