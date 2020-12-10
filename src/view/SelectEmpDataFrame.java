package view;

import java.awt.Container;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.EmpIdFrame;

import Config.JDBCConnection;

public class SelectEmpDataFrame extends JFrame{
	
	JFrame frame;
	Container container;
	public SelectEmpDataFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		EmpIdFrame empId=new EmpIdFrame();
		DefaultTableModel model = new DefaultTableModel(new String[]{"EmployeeId", "FirstName", "LastName", "Role","Gender", "Active"}, 0);
		PreparedStatement pst=conn.prepareStatement("select * from Employee where EmployeeId=?");
		pst.setInt(1,Integer.parseInt(empId.tEmployeeId.getText()));
		ResultSet rst=pst.executeQuery();
		if(rst!=null) {
			if(rst.next()) {
			    int a = rst.getInt("EmployeeId");
			    String b = rst.getString("FirstName");
			    String c = rst.getString("LastName");
			    String d = rst.getString("Role");
			    String e = rst.getString("Gender");
			    String f = rst.getString("Active");
			    model.addRow(new Object[]{a,b,c,d,e,f});
			}
		}
		
		table.setModel(model);
	    container=getContentPane();
	    setLayoutManger();
	    JScrollPane sp=new JScrollPane(table);  
	    
	    container.add(sp);
	    container.add(table);
	    
	    table.setBounds(10,10,800,900);
	    this.setVisible(true);
	    this.setBounds(10,10,800,900);	    
		this.setTitle("Selected Employee Data");
	}
	private void setLayoutManger() {
		container.setLayout(null);
		
	}
	

}
