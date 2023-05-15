package objects.mapCube;

import objects.environment.Rock;
import objects.environment.Trap;
import objects.environment.Wall;

public class MapCube{
	 

	 
	public Rock rock=new Rock();
	public Trap trap=new Trap();
	public Wall wall=new Wall();
	int positionX;
	int positionY;
	
	public boolean isPassable() {
		if(rock.isInMap==false&&wall.isInMap==false)return true;
		return false;
	}
}