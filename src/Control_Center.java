import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class Control_Center extends User{
	
		final JFrame ccframe = new JFrame();
		
		static String Selected_Base1 = "";
		static String Selected_Base2 = "";
		
		

		
		public void draw_Control_Center_Frame() {
			
			ccframe.setSize(1200, 750);
			ccframe.setLocation(500, 150);
			ccframe.setVisible(true);

			ccframe.setTitle("Software Technology - Drone Guard - Control_Center");
			ccframe.addWindowListener(new Close_Window());
			
			String dbases_array[] = {"<< Select one Base >>", "Base1", "Base2", "Base3", "BaseN"};
			
			GridLayout grid = new GridLayout(5, 2);

			File file = new File("logo.png");
			BufferedImage image1 = null;
			
			try {
				image1= ImageIO.read(file);
			}catch (IOException e1) {
				e1.printStackTrace();
			}
			
			JLabel clb1 = new JLabel(new ImageIcon(image1));
			
			JButton cb1 = new JButton("Show User's Info");
			JComboBox jcbox1 = new JComboBox(dbases_array);
			JButton cb2 = new JButton("Show Base Info");
			JButton cb3 = new JButton("Planning the drone support");
			JButton cb4 = new JButton("Collect Dbases reports & processing");
			JButton cb5 = new JButton("Annual Report for DroneGuard project");
			JButton cb6 = new JButton("Coordinate the operations");
			JButton cb7 = new JButton("Back");
            JTextArea txtarea = new JTextArea("OPERATION 1:\tFire Fighting \tLAT:... \tLONG:... \tDistribute Base1\nOPERATION 2:\tSearch & Rescue in Sea \tLAT:... \tLONG:... \tDistribute Base3");
			
            JPanel cpanel = new JPanel();
            
            cpanel.setLayout(grid);
            
            cpanel.add(clb1);
            cpanel.add(cb1);
            cpanel.add(jcbox1);
            cpanel.add(cb2);
            cpanel.add(cb3);
            cpanel.add(cb4);
            cpanel.add(cb5);
            cpanel.add(cb6);
            cpanel.add(cb7);
            cpanel.add(txtarea);
            
            
            cb1.addActionListener(new ActionListener() {
    			
    			public void actionPerformed(ActionEvent e) {
    				
    				DialogMessageUserInfo();
    			}
    		});

            
            jcbox1.addActionListener(new ActionListener() {
    			
    			public void actionPerformed(ActionEvent e) {
    				
    				Selected_Base1 = "Selected Base is the "+ jcbox1.getSelectedItem();
    				Selected_Base2 = (String) jcbox1.getSelectedItem();
    				System.out.println(Selected_Base1);
    			}
    		});
   
            
            cb2.addActionListener(new ActionListener() {
    			
    			public void actionPerformed(ActionEvent e) {
    				
    				DialogMessageBaseInfo();
    			}
    		});
            
            
            cb3.addActionListener(new ActionListener() {
    			
    			public void actionPerformed(ActionEvent e) {
    				
    				DialogMessageDroneSupport();
    			}
    		});

            
            cb4.addActionListener(new ActionListener() {
	
            	public void actionPerformed(ActionEvent e) {
		
            		DialogMessageReportsProcessing();
            	}
            });

            
            cb5.addActionListener(new ActionListener() {
	
            	public void actionPerformed(ActionEvent e) {
		
            		DialogMessageAnnualReportDG();
            	}
            });

            
            cb6.addActionListener(new ActionListener() {
	
            	public void actionPerformed(ActionEvent e) {
		
            		DialogMessageCoordination();
            	}
            });

            
            cb7.addActionListener(new ActionListener() {
    			
    			public void actionPerformed(ActionEvent e) {
    				
    				ccframe.dispose();
    				start.setVisible(true);
    			}
    		});
            
            
            ccframe.add(cpanel);
			
		}
		
		
		
		
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
		

		public void DialogMessageBaseInfo() {
			
			String msg = "The action of this button is to show the information about the selected base "+Selected_Base2+".\n Show his location on a Map and some info about the resources that are available.\n"+"To do this action use the --->: Show_Base_Info() method !\n"+"The output has the form :\n"+ 
			        "String Base_Name = Selected_Base\n" + "Int Number_of_Drone = \"\"\n" + "Int Number_of_human_resources = \"\"\n" + "Marker Location_on_Map = \"\"";
			JOptionPane optionPane = new JOptionPane();
			optionPane.setMessage(msg);
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			JDialog dialog = optionPane.createDialog(null, "Base's Info");
			dialog.setVisible(true);
			
		}
		
		public void Show_Base_Info() {
			//take data from Class: Distribute_Base//
		} 


		public void DialogMessageDroneSupport() {
			
			String msg = "The action of this button is to check which drones from any base have problems or schedualed service.\n"+"After coordinate the transport from any base to the IT_Base.\n"+
			"To do this action use many methods from classes --->: Control_Center ---> DroneTransport(), Report_Communications ---> ReportHardwareProblem()\n\n "
			 +"Finally update the list with pending tasks in IT_Drone_Guard Center";

			JOptionPane optionPane = new JOptionPane();
			optionPane.setMessage(msg);
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			JDialog dialog = optionPane.createDialog(null, "Plan for Drone Support");
			dialog.setVisible(true);
			
		}
		
		public void DroneTransport(){
			
		}
		
		
		public void DialogMessageReportsProcessing() {
			
			String msg = "The action of this button is to packaging all monthly reports from all distribute bases.\n"
					     +"The Control Center processing the reports and extract statistics about the operations all over the country.\n"
					     +"\n\tTo do this use the methods GatherReports() and ExtractStatistics()";

			JOptionPane optionPane = new JOptionPane();
			optionPane.setMessage(msg);
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			JDialog dialog = optionPane.createDialog(null, "Proccess the Bases's reports");
			dialog.setVisible(true);
			
		}
		
		public void GatherReports() {}
		
		public void ExtractStatistics(){}
		
		
		public void DialogMessageAnnualReportDG() {
			
			String msg = "The action of this button is to make an Annual report about the DroneGuard Project.\n"
					     +"This report describe the success operation ratio, suggestions to improve the project,\n faillures of the project and finally the total amount of financing.\n"
					     +"\n\tTo do this use the method Annual_Project_Report()";

			JOptionPane optionPane = new JOptionPane();
			optionPane.setMessage(msg);
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			JDialog dialog = optionPane.createDialog(null, "Proccess the Bases's reports");
			dialog.setVisible(true);
			
		}
		
		public void Annual_Project_Report(){}
		
		
		public void DialogMessageCoordination() {
			
			String msg = "The action of this button is to coordinate the operations between distributed bases and the actors of state.\n"
					     +"\n\tTo do this use from the Class : ---> Report_Communications\n ---> the methods : Give_Informations_Actors() and Give_Order_Distribute_Base()";

			JOptionPane optionPane = new JOptionPane();
			optionPane.setMessage(msg);
			optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
			JDialog dialog = optionPane.createDialog(null, "Proccess the Bases's reports");
			dialog.setVisible(true);
			
		}
}
