package system.exception;

import system.printClass.PrintingModule;

@SuppressWarnings("serial")
public class WrongInputException extends Exception {
	String type;

	public WrongInputException(String type) {
		this.type = type;

	}

	public void feedback() {
		switch (type) {
		case "stageSelectionException":
			PrintingModule.print("StageSelectionException()\n");
			break;
		case "actionException":
			PrintingModule.print("inputActionException()\n");
			break;
		}
	}
}