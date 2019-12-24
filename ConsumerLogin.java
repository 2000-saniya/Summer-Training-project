package gasbooking;



import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;



public class ConsumerLogin extends JFrame implements ActionListener {
	
	JButton b1,b2,b3;
	JLabel l1,l2,l3;
	JTextField tf1;
	JPanel panel;
	JPasswordField pf1;
	String email ,password;
	
	public ConsumerLogin() throws IOException
	{
		
	     new JFrame("my frame");
     //setContentPane(new JLabel(new ImageIcon("C:\\Users\\Dell\\Pictures\\sonu.jpg")));
	     
	     setContentPane(new JLabel(new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\GasBookingSystem\\src\\img\\loginimage.png")));

		 b1=new JButton("LOGIN");
		 b2=new JButton("Forgot Password?");
		 b3=new JButton("Register Now");
		 
		 panel=new JPanel();
		 
		 l1=new JLabel("EMAIL ID :");
		 l2=new JLabel("PASSWORD  :");
		 l3=new JLabel("CONSUMER LOGIN");
		 
		 tf1=new JTextField();
		 pf1=new JPasswordField();
		// tf2=new JTextField();
		 
		 l1.setBounds(60, 250, 150, 40);
		 l2.setBounds(60, 300, 150, 40);
		 l3.setBounds(180, 10, 400, 40);
		 
		 tf1.setBounds(250, 250, 300, 40);
		 pf1.setBounds(250, 300, 300, 40);
		// tf2.setBounds(250, 300, 300, 40);
		 
		 b1.setBounds(200, 400, 140, 30);
		 b2.setBounds(410, 350, 140, 20);
		 b3.setBounds(200, 450, 140, 30);
		 
 		 panel.setBounds(50, 230, 520, 300);
		 
		 b1.addActionListener(this);
		 b2.addActionListener(this);
		 b3.addActionListener(this);

		 
		 add(b1);
		 add(b2);
		 add(b3);
		 add(pf1);
		 add(l1);
		 add(l2);
		 add(l3);
		 
		 add(tf1);
		 
		 
		 
		 l1.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 20));
		 l2.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 20));
		 l3.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		 l3.setForeground(Color.darkGray);
		 //b1.setBackground(Color.cyan);
		 //b2.setBackground(Color.cyan);
		 //b3.setBackground(Color.cyan);
		 
		 setBackground(Color.white);
		 setSize(700,600);
		 setLayout(null);
		 setVisible(true);
		 
		 add(panel);
		 
		//f.addWindowListener(new WindowAdapter() {
			//public void windowClosing(WindowEvent arg0) {
				//super.windowClosing(arg0);
				//f.dispose();
			//}
	
		//});
		 
	}

	public static void main(String[] args) throws IOException {
		
		ConsumerLogin ff=new ConsumerLogin();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource()==b3)
		{
			new CustomerRegistration();
		}
		
		if(e.getSource()==b2)
		{
			new ForgotPassword();
		}
		
		if(e.getSource()==b1)
		{
			
			 
				 
				 
				 
				   String Email=tf1.getText();
				   String Password=String.valueOf(pf1.getPassword());
				   try {	
		        	Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gasbookingsystem","root","");
					Statement st=con.createStatement();
					String query = "SELECT * FROM `record` WHERE `Email` =? AND `Password` =?";
					PreparedStatement ps;
					ResultSet rs;
					
			            ps =con.prepareStatement(query);
			            
			            ps.setString(1, Email);
			            ps.setString(2, Password);
			            rs = ps.executeQuery();
			           
			            while (rs.next()) {
							Email=rs.getString(5);
						 Password=rs.getString(10);
							
						}
						
						if(Email.equals(Email) && Password.equals(Password)) {
							JOptionPane.showMessageDialog(null,"login successfully");
							
						}
						else {
							
							
							System.out.println("login Not successfully");
						}
				 }
						catch (Exception e1) {
				        	
				        	e1.printStackTrace();
				        }
			
		
	
			 }}
	

}
