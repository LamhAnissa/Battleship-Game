package lamhaouar.anissa;
import java.util.ArrayList;

public class Game {
	private Player[] players = new Player[2];
	
	
	public Player[] getPlayers() {
		return players;
	}
	


	public Game(Player p1, Player p2) {
	    this.players[0] = p1;
	    this.players[1] = p2;
	  }

		public static boolean coordOk(String a) {
			char ch;
			int y;
			boolean v=false;
			try{ch=a.charAt(0);} catch (IndexOutOfBoundsException e){return false;}
			if(Character.isLetter(ch) && ch<75){
				String y0 =a.substring(1);
		    	if (!isNaN(y0)){
		    		try { y=Integer.parseInt(y0);} catch(NumberFormatException n) {return false;}
		    		if (y>0 && !(y>10)) {
		    		v= true ;
		    			}
		    		}
				}
			return v;
			
		}
				
		
	

		public static boolean isValidForm(String cStart, String cEnd) {
			char row1;
			char row2;
			int y;
			int y2;
			boolean valid=false;
			
			try { row1 = cStart.charAt(0);
			     row2 = cEnd.charAt(0);}
			catch(IndexOutOfBoundsException r) {return false;}
			
		    if(Character.isLetter(row1) && Character.isLetter(row2)){
		    	if (row1<75 && row2<75) {
				String y0 =cStart.substring(1);
				String y1=cEnd.substring(1);
		    	if (!(isNaN(y0) || isNaN(y1))){
		    		int diffRow=(row2-row1);
		    		try{ y2=Integer.parseInt(y1);
		    		 y=Integer.parseInt(y0);} catch (NumberFormatException n) {return false;}
					int diffColumn=(y2-y);
					if (!(diffRow<0 || diffColumn<0)) {
		    		if((diffRow<=4 && diffColumn==0 && y2<11 ) || (diffColumn<=4 && diffRow==0 && y2<11)){
		    			valid = true ;
		    			}
		    		}
				}
		    }
		    }
			return valid;
			 }

		public static  boolean isNaN(String s1) {
			boolean res=false ;
			char[] ch=s1.toCharArray();
			for(char c : ch){ 
				if(!Character.isDigit(c)){ //&& res pour eviter de rentrer dans la boucle pour R.
					res= true; } 
				}
			return res;
	
		}
		
		
		public static ArrayList<String> CoordTemp(String start1,String end1){
			
			
			ArrayList<String> coordTest = new ArrayList<String>(); 	//Initialise Arraylist with all the Ship's Coordinates
				
			if (start1.charAt(0)==end1.charAt(0)){
					
					String letter = end1.substring(0,1);   
					int iStart = Integer.parseInt(start1.substring(1));
					int iEnd = Integer.parseInt(end1.substring(1));
					for (int i1=iStart;i1<iEnd +1; i1++) {
					String s =letter + String.valueOf(i1);
					coordTest.add(s);
					 }}
					else {	String numC = end1.substring(1);
							char lStart=start1.charAt(0);
							char lEnd=(char)(end1.charAt(0)+1);   
							for (char i =lStart;i<lEnd; i++) {	
								String pos=i + numC;
								coordTest.add(pos);
								
							}}
								return coordTest;		}	
	

	 
		public void printTable(Player p1, Player p2) {// Fonction d'affichage graphique 
			System.out.println("     -----------------------------------              -----------------------------------  ");
			System.out.println("               <Player 1>                                           <Player 2>              ");
			System.out.println("     -----------------------------------              -----------------------------------");
			
			System.out.print("                 Nb Success: "+p1.getTargets().size()+"         ");
			System.out.println("               Nb Success:: "+p2.getTargets().size()+"         ");
			System.out.print("                 Nb missed:: "+p1.getFails().size()+"         ");
			System.out.println("               Nb missed:: "+p2.getFails().size()+"         ");
			System.out.print("                 Score: "+p1.getScore()+"         ");
			System.out.println("                     Score: "+p2.getScore()+"         ");
		}
			

}