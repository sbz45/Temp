package objects.environment;

public class Trap {
	public boolean isInMap = false;
	public boolean isFilled = false;

	public Trap() {
		isInMap = false;

	}

	public void fill() {

		
		isFilled = true;
		isInMap = false;
		

	}
}