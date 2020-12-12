package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Config.JDBCConnection;
import dao.ISkillDao;
import model.Skill;

public class SkillDaoImpl implements ISkillDao{
	
	Connection conn=null;
	public SkillDaoImpl() throws ClassNotFoundException,SQLException
	{
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<Skill> getAllSkills() {
		List<Skill> allSkList =new ArrayList<Skill>();
		try
		{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from Skill");
			if(rst!=null)
			{
				Skill sk=null;
				while(rst.next())
				{
					sk=new Skill();
					sk.setSkillId(rst.getInt(1));
					sk.setSkillName(rst.getString(2));
					sk.setSkillDescription(rst.getString(3));
					sk.setActive(rst.getString(4));
					allSkList.add(sk);
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return allSkList;
	}

	@Override
	public void addSkill(Skill sk) {
		try {
			PreparedStatement pst=conn.prepareStatement("Insert into Skill(SkillName,SkillDescription,Active) values(?,?,?)");
			pst.setString(1,sk.getSkillName());
			pst.setString(2,sk.getSkillDescription());
			pst.setString(3,sk.getActive());
			int i=pst.executeUpdate();
			JFrame f =new JFrame();
			if(i==1)
			{
				JOptionPane.showMessageDialog(f,"Skill inserted");
			}
			else
			{
				JOptionPane.showMessageDialog(f,"Insertion failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

	@Override
	public Skill getSkillById(int id) {
		Skill sk=new Skill();
		try
		{
			PreparedStatement pst=conn.prepareStatement("Select * from Skill where SkillId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null)
			{
				if(rst.next())
				{
					sk=new Skill();
					sk.setSkillId(rst.getInt(1));
					sk.setSkillName(rst.getString(2));
					sk.setSkillDescription(rst.getString(3));
					sk.setActive(rst.getString(4));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}	
		return sk;
	}

	@Override
	public void updateSkill(Skill sk) {
		try {
			PreparedStatement pst=conn.prepareStatement("Update Skill set SkillName=?,set SkillDescription=? where SkillId=?");
			pst.setString(1,sk.getSkillName());
			pst.setString(2, sk.getSkillDescription());
			pst.setInt(3, sk.getSkillId());
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("1 record updated");
			}
			else
			{
				System.out.println("Updation failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

	@Override
	public void deactivateSkill(Skill sk) {
		try {
			PreparedStatement pst=conn.prepareStatement("Update Skill set Active=? where SkillId=?");
			pst.setString(1,"Deactive");
			pst.setInt(2,sk.getSkillId());
			int i=pst.executeUpdate();
			JFrame f =new JFrame();
			if(i==1)
			{
				JOptionPane.showMessageDialog(f,"Skill Deactivated");
			}
			else
			{
				JOptionPane.showMessageDialog(f,"Deactivation failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

	@Override
	public void deleteSkill(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("Delete From Skill where SkillId=?");
			pst.setInt(1,id);
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("Skill Deleted");
			}
			else
			{
				System.out.println("Deletion failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

	@Override
	public void activateSkill(Skill sk) {
		try {
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=? ");
			pst.setString(1, "Active");
			pst.setInt(2, sk.getSkillId());
			int i=pst.executeUpdate();
			JFrame f = new JFrame();
			if(i==1){
				JOptionPane.showMessageDialog(f,"Skill Activated...");
			}
			else {
				JOptionPane.showMessageDialog(f,"Activation failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
		
}


