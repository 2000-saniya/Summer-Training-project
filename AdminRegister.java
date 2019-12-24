package gasbooking;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import com.cdac.action.MethodImp;
import com.cdac.beans.RegistrationBeans;
import com.cdac.connection.MyCon;

public class AdminRegister extends JFrame implements ActionListener{
	
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	JLabel l8;
	
	JLabel l9;
		
	JTextField f1;
	JTextField f2;
	JTextField f3;
	JTextField f4;
	JTextField f5;
	JTextField f6;
	JTextField f7;
	JTextField f8;
	JTextField f9;
	
	JButton b1;

	public AdminRegister() {
		// TODO Auto-generated constructor stub
		new JFrame();

	 	l1=new JLabel("Name");
		l2=new JLabel("Phone No.");
	 	l3=new JLabel("Id");
		l4=new JLabel("D.O.B");
		l5=new JLabel("Email-Id");
		l6=new JLabel("Address");
		l7=new JLabel("State");
		l8=new JLabel("District");
		l9=new JLabel("Password");
		
		f1=new JTextField();
		f2=new JTextField();
		f3=new JTextField();
		f4=new JTextField();
		f5=new JTextField();
		f6=new JTextField();
		f7=new JTextField();
		f8=new JTextField();
		f9=new JTextField();
		
		b1=new JButton("Submit");
		
		l1.setBounds(50,50,100,30);
		 l2.setBounds(50,90,100,30);
		 l3.setBounds(50,130,100,30);
		 l4.setBounds(50,170,100,30);
		 l5.setBounds(50,210,100,30);
		 l6.setBounds(50,250,100,30);
		 l7.setBounds(50,290,100,30);
		 l8.setBounds(50,330,100,30);
		 l9.setBounds(50,370,100,30);
	
		 
		 
		 f1.setBounds(200, 50, 150, 30);
		 f2.setBounds(200, 90, 150, 30);
		 f3.setBounds(200, 130, 150, 30);
		 f4.setBounds(200, 170, 150, 30);
		 f5.setBounds(200, 210, 150, 30);
		 f6.setBounds(200, 250, 150, 30);
		 f7.setBounds(200, 290, 150, 30);
		 f8.setBounds(200, 330, 150, 30);
		 
		 f9.setBounds(200, 370, 150, 30);
		
	
		 b1.setBounds(150, 500, 200, 40);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
	
		
		add(f1);
		add(f2);
		add(f3);
		add(f4);
		add(f5);
		add(f6);
		add(f7);
		add(f8);
		add(f9);


		
		add(b1);

		
		b1.addActionListener(this);
		setSize(500,800);
		setLayout(null);
		setVisible(true);
		 
	}

	public static void main(String[] args) throws ClassNotFoundException  {
		// TODO Auto-generated method stub
AdminRegister a=new AdminRegister();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			 String name = f1.getText();
			 int phoneno = Integer.parseInt(f2.getText());
			 int id = Integer.parseInt(f3.getText());
			 String dob = f4.getText();
			 String email = f5.getText();
			 String address = f6.getText();
			 String state = f7.getText();
			 String district = f8.getText();
			 String password = f9.getText();
			 
			 PreparedStatement ps;
		        String query = "INSERT INTO `adminrecord`(`name`, `phoneno`, `id`, `dob`, `email`, `address`,`state`,`district`,`password`) VALUES (?,?,?,?,?,?,?,?,?)";
			
		        try {
		        	Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gasbookingsystem", "root", "");
		            ps = con.prepareStatement(query);
		            
		            ps.setString(1, name);
		            ps.setInt(2, phoneno);
		            ps.setInt(3,id);
		            ps.setString(4,dob);
		            ps.setString(5,email);
		            ps.setString(6,address);
		            ps.setString(7,state);
		            ps.setString(8,district);
		            ps.setString(9,password);
		            if(ps.executeUpdate() > 0)
		            {
		                JOptionPane.showMessageDialog(null, "Registered..");
		            }
		            
		        } catch (SQLException ex) {
		        	ex.printStackTrace();
		        }
		}
}}
