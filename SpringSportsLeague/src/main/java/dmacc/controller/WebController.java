package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Player;
import dmacc.beans.Team;
import dmacc.repository.SportsRepository;


@Controller
public class WebController {
	@Autowired
	SportsRepository repo;

	@GetMapping({ "/", "viewAll" })
	public String viewAllTeams(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewTeam(model);
		}
		
		model.addAttribute("teams", repo.findAll());
		return "results";
	}
	
	@GetMapping("/inputTeam")
	public String addNewTeam(Model model) {
		Team c = new Team();
		model.addAttribute("newTeam", c);
		return "input";
	}

	@GetMapping("/insertPlayer")
	public String addNewPlayer(Model model) {
		Player c = new Player();
		model.addAttribute("newPlayer", c);
		return "inputPlayer";
	}

	@GetMapping("/edit/{id}")
	public String showUpdateTeam(@PathVariable("id") long id, Model model) {
		Team c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
		model.addAttribute("newTeam", c);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String reviseTeam(Team c, Model model) {
		repo.save(c);
		return viewAllTeams(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Team c = repo.findById(id).orElse(null);
	    repo.delete(c);
	    return viewAllTeams(model);
	}
}