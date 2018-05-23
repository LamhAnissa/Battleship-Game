package lamhaouar.anissa;


public class Computer1 extends Computer{
	 
	static String name= "Level MEDIUM";
	public Computer1(int id) {
		super(id);
	}
	int r=1; 
	  int i=65;
	  String str;
	  int parcours=1;
	 
	  
	  
	public String generatePosition() {
		if(tour==0) { r=1; 
		  i=65;
		  parcours=1;
		  tour=1;}
		str=""+(char)(i)+r;	
		
		if (parcours==1)	{
			if (r%2==1) {
				if(i<74) {
		    if (i==73) {r=r+1; i=66;}
			else {
				 i=i+2;}}}
				 else {if (i<74) {i=i+2;} else {if (i==74 && r<10) {r=r+1; i=65;} else {parcours=2; r=1; i=66;}}}}
		else{
			if (r%2==1) {
			if(i<75) {
			    if (i==74) {r=r+1; i=65;}
				else {
					 i=i+2;}}}
					 else {if (i<73) {i=i+2;} else {if (i==73 && r<10) {r=r+1; i=66;}}}}
	
	
		
		return str;}

		@Override
		public void FireAt(Player p1) {
	
		String coord=this.generatePosition();
		   boolean touch=false;
           for (Ship s: p1.getArmy()) {
             if (!touch) {
             for(Coordinates c: s.getListCoord()) {
               if(coord.equals(c.getPosition())) {
                 touch=true;
                 if(!(this.getTargets().contains(c))){
                 c.setdown(true);
                 this.addtarget(c);
                 System.out.println("You have been touch at "+coord +" by IA 1");
            
                 if (s.isDestroyed()) {
                   this.setScore();
                   }}
                }
                 }}}if(!touch){if(this.getFails().contains(coord)){System.out.println(" \t \t Already missed this position ");}
                 else{this.addfails(coord); System.out.println("IA1 : Miss "+coord);}}
		
		
		}
		

	
			
			
			
}
			
			
			
			
			
		
	
