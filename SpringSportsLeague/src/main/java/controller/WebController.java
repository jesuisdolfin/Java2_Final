package dmacc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Contact;
import dmacc.repository.ContactRepository;


@Controller
public class WebController {
	@Autowired
	SportsRepository repo;

	@GetMapping({ "/", "viewAll" })
	public String viewAllPlayers(Model model) {
		if(repo.findAll().isEmpty()) {
			return addNewPlayer(model);
		}
		
		model.addAttribute("teams", repo.findAll());
		return "results";
	}

	@GetMapping("/inputPlayer")
	public String addNewContact(Model model) {
		Player c = new Player();
		model.addAttribute("newPlayer", c);
		return "input";
	}

	@GetMapping("/edit/{id}")
	public String showUpdatePlayer(@PathVariable("id") long id, Model model) {
		Player c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
		model.addAttribute("newPlayer", c);
		return "input";
	}

	@PostMapping("/update/{id}")
	public String revisePlayer(Player c, Model model) {
		repo.save(c);
		return viewAllPlayers(model);
	}
	
	@GetMapping("/delete/{id}")
	public String deleteUser(@PathVariable("id") long id, Model model) {
		Player c = repo.findById(id).orElse(null);
	    repo.delete(c);
	    return viewAllPlayers(model);
	}
}