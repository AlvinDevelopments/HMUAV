import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JToolBar;
import java.awt.Panel;
import javax.swing.JMenuBar;
import java.awt.Label;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import java.awt.TextArea;
import java.awt.GridLayout;
import javax.swing.JSplitPane;
import java.awt.Canvas;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.BevelBorder;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import java.awt.Component;
import javax.swing.border.LineBorder;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.Icon;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.event.ChangeListener;

import com.github.sarxos.webcam.Webcam;
import com.github.sarxos.webcam.WebcamPanel;

import javax.swing.event.ChangeEvent;
import javax.swing.JTextPane;
import java.beans.PropertyChangeListener;
import java.util.Arrays;
import java.beans.PropertyChangeEvent;

public class newGUI extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	
	static JSlider[] sliders = new JSlider[6];
	static JTextPane textPane = new JTextPane();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					newGUI frame = new newGUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public newGUI() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 945, 610);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setMargin(new Insets(0, 10, 0, 0));
		setJMenuBar(menuBar);
		
		JLabel lblMenu = new JLabel("HMUAV Navigation");
		menuBar.add(lblMenu);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(5, 5, 591, 524);
		contentPane.add(panel);
		panel.setLayout(new GridLayout(0, 1, 0, 0));
		
		JPanel panel_4 = new JPanel();
		panel.add(panel_4);
		panel_4.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(32, 26, 250, 203);
		panel_4.add(panel_5);
		
		JLabel lblNewLabel = new JLabel(new ImageIcon("home_underwater_sectionbg2.jpg"));
		//panel_5.add(lblNewLabel);
		//System.out.println(Arrays.toString(Webcam.getWebcams().toArray()));
		
		//WebcamPanel camPanel= new WebcamPanel(Webcam.getDefault());
		//WebcamPanel camPanel2= new WebcamPanel(Webcam.getWebcams().get(0));
		
		//WebcamPanel camPanel1= new WebcamPanel(Webcam.getDefault());
//		camPanel.setMinimumSize(getSize());
//		camPanel1.setMinimumSize(getSize());
		//panel_5.add(camPanel);
		//panel_5.pack();
		panel_5.setVisible(true);
		//panel_5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(308, 26, 250, 203);
		panel_4.add(panel_6);
		
		JLabel label_14 = new JLabel(new ImageIcon("home_underwater_sectionbg2.jpg"));
		//panel_6.add(label_14);
		//panel_6.add(camPanel1);
		
		JLabel lblCamera = new JLabel("Left Camera");
		lblCamera.setBounds(32, 6, 75, 16);
		panel_4.add(lblCamera);
		
		JLabel lblRightCamera = new JLabel("Right Camera");
		lblRightCamera.setBounds(308, 6, 84, 16);
		panel_4.add(lblRightCamera);
		
		JPanel panel_7 = new JPanel();
		panel.add(panel_7);
		panel_7.setLayout(null);
		
		sliders[0] = new JSlider();
		sliders[0].setValue(0);
		sliders[0].setMinimum(-100);
		sliders[0].addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//System.out.print("left thrust "+sliders[0].getValue()+"\n");
				//TCPServer.input = "0"+" "+newGUI.sliders[0].getValue()+"\n";
				textField.setText(Integer.toString(sliders[0].getValue()));
				HBridge.checkFlag = 1;
			}
		
		});
		
		sliders[0].setOrientation(SwingConstants.VERTICAL);
		sliders[0].setBounds(26, 69, 34, 145);
		panel_7.add(sliders[0]);
		
		sliders[1] = new JSlider();
		sliders[1].addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//TCPServer.input = "1"+" "+newGUI.sliders[1].getValue()+"\n";
				textField_1.setText(Integer.toString(sliders[1].getValue()));
			}
		});
		sliders[1].setOrientation(SwingConstants.VERTICAL);
		sliders[1].setBounds(97, 69, 34, 145);
		panel_7.add(sliders[1]);
		
		sliders[2] = new JSlider();
		sliders[2].setValue(0);
		sliders[2].setMinimum(-100);
		sliders[2].addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//TCPServer.input = "2"+" "+newGUI.sliders[2].getValue()+"\n";
				textField_2.setText(Integer.toString(sliders[2].getValue()));
				HBridge.checkFlag = 1;
			}
		});
		sliders[2].setOrientation(SwingConstants.VERTICAL);
		sliders[2].setBounds(193, 69, 34, 145);
		panel_7.add(sliders[2]);
		
		sliders[3] = new JSlider();
		sliders[3].addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//TCPServer.input = "3"+" "+newGUI.sliders[3].getValue()+"\n";
				textField_3.setText(Integer.toString(sliders[3].getValue()));
			}
		});
		sliders[3].setOrientation(SwingConstants.VERTICAL);
		sliders[3].setBounds(265, 69, 34, 145);
		panel_7.add(sliders[3]);
		
		sliders[4] = new JSlider();
		sliders[4].setValue(0);
		sliders[4].setMinimum(-100);
		sliders[4].addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//TCPServer.input = "4"+" "+newGUI.sliders[4].getValue()+"\n";
				textField_4.setText(Integer.toString(sliders[4].getValue()));
				HBridge.checkFlag = 1;
			}
		});
		sliders[4].setOrientation(SwingConstants.VERTICAL);
		sliders[4].setBounds(343, 69, 34, 145);
		panel_7.add(sliders[4]);
		
		sliders[5] = new JSlider();
		sliders[5].addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				//TCPServer.input = "5"+" "+newGUI.sliders[5].getValue()+"\n";
				textField_5.setText(Integer.toString(sliders[5].getValue()));
			}
		});
		sliders[5].setOrientation(SwingConstants.VERTICAL);
		sliders[5].setBounds(424, 69, 34, 145);
		panel_7.add(sliders[5]);
		
		JLabel lblLeft = new JLabel("Left");
		lblLeft.setBounds(60, 220, 61, 16);
		panel_7.add(lblLeft);
		
		JLabel lblRear = new JLabel("Rear");
		lblRear.setBounds(238, 220, 61, 16);
		panel_7.add(lblRear);
		
		JLabel lblRight = new JLabel("Right");
		lblRight.setBounds(397, 220, 61, 16);
		panel_7.add(lblRight);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sliders[0].setValue(0);
				sliders[1].setValue(50);
				sliders[2].setValue(0);
				sliders[3].setValue(50);
				sliders[4].setValue(0);
				sliders[5].setValue(50);
			}
		});
		btnReset.setBounds(445, 7, 117, 29);
		panel_7.add(btnReset);
		
		textField = new JTextField();
		textField.addPropertyChangeListener(new PropertyChangeListener() {
			public void propertyChange(PropertyChangeEvent evt) {
				sliders[0].setValue(Integer.valueOf(textField.getText()));
			}
		});
		textField.setText("0");
		textField.setBounds(26, 51, 61, 26);
		panel_7.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setText("50");
		textField_1.setColumns(10);
		textField_1.setBounds(89, 51, 61, 26);
		panel_7.add(textField_1);

		
		textField_2 = new JTextField();
		textField_2.setText("0");
		textField_2.setColumns(10);
		textField_2.setBounds(181, 51, 61, 26);
		panel_7.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setText("50");
		textField_3.setColumns(10);
		textField_3.setBounds(254, 51, 61, 26);
		panel_7.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setText("0");
		textField_4.setBounds(333, 51, 69, 26);
		panel_7.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setText("50");
		textField_5.setBounds(413, 51, 61, 26);
		panel_7.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(595, 5, 330, 555);
		contentPane.add(panel_1);
		
		JButton btnNewButton = new JButton("Quit");
		btnNewButton.setBounds(195, 484, 109, 29);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{
					Launcher.server[0].out.flush();
					Launcher.server[2].out.flush();
					Launcher.server[4].out.flush();
				}catch(Exception a) {
					System.exit(0);
				}
				Launcher.server[0].sendMessage("gergergergerg");
				Launcher.server[2].sendMessage("gregergt");
				Launcher.server[4].sendMessage("quergregergit");
				System.out.println("exited");
				System.exit(0);
			}
		});
		panel_1.setLayout(null);
		panel_1.add(btnNewButton);
		
		JButton btnConnection = new JButton("Connection");
		btnConnection.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnConnection.setBounds(33, 484, 109, 29);
		panel_1.add(btnConnection);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(34, 26, 270, 185);
		panel_1.add(panel_2);
		
		JLabel label_15 = new JLabel(new ImageIcon("rocket.jpg"));
		panel_2.add(label_15);
		
		JButton btnSubmit = new JButton("Submit");
		
		btnSubmit.setBounds(113, 422, 117, 29);
		panel_1.add(btnSubmit);
		
		textPane = new JTextPane();
		textPane.setFont(new Font("Courier", Font.PLAIN, 13));
		textPane.setBounds(33, 223, 271, 187);
		panel_1.add(textPane);
		
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("pressed");
				Controller.sendCommand(textPane.getText());
			}
		});
	}
	
	public static JSlider getSlider(int i) {
		return sliders[i];
	}
}
