package gasbooking;

import java.awt.Button;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;


public class ConsumerHomePage extends JFrame implements ActionListener{
	
	JLabel l1;
	JMenuBar m1;
	JMenu home;
	
	JMenuItem CylinderOrder;
	JMenuItem ChangeAddress;
	JMenuItem ConsumerHistory;
	JMenuItem Logout;

	ConsumerHomePage() {
		  
		 m1=new JMenuBar();
		 home=new JMenu("Home");

		 CylinderOrder=new JMenuItem("Cylinder Order");
		 ChangeAddress=new JMenuItem("Change Address");
		 ConsumerHistory=new JMenuItem("Cunsumer History");
		 Logout=new JMenuItem("Logout");
        
		 home.add(CylinderOrder);
		 home.add(ChangeAddress);
		 home.add(ConsumerHistory);
		 home.add(Logout);
		 
		 setJMenuBar(m1);
		 m1.add(home);
		 
		 home.addActionListener(this);
		 CylinderOrder.addActionListener(this);
		 ChangeAddress.addActionListener(this);
		 ConsumerHistory.addActionListener(this);
		 Logout.addActionListener(this);
			
        setSize(400,400);  
        setLayout(null);
        setVisible(true);
	}
	

	public static void main(String[] args) {
		ConsumerHomePage cp=new ConsumerHomePage();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==ChangeAddress)
		{
			new ChangeAddress();
		}
		if(e.getSource()==CylinderOrder)
		{
			new CylinderOrder();
		}
		if(e.getSource()==ConsumerHistory)
		{
			new display();
		}
	}

}
