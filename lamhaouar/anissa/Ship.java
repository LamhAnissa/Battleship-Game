package lamhaouar.anissa;
import java.util.ArrayList;


public class Ship {

		String startCoord;
		String endCoord;
		private ArrayList<Coordinates> listCoord = new ArrayList<Coordinates>(); 
		String category;
	
			protected ArrayList<Coordinates> getListCoord() {
			return listCoord;
		}
		protected void setListCoord(ArrayList<Coordinates> listCoord) {
			this.listCoord = listCoord;
		}

		public String getCategory() {
			return category;
		}
		public void setCategory(String category) {
			this.category = category;
		}
		public Ship(String startCoord, String endCoord) {
			this.startCoord = startCoord;
			this.endCoord = endCoord;
			this.ArraylistCoord();
			
		}
		public String getStartCoord() {
			return startCoord;
			
		}	public String getEndCoord() {
			return endCoord;
		}
		public boolean isHztl() {
			return (startCoord.charAt(0)==endCoord.charAt(0));
		}
	
		public void ArraylistCoord(){	//Initialise Arraylist with all the Ship's Coordinates
			if (this.isHztl()){
				
				String letter = endCoord.substring(0,1);   
				int iStart = Integer.parseInt(startCoord.substring(1));
				int iEnd = Integer.parseInt(endCoord.substring(1));
				for (int i1=iStart;i1<iEnd +1; i1++) {
				Coordinates c =new Coordinates(letter + String.valueOf(i1),false);
				listCoord.add(c);
				 }}
				else {	String numC = endCoord.substring(1);
						char lStart=startCoord.charAt(0);
						char lEnd=(char)(endCoord.charAt(0)+1);   
						for (char i =lStart;i<lEnd; i++) {	
							String pos=i + numC;
							Coordinates c=new Coordinates(pos,false);
							listCoord.add(c);
							
						}}
									}	
											
	
		public int getlength() {
			// return Ship's length.
			return listCoord.size();
		}
		
		
		public boolean isHit() {
			boolean res = false;
			for (Coordinates c: listCoord) {
				if (c.down) {
					return true;
					}}
			return res;
				}
			
		public boolean isDestroyed() {
			boolean res=true;
			for (Coordinates c: this.listCoord) {
				if (!c.down) {
					return false;
					}}
			return res;
				}
			
		
		
		
			public String checkSize(int d) {
				int s= this.getlength();
				String sz=null;
				if (!(s==3)) {
					if (s==5) {
					sz="Carrier";}
					if(s==4) {sz="BattleShip";}
					if(s==2) {sz="Destroyer";}}
				else {if (d==0) {
						sz="Cruiser";}
						else{if (d==1) {
								sz="Submarine";}
				
				}
				
				
				}
				this.setCategory(sz);
				return sz;
			
			}}
					
				
			
				
			

			
		







		

