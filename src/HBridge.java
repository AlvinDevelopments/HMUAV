import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HBridge extends Thread
{
	static String fromBeagleBone, toBeagleBone;
	static int checkFlag = 0;
	int dutyCycleBefore;
	int dutyCycle;
	int sliderNumber = 0;

    
    public HBridge(int number) throws IOException
    {	
    		sliderNumber = number;
    		initialize();
    }
    
    public void initialize() throws IOException
    {
    		//System.out.println("PWM Controls initialized.");
    		dutyCycleBefore = 0;
    		dutyCycle = 0;
    		Launcher.server[sliderNumber].sendMessage("thruster"+" "+sliderNumber+" connected.");

    }
    
	@Override
	public void run() 
	{
		//System.out.println("PWM Controls is active.");
		while(true) {
			if(checkDutyCycle())	{
				//System.out.println("Thruster "+sliderNumber+" Duty Cycle = "+dutyCycle+" ("+sliderNumber+" "+newGUI.sliders[sliderNumber].getValue()+")\n");
				System.out.println("slider "+sliderNumber+": "+newGUI.sliders[sliderNumber].getValue()+"\n");
//				 Launcher.server[sliderNumber].sendMessage(Integer.toString(newGUI.sliders[sliderNumber].getValue()));
				Launcher.server[sliderNumber].sendMessage(Integer.toString(newGUI.sliders[sliderNumber].getValue()));
				checkFlag=0;
			}
		}
	}
	
	public boolean checkDutyCycle() {
		if(newGUI.sliders[0]!=null&&checkFlag==1) {
			dutyCycle = newGUI.sliders[sliderNumber].getValue();
			return true;
		}
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
}
