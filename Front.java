package gasbooking;


import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

public class Front extends JFrame implements ActionListener{
		//JLabel l1;
		JLabel l2,l6,l4,l5,l3,l9;
		
		
		JButton b1;
		JButton b2;
		JButton b3;
		JPanel panel1,panel2,panel3;
		JMenuBar m1;
		JMenu home;
		JMenu book;
		JMenu regis;
		
		JMenu feed;
		JMenu about;
		
		JMenuItem BookCylinder;
		JMenuItem Bill;
		JMenuItem egas;
		JMenuItem feedb;
		JMenuItem comp;
		JMenuItem aboute;
		JMenuItem order;
		
		JMenuItem Cus;
		JMenuItem Dis;
		JMenuItem Adm;
		
		
		
	public Front() {
		// TODO Auto-generated constructor stub
		new JFrame();
	l4=new JLabel("<html>CONSUMER LOGIN</html>");
	l5=new JLabel("<html>DISTRIBUTOR LOGIN</html>");
	l6=new JLabel("<html>ADMIN LOGIN</html>");
	panel1=new JPanel();
	panel2=new JPanel();
	panel3=new JPanel();
	l4.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 17));
	l5.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 17));
	l6.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 17));
	l4.setForeground(Color.blue);
	//l5.setForeground(Color.gray);
	l6.setForeground(Color.blue);
	 l4.setHorizontalAlignment(JLabel.CENTER);
	 l5.setHorizontalAlignment(JLabel.CENTER);
	 l6.setHorizontalAlignment(JLabel.CENTER);
		 Icon warnIcon1 = new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GasBookingSystem\\Images\\consumer.JPG");
		 Icon warnIcon2 = new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GasBookingSystem\\Images\\distributor.JPG");
		 Icon warnIcon3 = new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GasBookingSystem\\Images\\admin.JPG");
		   
		b1=new JButton(warnIcon1);
		 b2=new JButton(warnIcon2);
		 b3=new JButton(warnIcon3);
		 
		 m1=new JMenuBar();
		 home=new JMenu("Home");
		 book=new JMenu("Book Cylinder");
		 regis=new JMenu("Register");
		
		 feed=new JMenu("Feedback");
		 about=new JMenu("About Us");
		 egas=new JMenuItem("e_Gas Seva");
		 feedb=new JMenuItem("Feedback");
		 comp=new JMenuItem("Complaint");
		order=new JMenuItem("Order Details");
		aboute=new JMenuItem("About eGas-Seva");
		 BookCylinder=new JMenuItem("Book_Cylinder");
		 Bill=new JMenuItem("Bill_Details");
		 Cus=new JMenuItem("Customer_registration");
		 Dis=new JMenuItem("Distributor_registration");
		 Adm=new JMenuItem("Admin_registration");
		 l9=new JLabel(new ImageIcon 
					("C:\\Users\\HP\\eclipse-workspace\\GasBookingSystem\\Images\\back.JPG"));
	//	 l1.setBounds(400,100,700,100);
		  setContentPane(new JLabel(new ImageIcon("C:\\Users\\HP\\eclipse-workspace\\GasBookingSystem\\Images\\front.jpg")));
		
		  b1.setBounds(100, 200, 200, 200);
		 l4.setBounds(100, 310, 200, 200);
		 b2.setBounds(600, 200, 200, 200);
		 l5.setBounds(600, 310, 200, 200);
		 b3.setBounds(1100, 200, 200, 200);
		 l6.setBounds(1100, 310, 200, 200);
		 l9.setBounds(500,-30,400,200);
		 
		// l1.setFont(new Font(Font.SERIF, Font.BOLD, 50));
		 //l1.setForeground(Color.darkGray);
		 panel1.add(b1);
		 panel2.add(b2);
		 panel3.add(b3);
		feed.add(feedb);
		feed.add(comp);
		about.add(aboute);
		about.add(aboute);
		regis.add(Cus);
		regis.add(Dis);
		regis.add(Adm);
		book.add(BookCylinder);
		book.add(Bill);
		book.add(order);
		 add(panel1);
		 add(panel2);
		 add(panel3);
		 
	add(l4);
	add(l5);
	add(l6);
		 add(b1);
		 add(b2);
		 add(l9);
		 add(b3);
		 setJMenuBar(m1);
		 m1.add(home);
		 m1.add(book);
		 m1.add(regis);
		 
		 m1.add(feed);
		 m1.add(about);
		 
		 	b1.addActionListener(this);
			b2.addActionListener(this);
			b3.addActionListener(this);
			
			home.addActionListener(this);
			
			feed.addActionListener(this);
			feedb.addActionListener(this);
			comp.addActionListener(this);
			aboute.addActionListener(this);
			about.addActionListener(this);
			
			BookCylinder.addActionListener(this);
			Bill.addActionListener(this);
			Cus.addActionListener(this);
			Dis.addActionListener(this);
			Adm.addActionListener(this);
			order.addActionListener(this);
			
			
			setSize(1500,600);
			setLayout(null);
			setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Front f1=new Front();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			try {
				new ConsumerLogin();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
			if(e.getSource()==b2)
			{
				new DistributorLogin();
			}
			if(e.getSource()==b3)
			{
				new AdminLogin();
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
			if(e.getSource()==feedb)
			{
				new Feedback();
			}
			if(e.getSource()==comp)
			{
				new Feedback();
			}
			if(e.getSource()==aboute)
			{
				new AboutUs();
			}
			if(e.getSource()==order)
			{
				new OrderDetails();
			}
		
	}

}
