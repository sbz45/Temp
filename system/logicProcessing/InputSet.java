package system.logicProcessing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

import objects.avatar.*;

public class InputSet {
	private static ArrayList<String> inputAvailable = new ArrayList<String>();
	private static ArrayList<String> operationAccording = new ArrayList<String>();

	static {
		inputAvailable.add("pickRock()");
		operationAccording.add("pickRock()");

		inputAvailable.add("move()");
		operationAccording.add("move()");

		inputAvailable.add("turnLeft()");
		operationAccording.add("turnLeft()");

		inputAvailable.add("showInformation()");
		operationAccording.add("showInformation()");

		inputAvailable.add("Q");
		operationAccording.add("Q");

		inputAvailable.add("putRock()");
		operationAccording.add("putRock()");

		inputAvailable.add("noRockPresent()");
		operationAccording.add("noRockPresent()");

		inputAvailable.add("noRockInBag()");
		operationAccording.add("noRockInBag()");

		inputAvailable.add("");
		operationAccording.add("");
	}

	public static void checkInput(String input) {
		if (hasInput(input)) {
			performInput(input);
		} else if (ifElseCheck(input)) {
			ifElseModule(input);
		} else if (definitionCheck(input)) {
			definitionModule(input);
		} else {
			System.out.print("Wrong Input Try Again!\n");
		}
	}

	private static boolean hasInput(String input) {
		if (inputAvailable.indexOf(input) != -1  ) {
			return true;
			}
			else if(input.matches("move\\(\\d+\\)")) {	
				
				return true;
			}
		return false;

	}

	private static void addInput(String name, String operation) {
		inputAvailable.add(name);
		operationAccording.add(operation);
	}

	private static void performInput(String input) {
		int indexInList = inputAvailable.indexOf(input);
		if(input.matches("move\\(\\d+\\)")) {system.logicProcessing.InputProcessing.inputProcessing(input, Avatar.theAvatar,
				Avatar.theAvatar.gameRecorder);return;}
		
			String[] inputLine = breakOperationsIntoSingleOperation(operationAccording.get(indexInList));
			for (String operation : inputLine) {

				system.logicProcessing.InputProcessing.inputProcessing(operation, Avatar.theAvatar,
						Avatar.theAvatar.gameRecorder);

			
		}
	}

	private static String[] breakOperationsIntoSingleOperation(String inputTile) {
		Pattern pattern = Pattern.compile("([a-z][a-z|A-Z|0-9]*\\([0-9]?\\))");// trying to match a function signature
		Matcher matcher = pattern.matcher(inputTile);

		List<String> list = new ArrayList<>();
		while (matcher.find()) {
			list.add(matcher.group());
		}
		String[] arr = new String[list.size()];
		list.toArray(arr);
		return arr;
	}

	private static boolean ifElseCheck(String inputLine) {
		if (inputLine.matches("if\\([a-z].*\\(\\)\\)\\{([a-z][a-z|A-Z|0-9]*\\([0-9]?\\);)+\\}"))
			return true;
		return false;
	}

	private static void ifElseModule(String inputLine) {

		String[] elements = breakOperationsIntoSingleOperation(inputLine);
		boolean key;
		if (elements[0].equals("noRockPresent()")) {
			key = Avatar.theAvatar.noRockPresent();
		} else if (elements[0].equals("noRockInBag()")) {
			key = Avatar.theAvatar.noRockInBag();
		} else {
			System.out.print("Wrong Input Try Again!\n");
			return;
		}
		if (key) {
			for (int i = 1; i < elements.length; i++) {
				performInput(elements[i]);
			}
		}
	}

	private static boolean definitionCheck(String inputLine) {
		if (inputLine.matches(".*\\(\\)\\{([a-z].+\\([0-9]?\\);)+?\\}"))
			return true;
		return false;
	}

	private static void definitionModule(String inputLine) {

		String[] elements = breakOperationsIntoSingleOperation(inputLine);
		String operations = "";
		for (int i = 1; i < elements.length; i++) {
			if(!hasInput(elements[i])) {
				System.out.println("Invalid input,not added");
			}else {
			operations=operations.concat(elements[i]);
			}
		}
		addInput(elements[0], operations);
	}
}