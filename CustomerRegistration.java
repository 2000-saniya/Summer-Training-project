package gasbooking;


import java.awt.Button;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import com.cdac.action.MethodImp;
import com.cdac.beans.RegistrationBeans;
import com.cdac.connection.MyCon;
import com.cdac.valid.Validation;


public class CustomerRegistration extends JFrame implements ActionListener{
	
	JLabel l1;
	JLabel l2;
	JLabel l3;
	JLabel l4;
	JLabel l5;
	JLabel l6;
	JLabel l7;
	JLabel l8;
	JLabel l9;
	JLabel l10;
	JLabel l11;
	
	JTextField f1;
	JTextField f2;
	JTextField f3;
	JTextField f4;
	JTextField f5;
	JTextField f6;
	JTextField f7;
	JTextField f8;
	JTextField f9;
	JPasswordField f10;
	JPasswordField f11;
	JButton b1;
	
	JComboBox c1;

	public CustomerRegistration() {
		// TODO Auto-generated constructor stub
		new JFrame();
		
		
	 l1=new JLabel("Name");
		 l2=new JLabel("Phone No.");
		 	l3=new JLabel("Aadhar Id");
		l4=new JLabel("D.O.B");
		l5=new JLabel("Email-Id");

		l6=new JLabel("Address");
		l7=new JLabel("State");
		l8=new JLabel("District");
		l9=new JLabel("Distributor");

		l10=new JLabel("Password");
		l11=new JLabel("Confirm Password");
		
		f1=new JTextField();
		f2=new JTextField();
		f3=new JTextField();
		f4=new JTextField();
		f5=new JTextField();
		 f6=new JTextField();
		f7=new JTextField();
		f8=new JTextField();
		
		f9=new JTextField();
		f10=new JPasswordField();
		f11=new JPasswordField();
		b1=new JButton("Submit");
		
		l1.setBounds(50,50,100,30);
		 l2.setBounds(50,90,100,30);
		 l3.setBounds(50,130,100,30);
		 l4.setBounds(50,170,100,30);
		 l5.setBounds(50,210,100,30);
		 l6.setBounds(50,250,100,30);
		 l7.setBounds(50,290,100,30);
		 l8.setBounds(50,330,100,30);
		 l9.setBounds(50,370,100,30);
		 l10.setBounds(50,410,100,30);
		 l11.setBounds(50,450,100,30);
		 
		 f1.setBounds(200, 50, 150, 30);
		 f2.setBounds(200, 90, 150, 30);
		 f3.setBounds(200, 130, 150, 30);
		 f4.setBounds(200, 170, 150, 30);
		 f5.setBounds(200, 210, 150, 30);
		 f6.setBounds(200, 250, 150, 30);
		 f7.setBounds(200, 290, 150, 30);
		 f8.setBounds(200, 330, 150, 30);
		 f9.setBounds(200, 370, 150, 30);
		 f10.setBounds(200, 410, 150, 30);
		 f11.setBounds(200, 450, 150, 30);
		 
		 b1.setBounds(150, 500, 200, 40);
		
		add(l1);
		add(l2);
		add(l3);
		add(l4);
		add(l5);
		add(l6);
		add(l7);
		add(l8);
		add(l9);
		add(l10);
		add(l11);
		add(f1);
		add(f2);
		add(f3);
		add(f4);
		add(f5);
		add(f6);
		add(f7);
		add(f8);
		add(f9);
		add(f10);
		add(f11);
		
		add(b1);
	/*String s1[]= {"Aadhar Id","VoterID","Driving License","Passport"};
		JComboBox c1=new JComboBox(s1);
		c1.setBounds(200, 370, 150, 30);
		add(c1);*/
		
		b1.addActionListener(this);
		setSize(500,800);
		setLayout(null);
		setVisible(true);
		 
	}

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub
		CustomerRegistration cr=new CustomerRegistration();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			String name;
			int i;
			long phonen;
			long id;
			String dob;
			String email;
			String address;
			String state;
			String district;
			String distributor;
			String password;
			Scanner sc=new Scanner(System.in);
			
			MethodImp mi=new MethodImp();
			RegistrationBeans rb=new RegistrationBeans();
			Connection con = null;
			Validation vd=new Validation();
			try {
				con = new MyCon().config();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			String Name1=f1.getText();
			long Phone=0;
			Phone=Long.parseLong(f2.getText());
			long ID1=Long.parseLong(f3.getText());
			String DOB1=f4.getText();
			String Email1=f5.getText();
			String Address1=f6.getText();
			String State1=f7.getText();
			String District1=f8.getText();
			String Distri=f9.getText();
			String Pass1=f10.getText();
			String Pass2=f11.getText();
			
			vd.validName(Name1);
		//	vd.validPhonee(Phone);
			vd.validemail(Email1);
			vd.validAddress(Address1);
			vd.validState(State1);
			vd.validDistrict(District1);
			vd.validDistri(Distri);
			vd.validPassword(Pass1);
			vd.validCPassword(Pass2);
		
			if(!Pass1.equals(Pass2))
			{
	     JOptionPane.showMessageDialog(null, "Password doesn't match....");
			}
			else {
			
			rb.setName(Name1);
			rb.setPhoneNo(Phone);	
			rb.setID(ID1);
			rb.setDOB(DOB1);
			rb.setEmail(Email1);
			rb.setAddress(Address1);
			rb.setState(State1);
			rb.setDistrict(District1);
			rb.setDistributor(Distri);
			rb.setPassword(Pass1);
			
			i=((MethodImp) mi).insertRecord(rb,con);
			System.out.println(i);
			if(i>0)
			{
				JOptionPane.showMessageDialog(null,"Registered");
			}}
			
		}
	}

}
