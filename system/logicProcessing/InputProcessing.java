package system.logicProcessing;

import objects.avatar.Avatar;
import system.exception.WrongActionException;
import system.exception.WrongInputException;
import system.mainGame.GameRecorder;

public class InputProcessing {

	
	public static void inputProcessing(String action, Avatar avatar, GameRecorder gameRecorder) {
		try {
		if (action.equals("pickRock()")) {
			if (avatar.pickRock())
				gameRecorder.score+=1;
		} else if (action.equals("move()")) {
			avatar.move();
			if(GameSystem.isLose(gameRecorder, avatar, avatar.map));
		} else if (action.equals("turnLeft()")) {
			avatar.turnLeft();
		} else if (action.equals("showInformation()")) {
			GameSystem.showInformation(avatar, gameRecorder);
		} else if (action.equals("Q")) {
			gameRecorder.keyout = false;
		} else if (action.equals("putRock()")) {
			avatar.putRock();
		} else if (action.equals("noRockPresent()")) {
			avatar.noRockPresent();
		} else if (action.equals("noRockInBag()")) {
			avatar.noRockInBag();
		}else if (action.matches("move\\(\\d+\\)")) {
			int times = Integer.parseInt(action.replaceAll("[^\\d]", ""));
			for (int i = 0; i < times; i++) {
				avatar.move();
				if(GameSystem.isLose(gameRecorder, avatar, avatar.map))break;
			}
			
		} else {
			throw new WrongInputException("actionException");
		}
		}catch(WrongActionException exception)
		{
			exception.feedback();
		}catch(WrongInputException exception)
		{
			exception.feedback();
		}
		
	}
	




	/*
	 * private static int outRandom(int max) { return (int) (Math.random() * (max +
	 * 1)); }
	 */

	

	
}