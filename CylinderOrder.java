package gasbooking;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CylinderOrder extends JFrame implements ActionListener{
	
	JButton b1,b2;
	JLabel l1,l2,l3,l4,l5,l6;
	JTextField tf1,tf2,tf3,tf4,tf5;

	JPanel panel;
	
int  Amount;
    public CylinderOrder() 
	{
		new JFrame();
		
		setContentPane(new JLabel(new ImageIcon("C:\\Users\\Dell\\eclipse-workspace\\GasBookingSystem\\src\\img\\delivery copy.png")));

		b1=new JButton("SUBMIT");
		b2=new JButton("Change Address");
		
	    l1=new JLabel("Enter Phone Number :");
	    l2=new JLabel("Number of cylinder required:");
	    l3=new JLabel("Amount(to be payed) :");
	    l5=new JLabel("Booked Date :");
	    l6=new JLabel("Delivery Date :");
	    l4=new JLabel("CYLINDER ORDER");
	    
	    panel=new JPanel();
	    
	    tf1=new JTextField();
	    tf2=new JTextField();
	    tf3=new JTextField();
	    tf4=new JTextField();
	    tf5=new JTextField();
	    
	  
	
	    l1.setBounds(50,50,200,30);
	    l2.setBounds(50,90,200,30);
	    l3.setBounds(50,130,200,30);
	    l5.setBounds(50,170,200,30);
	    l6.setBounds(50,210,200,30);
	    l4.setBounds(150,10,200,40);

	    tf1.setBounds(240, 50, 150, 30);
	    tf2.setBounds(240, 90, 150, 30);
	    tf3.setBounds(240, 130, 150, 30);
	    tf4.setBounds(240, 170, 150, 30);
	    tf5.setBounds(240, 210, 150, 30);
	    
	    l4.setFont(new Font(Font.SERIF, Font.BOLD, 20));
	    l4.setForeground(Color.darkGray);
	    
	    panel.setBounds(10, 20, 400, 270);
	    
	    b1.setBounds(60, 250, 140, 30);
	    b2.setBounds(230, 250, 140, 30); 
	    
	   

	    b1.addActionListener(this);
	    b2.addActionListener(this);
	    
	    add(l1);
	    add(l2);
	    add(l3);
	    add(l4);
	    add(l5);
	    add(l6);
	        
	    add(tf1);
	    add(tf2);
	    add(tf3);
	    add(tf4);
	    add(tf5);
	
	    add(b1);
	    add(b2);
		
	    
		
	    add(panel);
			
	  
	    
	    setResizable(false);
			
	    setSize(600,470);
        setLayout(null); 
		setVisible(true);
		//tf3.setEditable(false);
	//	tf5.setEditable(false);
		}

	public static void main(String[] args)  {

           CylinderOrder co=new CylinderOrder();
		}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b2)
		{
			new ChangeAddress();
		}
		
		if(e.getSource()==b1)
		{
			
			
			 try {
				  long PhoneNo=Integer.parseInt(tf1.getText());
				    int cylinder=Integer.parseInt(tf2.getText());
				    int Amount=Integer.parseInt(tf3.getText());
				    String BookedDate=tf4.getText();
				    String DeliveryDate=tf5.getText();
				   
					
				  
				    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				    java.util.Date textFieldAsDate=null;
				    try {
				    	textFieldAsDate=sdf.parse(BookedDate);
				    	textFieldAsDate=sdf.parse(DeliveryDate);
				    }
				    catch(ParseException pe)
				    {
				    	
				    }   
	               
				    
				    Class.forName("com.mysql.jdbc.Driver");
					Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gasbookingsystem","root","");
					Statement st=con.createStatement();
					String Query="insert into cylinderorder values("+PhoneNo+","+cylinder+","+Amount+",'"+BookedDate+"','"+DeliveryDate+"')";
                      
					  	
					int i=st.executeUpdate(Query); 
					
					if(i>0)
					    {
						JOptionPane.showMessageDialog(null,"Your Refill is Booked Successfully.");
						}
		          
		    } catch (Exception e1) {
		        	
		        	e1.printStackTrace();
		        }
		}
		
	}
}
