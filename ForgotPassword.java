package gasbooking;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import com.cdac.valid.Validation; 
public class ForgotPassword extends JFrame implements ActionListener{
	JLabel l1,l2,l3,l4;
	JTextField tf1;
	JPasswordField pf1,pf2;
	JButton b1,b2;
	
	

	public ForgotPassword() {
		// TODO Auto-generated constructor stub
		 new JFrame("my frame");
		 b1=new JButton("Change Password");
		 b2=new JButton("Login");
		 l1=new JLabel("Aadhar ID :");
		 l2=new JLabel("NEW PASSWORD  :");
		 l3=new JLabel("CONFIRM PASSWORD");
		 l4=new JLabel("Change LOGIN Password");
		 tf1=new JTextField();
		 pf1=new JPasswordField();
		 pf2=new JPasswordField();
		 l1.setBounds(60, 250, 150, 40);
		 l2.setBounds(60, 300, 150, 40);
		 l3.setBounds(60, 350, 150, 40);
		 l4.setBounds(200,100,300,50);
		 tf1.setBounds(250, 250, 300, 40);
		 pf1.setBounds(250, 300, 300, 40);
		 pf2.setBounds(250, 350, 300, 40);
		 
		 b1.setBounds(200, 430, 140, 30);
		 b2.setBounds(200, 500, 140, 30);
		 
		 
		 	add(l1);
			add(l2);
			add(l3);
			add(l4);
			add(tf1);
			add(pf1);
			add(pf2);
			add(b1);
			add(b2);
			
			b1.addActionListener(this);
			b2.addActionListener(this);
			 setBackground(Color.white);
			 setSize(700,600);
			 setLayout(null);
			 setVisible(true);
	}

	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
ForgotPassword fp=new ForgotPassword();
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			PreparedStatement ps;
			String Id=tf1.getText();
			 String OPassword=String.valueOf(pf1.getPassword());
			 String CPassword=String.valueOf(pf2.getPassword());
			 Validation vd=new Validation();
			 if(OPassword.equals("") )
		      {
		     JOptionPane.showMessageDialog(null, "Enter Password again..");
		        }
			 else if(CPassword.equals("")) {
				 JOptionPane.showMessageDialog(null, "Add Confirm Password.");
			 }
			 else if(!OPassword.equals(CPassword))
					{
			     JOptionPane.showMessageDialog(null, "Password doesn't match....");
					}
					else {
				
				 try {	
			        	Class.forName("com.mysql.jdbc.Driver");
						Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gasbookingsystem","root","");
						Statement st=con.createStatement();
						String query = "update record set password='"+OPassword+"' where id="+Id+"";
						ps=con.prepareStatement(query);
						
						ps.executeUpdate();
						JOptionPane.showMessageDialog(null, "Password changed successfully....");
			} 
			catch (Exception e1) {
	        	
	        	e1.printStackTrace();
	        }
					}
		}
		if(e.getSource()==b2) {
			try {
				new ConsumerLogin();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
