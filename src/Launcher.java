import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;
import java.net.InetAddress;

public class Launcher {
	static TCPServer[] server = new TCPServer[6];
	
	public static void main(String[] arguments) throws Exception 
	{
		
		Calculator calc;
		HBridge thrust1;
		HBridge thrust2;
		HBridge thrust3;
		
			
		// Graphic User Interface (GUI) is generated.
		EventQueue.invokeLater(new Runnable() 
		{
			// GUI will be shown until the program is terminated.
			public void run() 
			{
				try 
				{
					newGUI frame = new newGUI();
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
			
		// The program waits 50 milliseconds while the generated GUI is fully initialized.
		try 
		{
			Thread.sleep(10);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
		
	    server[0] = new TCPServer("8089");
		server[0].start();
		
		server[1] = new TCPServer("8090");
		server[1].start();
		
//		server[2] = new TCPServer("8091");
//		server[2].start();
//		
//		server[3] = new TCPServer("8092");
//		server[3].start();
//		
//		server[4] = new TCPServer("8093");
//		server[4].start();
		
//		server[5] = new TCPServer("8094");
//		server[5].start();
		
		System.out.println("Servers started.");
		
		
//		calc.start();
//		System.out.println("Calc initialized.");
		
		
		thrust1 = new HBridge(0);
		thrust1.start();
//		
//		thrust2 = new HBridge(2);
//		thrust2.start();
//		
//		thrust3 = new HBridge(4);
//		thrust3.start();
//					
		System.out.println("PWM Controls initialized.");
	}
			
}
