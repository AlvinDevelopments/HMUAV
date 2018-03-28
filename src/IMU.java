import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;

public class IMU extends Thread{
	
	private String data;
	private BufferedReader reader;
	
	private double x;
	private double y;
	private double z;
	private double w;
	private double txtFieldZ, txtFieldSpeed, txtFieldNose, txtFieldRoll,txtFieldIP, txtEulerRoll, txtEulerPitch, txtEulerYaw, txtAccX, txtAccY, txtAccZ;
	
	
	
	private ServerSocket socket;
	InputStream in;
	String clientSentence;
	String capitalizedSentence;

	public IMU() throws UnknownHostException, IOException{
		
		this.socket = new ServerSocket(8097);
//		this.in = socket.getInputStream();
//		reader = new BufferedReader(new InputStreamReader(in));
		initialize();
	}
	
	
	public void run() {
		
		Socket connectionSocket = null;
		
		 while (true) {
			 	System.out.println("waiting on connection");
//			 	updateGUI();
			   
			try {
				connectionSocket = socket.accept();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			   BufferedReader inFromClient = null;
			try {
				inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			} catch (IOException e2) {
				// TODO Auto-generated catch block
				e2.printStackTrace();
			}
			
			while(true) {
			   
				
				
			   try {
				clientSentence = inFromClient.readLine();
				if(clientSentence==null) {
					break;
				}
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			   
			   
			  	updateIMU(clientSentence);
			  	updateGUI();
			   
			   clientSentence=null;
//			   connectionSocket.getInputStream().flush()
			}
		}
		
	}
	
	
	private void initialize() {
		
	}
	
	private void updateIMU(String input){
		System.out.println(input);
		String[] data = input.split(" ");
		txtFieldZ = Double.parseDouble(data[0]);
		txtFieldSpeed = Double.parseDouble(data[1]);
		txtFieldNose = Double.parseDouble(data[2]);
		txtFieldRoll = Double.parseDouble(data[3]);
		txtFieldIP = Double.parseDouble(data[4]);
		txtEulerRoll = Double.parseDouble(data[5]);
		txtEulerPitch = Double.parseDouble(data[6]);
		txtEulerYaw = Double.parseDouble(data[0]);
		txtAccX = Double.parseDouble(data[0]);
		txtAccY = Double.parseDouble(data[0]);
		txtAccZ = Double.parseDouble(data[0]);
		
	}
	
	private void updateGUI(){
		
		newGUI.txtFieldZ.setText(Double.toString(this.txtFieldZ));
//		newGUI.txtFieldSpeed.setText(Double.toString(this.txtFieldSpeed));
		newGUI.txtFieldNose.setText(Double.toString(this.txtFieldNose));
		newGUI.txtFieldRoll.setText(Double.toString(this.txtFieldRoll));
//		newGUI.txtFieldIP.setText(Double.toString(this.txtFieldIP));
		newGUI.txtEulerRoll.setText(Double.toString(this.txtEulerRoll));
		newGUI.txtEulerPitch.setText(Double.toString(this.txtEulerPitch));
		newGUI.txtEulerYaw.setText(Double.toString(this.txtEulerYaw));
		newGUI.txtAccX.setText(Double.toString(this.txtAccX));
		newGUI.txtAccY.setText(Double.toString(this.txtAccY));
		newGUI.txtAccZ.setText(Double.toString(this.txtAccZ));
		
		
	}
	

}
