package lamhaouar.anissa;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

	public class HumanPlayer implements Player {
		
		private int id;
		public int tour;
	    public int score;
	    final int nbShips=5;
		ArrayList<Ship> army = new ArrayList<Ship>();
		ArrayList<Coordinates> targets = new ArrayList<Coordinates>();
		ArrayList<String> fails = new ArrayList<String>();
		ArrayList<Integer> list1 = new ArrayList<Integer>();
		Scanner sc= new Scanner(System.in);
	
		public HumanPlayer(int id) {
			this.id = id;
			list1=getAr();
			}
		
		public int getId() {
			return this.id;
		}

		public int getScore() {
			return this.score;
		}
		
		public void setTour(){ this.tour=0;}
	
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

		public ArrayList<Coordinates> getTargets() {
			return this.targets;
		}

		public ArrayList<String> getFails() {
			return this.fails;
		}


		public ArrayList<Integer> getAr() {// verifie qu'on est pas plusieurs bateaux de meme taille 
			
			List<Integer> al=new ArrayList<Integer>();
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
			public void InitFleet() {
				 
				 boolean validForm = false;
	             boolean validPlace = false;
	             int d=0;
				 String str = null;
				 String str1=null;
				for (int n=1; n<nbShips+1;n++) { // n for ship's number 
					validForm = false;
					validPlace = false;
					
			            while(!(validForm && validPlace)) {
			      try { System.out.printf("Player %d, Enter 1st and THEN last case of your ship n� %s", this.getId(),n );
			         str = sc.nextLine();
			         str1 = sc.nextLine();} catch(IndexOutOfBoundsException e) {System.out.printf("Player %d, Enter valid coordinates please :", this.getId(),n );
			         str = sc.nextLine();
			         str1 = sc.nextLine();
			        }
			        finally {
			        System.out.println("Coordinates : ("+" "+ str +" , "+ str1 +")");
			        if (Game.isValidForm(str,str1)) { 
			            validForm=true; 
			          if (this.isFreePlace(str,str1)) { 
			            if(this.placeShip(str,str1)){
			              Ship s= new Ship(str,str1);
			              this.addShip(s);
			     
			              String cat=s.checkSize(d);
			              if (cat.equals("Cruiser")){d++;}
			              System.out.printf("Placing" +" "+ cat+"\n");
			              validPlace=true;}
			            else {System.out.println("Cannot place anymore ships of this size \n "); }}
			            else {System.out.println("Cannot place ship there. Try again \n ");}}
			        else {System.out.println("Wrong coordinates format");}}}
				
			}}

			@Override
			public void FireAt(Player p1) {
//				
					String coord=null;
		          System.out.printf(" \n Player %d , it's time to Attack \n Choose a case ",this.getId());
		          try{ coord = sc.nextLine();}
		          catch(IndexOutOfBoundsException k) { coord = sc.nextLine();
		          System.out.printf("Player %d ,choose a Valid case please : ",this.getId());}
		          finally {
		          boolean touch=false;
		          if(Game.coordOk(coord)) {
		            for (Ship s: p1.getArmy()) {
		              if (!touch) {
		              for(Coordinates c: s.getListCoord()) {
		                if(coord.equals(c.getPosition())) {
		                  touch=true;
		                  if(!(this.getTargets().contains(c))){
		                  c.setdown(true);
		                  this.addtarget(c);
		             
		                  if (s.isDestroyed()) {
		                    this.score=score+1;;
		                    System.out.println("\t \t You sank my "+ s.category);}
		                  else {System.out.println("\t \t hit ");}}
		                  else {System.out.println("\t \t Already hit this position");}
		                  }
		                  }}}if(!touch){if(this.getFails().contains(coord)){System.out.println(" \t \t Already missed this position ");}
		                  else{System.out.println(" \t \t miss "); this.addfails(coord); }}
		                  }
		                  //System.out.print(Arrays.toString(current.fails.toArray()));
		                  
		             
		           

		             
		          else {System.out.println("\t This case not exist ");
		      }
		          }
		      
		       }
			

			public void printGrid(Player p2) {
				  
				  System.out.println(" \n  First Grid with your fleet: \n" );
				  int ch=65;
				  int ref=ch-1;
				  int test=0;
				  String pos;
				  for(int r=0;r<11;r++) {
					  
				  for (int c=0;c<11;c++) {
					  
					  if(c==0 && r==0) { System.out.print("    ");}
					  	else {if(c==0) {if(r==10) {System.out.print(""+r+" |");}
					  	else {System.out.print(" "+r+" |");}}
					  	
					  			else {if(r==0) {System.out.print(" "+(char)(ch)+" |"); ch++;}
					  					else {for(Coordinates cTarg: p2.getTargets()) {
					  										if(cTarg.getPosition().equals(""+(char)(ref+c) + r)) {System.out.print(" X |");test=1;}}
					  					
					  					   	  for(Ship sh: this.getArmy()) {
					  					   		  for (Coordinates cShip: sh.getListCoord()) {//si il ya un bateau mais qu'il est toucher on met une croix				  									
					  					   			  pos=cShip.getPosition();
					  					   			  if((pos.equals(""+(char)(ref+c) + r))&& (!(test==1))) {
					  									System.out.print(" B |");
					  									test=1;} 
					  										}}if (!(test==1)) {
						  										System.out.print(" ~ |");}test=0;}
					  									
					  						
					  									}
									  						// c'est quil y a un bateau mais qu'il est pas touch�
					  				
					  								}
					  							
						  		 }System.out.print(" \n");}
				  ch=65;
				  ref=ch-1;
				  
				  System.out.println(" \n Second Grid with your shoot : \n");
				  for(int r1=0;r1<11;r1++) {
					  for (int c1=0;c1<11;c1++) {
						  
						  if(c1==0 && r1==0) { System.out.print("    ");}
						  	else {if(c1==0) {if(r1==10) {System.out.print(""+r1+" |");}
						  	else {System.out.print(" "+r1+" |");}
						  	}
						  			else {if(r1==0) {System.out.print(" "+(char)(ch)+" |"); ch++;}
						  					else {
						  									for(Coordinates cTarg: this.getTargets()) {
						  										pos=cTarg.getPosition();					
						  										if(pos.equals(""+(char)(ref+c1) + r1)) {System.out.print(" X |");test=1;}}
						  									if(!(test==1)) {
						  									for (String cFails: this.getFails()) {
						  									if(cFails.equals(""+(char)(ref+c1) + r1)) {System.out.print(" O |"); test=1;}}
						  								}if(!(test==1)) {System.out.print( " ~ |");}
						  								else {test=0;}
						  								}
						  								}
							  		
							  			
							  			
							  		 }}System.out.print(" \n");}}

			@Override
			public void refresh() {
				this.getArmy().clear();
				this.getFails().clear();
				this.getTargets().clear();
				this.score=0;
				this.list1=getAr();
				
				
			}
				  

			
			}
				
				// else { //Vous ne pouvez pas placer de bateau sur ces coordonnees .
				
			

