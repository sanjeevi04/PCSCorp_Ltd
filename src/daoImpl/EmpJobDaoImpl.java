package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Config.JDBCConnection;
import dao.IEmpJobDao;
import model.EmpJob;

public class EmpJobDaoImpl implements IEmpJobDao {
	
	Connection conn=null;
	public EmpJobDaoImpl() throws ClassNotFoundException,SQLException
	{
		conn=JDBCConnection.getDBConnection();
	}

	@Override
	public List<EmpJob> getAllEmpJobs() {
		List<EmpJob>allEmpJobList =new ArrayList<EmpJob>();
		try
		{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("Select * from EmpJob");
			if(rst!=null)
			{
				EmpJob empj=null;
				while(rst.next())
				{empj=new EmpJob();
					empj.setEJId(rst.getInt(1));
					empj.setEmployeeId(rst.getInt(2));
					empj.setJobId(rst.getInt(3));
					empj.setRecruited(rst.getString(4));
					allEmpJobList.add(empj);
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}
		return allEmpJobList;	
	}

	@Override
	public void addEmpJob(EmpJob ej) {
		try {
			PreparedStatement pst=conn.prepareStatement("Insert into EmpJob(EmployeeId,JobId,Recruited) values(?,?,?)");
			pst.setInt(3,ej.getEmployeeId());
			pst.setInt(3,ej.getJobId());
			pst.setString(3,ej.getRecruited());
		
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
	public EmpJob getEmpJobById(int id) {
		EmpJob empj=new EmpJob();
		try
		{
			PreparedStatement pst=conn.prepareStatement("Select * from EmployeeJob where EJId=?");
			pst.setInt(1, id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null)
			{
				if(rst.next())
				{
					empj.setEJId(rst.getInt(1));
					empj.setEmployeeId(rst.getInt(2));
					empj.setJobId(rst.getInt(3));
					empj.setRecruited(rst.getString(4));
				}
			}
		}
		catch(SQLException ex)
		{
			System.out.println(ex.getMessage());
		}	
		return empj;
	}

	@Override
	public void updateEmpJob(EmpJob ej) {
		try {
			PreparedStatement pst=conn.prepareStatement("update EmpJob set Recruited=? where EJId=? ");
			pst.setString(1, ej.getRecruited());
			pst.setInt(2, ej.getEJId());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record updated...");
			}
			else {
				System.out.println("update failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

	@Override
	public void deleteEmpJob(int id) {
		try {
			PreparedStatement pst=conn.prepareStatement("delete from EmpJob where EJId=? ");
			pst.setInt(1, id);
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record deleted...");
			}
			else {
				System.out.println("deletion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}

}
