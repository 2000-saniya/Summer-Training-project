package gasbooking;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Feedback  extends JFrame implements ActionListener{
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	
	JTextField f1;
	JTextArea a1;
	ButtonGroup bg;
	JButton b1,b2;
	JRadioButton r1,r2,r3;
	
	
	public Feedback() {
		// TODO Auto-generated constructor stub
		new JFrame();
		
		l1=new JLabel("<html><u>LPG<html><u>");
		l2=new JLabel("<html>Welcome to e-Gas Customer Care. We value your relationship and your satisfaction is important to us. In case you have a Query/Suggestion/Complaint/Appreciation, <br/>kindly fill in the details below:</html> ");
		l3=new JLabel("<html><u>PLEASE PROVIDE DETAILS BELOW<html><u>");
		l4=new JLabel("Registered Mobile No-");
		l5=new JLabel("Feedback Type:-");
		l6=new JLabel(new ImageIcon 
				("C:\\Users\\HP\\eclipse-workspace\\GasBookingSystem\\Images\\Logo.JPG"));
		
		 r1=new JRadioButton("Complaint"); 
		 r2=new JRadioButton("Query");
		 r3=new JRadioButton("Suggestion");
		
		f1=new JTextField();
		a1=new JTextArea();
		bg=new ButtonGroup();
		b1=new JButton("Submit");
		b2=new JButton("Exit");
		l1.setBounds(20,150,80,40);
		l2.setBounds(20,195,1200,50);
		l3.setBounds(380,250,800,40);
		l4.setBounds(400,300,300,40);
		f1.setBounds(400,345,400,30);
		l5.setBounds(100,420,200,40);
		l6.setBounds(400,-30,400,200);
		r1.setBounds(100,470,200,30);
		r2.setBounds(500,470,200,30);
		r3.setBounds(900,470,200,30);
		
		a1.setBounds(100,520,1000,170);
		
		b1.setBounds(600,700,100,40);
		b2.setBounds(1000,700,100,40);
		
		l1.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 30));
		l2.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
		l1.setForeground(Color.blue);
		//l2.setForeground(Color.blue);
		l3.setFont(new Font(Font.SANS_SERIF, Font.CENTER_BASELINE, 25));
		l3.setForeground(Color.orange);
		l4.setForeground(Color.blue);
		l5.setForeground(Color.orange);
		r1.setForeground(Color.blue);
		r2.setForeground(Color.blue);
		r3.setForeground(Color.blue);
		l4.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
		l5.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 20));
		r1.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
		r2.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
		r3.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 15));
		b1.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 20));
		b2.setFont(new Font(Font.SERIF, Font.CENTER_BASELINE, 20));
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(f1);
		add(r1);
		add(r2);
		add(r3);
		add(a1);
		add(b1);
		
		add(l6);
		bg.add(r1);
		bg.add(r2);
		bg.add(r3);
		b1.addActionListener(this);
		b2.addActionListener(this);
		setBackground(Color.white);
		setSize(1200,800);
		setLayout(null);
		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Feedback f1=new Feedback();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b2)
		{
			System.exit(0);
		}
		if(e.getSource()==b1)
		{
			try	{
				
				String s = a1.getText();
				File file=new File("File3.txt");
				FileWriter writer=new FileWriter(file);
				file.createNewFile();
				  

				  writer.write(f1.getText());
				 
				if(r1.isSelected())
				{writer.write("Complaint Type:");	
				 
				writer.write(s);
				}
				else if(r2.isSelected())
				{writer.write("Query Type:");	
				 
				writer.write(s);
				}
				else if(r3.isSelected())
				{writer.write("Suggestion Type:");
				 
				writer.write(s);
				}
				 
				writer.flush();
				writer.close();
			}
			catch(IOException ioe) {
				System.out.println("Exception Caught : " +ioe.getMessage());
			}
		}
	}

}
