package view;


import javax.swing.JFrame;
import javax.swing.table.DefaultTableModel;
import java.awt.Container;
import java.sql.*;
import javax.swing.*;
import Config.JDBCConnection;

public class AllEmployeesFrame {

	JFrame frame;
	Container container;
	public AllEmployeesFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"empId", "FirstName", "LastName", "Role","Gender", "Active"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Employee");
		while(rst.next())
		{
		    int eId = rst.getInt("empId");
		    String fName = rst.getString("FirstName");
		    String lName = rst.getString("LastName");
		    String rl = rst.getString("Role");
		    String gn = rst.getString("Gender");
		    String act = rst.getString("Active");
		    model.addRow(new Object[]{eId,fName,lName,rl,gn,act});
		    table.setModel(model);
		    container=getContentPane();
		    setLayoutManger();
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setVisible("Employee Data");
		}
	}

	private void setVisible(String string) {
		// TODO Auto-generated method stub
		
	}

	private void setBounds(int a, int b, int c, int d) {
		// TODO Auto-generated method stub
		
	}

	private Container getContentPane() {
		// TODO Auto-generated method stub
		return null;
	}

	private void setVisible(boolean b) {
		// TODO Auto-generated method stub
		
	}

	private void setLayoutManger() {
		container.setLayout(null);
		
	}
	
	
}
