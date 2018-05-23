package lamhaouar.anissa;

import java.util.ArrayList;

public class Computer2 extends Computer{
	static String name= "Level HARD";
	public Computer2(int id) {
		super(id);
	}

	 ArrayList<String> pass = new ArrayList<>();
	 boolean init=true;
	 String record;
	 String coord;
	 String previous;
	 String next;
	 int check=0;
	 int k=0;
	 int length=1;
	 
	 
	 
	 public String positionAttack() {
		 
	  
         if(tour==0) {
           record=this.generatePosition(63,1);
           coord=record;
            tour=1;
         }
         else {
        	 
          if (!(this.getFails().contains(record))) {
      
            if (check==0) {
            	length=1;
              k=coord.charAt(0)-1;
              System.out.println(k);
                 if(k>64){
                 previous=""+(char)(record.charAt(0)-1)+Integer.parseInt(record.substring(1));
                 if(!(this.getFails().contains(previous))) {
                   coord=previous;
                   check=1;}
                 else{record=generatePosition(record.charAt(0), Integer.parseInt(record.substring(1))); check=0; coord=record;}}
                   else{
                     if(record.charAt(0)+1<75){
                     next=""+(char)(record.charAt(0)+1)+Integer.parseInt(record.substring(1));
                   if(!(this.getFails().contains(next))) {
                     
                     coord=next;
                     check=2;}}}}
         
         
            else {
                   if (!(this.getFails().contains(coord))&& check ==1) {
                	  length++;
                     if (coord.charAt(0)-1>64){
                     previous=""+(char)(coord.charAt(0)-1)+coord.charAt(1);
                     if (!(this.getFails().contains(previous))){
                       coord=previous; length++;}
                     else{if (record.charAt(0)+1<75) {
                         coord=""+(char)(record.charAt(0)+1)+record.charAt(1); check=2;
                     }
                     else {record=generatePosition(record.charAt(0),Integer.parseInt(record.substring(1)));
                     	   check=0; coord=record;}}
                     }
                     else {if (record.charAt(0)+1<75) {
                       coord=""+(char)(record.charAt(0)+1)+record.charAt(1); check=2;
                       }
                     else {record=generatePosition(record.charAt(0),Integer.parseInt(record.substring(1))); check=0;}
                     }}
                     
                     
                     
                   else {
                     
                   if(this.getFails().contains(coord)&& check==1){
                     if(record.charAt(0)+1<75) {
                     next=""+(char)(record.charAt(0)+1)+(Integer.parseInt(record.substring(1)));
                     if(this.getFails().contains(next)) {next=""+(char)(record.charAt(0)+2)+(Integer.parseInt(record.substring(1))); check=0; length=0;}
                     else {coord=next; check=2;}
                     }
                     else {coord=""+(char)(record.charAt(0))+(Integer.parseInt(record.substring(1))-1); 
                     check=3;}}
                    
                   
                   else{
                   if(!(this.getFails().contains(coord))&& check ==2) {
                	   if(coord.charAt(0)+1<75) {
                     coord= ""+(char)(coord.charAt(0)+1)+Integer.parseInt(coord.substring(1));
                     length++;}
                	   else {record=generatePosition((coord.charAt(0)-1),(Integer.parseInt(coord.substring(1))));  coord=record; check=0;}}
                   else { if (length>1 && check==2) {
                     if(coord.charAt(0)+2<75){
                     record=generatePosition(coord.charAt(0),(Integer.parseInt(coord.substring(1))));
                     coord=record;
                     check=0;
                   }
                   else {record=generatePosition(record.charAt(0),(Integer.parseInt(record.substring(1))));
                     coord=record;
                     check=0;

                   }} 
                    
                   else {
                       if (Integer.parseInt(record.substring(1))-1>0 && check==2) {
                       previous=""+(char)(record.charAt(0))+(Integer.parseInt(record.substring(1))-1);
                         if(this.getFails().contains(coord)){
                         coord=previous; check=3;}}
                       //  }
                   
                      else{if(check==2) {coord=""+(char)(record.charAt(0))+Integer.parseInt(record.substring(1));}
                         
                      else {if(!(this.getFails().contains(coord))&& check ==3) {
                     k= Integer.parseInt(coord.substring(1))-1;
                     if(k>0 && k<11) {
                     coord=""+(char)(coord.charAt(0))+k;} 
                     else {coord=""+(char)(record.charAt(0))+Integer.parseInt(record.substring(1))+1; check=4;}}
                   else {
                     if (Integer.parseInt(record.substring(1))+1<11 && check==3) {
                       next=""+(char)(coord.charAt(0))+(Integer.parseInt(record.substring(1))+1);
                         if(!(this.getFails().contains(next))){	 
                         coord=next; check=4;}
                         else{ record=generatePosition(record.charAt(0), Integer.parseInt(record.substring(1)));
                        check=0; coord=record;}}
                
                 
                   
                     else { if(!(this.getFails().contains(coord))&& check ==4) {
                     k= Integer.parseInt(coord.substring(1))+1;
                     if(k>0 && k<11) {
                     coord=""+(char)(coord.charAt(0))+k;}
                     else {record=generatePosition(record.charAt(0),Integer.parseInt(record.substring(1))); coord=record; check=0; }}
                   else {if(this.getFails().contains(coord) && check==4){
                     record=generatePosition(record.charAt(0),Integer.parseInt(record.substring(1)));
                     coord=record;
                     check=0;}}}}}}}}}}}}
              
                     
                   
                 else {
				record=generatePosition(record.charAt(0),Integer.parseInt(record.substring(1)));
				if(this.pass.contains(record)){record=generatePosition(record.charAt(0),Integer.parseInt(record.substring(1)));
				}coord=record; check=0;}
         pass.add(coord);}
  
		return coord;}
      
      
		@Override
		public void FireAt(Player p1) {
			
		String coord=this.positionAttack();
		   boolean touch=false;
           for (Ship s: p1.getArmy()) {
             if (!touch) {
             for(Coordinates c: s.getListCoord()) {
           
               if(coord.equals(c.getPosition())) {
                 touch=true;
                 if(!(this.getTargets().contains(c))){
                 c.setdown(true);
                 this.addtarget(c);
                 System.out.println("You have been touch at "+coord+ " by IA2");
            
                 if (s.isDestroyed()) {
                   this.setScore();
                   }}
                }
                 }}}if(!touch){if(this.getFails().contains(coord)){System.out.println(" \t \t Already missed this position ");}
                 else{this.addfails(coord); System.out.println("Miss "+coord);}}
		
		
		}

		int r=1; 
		  int i=65;
		  String str;
		  int parcours=1;
		  
					
					
public String generatePosition(int i , int r) {
						
							if (r%2==1) {
								if(i<74 || i==74) {
						    if (i==73 || i==74) {r=r+1; i=66;}
							else {
								 i=i+2;}}}
								 else {if (i<74 && !(i==73)) {i=i+2;} else {if ((i==74|| i==73)&& r<10) {r=r+1; i=65;} else { r=1; i=66;}}}
						
							String str = ""+(char)(i)+r;

						
					return str;
							 }
						

			public void refresh() {
				super.refresh();
				this.pass.clear();
			}
			
		}
	