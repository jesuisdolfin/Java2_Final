package dmacc.beans;

import java.util.ArrayList;

import org.springframework.ui.ModelMap;

public class Standings {

	private ModelMap standingsMap = new ModelMap();
	private ModelMap teamNameMap = new ModelMap();

	public Standings() {
		super();
	}

	public ModelMap makeRanksWithWins(ArrayList<Integer> standings) {
		int rank = standings.size();
		for (int i = 0; i < standings.size(); ++i) {
			standingsMap.put(String.valueOf(rank), standings.get(i));
			rank--;
		}

		return standingsMap;
	}

	public ModelMap makeRanksWithTeamName(ArrayList<Integer> standings) {

		return teamNameMap;
	}

	public ModelMap getStandingsMap() {
		return standingsMap;
	}

	public void setStandingsMap(ModelMap standingsMap) {
		this.standingsMap = standingsMap;
	}

}
