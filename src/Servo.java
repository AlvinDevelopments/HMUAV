import java.io.IOException;

public class Servo extends Thread
{
	static String fromBeagleBone, toBeagleBone;
	private static int checkFlag = 0;

 
    public Servo() throws IOException
    {	
    		initialize();
    }
    
    public void initialize() throws IOException
    {
    		System.out.println("Servo initialized.");
//    		dutyCycleBefore = 0;
//    		dutyCycle = 0;
    		//Launcher.server[1].sendMessage("thruster"+" "+sliderNumber+" connected.");
    }
    
	@Override
	public void run() 
	{
		while(true) {
			if(checkDutyCycle())	{
				 Launcher.sServer.sendMessage(newGUI.servo_1.getValue(),newGUI.servo_2.getValue(),newGUI.servo_3.getValue());
				checkFlag=0;
			}
		}
	}
	
	public boolean checkDutyCycle() {
		if(newGUI.thruster_1!=null&&checkFlag==1) {
//			dutyCycle = newGUI.sliders[sliderNumber].getValue();
			return true;
		}
		try {
			Thread.sleep(50);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	

	public static void setFlagOn() {
		checkFlag = 1;
	}
	
	public static void setFlagOff() {
		checkFlag = 0;
	}
}
