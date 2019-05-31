import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.*;


import com.sun.glass.events.WindowEvent;

public class User  extends JFrame implements ActionListener {


    /**
     *
     */
    private static final long serialVersionUID = 1L;

    static String User = "";
    static String Pass = "";

    final static User start = new User();


    public static void main(String[] args) {




        start.setVisible(true);
        start.setSize(900, 750);
        start.setLocation(600, 150);
        start.setResizable(true);
        start.addWindowListener(new Close_Window());


    }




    public User() {

        super("Software Technology - Drone Guard");

        Container cp =  getContentPane();

        File file = new File("logo.png");
        BufferedImage image1 = null;

        try {
            image1= ImageIO.read(file);
        }catch (IOException e1) {
            e1.printStackTrace();
        }

        JLabel lb1 = new JLabel(new ImageIcon(image1));

        JLabel lb2 = new JLabel("Username :");
        JLabel lb3 = new JLabel("Password :");
        JTextField  UserField = new JTextField("");
        JPasswordField  PassField = new JPasswordField("");
        JButton b1 = new JButton("Sign In");

        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();


        panel1.add(lb1);

        panel2.setBackground(Color.DARK_GRAY);
        GridLayout grid = new GridLayout(2,2);
        panel2.setLayout(grid);


        panel2.add(lb2);
        panel2.add(UserField);
        panel2.add(lb3);
        panel2.add(PassField);

        panel3.add(b1);

        b1.addActionListener(new ActionListener () {

            public void  actionPerformed(ActionEvent e) {


                User = UserField.getText();
                Pass = PassField.getText();


                FindNextPage();

                System.out.println("H1 :"+User);
                System.out.println("H2 :"+Pass);


            }
        });



        cp.add(panel1, BorderLayout.NORTH);
        cp.add(panel2, BorderLayout.CENTER);
        cp.add(panel3, BorderLayout.SOUTH);



    }


    public void FindNextPage() {


        if ((User).equals("User1")) {

            Distribute_Base dbinst = new Distribute_Base();
            start.setVisible(false);
            //start.dispose();

            dbinst.draw_Base_Frame();

        }else if((User).equals("User2")){
            Control_Center CCinst = new Control_Center();
            start.setVisible(false);

            CCinst.draw_Control_Center_Frame();
            //call Control Center
        }else if((User).equals("User3")) {
            IT_DroneGuard itinst = new IT_DroneGuard();
            start.setVisible(false);

            itinst.draw_IT_frame();

            //call IT_DroneGuard
        }else {
            System.out.println("Wrong Username !!! ");

        }


    }


    @Override
    public void actionPerformed(ActionEvent arg0) {
        // TODO Auto-generated method stub

    }





}


class Close_Window extends WindowAdapter {

    public void windowClosing(WindowEvent e) {
        System.exit(0);
    }
}


