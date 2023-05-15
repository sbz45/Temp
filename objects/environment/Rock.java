package objects.environment;
public class Rock{
	public boolean isInMap=false;
	boolean isInTrap=false;
	public Rock(){
		 isInMap=false;
		 isInTrap=false;
	}
	
	public boolean pick() {
		if (isInMap) {
			isInMap = false;
			return true;
		} else {
			return false;
		}

	}
}