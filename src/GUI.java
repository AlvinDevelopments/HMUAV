import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JProgressBar;
import java.awt.SystemColor;
import javax.swing.UIManager;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Insets;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI extends JFrame {

	private static final long serialVersionUID = 1L;
	public static JTextField txtFieldZ, txtFieldSpeed, txtFieldNose, txtFieldRoll, txtFieldIP, txtEulerRoll, txtEulerPitch, txtEulerYaw, txtAccX, txtAccY, txtAccZ;
	//public static Draw canvas;
	public static JProgressBar speedBar, depthBar;
	public static JLabel depthPtr;
	
	private JPanel contentPane;

	public GUI() 
	{
		/***
		 * Format / Layout of the GUI
		 */
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1024, 768);
		setTitle("UUV Monitoring System-V.1.0.0");
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.control);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		/***
		 * Plotting depth bar and speed bar
		 */
		depthPtr = new JLabel(new ImageIcon("depthPtr.png"));
		depthPtr.setBounds(26, 59, 14, 14);
		//depthBar.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(depthPtr);
		
		JLabel depthBar = new JLabel(new ImageIcon("depthBar.png"));
		depthBar.setBounds(25, 66, 16, 600);
		depthBar.setBorder(new LineBorder(new Color(255, 255, 255)));
		//depthBar.setVerticalAlignment(SwingConstants.TOP);
		contentPane.add(depthBar);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(SystemColor.control);
		panel.setBounds(732, 131, 274, 436);
		contentPane.add(panel);
		panel.setLayout(null);
		
		/***
		 * Plotting Vehicle's Status in Numbers and Texts
		 */
		JLabel lblAxisZ = new JLabel("Elevation");
		lblAxisZ.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAxisZ.setForeground(Color.BLACK);
		lblAxisZ.setBounds(13, 50, 72, 24);
		panel.add(lblAxisZ);
		
		txtFieldZ = new JTextField();
		txtFieldZ.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldZ.setText("0.0");
		txtFieldZ.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldZ.setEditable(false);
		txtFieldZ.setColumns(10);
		txtFieldZ.setBounds(97, 50, 166, 24);
		panel.add(txtFieldZ);
		
		JLabel lblNose = new JLabel("Nose");
		lblNose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNose.setForeground(Color.BLACK);
		lblNose.setBounds(13, 83, 72, 24);
		panel.add(lblNose);
		
		txtFieldNose = new JTextField();
		txtFieldNose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldNose.setText("0.0");
		txtFieldNose.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldNose.setEditable(false);
		txtFieldNose.setColumns(10);
		txtFieldNose.setBounds(97, 83, 166, 24);
		panel.add(txtFieldNose);
		
		JLabel lblRoll = new JLabel("Roll");
		lblRoll.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblRoll.setForeground(Color.BLACK);
		lblRoll.setBounds(13, 116, 72, 24);
		panel.add(lblRoll);
		
		txtFieldRoll = new JTextField();
		txtFieldRoll.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldRoll.setText("0.0");
		txtFieldRoll.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldRoll.setEditable(false);
		txtFieldRoll.setColumns(10);
		txtFieldRoll.setBounds(97, 116, 166, 24);
		panel.add(txtFieldRoll);
		
		JLabel lblNewLabel = new JLabel("Vehicle Status");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel.setBounds(13, 13, 249, 24);
		panel.add(lblNewLabel);
		
		JLabel lblNetworkStatus = new JLabel("Network Status");
		lblNetworkStatus.setHorizontalAlignment(SwingConstants.CENTER);
		lblNetworkStatus.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNetworkStatus.setBounds(13, 361, 249, 25);
		panel.add(lblNetworkStatus);
		
		JLabel lblIp = new JLabel("IP");
		lblIp.setForeground(Color.BLACK);
		lblIp.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblIp.setBounds(12, 399, 57, 24);
		panel.add(lblIp);
		
		txtFieldIP = new JTextField();
		txtFieldIP.setText("0.0.0.0");
		txtFieldIP.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldIP.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtFieldIP.setEditable(false);
		txtFieldIP.setColumns(10);
		txtFieldIP.setBounds(81, 399, 181, 24);
		panel.add(txtFieldIP);
		
		// Euler's angle
		txtEulerRoll = new JTextField();
		txtEulerRoll.setText("0.0");
		txtEulerRoll.setHorizontalAlignment(SwingConstants.RIGHT);
		txtEulerRoll.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEulerRoll.setEditable(false);
		txtEulerRoll.setColumns(10);
		txtEulerRoll.setBounds(13, 208, 75, 24);
		panel.add(txtEulerRoll);
		
		txtEulerPitch = new JTextField();
		txtEulerPitch.setText("0.0");
		txtEulerPitch.setHorizontalAlignment(SwingConstants.RIGHT);
		txtEulerPitch.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEulerPitch.setEditable(false);
		txtEulerPitch.setColumns(10);
		txtEulerPitch.setBounds(100, 208, 75, 24);
		panel.add(txtEulerPitch);
		
		txtEulerYaw = new JTextField();
		txtEulerYaw.setText("0.0");
		txtEulerYaw.setHorizontalAlignment(SwingConstants.RIGHT);
		txtEulerYaw.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtEulerYaw.setEditable(false);
		txtEulerYaw.setColumns(10);
		txtEulerYaw.setBounds(188, 208, 75, 24);
		panel.add(txtEulerYaw);
		
		JLabel labelEuler = new JLabel("Euler Angles");
		labelEuler.setHorizontalAlignment(SwingConstants.LEFT);
		labelEuler.setFont(new Font("Tahoma", Font.PLAIN, 18));
		labelEuler.setBounds(14, 153, 248, 24);
		panel.add(labelEuler);
		
		JLabel lblEulerRoll = new JLabel("Roll");
		lblEulerRoll.setHorizontalAlignment(SwingConstants.CENTER);
		lblEulerRoll.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEulerRoll.setBounds(13, 190, 75, 18);
		panel.add(lblEulerRoll);
		
		JLabel lblEurlerPitch = new JLabel("Pitch");
		lblEurlerPitch.setHorizontalAlignment(SwingConstants.CENTER);
		lblEurlerPitch.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEurlerPitch.setBounds(101, 190, 75, 18);
		panel.add(lblEurlerPitch);
		
		JLabel lblEulerYaw = new JLabel("Yaw");
		lblEulerYaw.setHorizontalAlignment(SwingConstants.CENTER);
		lblEulerYaw.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblEulerYaw.setBounds(188, 190, 75, 18);
		panel.add(lblEulerYaw);
		
		txtAccX = new JTextField();
		txtAccX.setText("0.0");
		txtAccX.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAccX.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAccX.setEditable(false);
		txtAccX.setColumns(10);
		txtAccX.setBounds(13, 300, 75, 24);
		panel.add(txtAccX);
		
		// Acceleration from IMU
		JLabel lblAccX = new JLabel("X");
		lblAccX.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccX.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAccX.setBounds(13, 282, 75, 18);
		panel.add(lblAccX);
		
		JLabel lblAccY = new JLabel("Y");
		lblAccY.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccY.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAccY.setBounds(101, 282, 75, 18);
		panel.add(lblAccY);
		
		txtAccY = new JTextField();
		txtAccY.setText("0.0");
		txtAccY.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAccY.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAccY.setEditable(false);
		txtAccY.setColumns(10);
		txtAccY.setBounds(100, 300, 75, 24);
		panel.add(txtAccY);
		
		txtAccZ = new JTextField();
		txtAccZ.setText("0.0");
		txtAccZ.setHorizontalAlignment(SwingConstants.RIGHT);
		txtAccZ.setFont(new Font("Tahoma", Font.PLAIN, 18));
		txtAccZ.setEditable(false);
		txtAccZ.setColumns(10);
		txtAccZ.setBounds(188, 300, 75, 24);
		panel.add(txtAccZ);
		
		JLabel lblAccZ = new JLabel("Z");
		lblAccZ.setHorizontalAlignment(SwingConstants.CENTER);
		lblAccZ.setFont(new Font("Tahoma", Font.PLAIN, 11));
		lblAccZ.setBounds(188, 282, 75, 18);
		panel.add(lblAccZ);
		
		JLabel lblAcceleration = new JLabel("Acceleration");
		lblAcceleration.setHorizontalAlignment(SwingConstants.LEFT);
		lblAcceleration.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblAcceleration.setBounds(14, 245, 248, 24);
		panel.add(lblAcceleration);
		
		
		// 3D Drawing
//		canvas = new Draw();
//		canvas.setBorder(new LineBorder(new Color(0, 0, 0), 1));
//		canvas.setBackground(SystemColor.control);
//		canvas.setBounds(12, 45, 708, 638);
//		contentPane.add(canvas);
		
		speedBar = new JProgressBar();
		speedBar.setBounds(12, 696, 527, 24);
		contentPane.add(speedBar);
		
		txtFieldSpeed = new JTextField();
		txtFieldSpeed.setBounds(620, 696, 100, 24);
		contentPane.add(txtFieldSpeed);
		txtFieldSpeed.setText("0");
		txtFieldSpeed.setHorizontalAlignment(SwingConstants.RIGHT);
		txtFieldSpeed.setEditable(false);
		txtFieldSpeed.setColumns(10);
		
		// Speed Texts
		JLabel lblSpeed = new JLabel("Speed:");
		lblSpeed.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblSpeed.setBounds(551, 696, 57, 24);
		contentPane.add(lblSpeed);
		lblSpeed.setForeground(Color.BLACK);
		
		// Reset
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setForeground(Color.BLACK);
		btnReset.setBackground(SystemColor.control);
		btnReset.setBounds(732, 45, 274, 32);
		contentPane.add(btnReset);
		
		// Exit
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) 
			{
				System.exit(0);
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnExit.setBackground(SystemColor.control);
		btnExit.setBounds(732, 86, 132, 32);
		contentPane.add(btnExit);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(SystemColor.control);
		menuBar.setBounds(0, 0, 1018, 32);
		contentPane.add(menuBar);
		
		JMenu mnFile = new JMenu("File");
		mnFile.setFont(new Font("Calibri", Font.PLAIN, 18));
		menuBar.add(mnFile);
		
		JMenuItem mntmExit = new JMenuItem("Exit");
		mntmExit.setFont(new Font("Calibri", Font.PLAIN, 18));
		mnFile.add(mntmExit);
		
		JMenu mnHelp = new JMenu("Help");
		mnHelp.setFont(new Font("Calibri", Font.PLAIN, 18));
		menuBar.add(mnHelp);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.setFont(new Font("Calibri", Font.PLAIN, 18));
		mnHelp.add(mntmAbout);
		
		JButton btnAbout = new JButton("About");
		btnAbout.setForeground(Color.BLACK);
		btnAbout.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAbout.setBackground(SystemColor.control);
		btnAbout.setBounds(874, 86, 132, 32);
		contentPane.add(btnAbout);
		
		JPanel panelLogo = new JPanel();
		panelLogo.setBackground(SystemColor.control);
		panelLogo.setBounds(732, 580, 274, 140);
		contentPane.add(panelLogo);
		
		JLabel logo = new JLabel(new ImageIcon("logo.png"));
		logo.setVerticalAlignment(SwingConstants.CENTER);
		panelLogo.add(logo);
	}

}
