package system.logicProcessing;
import system.mainGame.*;
import objects.avatar.Avatar;
import objects.mapCube.MapCube;
import system.mainGame.GameRecorder;
import system.printClass.PrintingModule;

public class GameSystem{
	public static void showInformation(Avatar avatar ,GameRecorder gameRecorder ) {
		System.out.print("There is " + (gameRecorder.numRock - gameRecorder.score) + " rock on the map that you need to collect.");

		System.out.print("There is " + avatar.rockInBag + " rock in your bag.");

		if (gameRecorder.numRock != gameRecorder.score) {
			int distance = 0x7fffffff;
			int minDistance = 0x7fffffff;
			for (int x = 0; x < avatar.map[0].length; x++) {
				for (int y = 0; y < avatar.map.length; y++) {
					if (avatar.map[y][x].rock.isInMap)
						distance = Math.abs(avatar.positionX - x) + Math.abs(avatar.positionY - y);
					if (distance < minDistance)
						minDistance = distance;
				}
			}
			System.out.print("You are " + minDistance + " steps away from the nearest rock.\n");
		} else {
			System.out.print("Congratulations!You've already collected all the rocks");
		}
	}
	
	public static boolean isWin(GameRecorder gameRecorder) {
		if(gameRecorder.score==gameRecorder.numRock) {
			gameRecorder.keyout=false;
			System.out.print("Congratulations!You've already collected all the rocks\n");
			GameStartEnd.Restart(gameRecorder.keyToStage);
			return true;
		}
		return false;
	}
	
	public static boolean isLose(GameRecorder gameRecorder,Avatar avatar,MapCube[][] map) {
		if(map[avatar.positionY][avatar.positionX].trap.isInMap) {
			gameRecorder.keyout=false;
			PrintingModule.printMap(avatar, map);
			System.out.print("Oops!You Lose!\n");
			GameStartEnd.Restart(gameRecorder.keyToStage);
			return true;
		}
		return false;
	}
}
