package lamhaouar.anissa;

import java.util.ArrayList;

public interface Player {

	void setTour();
	void InitFleet();
	void FireAt(Player p1);
	ArrayList<Ship> getArmy();
	ArrayList<Coordinates> getTargets();
	int getScore();
	ArrayList<String> getFails();
	int getId();
	public void refresh(); 
	public void printGrid(Player p2);

}

