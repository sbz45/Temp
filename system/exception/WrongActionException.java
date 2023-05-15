package system.exception;

import system.printClass.PrintingModule;



@SuppressWarnings("serial")
public class WrongActionException extends Exception {

	String type;

	public WrongActionException(String type) {
		this.type = type;

	}

	public void feedback() {
		switch (type) {
		case "inputNotExistException":
			PrintingModule.print("InputNotExistException()\n");
			break;
		case "rockAlreadyFilledException":
			PrintingModule.print("RockAlreadyFilledException()\n");
			break;
		case "rockDoNotExistException":
			PrintingModule.print("RockDoNotExistException()\n");
			break;
		case "trapDoNotExistException":
			PrintingModule.print("TrapDoNotExistException()\n");
			break;
		case "trapAlreadyFilledException":
			PrintingModule.print("TrapAlreadyFilledException()\n");
			break;
		case "movingIntoWallException":
			PrintingModule.print("MovingIntoWallException()\n");
			break;
		case "movingIntoRockException":
			PrintingModule.print("MovingIntoRockException()\n");
			break;
		case "movingOutOfBoundException":
			PrintingModule.print("MovingOutOfBoundException()\n");
			break;
		}
	}

}