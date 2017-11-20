import java.awt.EventQueue;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;


public class Launcher {
	
	
	
	public static void main(String[] arguments) throws IOException 
	{
		
		TCPServer server;
		Calculator calc;
			
		// Graphic User Interface (GUI) is generated.
		EventQueue.invokeLater(new Runnable() 
		{
			// GUI will be shown until the program is terminated.
			public void run() 
			{
				try 
				{
					GUI frame = new GUI();
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
			Thread.sleep(50);
		} 
		catch (InterruptedException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
			
		server = new TCPServer();
		server.start();
			
		calc = new Calculator();
		calc.start();
					
			
	}
			
}
