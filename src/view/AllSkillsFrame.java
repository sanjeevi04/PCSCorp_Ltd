package view;

import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

import javax.swing.table.DefaultTableModel;

import Config.JDBCConnection;
public class AllSkillsFrame extends JFrame {
	
	private static final long serialVersionUID = 1L;
	JFrame frame;
	Container container;
	public AllSkillsFrame() throws ClassNotFoundException, SQLException {
		Connection conn=JDBCConnection.getDBConnection();
		Statement stmt=conn.createStatement();
		frame=new JFrame();   
		JTable table=new JTable();
		DefaultTableModel model = new DefaultTableModel(new String[]{"SkillId", "SkillName", "SkillDescription", "Active"}, 0);
		ResultSet rst=stmt.executeQuery("select * from Skill");
		model.addRow(new String[]{"SkillId", "SkillName", "SkillDescription", "Active"});
		while(rst.next())
		{
		    int skId = rst.getInt("SkillId");
		    String skName = rst.getString("SkillName");
		    String skDsc = rst.getString("SkillDescription");
		    String act = rst.getString("Active");
		    model.addRow(new Object[]{skId,skName,skDsc,act});
		    table.setModel(model);
		    container=getContentPane();
		    container.setLayout(null);
		    JScrollPane sp=new JScrollPane(table);    
		    container.add(sp);
		    container.add(table);
		    table.setBounds(10,10,800,900);
		    this.setVisible(true);
		    this.setBounds(10,10,800,900);
		    this.setTitle("Skill Data");
		}

	}
}
