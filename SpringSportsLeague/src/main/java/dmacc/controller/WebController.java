package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Player;
import dmacc.beans.Team;
import dmacc.repository.PlayerRepository;
import dmacc.repository.SportsRepository;


@Controller
public class WebController {
	@Autowired
	SportsRepository repo;
	
	@Autowired
	PlayerRepository playerRepo;

	@GetMapping({ "/", "/viewAllTeams" })
	public String viewAllTeams(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewTeam(model);
		}
		
		model.addAttribute("my_teams", repo.findAll());
		return "teamResults";
	}
	
	@GetMapping("/viewAllPlayers")
	public String viewAllPlayers(Model model) {
		if(playerRepo.findAll().isEmpty()) {
			return addNewPlayer(model);
		}
		
		model.addAttribute("my_players", playerRepo.findAll());
		return "playerResults";
	}
	
	@GetMapping("/inputTeam")
	public String addNewTeam(Model model) {
		Team c = new Team();
		model.addAttribute("currentTeam", c);
		return "inputTeam";
	}

	@GetMapping("/inputPlayer")
	public String addNewPlayer(Model model) {
		Player c = new Player();
		model.addAttribute("newPlayer", c);
		return "inputPlayer";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateTeam(@PathVariable("id") long id, Model model) {
		Team c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
		model.addAttribute("currentTeam", c);
		return "input";
	}

	@PostMapping("/updateTeam/{id}")
	public String reviseTeam(Team c, Model model) {
		repo.save(c);
		return viewAllTeams(model);
	}
	
	@PostMapping("/updatePlayer/{id}")
	public String revisePlayer(Player p, Model model) {
		playerRepo.save(p);
		return viewAllPlayers(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Team c = repo.findById(id).orElse(null);
	    repo.delete(c);
	    return viewAllTeams(model);
	}
}