package gasbooking;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;

public class OrderDetails extends JFrame implements ActionListener{
	JLabel l1;
	JLabel l2;
	JLabel l3;
	 JFrame frame1;
	   JButton b1;
	   JTextField f1;
	    Connection con;
	    ResultSet rs, rs1;
	    Statement st, st1;
	    PreparedStatement pst;
	    String ids;
	    static JTable table;

	    	String[] columnNames = {"PhoneNo", "Cylinder", "Amount", "Book_date","Deliver_Date"};
	public OrderDetails() {
		// TODO Auto-generated constructor stub
		new JFrame();
		 l1=new JLabel("Cylinder Order Details");
			 l2=new JLabel("Enter Phone No.");
			 	f1=new JTextField();
			 	b1=new JButton("SUBMIT");
			    l1.setBounds(200, 50, 350, 40);
		        l2.setBounds(75, 110, 200, 30);
		        f1.setBounds(250, 110, 200, 30);
		        b1.setBounds(150, 150, 150, 30);
		        b1.addActionListener(this);
		        add(l2);
		        add(l1);
		        add(f1);
		        add(b1);
		        setLayout(null);
		        setVisible(true);
		        setSize(500, 500);
		        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	}
	  public void showTableData() {
			
		  frame1 = new JFrame("Database Search Result");
	        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	        frame1.setLayout(new BorderLayout());

	//TableModel tm = new TableModel();

	        DefaultTableModel model = new DefaultTableModel();

	        model.setColumnIdentifiers(columnNames);

	//DefaultTableModel model = new DefaultTableModel(tm.getData1(), tm.getColumnNames());

	//table = new JTable(model);

	        table = new JTable();
	        table.setModel(model);
	        table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
	        table.setFillsViewportHeight(true);
	        JScrollPane scroll = new JScrollPane(table);
	        scroll.setHorizontalScrollBarPolicy(
	                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
	        scroll.setVerticalScrollBarPolicy(
	                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);   
	//String textvalue = textbox.getText();
	        int PhoneNo=0;
	        int Cylinder=0;
	        int Amount =0;
	        String Book_Date = "";
	        String Deliver_Date = "";
	        int phone=Integer.parseInt(f1.getText());
	        try {
	        	Class.forName("com.mysql.jdbc.Driver");
				Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/gasbookingsystem","root","");
				Statement st=con.createStatement();
	            pst = con.prepareStatement("select * from cylinderorder where phoneno='"+phone+"'");
	            ResultSet rs = pst.executeQuery();
	            int i = 0;
	            if (rs.next()) {

	                PhoneNo = rs.getInt("phoneno");

	                Cylinder= rs.getInt("CylinderRequired");

	                Amount= rs.getInt("Amount");

	                Book_Date = rs.getString("BookedDate");
	                Deliver_Date = rs.getString("DeliveryDate");

	                model.addRow(new Object[]{PhoneNo, Cylinder, Amount, Book_Date, Deliver_Date});

	                i++;

	            }

	            if (i < 1) {

	                JOptionPane.showMessageDialog(null, "No Record Found", "Error", JOptionPane.ERROR_MESSAGE);

	            }

	            if (i == 1) {

	                System.out.println(i + " Record Found");

	            } else {

	                System.out.println(i + " Records Found");

	            }

	        } catch (Exception ex) {

	            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

	        }

	        frame1.add(scroll);
	        frame1.setVisible(true);
	        frame1.setSize(400, 300);

	    }

	 


	public static void main(String[] args) {
		// TODO Auto-generated method stub
OrderDetails od=new OrderDetails();
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b1)
		{
			showTableData();
			}
		}
	}


