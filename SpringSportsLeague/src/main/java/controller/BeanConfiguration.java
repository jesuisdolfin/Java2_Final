package dmacc.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dmacc.beans.Address;
import dmacc.beans.Contact;


@Configuration
public class BeanConfiguration {

	@Bean
	public Player player() {
		Player bean = new Player();
		bean.setPlayerName("Player Name");
		bean.setPlayerNumber("15");
		//bean.setPlayerTeam();
		return bean;
	}
	
	@Bean
	
	public Team team() {
		Team bean = new Team();
		bean.
	}
}
