package system.mainGame;

import system.printClass.PrintingModule;
import java.util.Scanner;
import objects.mapCube.MapCube;
import objects.avatar.Avatar;
import system.logicProcessing.GameSystem;



class Map {
	public static void selectStage() {
		PrintingModule.input = new Scanner(System.in);
		boolean temp=true;
		while (temp) {
			switch (PrintingModule.input.nextLine()) {
			case "stage 1":
				stage(1);
				temp=false;
				break;
			case "q":
				temp=false;
				break;
			case "stage 2":
				stage(2);
				temp=false;
				break;
			case "stage 3":
				stage(3);
				temp=false;
				break;
			case "Q":
				temp=false;
				break;
			case "new map":
			stage(4);
				temp=false;
				break;
			default:
				System.out.print("Wrong input,retry please.");
				break;

			}
		}
		
	}

	public static void stage(int keyToStage) {
		
		Avatar avatar = new Avatar();
		GameRecorder gameRecorder = new GameRecorder(keyToStage);

		MapCube[][] map = InitializeSceneAndAvatar.initializeSceneAndAvatar(gameRecorder, avatar);

		// tO avoid that the map do not render before inputting anything
		PrintingModule.printMap(avatar, map);

		while (gameRecorder.keyout) {

			system.logicProcessing.InputSet.checkInput(PrintingModule.input.nextLine());


			if(gameRecorder.keyout)PrintingModule.printMap(avatar, map);

			GameSystem.isWin(gameRecorder);

		}
		PrintingModule.input.close();
	}

	/*
	 * private static void newMap() {
	 * 
	 * }
	 */
}