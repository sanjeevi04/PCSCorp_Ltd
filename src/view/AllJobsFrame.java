package view;
import java.awt.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import Config.JDBCConnection;

public class AllJobsFrame extends JFrame{
	
	private static final long serialVersionUID = 1L;
	JFrame frame;
	Container container;
	public AllJobsFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"JobId","JobTitle", "JobDescription", "CompanyName", "Location","Skills","Salary","Activate"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Job");
		while(rst.next())
		{
		    int jId= rst.getInt("JobId");
		    String jTl = rst.getString("JobTitle");
		    String jDs = rst.getString("JobDescription");
		    String cName = rst.getString("CompanyName");
		    String loc = rst.getString("Location");
		    String sk = rst.getString("Skills");
		    String slry= rst.getString("Salary");
		    String act = rst.getString("Activate");
		    model.addRow(new Object[]{jId,jTl,jDs,cName,loc,sk,slry,act});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Job Data");
		}

	}

}
