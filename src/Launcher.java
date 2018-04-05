import java.awt.EventQueue;

public class Launcher {
	static Controller controller;
	static Motor thrust;
	static Motor servo;
	static IMU imu;
	
	static Controls control;
	static Settings setting;

	
	// connection info used to connect to the Python scripts controlling the hardware on the Beaglebone Black
	// "192.168.7.2" is usually the default IP address of the Beaglebone Black
	static String address = "192.168.7.2";
	static String sPort = "8089";
	static String hPort = "8090";

	public static void main(String[] arguments) throws Exception {

		// Graphic User Interface (GUI) is generated.
		// Settings and Controls Interface are also generated, but not shown until opened by user.
		EventQueue.invokeLater(new Runnable() {
			// GUI will be shown until the program is terminated.
			public void run() {
				try {
					newGUI frame = new newGUI();
					frame.setVisible(true);

					control = new Controls();
					control.setVisible(false);

					setting = new Settings();
					setting.setVisible(false);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

		// The program waits 50 milliseconds while the generated GUI is fully
		// initialized.
		try {
			Thread.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// A ServerSocket thread that accepts a connection from the IMU (Inertial Measurement Unit) and listens 
		// for incoming data from the IMU
		imu = new IMU();
		imu.start();

	}

	/**
	 * 
	 * @throws Exception
	 */
	static void launch() throws Exception {

		controller = new Controller();
		controller.start();

		servo = new Motor(address, sPort);
		servo.start();

		thrust = new Motor(address, hPort);
		thrust.start();

//		System.out.println("PWM Controls initialized.\n");

	}
	
	/**
	 * Setter function that changes the IP and ports to connect to.
	 * @param IP IP address of the Beaglebone Black
	 * @param hhPort port of the script controlling the HBridges
	 * @param ssPort port of the script controlling the Servos
	 */
	static void setPorts(String IP, String hhPort, String ssPort) {
		System.out.println("Ports set to ");
		address = IP;
		sPort = ssPort;
		hPort = hhPort;
	}
	
	
}