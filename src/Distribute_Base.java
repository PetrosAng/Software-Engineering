import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;


public class Distribute_Base extends User {
	
	final JFrame dframe = new JFrame();
	final JFrame checkframe = new JFrame();
	final JFrame a_checkframe = new JFrame();

	static String Selected_Drone1 = "";
	static String Selected_Drone2 = "";

    static String Latitude = "";
    static String Longitude = "";
    static String Radius = "";
    static String TypeOfEmergency = "";
    static String Kilos = "";

	
	public void draw_Base_Frame() {
		
		
		dframe.setSize(900, 750);
		dframe.setLocation(600, 150);
		dframe.setVisible(true);

		dframe.setTitle("Software Technology - Drone Guard - Distribute Base");
		dframe.addWindowListener(new Close_Window());
		
		//Container cp1 = getContentPane();
		
		GridLayout grid = new GridLayout(7, 2);
		
		
		String drone_array[]= {"<< Select one Drone >>", "Drone1","Drone2","Drone3","Drone(N)"};
		
		
		File file = new File("logo.png");
		BufferedImage image1 = null;
		
		try {
			image1= ImageIO.read(file);
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JLabel lb1 = new JLabel(new ImageIcon(image1));
		
		JButton db1 = new JButton("Show User's Info");
		JComboBox jcbox1 = new JComboBox(drone_array);
		
		JButton db2 = new JButton("Set AutoPilot Patrol Mode");
		JButton db3 = new JButton("Switch to Manual Remote Control Mode");
		JButton db4 = new JButton("PreFlight Check");
		JButton db5 = new JButton("AfterFlight Check");
		JButton db6 = new JButton("Hardware Problem Report");                 
		JButton db7 = new JButton("Drone Flight Info");
		JButton db8 = new JButton("Deliver Packet");
		JButton db9 = new JButton("Video & Data Recording / Make Report");
		JButton db10 = new JButton("Exit to Login Page");
		JTextArea txtarea = new JTextArea("WARINGS & HAZARDAS ---> !!!\n---> One small fire side : LAT=... , LONG=... \n--->");
		
		
		JPanel panel1 = new JPanel();
		panel1.setLayout(grid);
		
		panel1.add(lb1);
		panel1.add(db1);
		panel1.add(jcbox1);
		panel1.add(db2);
		panel1.add(db3);
		panel1.add(db4);
		panel1.add(db5);
		panel1.add(db6);
		panel1.add(db7);
		panel1.add(db8);
		panel1.add(db9);
		panel1.add(txtarea);
		panel1.add(db10);
		
		db1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogMessageUserInfo();
			}
		});
		
		
		jcbox1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Selected_Drone1 = "Selected Drone is the "+ jcbox1.getSelectedItem();
				Selected_Drone2 = (String) jcbox1.getSelectedItem();
				System.out.println(Selected_Drone1);
			}
		});
		
		db2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogPaneSetAutoPilot();
				System.out.println(Latitude);
				System.out.println(Longitude);
				System.out.println(Radius+" km");


			}
		});
		
		db3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogMessageRemoteControl();
				/* call method from Class Flight */

			}
		});
		
		db4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				draw_PreCheckWin();
			}
		});
		
		
		db5.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				draw_AfterCheckWin();
			}
		});
		
		
		db6.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogMessageHardwareProblemReport();
				/* call method from Class Report_Communication */

			}
		});
		
		
		db7.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogMessageFlightStatus();
			}
		});
		
		
		db8.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogPaneSetDelivryDest();
				System.out.println(Latitude);
				System.out.println(Longitude);
				System.out.println(TypeOfEmergency);
				System.out.println(Kilos+" kg");
				
			}
		});
		
		
		db9.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogMessageReportButton();
				/* call method from Class Report_Communication */
			}
		});
		
		
		db10.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				dframe.dispose();
				start.setVisible(true);
			}
		});
		
		dframe.add(panel1);
		
	}// draw_Base_Frame() ---> END
	
	
	public void DialogMessageUserInfo() {
		
		String msg = "The action of this button is to show the information about the User.\n"+"To do this action use the --->: Show_User_Info() method !\n"+"The output has the form :\n"+ 
		        "String User_Name = User\n" + "String Login_Time = \"\"\n" + "String In_Charge_Of_Drones = \"\"\n" + "String Location = \"\"";
		JOptionPane optionPane = new JOptionPane();
		optionPane.setMessage(msg);
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog(null, "User's Info");
		dialog.setVisible(true);
		
	}
	
	@SuppressWarnings("unused")
	public void Show_User_Info() {
		
		String User_Name = User;
		String Login_Time = "";
		String In_Charge_Of_Drones = "";
		String Location = "";
	}
	
	public void DialogPaneSetAutoPilot() {
		
		Latitude = JOptionPane.showInputDialog("Enter Input for Latitude :");
		Longitude = JOptionPane.showInputDialog("Enter Input for Longitude :");
		Radius = JOptionPane.showInputDialog("Enter the radius for the Patrol :");
		
	}
	
	public void DialogPaneSetDelivryDest() {
		
		Latitude = JOptionPane.showInputDialog("Enter Input for Latitude :");
		Longitude = JOptionPane.showInputDialog("Enter Input for Longitude :");
		TypeOfEmergency = JOptionPane.showInputDialog("Enter the type of the emergency :");
		Kilos = JOptionPane.showInputDialog("Enter the kilos of the first-aid kit :");
		
	}
	
	public void DialogMessageRemoteControl() {
		
		String msg = "The action of this button is switch to manual remote control.\n"+"\tTo do this action use the --->: Active_Remote_Control() method !\n\n"+
		"This method take inputs from a joystick back in the distribute_base\n"+"and use some other methods from Drone{Class}\n"+" to react with the mechanical parts of the drone to control his flight !";

		JOptionPane optionPane = new JOptionPane();
		optionPane.setMessage(msg);
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog(null, "Active Manual Control");
		dialog.setVisible(true);
		
	}
	
	public void Active_Remote_Control() {
		
		System.out.println("Remote Manual Control is active now !!!");
		
		// na kalesw kapoies methodous apo th class toy Drone //
		
	}
	
	public void draw_PreCheckWin(){
		
		checkframe.setSize(950, 500);
		checkframe.setLocation(600, 300);
		checkframe.setVisible(true);

		checkframe.setTitle("Software Technology - Drone Guard - Distribute Base");
		checkframe.addWindowListener(new Close_Window());
		
		String msg1 = "The action of this button is to make a check on the selected drone "+Selected_Drone2+" before his take off !!!";
		
		String msg2 = "\t It use methods from Drone {Class} for checking :";
		String msg3 = "CommunicationSystems_Checking()";
		String msg4 = "Engine_Checking()";
		String msg5 = "Flying_Componets_Checking()";
		String msg6 = "Sensors_Checking()";
		String msg7 = "Battery_Checking()";
		String msg8 = "Emergency_Landing_System_Checking()";
		
		JLabel label1 = new JLabel(msg1);
		JLabel label2 = new JLabel(msg2);
		JLabel label3 = new JLabel(msg3);
		JLabel label4 = new JLabel(msg4);
		JLabel label5 = new JLabel(msg5);
		JLabel label6 = new JLabel(msg6);
		JLabel label7 = new JLabel(msg7);
		JLabel label8 = new JLabel(msg8);

		
		JCheckBox ckbox1 = new JCheckBox("Communication Systems", true);
		JCheckBox ckbox2 = new JCheckBox("Engine", true);
		JCheckBox ckbox3 = new JCheckBox("Flying Componets", true);
		JCheckBox ckbox4 = new JCheckBox("Sensors/Cameras", true);
		JCheckBox ckbox5 = new JCheckBox("Battery", true);
		JCheckBox ckbox6 = new JCheckBox("Emergency_Landing_System", true);
		JButton chbox = new JButton("Back");
		
		GridLayout grid = new GridLayout(15,1);
		
		JPanel micro_p = new JPanel();
		micro_p.setLayout(grid);
		
		micro_p.add(label1);
		micro_p.add(label2);
		micro_p.add(label3);
		micro_p.add(label4);
		micro_p.add(label5);
		micro_p.add(label6);
		micro_p.add(label7);
		micro_p.add(label8);

		micro_p.add(ckbox1);
		micro_p.add(ckbox2);
		micro_p.add(ckbox3);
		micro_p.add(ckbox4);
		micro_p.add(ckbox5);
		micro_p.add(ckbox6);
		micro_p.add(chbox);
		
		chbox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				checkframe.dispose();
				dframe.setVisible(true);
			}
		});
		
		checkframe.add(micro_p);
		
	}
	
	public void draw_AfterCheckWin(){
		
		a_checkframe.setSize(950, 500);
		a_checkframe.setLocation(600, 300);
		a_checkframe.setVisible(true);

		a_checkframe.setTitle("Software Technology - Drone Guard - Distribute Base");
		a_checkframe.addWindowListener(new Close_Window());
		
		String msg1 = "The action of this button is to make a check on the selected drone "+Selected_Drone2+" after his landing !!!";
		
		String msg2 = "\t It use methods from Drone {Class} for checking after the flight :";
		String msg3 = "CommunicationSystems_Checking()";
		String msg4 = "Engine_Checking()";
		String msg5 = "Flying_Componets_Checking()";
		String msg6 = "Sensors_Checking()";
		String msg7 = "Battery_Checking()";
		String msg8 = "Emergency_Landing_System_Checking()";
		
		JLabel label1 = new JLabel(msg1);
		JLabel label2 = new JLabel(msg2);
		JLabel label3 = new JLabel(msg3);
		JLabel label4 = new JLabel(msg4);
		JLabel label5 = new JLabel(msg5);
		JLabel label6 = new JLabel(msg6);
		JLabel label7 = new JLabel(msg7);
		JLabel label8 = new JLabel(msg8);

		
		JCheckBox ckbox1 = new JCheckBox("Communication Systems", true);
		JCheckBox ckbox2 = new JCheckBox("Engine", true);
		JCheckBox ckbox3 = new JCheckBox("Flying Componets");
		JCheckBox ckbox4 = new JCheckBox("Sensors/Cameras", true);
		JCheckBox ckbox5 = new JCheckBox("Battery");
		JCheckBox ckbox6 = new JCheckBox("Emergency_Landing_System", true);
		JButton chbox = new JButton("Back");
		
		GridLayout grid = new GridLayout(15,1);
		
		JPanel micro_p = new JPanel();
		micro_p.setLayout(grid);
		
		micro_p.add(label1);
		micro_p.add(label2);
		micro_p.add(label3);
		micro_p.add(label4);
		micro_p.add(label5);
		micro_p.add(label6);
		micro_p.add(label7);
		micro_p.add(label8);

		micro_p.add(ckbox1);
		micro_p.add(ckbox2);
		micro_p.add(ckbox3);
		micro_p.add(ckbox4);
		micro_p.add(ckbox5);
		micro_p.add(ckbox6);
		micro_p.add(chbox);
		
		chbox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				a_checkframe.dispose();
				dframe.setVisible(true);
			}
		});
		
		a_checkframe.add(micro_p);
		
	}

	public void DialogMessageHardwareProblemReport() {
		
		String msg = "The action of this button is to send a report with the problems of "+Selected_Drone2+".\n"+"\tTo do this action use the --->: Report_Hardware_Problem() method !\n\n"+
				"This method take as input a list of problems that have been discoverd by\n the checking proccess and give this list to the IT-Section of Drone Guard.\nAfter this the base sent the brocken drone to IT-Drone Guard for fixing !!!";

				JOptionPane optionPane = new JOptionPane();
				optionPane.setMessage(msg);
				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = optionPane.createDialog(null, "Hardware Problem Report");
				dialog.setVisible(true);
		
	}

	
	
	public void DialogMessageFlightStatus() {
		
		String msg = "The action of this button is to show some informations about the flying state of "+Selected_Drone2+".\n"+"\tTo do this action use some methods from Class --->: Drone !\n\n"
		              +"\tThe Methods are :\nCommunicationSystems_Status()\nEngine_Status()\nFlying_Componets_Status()\nSensors_Status()\nBattery_Status()";
				

				JOptionPane optionPane = new JOptionPane();
				optionPane.setMessage(msg);
				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = optionPane.createDialog(null, "Flight Informations");
				dialog.setVisible(true);
		
	}
	
	public void DialogMessageReportButton() {
		
		String msg = "The action of this button is to recording the data that the drones send back to distribute bases\n"
					  +"for proccesing and analysis. To do this action use some methods from Class : ---> Report_Communication\n"
					  +"The User has three options : \n\n"
				      +"\t1) Make a daily report with the most significant info. ---> Daily_Report() !\n"
					  +"\t2) Make a monthly report with the most significant info. ---> Monthly_Report() !\n"
				      +"\t3) Report an Emergency to the Control Center. ---> Emergency_Call() !da\n\n";
				 

				JOptionPane optionPane = new JOptionPane();
				optionPane.setMessage(msg);
				optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
				JDialog dialog = optionPane.createDialog(null, "Data Recording - Report");
				dialog.setVisible(true);
		
	}

}
