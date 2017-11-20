import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer extends Thread
{
	static String fromBeagleBone, toBeagleBone;
	
	public static long sendTime, timeDiff;
	
	// A double array to store selected seven beaglebone statuses 
	public static double [] bbData = new double [7];

    ServerSocket server; 
    Socket client;
    
    BufferedReader br, in;
    
    PrintWriter out;

    boolean run; 
    
    public TCPServer() throws IOException
    {
    	initialize();
    }
    
    public void initialize() throws IOException
    {
    	server = new ServerSocket(8080);
    	System.out.println("[Server] successfully initialized.");
    	System.out.println("[Server] waiting for connection from BeagleBone.");
    	client = server.accept();
        System.out.println("[Server] successfully connected to the client.");
        
        br = new BufferedReader(new InputStreamReader(System.in));
        in = new BufferedReader(new InputStreamReader(client.getInputStream()));
        out = new PrintWriter(client.getOutputStream(),true);
        
        fromBeagleBone = in.readLine();
        System.out.println("[BeagleBone] " + fromBeagleBone);
        
        toBeagleBone = "";
        
        run = true;
    }
    
	@Override
	public void run() 
	{
		while(run)
		{
			out.flush();
			
			if(toBeagleBone.length() > 0)
			{   
		        out.println(toBeagleBone);
		        
		        /**
		         *  Store the current time when the computer is sending data to beaglebone
		         *  This is to calculate the position values from integrating imu acceleration values
		         */
		        sendTime = System.currentTimeMillis();
		        
		        try 
				{
					fromBeagleBone = in.readLine();
					timeDiff = System.currentTimeMillis() - sendTime;
			
					// timeDiff is the length of time from sending command to receive the response from BB
					
					String [] tmp = fromBeagleBone.split(",");
					
					// Parse beaglebone statuses from the received string, and store them to the array
					for(int i = 0; i < tmp.length; i++)
					{
						bbData[i] = Double.parseDouble(tmp[i]);
					}
					//System.out.println(bbData[0] + " " + bbData[1] + " " + bbData[2] + " " + bbData[3] + " " + bbData[4] + " " + bbData[5] + " " + bbData[6]);
				} 
				catch (IOException e) 
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//System.out.println("[BeagleBone] " + fromBeagleBone);
				
				toBeagleBone = "";
			}
		}
	}
}
