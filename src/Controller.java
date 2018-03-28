
public class Controller extends Thread{
	
	public Controller(){
		//TO-DO
	}
	
	public static void yawLeft(int degree) {
		
	}
	
	public static void yawRight(int degree) {
		
	}
	
	
	public static void rollLeft(int degree) {
		
	}
	
	public static void rollRight(int degree) {
		
	}
	
	public static void pitchLeft(int degree) {
		
	}
	
	public static void pitchRight(int degree) {
		
	}
	
	public static void moveForward(int thrust) {
		Launcher.sServer.sendMessage(50,50,50);
		Launcher.hServer.sendMessage(thrust,thrust,thrust);
		newGUI.servo_1.setValue(50);
		newGUI.servo_2.setValue(50);
		newGUI.servo_3.setValue(50);
		newGUI.thruster_1.setValue(thrust);
		newGUI.thruster_2.setValue(thrust);
		newGUI.thruster_3.setValue(thrust);
	}
	
	public static void moveBackward(int thrust) {
		Launcher.sServer.sendMessage(0,0,0);
		Launcher.hServer.sendMessage(thrust,thrust,thrust);
		newGUI.servo_1.setValue(0);
		newGUI.servo_2.setValue(0);
		newGUI.servo_3.setValue(0);
		newGUI.thruster_1.setValue(thrust);
		newGUI.thruster_2.setValue(thrust);
		newGUI.thruster_3.setValue(thrust);
	}
	
	
	public static void leftThrust(int dutyCycle) {
		
		
		
	}
	
	public static void rightThrust(int dutyCycle) {
		
	}
	
	public static void rearThrust(int dutyCycle) {
		
	}
	
	public static void leftTilt(int dutyCycle) {
		
	}
	
	public static void rightTilt(int dutyCycle) {
		
	}
	
	public static void rearTilt(int dutyCycle) {
		
	}
	
	public static void stopThrusters() {
		Launcher.hServer.sendMessage(50,50,50);
	}
	
	
	
	public static void sendCommand(String command){
		System.out.println(command);
		String[] commandArray = command.split("\n");
		String[][] commands = new String[commandArray.length][3];
		for( int i = 0; i < commandArray.length;i++) {
			commands[i] = commandArray[i].split(" ");
		}
		
		
		int i = 0;
		
		while(i<commands.length) {
			System.out.println("compare "+i);
			System.out.println(commands[i][0]);
			
			if(commands[i][0].compareTo("forward")==0) {
				moveForward(Integer.valueOf(commands[i][1]));
			}
			else if(commands[i][0].compareTo("backward")==0) {
				moveBackward(Integer.valueOf(commands[i][1]));
			}
			else if(commands[i][0].compareTo("left")==0) {
				if(commands[i][1].compareTo("thrust")==0) {
					newGUI.thruster_1.setValue(Integer.valueOf(commands[i][2]));
				}
				else if(commands[i][1].compareTo("tilt")==0) {
					newGUI.servo_1.setValue(Integer.valueOf(commands[i][2]));
				}
			}
			else if(commands[i][0].compareTo("rear")==0) {
				if(commands[i][1].compareTo("thrust")==0) {
					newGUI.thruster_2.setValue(Integer.valueOf(commands[i][2]));
				}
				else if(commands[i][1].compareTo("tilt")==0) {
					newGUI.servo_2.setValue(Integer.valueOf(commands[i][2]));
				}
			}
			else if(commands[i][0].compareTo("right")==0) {
				if(commands[i][1].compareTo("thrust")==0) {
					newGUI.thruster_3.setValue(Integer.valueOf(commands[i][2]));
				}
				else if(commands[i][1].compareTo("tilt")==0) {
					newGUI.servo_3.setValue(Integer.valueOf(commands[i][2]));
				}
			}
			
			else if(commands[i][0].compareTo("wait")==0) {
				try {
					Thread.sleep(Integer.valueOf(commands[i][1]));
				} catch (NumberFormatException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			
			
			i++;
			
		}
	}


}
