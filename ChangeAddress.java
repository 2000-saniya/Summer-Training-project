package gasbooking;



import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ChangeAddress extends JFrame implements ActionListener {
	
	JButton b1;
	JLabel l1,l2,l3,l4,l5;
	JTextField tf1,tf2,tf3,tf4;
	//JComboBox c1,c2,c3;
	JPanel panel;
	String State;
	String District;
	String Address;
	Long ID;
	
	public ChangeAddress()
	{
		b1=new JButton("Address Change");
		
		 setContentPane(new JLabel(new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\GasBookingSystem\\src\\img\\.jpg")));
		
		l1=new JLabel("ID :");
		l2=new JLabel("New Address :");
		l3=new JLabel("State :");
		l4=new JLabel("District :");
		l5=new JLabel("CHANGE ADDRESS");
		
		panel=new JPanel();
		
		tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
	
		 b1.setBounds(100, 280, 150, 30);
		    
		 l1.setBounds(30, 100, 100, 30);
	     l2.setBounds(30, 140, 200, 30);
	     l3.setBounds(30, 180, 100, 30);
   	     l4.setBounds(30, 220, 100, 30);
   	     l5.setBounds(100, 30, 200, 30);


	     tf2.setBounds(150, 140, 170, 30);
	     tf1.setBounds(150, 100, 170, 30);
	     tf3.setBounds(150, 180, 170, 30);
	     tf4.setBounds(150, 220, 170, 30);
	     
	     
	     l5.setFont(new Font(Font.SERIF, Font.BOLD, 20));
		 l5.setForeground(Color.darkGray);
	     
	     panel.setBounds(20, 20, 320, 300);
	     
		 add(b1);
		  
	     add(l1);
		 add(l2);
		 add(l3);
	     add(l4);
	     add(l5);
		  
		 add(tf1);
		 add(tf2);
		 add(tf3);
		 add(tf4);
		
		
				 add(panel);
		
		 
		 b1.addActionListener(this);
		  
		 setResizable(false);
		 setSize(800,400);
		 setLayout(null);
		 setVisible(true);
		  

	}
	

	public static void main(String[] args) {
		
		new ChangeAddress();

	}


	@Override
	public void actionPerformed(ActionEvent e) {

        
		if(e.getSource()==b1)
		{
		
			try {Long ID = Long.parseLong(tf1.getText());
				 String Address = tf2.getText();
				 String State = tf3.getText();
				 String District = tf4.getText();
				Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gasbookingsystem", "root", "");
				Statement st=con.createStatement();
				String Query="update record set address='"+Address+"',State='"+State+"',District='"+District+"' where ID="+ID+"";
				int i=st.executeUpdate(Query);
				if(i>0)
				{
					
					System.out.println("Change Address Successfully");	
				}
			}
			catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	
	}
}