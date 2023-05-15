package system.mainGame;



import system.printClass.PrintingModule;

public class GameStartEnd {

	
	public static void main(String[] args) {
		

		PrintingModule.printWelcome();
		system.mainGame.Map.selectStage();
		

		System.out.print("See you!");

	}
	public static boolean Restart(int stage) {
		
		System.out.print("Do you want to restart the game?\nYes or No\n");
		
		
		String  s=PrintingModule.input.nextLine();
		while(true){
		if(s.equals("Yes")) {
			
			system.mainGame.Map.stage(stage);
			return true;
		}else if(s.equals("No")){
		PrintingModule.printWelcome();
		system.mainGame.Map.selectStage();
		PrintingModule.input.close();
		return false;
		}
		}
	}
}