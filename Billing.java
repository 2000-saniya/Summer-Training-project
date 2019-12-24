package gasbooking;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Billing extends JFrame implements ActionListener{
	
	JLabel l1,l2,l3,l4,l5,l6,l7;
	JTextField tf1,tf2,tf3,tf4,tf5,tf6;
	//JComboBox c1;
	JButton b1;
	int PhoneNo;
	String Date;
	String Delivery;
	String Amount;
	
	public Billing() {
		
		new JFrame();
		
		//l1=new JLabel("Billing  Id :");
		l2=new JLabel("Phone Number :");
		l3=new JLabel("Booked Date :");
		l4=new JLabel("Delivery Date :");
		l5=new JLabel("Amount :");
		//l6=new JLabel("Amount :");
		l7=new JLabel("BILL DETAILS");
		
		//tf1=new JTextField();
		tf2=new JTextField();
		tf3=new JTextField();
		tf4=new JTextField();
		tf5=new JTextField();
		//tf6=new JTextField();
		
		b1=new JButton("SUBMIT");
		
		//String s1[]= {"Aadhar Id","VoterID","Driving License","Passport"};
		//c1=new JComboBox();
		
		//l1.setBounds(50, 60, 100, 30);
		l2.setBounds(50, 120, 100, 30);
		l3.setBounds(50, 180, 100, 30);
		l4.setBounds(50, 240, 100, 30);
		l5.setBounds(50, 300, 100, 30);
		//l6.setBounds(50, 360, 100, 30);
		l7.setBounds(150, 10, 200, 30);
		
		//tf1.setBounds(150, 60, 200, 40);
		tf2.setBounds(150, 120, 200, 40);
		tf3.setBounds(150, 180, 200, 40);
		tf4.setBounds(150, 240, 200, 40);
		tf5.setBounds(150, 300, 200, 40);
		//tf6.setBounds(150, 360, 200, 40);
		
		
		//c1.setBounds(100, 80, 200, 40);
		
		b1.setBounds(160, 420, 100, 30);
		
		 b1.addActionListener(this);
		
		//add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		//add(l6);
		add(l7);
		
		//add(tf1);
		add(tf2);
		add(tf3);
		add(tf4);
		add(tf5);
		//add(tf6);
		
		
		//add(c1);
		
		add(b1);
		
		 l7.setFont(new Font(Font.SERIF, Font.BOLD, 30));
		 l7.setForeground(Color.darkGray);
		
		setSize(580,620);
		setLayout(null);
		setVisible(true);

	}
	

	public static void main(String[] args) {


		Billing cr=new Billing();

	}


	@Override
	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==b1)
		{
			
			//Scanner sc=new Scanner(System.in);
			
			 try {
				    Class.forName("com.mysql.jdbc.Driver");
				    Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/gasbookingsystem","root","");
				    String Phone;
				    Phone = tf2.getText();
				    String query="SELECT * FROM CylinderOrder where PhoneNo="+Phone;
				    
				    Statement st=conn.createStatement();
				    ResultSet rs=st.executeQuery(query);
				    
				    while (rs.next()) {
				    	int PhoneNo=rs.getInt("PhoneNo");
						
				    	String CylinderRequired=rs.getString("CylinderRequired");
				    	String Amount=rs.getString("Amount");
				    	
				    	String BookedDate=rs.getString("BookedDate");
				    	String DeliveryDate=rs.getString("DeliveryDate");
				    	
				        tf3.setText(BookedDate);
				        tf4.setText(DeliveryDate);
				        tf5.setText(Amount);
				
				    	
					}
				    st.close();
			 }
			 catch (Exception e1) {
				System.err.println("Got an exception!");
				System.err.println(e1.getMessage());
			}
}
	}
}