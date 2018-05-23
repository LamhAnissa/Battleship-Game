package fr.battleship;

import java.io.FileWriter;
import java.io.IOException;

import lamhaouar.anissa.*;
public class TestIA{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Test IA 

		
		int lvl1_0=0;
		int lvl0_1=0;
		int lvl1_2=0;
		int lvl2_1=0;
		int lvl2_0=0;
		int lvl0_2=0;
		
		boolean finish1=false;
		
		int t=-1;
		int v;
		Computer0 c0=new Computer0(0);
		Computer1 c1= new Computer1(1);
		Computer2 c2= new Computer2(2);
	Game g1=new Game(c0,c1);
	for(int nb=0;nb<100;nb++) {
			
			 t++;
				t=t%2;
			
			System.out.println("joueur 1  : " +g1.getPlayers()[t].getId());
			c0.InitFleet();
			c1.InitFleet();
			 v=(t+1)%2;
			while(!(finish1)) {
				g1.getPlayers()[t].FireAt(g1.getPlayers()[v]);
				if(g1.getPlayers()[t].getScore()==5) { 
					finish1=true;
					if (g1.getPlayers()[t].getId()==1) {lvl1_0++; System.out.println("Player 1 win");}
					else {lvl0_1++;}}
				else{g1.getPlayers()[v].FireAt(g1.getPlayers()[t]);
					if (g1.getPlayers()[v].getScore()==5) {
						finish1=true;  
						if (g1.getPlayers()[v].getId()==1) {lvl1_0++; System.out.println("Player 1 win");}
						else {if (g1.getPlayers()[v].getId()==0) { lvl0_1++; System.out.println("Player 1 win");}}}}
			}	
	c1.tour=0; finish1=false; for(Player p: g1.getPlayers()) {p.refresh();}}
	System.out.println(" score lvl 1 : "+lvl1_0+ "  lvl0 :"+lvl0_1);
Game g2=new Game(c2,c1);
	for(int nb=0;nb<100;nb++) {
		
		 t++;
			t=t%2;
		
		System.out.println("joueur 1  : " +g1.getPlayers()[t].getId());
		c2.InitFleet();
		c1.InitFleet();
		 v=(t+1)%2;
		while(!(finish1)) {
		System.out.println(g2.getPlayers()[t].getId());
			g2.getPlayers()[t].FireAt(g2.getPlayers()[v]);
			if(g2.getPlayers()[t].getScore()==5) { 
				finish1=true;
				if (g2.getPlayers()[t].getId()==1) {lvl1_2++; System.out.println("Player 1 win");}
				else {lvl2_1++;}}
			else{g2.getPlayers()[v].FireAt(g2.getPlayers()[t]);
				if (g2.getPlayers()[v].getScore()==5) {
					finish1=true;  
					if (g2.getPlayers()[v].getId()==1) {lvl1_2++; System.out.println("Player 1 win");}
					else {if (g2.getPlayers()[v].getId()==2) { lvl2_1++; System.out.println("Player 1 win");}}}}
		}	
c1.tour=0; finish1=false; for(Player p: g2.getPlayers()) {p.refresh();}}
System.out.println(" score lvl 1 : "+lvl1_2+ "  lvl2 :"+lvl2_1);	
	
Game g4=new Game(c2,c0);
for(int nb=0;nb<100;nb++) {
	
	 t++;
		t=t%2;
	
	System.out.println("joueur 1  : " +g4.getPlayers()[t].getId());
	c0.InitFleet();
	c2.InitFleet();
	 v=(t+1)%2;
	while(!(finish1)) {
	System.out.println(g4.getPlayers()[t].getId());
		g4.getPlayers()[t].FireAt(g4.getPlayers()[v]);
		if(g4.getPlayers()[t].getScore()==5) { 
			finish1=true;
			if (g4.getPlayers()[t].getId()==2) {lvl2_0++; }
			else {lvl2_0++;}}
		else{g4.getPlayers()[v].FireAt(g4.getPlayers()[t]);
			if (g4.getPlayers()[v].getScore()==5) {
				finish1=true;  
				if (g4.getPlayers()[v].getId()==2) {lvl2_0++; }
				else {if (g4.getPlayers()[v].getId()==0) { lvl0_2++; }}}}
	}	
c2.tour=0; finish1=false; for(Player p: g4.getPlayers()) {p.refresh();}}
System.out.println(" score lvl 0 : "+lvl0_2+ "  lvl2 :"+lvl2_0);	
System.out.println(" score lvl 1 : "+lvl1_2+ "  lvl2 :"+lvl2_1);	

try{ FileWriter file = new FileWriter("ai_proof.csv");
file.append("AI Name ; score; AI Name2; score2 \n");
file.append("AI Level Beginner;" + lvl0_1 +" Level Medium;"+ lvl1_0 +"\n");
file.append("AI Level Beginner;" + lvl0_2 +" Level Hard;"+ lvl2_0 +"\n");
file.append("AI Level Medium;" + lvl1_2 +" Level Medium;"+ lvl2_1 +"\n");
file.close();
}
catch(IOException e){e.printStackTrace();}}}





	