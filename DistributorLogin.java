package gasbooking;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class DistributorLogin extends JFrame implements ActionListener{
	
	JButton b1,b2,b3;
	JLabel l1,l2,l3;
	JTextField tf1,tf2;
	
	public DistributorLogin()
	{
		
	     new JFrame("my frame");
	     
	     setContentPane(new JLabel(new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\GasBookingSystem\\src\\img\\banner7.jpg")));
		 
		 b1=new JButton("Login");
		 b2=new JButton("Forgot Password");
		 b3=new JButton("Register Now");
		 
		 l1=new JLabel("EMAIL ID :");
		 l2=new JLabel("PASSWORD :");
		 l3=new JLabel("DISTRIBUTOR LOGIN");
		 
		 tf1=new JTextField();
		 tf2=new JTextField();
		 
		 l1.setBounds(60, 60, 150, 40);
		 l2.setBounds(60, 120, 150, 40);
		 l3.setBounds(200, 10, 250, 40);
		 
		 tf1.setBounds(250, 60, 200, 40);
		 tf2.setBounds(250, 120, 200, 40);
		 
		 b1.setBounds(110, 200, 140, 30);
		 b2.setBounds(310, 160, 140, 20);
		 b3.setBounds(110, 250, 140, 30);
		 
		 l3.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		 l3.setForeground(Color.darkGray);
		 
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);
		 
		 add(b1);
		 add(b2);
		 add(b3);
		 
		 add(l1);
		 add(l2);
		 add(l3);
		 
		 add(tf1);
		 add(tf2);
		 
		 setSize(800,400);
		 setLayout(null);
		 setVisible(true);
	}

	public static void main(String[] args) {


		DistributorLogin dl=new DistributorLogin();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b3)
		{
			new DistributorRegistration();
		}
		
		if(e.getSource()==b1)
		{
			
			 try {
				 
				 
				 
				   String Email=tf1.getText();
				   String Password=tf2.getText();
				
		        	Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mainproject","root","");
					Statement st=con.createStatement();
					String Query="select * from register where Email='"+Email+"'And Password='"+Password+"' ";
					
					System.out.println(Query);
					
					ResultSet rs=st.executeQuery(Query);
					while (rs.next()) {
						Email=rs.getString(5);
					 Password=rs.getString(10);
						
					}
					
					if(Email.equals(Email) && Password.equals(Password)) {
						
						System.out.println("login successfully");
						
						
					}
					else {
						
						
						System.out.println("login Not successfully");
					}
			 }
					catch (Exception e1) {
			        	
			        	e1.printStackTrace();
			        }
			
			
			
		}
		
	}
	

}