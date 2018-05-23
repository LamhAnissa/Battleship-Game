package lamhaouar.anissa;

import java.awt.List;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public abstract class Computer implements Player{
	
	private int id;
	public int score;
    final int nbShips=5;
	ArrayList<Ship> army = new ArrayList<Ship>();
	ArrayList<Coordinates> targets = new ArrayList<Coordinates>();
	ArrayList<String> fails = new ArrayList<String>();
	ArrayList<Integer> list1 = new ArrayList<Integer>();
	Scanner sc= new Scanner(System.in);
	Random generator = new Random();
	 public int tour=0;
	public Computer(int id) {
		this.id = id;
		list1=getAr();
		}
	
	public int getId() {
		return id;
	}

	public int getScore() {
		return score;
	}

	public void setScore() {
		this.score = score+1;
	}
	
	public void setTour(){ 
		this.tour=0;
	}
		
	public int getNbShips() {
		return nbShips;
	}

	public void addShip(Ship ship) {
		this.army.add(ship);
	}
	
	public void addtarget(Coordinates c) {
		this.targets.add(c);
	}
	

	public void addfails(String coord) {
		this.fails.add(coord);
	}
	
	public ArrayList<Ship> getArmy() {
		return this.army;
	}

	public void setArmy(ArrayList<Ship> army) {
		this.army = army;
	}

	public ArrayList<Coordinates> getTargets() {
		return this.targets;
	}

	public ArrayList<String> getFails() {
		return this.fails;
	}


	public String Randy() {
		
		int s = generator.nextInt(10)+1;  
        int limit=75;
    	char k=(char)(limit-s);
    	int s2 = generator.nextInt(10)+1; 
    	String cStart=""+k+s2;
    	
    	return cStart;}
	
	  @Override
		public void InitFleet() {	
		  
		 System.out.println("init fleet");
			 boolean validForm = false;
          boolean validPlace = false;
          int d=0;
			
			for (int n=1; n<nbShips+1;n++) { // n for ship's number 
				validForm=false; validPlace=false;
		    
		           while(!( validForm && validPlace)){
		            	
		            	String cStart= Randy();
		            	String cEnd=Randy();
		            	
		            	if (Game.isValidForm(cStart,cEnd)) { 
		            		validForm=true; 
		            		if (this.isFreePlace(cStart,cEnd)) { 
		            		if(this.placeShip(cStart,cEnd)){
		            		Ship s1= new Ship(cStart,cEnd);
		                    this.addShip(s1);
		     
		                    String cat=s1.checkSize(d);
		                    if (cat.equals("Cruiser")){d++;}
		                     validPlace=true;
		                    System.out.println(" creer ship");
		            		}
	           }
		}}}}

	@Override
	public void FireAt(Player p1) {
	}
	
	
	public ArrayList<Integer> getAr() {
		
		ArrayList<Integer> al=new ArrayList<Integer>();
		int[] size= {5,4,3,3,2};
		for (int i:size) {
			al.add(i);}
		return  (ArrayList<Integer>) al;	
	}
	public boolean isFreePlace(String start,String end ) {// verifie que aucun bateau ne se chevauche 
		boolean res=true;
		if (Game.isValidForm(start,end)) {
			ArrayList<String> coordT=Game.CoordTemp(start,end);
			
				for (Ship sh : this.army) {
						for (Coordinates c : sh.getListCoord()) {
							String p=c.getPosition();
							if (coordT.contains(p)) {
								return false;}
							}
						} if (coordT.size()>5) { res=false;}
			
						
						}
		return res;
		} 
				
	
		

		public boolean placeShip(String cs, String ce) {//verifie que le bateau de t 
			
			int i;	
			boolean b=false;
				if (isFreePlace(cs,ce)) {
				ArrayList<String> coT=Game.CoordTemp(cs,ce);
				i=coT.size();
				if(this.list1.contains(i)) {
					this.list1.remove(this.list1.indexOf(i));
					b=true;}
				
					}
				
					//else: Vous ne pouvez plus creer de bateaux de cette taille 
				return b; }
		
		@Override
		public void refresh() {
			this.getArmy().clear();
			this.getFails().clear();
			this.getTargets().clear();
			this.score=0;
			this.list1=getAr();
		
			
			// TODO Auto-generated method stub
			
		}
		@Override
		public void printGrid(Player p1) {}

}