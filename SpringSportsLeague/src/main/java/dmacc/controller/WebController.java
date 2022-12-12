package dmacc.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.SortedMap;
import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Player;
import dmacc.beans.Roster;
import dmacc.beans.Standings;
import dmacc.beans.Team;
import dmacc.repository.PlayerRepository;
import dmacc.repository.SportsRepository;
// System.out.println("Hello World");

@Controller
public class WebController {
	@Autowired
	SportsRepository repo;

	@Autowired
	PlayerRepository playerRepo;

	@GetMapping("/viewStandings")
	public String viewStandings(Model model) {
		Standings s = new Standings();

		// Sort arraylist of team wins in ascending order
		ArrayList<Team> standings = new ArrayList<Team>();
		for (Team t : repo.findAll()) {
			standings.add(t);
		}

		ArrayList<Integer> strStandings = new ArrayList<Integer>();
		for (int i = 0; i < standings.size(); ++i) {
			strStandings.add(standings.get(i).getTeamWins());
		}
		strStandings.sort(null);

		// Place key value pairs of rank and team wins into map
		ModelMap teamNameMap = s.makeRanksWithWins(strStandings);

		int rank = standings.size();
		for (Team t : standings) {
			teamNameMap.put(String.valueOf(rank), t.getTeamName());
			rank--;
		}

		s.setStandingsMap(teamNameMap);

		model.addAttribute("my_standings", s);
		return "standings";
	}

	@GetMapping({ "/", "/viewAllTeams" })
	public String viewAllTeams(Model model) {
		if (repo.findAll().isEmpty()) {
			return addNewTeam(model);
		}

		model.addAttribute("my_teams", repo.findAll());
		return "teamResults";
	}

	@GetMapping("/viewAllPlayers")
	public String viewAllPlayers(Model model) {
		if (playerRepo.findAll().isEmpty()) {
			return addNewPlayer(model);
		}

		model.addAttribute("my_players", playerRepo.findAll());
		return "playerResults";
	}

	@GetMapping("/viewRoster/{teamName}")
	public String viewAllRosters(@PathVariable("teamName") String teamName, Model model) {
		Roster r = new Roster();
		ModelMap alphaMap = new ModelMap();

		for (Player p : playerRepo.findAll()) {
			if (p.getPlayerTeam().equals(teamName))
				alphaMap.put(p.getPlayerNumber(), p.getPlayerName());
		}
		r.setAlphaMap(alphaMap);
		r.setTeamName(teamName);

		model.addAttribute("my_roster", r);
		return "rosterResults";
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

	@GetMapping("/editTeam/{id}")
	public String showUpdateTeam(@PathVariable("id") long id, Model model) {
		Team c = repo.findById(id).orElse(null);
		// Team c = repo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + c.toString());
		model.addAttribute("currentTeam", c);
		return "inputTeam";
	}

	@GetMapping("/editPlayer/{id}")
	public String showUpdatePlayer(@PathVariable("id") long id, Model model) {
		Player l = playerRepo.findById(id).orElse(null);
		System.out.println("ITEM TO EDIT: " + l.toString());
		model.addAttribute("newPlayer", l);
		return "inputPlayer";
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

	@GetMapping("/deleteTeam/{id}")
	public String deleteTeam(@PathVariable("id") long id, Model model) {
		Team c = repo.findById(id).orElse(null);
		repo.delete(c);
		return viewAllTeams(model);
	}

	@GetMapping("/deletePlayer/{id}")
	public String deletePlayer(@PathVariable("id") long id, Model model) {
		Player c = playerRepo.findById(id).orElse(null);
		playerRepo.delete(c);
		return viewAllPlayers(model);
	}
}