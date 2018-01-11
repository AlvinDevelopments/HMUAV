
public class Controller {
	
	public Controller(){
		//TO-DO
	}
	
	public static void sendCommand(String command){
		String[] commandArray = command.split(" ");
//		String[] commands = command.split("\n");
//		String[] commandArray = new String[100];
//		for(int i = 0; i < commands.length; i++) {
//			commandArray = commands[i].split(" ");
//		}
//		
//		if(commandArray.length==1) {
//			commandArray[0]=command;
//		}
		

		if(commandArray[0].compareTo("left")==0) {
			if(commandArray[1].compareTo("thrust")==0) {
				newGUI.sliders[0].setValue(Integer.valueOf(commandArray[2]));
			}
			else if(commandArray[1].compareTo("tilt")==0) {
				newGUI.sliders[1].setValue(Integer.valueOf(commandArray[2]));
			}
		}
		else if(commandArray[0].compareTo("rear")==0) {
			if(commandArray[1].compareTo("thrust")==0) {
				newGUI.sliders[2].setValue(Integer.valueOf(commandArray[2]));
			}
			else if(commandArray[1].compareTo("tilt")==0) {
				newGUI.sliders[3].setValue(Integer.valueOf(commandArray[2]));
			}
		}
		else if(commandArray[0].compareTo("right")==0) {
			if(commandArray[1].compareTo("thrust")==0) {
				newGUI.sliders[4].setValue(Integer.valueOf(commandArray[2]));
			}
			else if(commandArray[1].compareTo("tilt")==0) {
				newGUI.sliders[5].setValue(Integer.valueOf(commandArray[2]));
			}
		}
		
	}


}
