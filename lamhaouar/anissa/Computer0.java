package lamhaouar.anissa;

import java.util.Random;

public class Computer0 extends Computer{
	
	static String name= "Level BEGINNER";
	Random generator = new Random();
	
	public Computer0(int id) {
		super(id);
	}


		@Override
		public void FireAt(Player p1) {
			
				 String coord=Randy();
		          boolean touch=false;
		            for (Ship s: p1.getArmy()) {
		              if (!touch) {
		              for(Coordinates c: s.getListCoord()) {
		                if(coord.equals(c.getPosition())) {
		                  touch=true;
		                  if(!(this.getTargets().contains(c))){
		                  c.setdown(true);
		                  this.addtarget(c);
		                  System.out.println("You have been touch at "+coord);
		             
		                  if (s.isDestroyed()) {
		                    this.setScore();
		                    }}
		                 }
		                  }}}if(!touch){if(this.getFails().contains(coord)){System.out.println(" \t \t Already missed this position ");}
		                  else{this.addfails(coord); System.out.println("Miss "+coord);}}
		                  //System.out.print(Arrays.toString(current.fails.toArray()));
		                  }
		             
		           

		       
	
}
