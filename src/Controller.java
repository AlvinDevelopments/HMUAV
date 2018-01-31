
public class Controller {
	
	public Controller(){
		//TO-DO
	}
	
	public static void sendCommand(String command){
		String[] commandArray = command.split("\n");
		String[][] commands = new String[commandArray.length][3];
		for( int i = 0; i < commandArray.length;i++) {
			commands[i] = commandArray[i].split(" ");
		}
		
//		if(commandArray.length==1) {
//			commandArray[0]=command;
//		}
		
		int i = 0;
		System.out.println("length is "+commands.length);
		
		while(i<commands.length) {
			System.out.println("compare "+i);
			if(commands[i][0].compareTo("left")==0) {
				if(commands[i][1].compareTo("thrust")==0) {
					newGUI.sliders[0].setValue(Integer.valueOf(commands[i][2]));
				}
				else if(commands[i][1].compareTo("tilt")==0) {
					newGUI.sliders[1].setValue(Integer.valueOf(commands[i][2]));
				}
			}
			else if(commands[i][0].compareTo("rear")==0) {
				if(commands[i][1].compareTo("thrust")==0) {
					newGUI.sliders[2].setValue(Integer.valueOf(commands[i][2]));
				}
				else if(commands[i][1].compareTo("tilt")==0) {
					newGUI.sliders[3].setValue(Integer.valueOf(commands[i][2]));
				}
			}
			else if(commands[i][0].compareTo("right")==0) {
				if(commands[i][1].compareTo("thrust")==0) {
					newGUI.sliders[4].setValue(Integer.valueOf(commands[i][2]));
				}
				else if(commands[i][1].compareTo("tilt")==0) {
					newGUI.sliders[5].setValue(Integer.valueOf(commands[i][2]));
				}
			}
			
			i++;
			
		}
	}


}
