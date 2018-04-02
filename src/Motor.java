import java.io.IOException;

public class Motor extends Thread
{
	static String fromBeagleBone, toBeagleBone;
	private static int checkFlag = 0;
	private TCPServer server;

    public Motor(String address, String socketNumber) throws IOException
    {	
    		initialize(address, socketNumber);
    }
    
    public void initialize(String address, String socketNumber) throws IOException
    {
    		System.out.println("Servo initialized.");
    		try {
				server = new TCPServer(address, socketNumber);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
