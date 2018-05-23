package lamhaouar.anissa;

public class Coordinates {
	
	private String position;
	boolean down;
	
	public Coordinates(String position, boolean down) {
		this.position = position;
		this.down = down;
	}

	public String getPosition() {
		return position;
	}

	public boolean isdown() {
		return down;
	}

	public void setdown(boolean down) {
		this.down = down;
	}
	



}
