package system.mainGame;



import java.util.ArrayList;

import system.printClass.PrintingModule;
import objects.avatar.Avatar;
import objects.mapCube.MapCube;

public class InitializeSceneAndAvatar {
	static public MapCube[][] initializeSceneAndAvatar(GameRecorder gameRecorder, Avatar avatar) {
		MapCube[][] map;
		avatar.gameRecorder=gameRecorder;
		switch (gameRecorder.keyToStage) {
		case 1:
			gameRecorder.numRock = 1;

			map = new MapCube[3][6];
			initializeMapCubeArray(map);
			map[1][5].rock.isInMap = true;

			avatar.positionX = 0;
			avatar.positionY = 1;
			avatar.map = map;

			return map;

		case 2:
			gameRecorder.numRock = 1;

			map = new MapCube[3][6];
			initializeMapCubeArray(map);
			map[0][0].wall.isInMap = true;
			map[1][0].wall.isInMap = true;
			map[2][2].wall.isInMap = true;
			map[2][3].wall.isInMap = true;
			map[2][4].wall.isInMap = true;
			map[2][5].wall.isInMap = true;
			map[1][5].rock.isInMap = true;

			avatar.positionX = 0;
			avatar.positionY = 2;
			avatar.map = map;

			return map;

		case 3:
			gameRecorder.numRock = 2;

			map = new MapCube[5][8];
			initializeMapCubeArray(map);
			map[0][4].wall.isInMap = true;
			map[1][4].wall.isInMap = true;
			map[3][4].wall.isInMap = true;
			map[3][5].wall.isInMap = true;
			map[3][6].wall.isInMap = true;
			map[3][7].wall.isInMap = true;
			map[4][4].wall.isInMap = true;
			map[4][5].wall.isInMap = true;
			map[4][6].wall.isInMap = true;
			map[4][7].wall.isInMap = true;
			map[0][7].rock.isInMap = true;
			map[1][2].rock.isInMap = true;
			map[2][4].trap.isInMap = true;

			avatar.positionX = 0;
			avatar.positionY = 4;
			avatar.map = map;

			return map;
		case 4:

			

			System.out.println("Please input map");

			String mapLine;
			mapLine = PrintingModule.input.nextLine();
			
			
			
			ArrayList<MapCube[]> mapCubeAll = new ArrayList<MapCube[]>();

			int count = 0;
			
			while (!mapLine.equals("")){
				ArrayList<MapCube> mapCubeLine = new ArrayList<MapCube>();
				
				for (int i = 0; i < mapLine.length(); i++) {
					
					
					switch (mapLine.charAt(i )) {
					case '·':
						mapCubeLine.add(new MapCube());
						break;
					case '■':
						mapCubeLine.add(new MapCube());
						mapCubeLine.get(mapCubeLine.size()-1).wall.isInMap = true;
						break;
					case '×':
						mapCubeLine.add(new MapCube());
						mapCubeLine.get(mapCubeLine.size()-1).trap.isFilled = true;
						break;
					case '⊙':
						mapCubeLine.add(new MapCube());
						mapCubeLine.get(mapCubeLine.size()-1).trap.isInMap = true;
						break;
					case '●':
						mapCubeLine.add(new MapCube());
						mapCubeLine.get(mapCubeLine.size()-1).rock.isInMap = true;
						gameRecorder.numRock++;
						break;
					case '►':
						mapCubeLine.add(new MapCube());
						avatar.positionX = mapCubeLine.size()-1;
						avatar.positionY = count;
						avatar.direction=0;
						break;
					case '▲':
						mapCubeLine.add(new MapCube());
						avatar.positionX = mapCubeLine.size()-1;
						avatar.positionY = count;
						avatar.direction=1;
						break;
					case '◄':
						mapCubeLine.add(new MapCube());
						avatar.positionX = mapCubeLine.size()-1;
						avatar.positionY = count;
						avatar.direction=2;
						break;
					case '▼':
						mapCubeLine.add(new MapCube());
						avatar.positionX = mapCubeLine.size()-1;
						avatar.positionY = count;
						avatar.direction=3;
						break;
					}
				}
				count++;
				mapLine = PrintingModule.input.nextLine();
				MapCube[] arr=new MapCube[mapCubeLine.size()];
				mapCubeAll.add( mapCubeLine.toArray(arr));
			}
			map = new MapCube[mapCubeAll.size()][];
			for (int i = 0; i < mapCubeAll.size(); i++) {
				map[i] = mapCubeAll.get(i);
			}

			avatar.map = map;

			return map;

		}
		return null;
	}

//	private static int getLengthValid(String s) {
//		int count = 0;
//		for (int i = 0; i < s.length(); i++) {
//			if (s.charAt(i) != ' ')
//				count++;
//		}
//		return count;
//	}

	private static void initializeMapCubeArray(MapCube[][] map) {

		for (MapCube[] row : map) {
			for (int i = 0; i < row.length; i++) {
				row[i] = new MapCube();
			}
		}

	}
}