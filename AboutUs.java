package gasbooking;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class AboutUs extends JFrame implements ActionListener{
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
	JMenuBar m1;
	JMenu home;
	JMenu book;
	JMenu regis;
	
	JMenu feed;
	JMenuItem BookCylinder;
	JMenuItem Bill;
	JPanel panel;

	JMenuItem Cus;
	JMenuItem Dis;
	JMenuItem Adm;
	

	public AboutUs() {
		// TODO Auto-generated constructor stub
		new JFrame();
		l1=new JLabel("ABOUT e-GAS SEVA");
		l2=new JLabel("<html><u>e-Gas Seva- In every heart, In every part.</u></html>");
		l3=new JLabel("<html>Today, e-gas Seva LPG is sold and delivered in four different pack sizes. The 5kg and 14.2 kg cylinders for domestic use are subsidized and <br/>comprise almost half of all gas distributed while the 19kg, 47.5 kg and 425 kg Jumbo cylinders are marked for industrial and commercial consumption. e-gas Seva LPG is also supplied in bulk to large volume consumers in the manufacturing and engineering sectors.</html>");
		l4=new JLabel("<html>At e-gas Seva, we continuously strive for customer delight through our value-added products and services. e-gas Seva has traversed the digital platform to provide numerous initiatives for greater customer convenience viz.");
		l5=new JLabel("#SMS/IVRS Refill booking");
		l6=new JLabel("#Preferred Time Delivery");
		l7=new JLabel("#Online portability of connections");
		l8=new JLabel("#Online payments for New connections and Refill delivery");
		l9=new JLabel(new ImageIcon 
				("C:\\Users\\HP\\eclipse-workspace\\GasBookingSystem\\Images\\Logo.JPG"));
		 m1=new JMenuBar();
		 home=new JMenu("Home");
		 book=new JMenu("Book Cylinder");
		 regis=new JMenu("Register");
		
		 feed=new JMenu("Feedback");
		 panel=new JPanel();
		 
		 BookCylinder=new JMenuItem("Book_Cylinder");
		 Bill=new JMenuItem("Bill_Details");
		 Cus=new JMenuItem("Customer_registration");
		 Dis=new JMenuItem("Distributor_registration");
		 Adm=new JMenuItem("Admin_registration");
		 
		 l1.setBounds(50,150,400,50);
		 l1.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 40));
		// l1.setForeground(Color.orange);
		 l2.setBounds(400,240,800,55);
		 l2.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 45));
		 l2.setForeground(Color.blue);
		 l3.setBounds(100,350,1200,100);
		 l3.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 15));
		 l4.setBounds(100,400,1200,100);
		 l4.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 15));
		 l5.setBounds(100,500,1200,30);
		 l5.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 15));
		 l5.setForeground(Color.blue);
		 l6.setBounds(100,530,1200,30); 
		 l6.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 15));
		 l6.setForeground(Color.blue);
		 l7.setBounds(100,560,1200,30);
		 l7.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 15));
		 l7.setForeground(Color.blue);
		 l8.setBounds(100,590,1200,30);
		 l8.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 15));
		 l8.setForeground(Color.blue);
		 l9.setBounds(560,-30,400,200);
		 book.add(BookCylinder);
			book.add(Bill);
			regis.add(Cus);
			regis.add(Dis);
			regis.add(Adm);
			
			 add(l1);
			 add(l2);
			 add(l3);	
			 add(l4);
			 add(l5);
			 add(l6);
			 add(l7);
			 add(l8);
			 add(l9);
			 setJMenuBar(m1);
			 m1.add(home);
			 m1.add(book);
			 m1.add(regis);
			
			 m1.add(feed);
		
				home.addActionListener(this);
			
				feed.addActionListener(this);
				
				
				BookCylinder.addActionListener(this);
				Bill.addActionListener(this);
				Cus.addActionListener(this);
				Dis.addActionListener(this);
				Adm.addActionListener(this);
				
				
				setSize(1500,800);
				setLayout(null);
				setVisible(true);

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
AboutUs us=new AboutUs();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==home)
		{
			new Front();
		}
		if(e.getSource()==feed)
		{
			new Feedback();
		}
		
		if(e.getSource()==BookCylinder)
			{
				new CylinderOrder();
			}
			if(e.getSource()==Bill)
			{
				new Billing();
			}
			if(e.getSource()==Cus)
			{
				new CustomerRegistration();
			}
			if(e.getSource()==Dis)
			{
				new DistributorRegistration();
			}
			if(e.getSource()==Adm)
			{
				new AdminRegister();
			}
	}

}
