package system.printClass;

import java.util.Scanner;

import objects.avatar.Avatar;
import objects.mapCube.MapCube;

public class PrintingModule {

	
	public static Scanner input=new Scanner(System.in);
	
	public static void print(String output) {
		System.out.print(output);
	}

	public static void printWelcome() {
		print("▮▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▮\n");
		print("▮      		S				     ▮\n");
		print("▮            enter a number to select stage          ▮\n");
		print("▮                                                    ▮\n");
		print("▮     stage 1      stage 2      stage3    new map    ▮\n");
		print("▮▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▬▮\n\n");
		print("       made by Lan Jiajie,Student ID:22302010012\n");
		print("       enter 'Q' for quit(better later)\n");
	}

	public static void printMap(Avatar avatar, MapCube map[][]) {

		for (int i = 0; i < map.length; i++) {					// printing by rows
			for (int j = 0; j < map[i].length; j++) {			// printing by columns
				if (avatar.positionX == j && avatar.positionY == i) {
					printAvatar(avatar.direction); 
				} else if (map[i][j].wall.isInMap) {
					print("■");
				} else if (map[i][j].trap.isFilled) {
					print("×");
				} else if (map[i][j].trap.isInMap) {
					print("⊙");
				} else if(map[i][j].rock.isInMap) {
					print("●");
				} else {
					print("·");
				}

			}

			print("\n");
		}
	}
	
	private static void printAvatar(int direction) {
		if (direction == 0) {
			System.out.print("►");
		} else if (direction == 1) {
			System.out.print('▲');
		} else if (direction == 2) {
			System.out.print('◄');
		} else if (direction == 3) {
			System.out.print('▼');
		}
	}
}
