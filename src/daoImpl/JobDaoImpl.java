package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import Config.JDBCConnection;
import dao.IJobDao;
import model.Job;

public class JobDaoImpl implements IJobDao{
	
	Connection conn=null;
	public JobDaoImpl() throws ClassNotFoundException, SQLException{
		conn=JDBCConnection.getDBConnection();
	}
	

	@Override
	public List<Job> getAllJob() {
		List<Job> allJobList=new ArrayList<Job>(); 
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from Job");
			if(rst!=null) {
				Job jb=null;
				while(rst.next()) {
					jb=new Job();
					jb.setJobId(rst.getInt(1));
					jb.setJobTitle(rst.getString(2));
					jb.setJobDescription(rst.getString(3));
					jb.setCompanyName(rst.getString(4));
					jb.setLocation(rst.getString(5));
					jb.setSalary(rst.getString(6));
					jb.setActivate(rst.getString(7));
					allJobList.add(jb); 
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allJobList;
	}

	@Override
	public void addJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("Insert into Job(JobTitle,JobDescription,CompanyName,Location,KeySkill,Salary,Active) values(?,?,?,?,?,?,?)");
			pst.setString(1,job.getJobTitle());
			pst.setString(2,job.getJobDescription());
			pst.setString(3,job.getCompanyName());
			pst.setString(4,job.getLocation());
			pst.setString(5,job.getSalary());
			pst.setString(6,job.getActivate());
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("1 record inserted");
			}
			else
			{
				System.out.println("Insertion failed...");
			}
		}
			catch(SQLException ex)
			{
				System.out.println(ex.getMessage());
			}
		
	}

	@Override
	public Job getJobById(int id) {
		Job job=new Job();
		try
		{
			PreparedStatement pst=conn.prepareStatement("Select * from Job where JobId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null)
			{
				if(rst.next())
				{
					job.setJobId(rst.getInt(1));
					job.setJobTitle(rst.getString(2));
					job.setJobDescription(rst.getString(3));
					job.setCompanyName(rst.getString(4));
					job.setLocation(rst.getString(5));
					job.setSalary(rst.getString(6));
					job.setActivate(rst.getString(7));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}	
		return job;
	}

	@Override
	public void updateJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("Update Job set JobTitle=?,set JobDescription=? where EmployeeId=?");
			pst.setString(1,job.getJobTitle());
			pst.setString(2,job.getJobDescription());
			pst.setInt(3,job.getJobId());
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
	public void deactivateJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("Update Job set Activate=? where JobId=?");
			pst.setString(1,"Deactivate");
			pst.setInt(2,job.getJobId());
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("Job Deactivated");
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
	public void deleteJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("Delete From Job where JobId=?");
			pst.setInt(1,id);
			int i=pst.executeUpdate();
			
			if(i==1)
			{
				System.out.println("Job Deleted");
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
	public void activateJob(Job job) {
		try {
			PreparedStatement pst=conn.prepareStatement("update Skill set Active=? where SkillId=? ");
			pst.setString(1, "Active");
			pst.setInt(2, job.getJobId());
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
	
	
	


