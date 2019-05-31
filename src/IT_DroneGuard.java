import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;

public class IT_DroneGuard extends User{
	
	final JFrame itframe = new JFrame();
	static String Selected_Brocken_Drone1 = "";
	//static String Selected_Base2 = "";
	
	public void draw_IT_frame() {
		
		itframe.setSize(900, 750);
		itframe.setLocation(600, 150);
		itframe.setVisible(true);
		
		itframe.setTitle("Software Technology - Drone Guard - IT Center");
		itframe.addWindowListener(new Close_Window());
		
		String brocken_drones_array[] = {"<< Select drone for repair >>", "Drone_id_1", "Drone_id_2","Drone_id_3", "Drone_id_N"};   
		
		GridLayout grid = new GridLayout(3, 2);

		File file = new File("logo.png");
		BufferedImage image1 = null;
		
		try {
			image1= ImageIO.read(file);
		}catch (IOException e1) {
			e1.printStackTrace();
		}
		
		JLabel itlb1 = new JLabel(new ImageIcon(image1));
		
		JComboBox jcbox1 = new JComboBox(brocken_drones_array);
		JButton itb1 = new JButton("Service and fixing of the selected drone");
		JButton itb2 = new JButton("Give a new software update");
		JButton itb3 = new JButton("Gather all data to use it for reasearch");
		JButton itb4 = new JButton("Back");
		
		
		
		JPanel itpanel = new JPanel();
		
		itpanel.setLayout(grid);
		
		itpanel.add(itlb1);
		itpanel.add(jcbox1);
		itpanel.add(itb1);
		itpanel.add(itb2);
		itpanel.add(itb3);
		itpanel.add(itb4);

		jcbox1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				Selected_Brocken_Drone1 = "Selected brocken drone is the "+jcbox1.getSelectedItem();
			    System.out.println(Selected_Brocken_Drone1);
			}
		});
		
		
		itb1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogMessageService();
			}
		});
		
		itb2.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogMessageGiveSoftwareUpdate();
			}
		});
		
		itb3.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				DialogMessageGatherDataResearch();
			}
		});
		
		itb4.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				
				itframe.dispose();
				start.setVisible(true);
			}
		});
		
		
		itframe.add(itpanel);
		
		
		
	}
	
	public void DialogMessageService() {
		
		String msg = "The action of this button is to examine the problems that have been noticed and fix them or make the schedualed service.\n"
					 +"\n\tTo do this use the methods FixDronesProblems() and Service()";

		JOptionPane optionPane = new JOptionPane();
		optionPane.setMessage(msg);
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog(null, "Service and Problems Fixing");
		dialog.setVisible(true);
		
	}

	public void FixDronesProblems(){}
	
	public void Service() {}
	
	
	public void DialogMessageGiveSoftwareUpdate() {
		
		String msg = "The action of this button is to make available a new software update.\n"
				     +"This update concers the sofrware that drones use and also the software that the distribute bases and control center use.\n"
					 +"\n\tTo do this use the method UpdateSoftware()";

		JOptionPane optionPane = new JOptionPane();
		optionPane.setMessage(msg);
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog(null, "Software Update");
		dialog.setVisible(true);
		
	}
	
	public void UpdateSoftware() {}
	
	
	public void DialogMessageGatherDataResearch() {
		
		String msg = "The action of this button is to gather all data from drones operations.\n"
				     +"All this data will be used for research and to develop improvments for the drones.\n"
					 +"\n\tTo do this use the method Gather_Data_&_Research()";

		JOptionPane optionPane = new JOptionPane();
		optionPane.setMessage(msg);
		optionPane.setMessageType(JOptionPane.INFORMATION_MESSAGE);
		JDialog dialog = optionPane.createDialog(null, "Research and Development");
		dialog.setVisible(true);
		
	}
	
	public void Gather_Data__Research(){}

}
