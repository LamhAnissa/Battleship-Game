package lamhaouar.anissa;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Battleship {
	public static void main (String[] args) {
		


		System.out.println("                                BATTLESHIP  GAME        \n     ");	
		boolean replay=true;
		boolean finish = false;
	Scanner scan = new Scanner(System.in);
	int nbShips=5;
		String enter;


		int str = 0;
	
		System.out.println("Choose your play mode : 1 for Human VS Human \n  \t  \t \t2 for Human VS Computer \n \t  \t \t3 for Computer VS Computer \n");
	    try{str=scan.nextInt();} catch(InputMismatchException f) { System.out.println(" Not valid entry: ");str=scan.nextInt();} 
	    finally{
	    while(str>3 || str==0){
	    	System.out.println("Choose your play mode between 1 and 3 ...");
	    	try{str=scan.nextInt();} catch (InputMismatchException d) {str=scan.nextInt();}}
	
	    if (str==1) {
	    	
	int t =-1;    	
	HumanPlayer p1=new HumanPlayer(1);
	HumanPlayer p2=new HumanPlayer(2);
	Game g= new Game(p1,p2);
	while(replay) {
		
	for(Player p: g.getPlayers()) {
	int i=p.getId();
	i=(i+1)%2;
	((HumanPlayer)p).InitFleet();
	((HumanPlayer) p).printGrid(g.getPlayers()[i]);
	System.out.println("\n Check your grid ,and then it's to the 2nd player to play\n");	
}
	System.out.println("\n"+" Done placing ships \n");	
	System.out.println("Now , Let's start!");
	
	t++;
	t=t%2;
	int v=(t+1)%2;
	while(!finish) {

		g.getPlayers()[t].printGrid(g.getPlayers()[v]);
		g.getPlayers()[t].FireAt(g.getPlayers()[v]);
		if (g.getPlayers()[t].getScore()==nbShips) {System.out.println("   Player " + g.getPlayers()[t].getId() +" you win !" + "\n" );
		finish=true;
		}else {g.getPlayers()[v].printGrid(g.getPlayers()[t]); g.getPlayers()[v].FireAt(g.getPlayers()[t]);
		if (g.getPlayers()[v].getScore()==nbShips) {System.out.println("   Player " + g.getPlayers()[v].getId() +" you win !" + "\n" );
		finish=true;
		}}}g.printTable(g.getPlayers()[t],g.getPlayers()[v]); 
		System.out.println("Do you want to take your revenge?  : 1-Yes / 2-No ");
		int rep=scan.nextInt();
		if(rep==1) {finish=false; g.getPlayers()[1].refresh(); g.getPlayers()[0].refresh();}
		else {replay=false; t=-1; System.out.println("END");}}
		
	}
	    else {if (str==2) {
	    	int t=-1;
	    	HumanPlayer p3= new HumanPlayer(1);
	    	int level;
	    	System.out.println(" Select the level of AI against which you want to play : 0- Level Beginner, 1- Level Medium or 2- Level Hard" );
	    	try{level=scan.nextInt();} catch(InputMismatchException q) {System.out.println("Choose a level between [0,2] :"); level=scan.nextInt();}
	    	while (level>2) {System.out.println(" This level of AI not exist" ); System.out.println(" Select the level of AI against which you want to play : (0, 1 or 2)" );
	    	str=scan.nextInt();}
	    	
	    	Player Ai = null;
	    	Game g=new Game(p3,Ai);
	    	if (level==0) {
	    		g.getPlayers()[1]=new Computer0(2);}
		    	else {if (level==1) {g.getPlayers()[1]=new Computer1(2);} 
		    	else {g.getPlayers()[1]=new Computer2(2);}
		    	}
	    	while (replay) {
	    		t++;
	    		t=t%2;
	    		int v=(t+1)%2;
	    	g.getPlayers()[t].InitFleet();
	    	if(t==0) {
	    	p3.printGrid(g.getPlayers()[1]);	 }
	    	g.getPlayers()[v].InitFleet();
	    	if(v==0){
		    	p3.printGrid(g.getPlayers()[1]); }
	    	   while (!(finish)) {
	    		   if(t==0) {
	    		    	p3.printGrid(g.getPlayers()[1]);
	    		   }
	    		   g.getPlayers()[t].FireAt(g.getPlayers()[v]);
				if (g.getPlayers()[t].getScore()==nbShips) {System.out.println("   Player " + g.getPlayers()[t].getId() +" you win !" + "\n" );
				finish=true;}
				else {if(v==0) {
			    	p3.printGrid(g.getPlayers()[1]);}
					g.getPlayers()[v].FireAt(g.getPlayers()[t]);
				if (g.getPlayers()[v].getScore()==nbShips) {System.out.println("   Player " + g.getPlayers()[t].getId() +" you loose !" + "\n" );
				finish=true;}}}
			g.printTable(g.getPlayers()[t], g.getPlayers()[v]); 
			System.out.println("Do you want to take your revenge?  : 1-Yes / 2-No ");
			int rep=scan.nextInt();
			if(rep==1) {finish=false; g.getPlayers()[1].refresh(); g.getPlayers()[0].refresh();}
			else {replay=false; t=-1; System.out.println("END");}}
			

	    	}
	    	
	    else { Computer p1 = null;
      Computer p2 = null;
      Game g3=new Game(p1,p2);
    for(int i=0;i<2;i++) {
  System.out.printf(" Select the level of the  AI n %d :0(Beginner), 1(Medium) or 2(Hard)",i+1 );
 try { str=scan.nextInt();} catch(InputMismatchException z) {System.out.println("Choose a level between [0,2] :"); str=scan.nextInt();}
  if (str==0) {g3.getPlayers()[i]= new Computer0(i+1);}
  else {if(str==1) {g3.getPlayers()[i]= new Computer1(i+1);}
  else {g3.getPlayers()[i] = new Computer2(i+1);}}}
    int t=-1;
   while(replay) {
	   t++;
		t=t%2;
		int v=(t+1)%2; 

  g3.getPlayers()[t].InitFleet();
  g3.getPlayers()[v].InitFleet();
  while (!(finish)) {
    g3.getPlayers()[t].FireAt(g3.getPlayers()[v]);
    if(g3.getPlayers()[t].getScore()==nbShips) {finish=true; }
    else{g3.getPlayers()[v].FireAt(g3.getPlayers()[t]);
    if (g3.getPlayers()[v].getScore()==nbShips) {
  finish=true;}
  
  }
  }g3.printTable(g3.getPlayers()[t],g3.getPlayers()[v]); System.out.println("Do you want to take your revenge?  : 1-Yes / 2-No ");
	int rep=scan.nextInt();
	if(rep==1) {finish=false; for(Player p: g3.getPlayers()) {p.refresh();} g3.getPlayers()[0].setTour(); g3.getPlayers()[1].setTour();}
	else {replay=false; t=-1; System.out.println("END");}}}}

	  
	
	
	}

    
    


}}


