package objects.avatar;

import objects.mapCube.MapCube;
import system.exception.*;
import system.mainGame.GameRecorder;
import system.printClass.PrintingModule;

public class Avatar {
	public int positionX=123124;
	public int positionY=12412321;
	public int direction;
	public int rockInBag;
	public static Avatar theAvatar;
	
	
	
	//the map that the avatar exists maintenant
	public MapCube[][] map;
	public GameRecorder gameRecorder;

	/*
	 * Avatar(int positionX,int positionY) { this.positionX = positionX;
	 * this.positionY = positionY; direction = 3; }
	 */

//	Avatar(MapCube[][] map){
//		direction=0;
//		rockInBag=0;
//		this.map=map;
//	}
	public Avatar(){
		direction=0;
		rockInBag=0;
		theAvatar=this;
	}
	
	public void turnLeft() {
		direction = (direction + 1) % 4;
	}

	public void turnRight() {
		direction = (direction + 3) % 4;
	}

	// pick up the rock in the front ,return true if accomplished
	public boolean pickRock() throws WrongActionException{
		if (getCubeAhead().rock.isInMap == true) {
			getCubeAhead().rock.isInMap = false;
			rockInBag++;
			return true;
		}
		if (getCubeAhead().trap.isFilled == true)throw 
			new WrongActionException("trapAlreadyFilledException");
		throw new WrongActionException("rockDoNotExistException");
		
	}

	private MapCube getCubeAhead()throws ArrayIndexOutOfBoundsException {
		
		switch (direction) {
		case 0:

			return map[positionY][positionX + 1];

		case 1:

			return map[positionY - 1][positionX];

		case 2:

			return map[positionY][positionX - 1];

		case 3:

			return map[positionY + 1][positionX];

		}
		return map[0][0];
		

	}

	

	public void move() throws WrongActionException{
		try {
		if (getCubeAhead().isPassable() == false) {
			if(getCubeAhead().wall.isInMap)throw new WrongActionException("movingIntoWallException");
			throw new WrongActionException("movingIntoRockException");
			
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			PrintingModule.print("ArrayIndexOutOfBoundsException\n");
			return ;
		}
		switch (direction) {
		case 0:
			if(positionX==map[0].length)throw new WrongActionException("movingOutOfBoundException");
			positionX++;
			break;
		case 1:
			if(positionY==-1)throw new WrongActionException("movingOutOfBoundException");
			positionY--;
			break;
		case 2:
			if(positionX==0)throw new WrongActionException("movingOutOfBoundException");
			positionX--;
			break;
		case 3:
			if(positionY==map.length)throw new WrongActionException("movingOutOfBoundException");
			positionY++;
			break;
		}
	}

	public boolean putRock()throws WrongActionException {
		MapCube cubeAhead=getCubeAhead();
		if(!cubeAhead.trap.isInMap)throw new WrongActionException("trapDoNotExistException");
		if(cubeAhead.trap.isFilled)throw new WrongActionException("trapAlreadyFilledException");
		if(rockInBag==0)throw new WrongActionException("noRockInBagException");
		rockInBag--;
		cubeAhead.trap.fill();
		return true;
	}

	public boolean noRockPresent() {
		try {
		if(!getCubeAhead().rock.isInMap) {
			System.out.println(true);
			return true;
		}
		System.out.println(false);
		return false;
		}catch(ArrayIndexOutOfBoundsException e) {
			PrintingModule.print("ArrayIndexOutOfBoundsException\n");
			return true;
		}
	}
	
	public boolean noRockInBag() {
		
		if(rockInBag==0) {
			System.out.println(true);
			return true;
		}
		System.out.println(false);
		return false;
		
	}
}