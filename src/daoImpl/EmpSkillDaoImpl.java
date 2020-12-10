package daoImpl;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import Config.JDBCConnection;
import dao.IEmpSkillDao;
import dao.ISkillDao;
import model.EmpSkill;
import model.Skill;

public class EmpSkillDaoImpl implements IEmpSkillDao {
	
	Connection conn=null;
	public EmpSkillDaoImpl() throws ClassNotFoundException, SQLException{
		conn=JDBCConnection.getDBConnection();
	}
	@Override
	public List<EmpSkill> getAllEmpSkills() {
		List<EmpSkill> allEmpSkillList=new ArrayList<EmpSkill>(); 
		try{
			Statement stmt=conn.createStatement();
			ResultSet rst=stmt.executeQuery("select * from EmpSkill");
			if(rst!=null) {
				EmpSkill esk=null;
				while(rst.next()) {
					esk=new EmpSkill();
					esk.setESId(rst.getInt(1));
					esk.setEmployeeId(rst.getInt(2));
					esk.setSkillId(rst.getInt(3));
					esk.setExpYear(rst.getInt(4));
					allEmpSkillList.add(esk); 
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return allEmpSkillList;
	}
	@Override
	public void addEmpSkill(EmpSkill esk) {
		try {
			PreparedStatement pst=conn.prepareStatement("insert into EmpSkill(EmployeeId,SkillId,ExpYear) values(?,?,?)");
			pst.setInt(1,esk.getEmployeeId());
			pst.setInt(2,esk.getSkillId());
			pst.setInt(3, esk.getExpYear());
			int i=pst.executeUpdate();
			if(i==1){
				System.out.println("1 record inserted...");
			}
			else {
				System.out.println("insertion failed...");
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		
	}
	@Override
	public EmpSkill getEmpSkillById(int id) {
		EmpSkill esk=new EmpSkill();
		try{
			PreparedStatement pst=conn.prepareStatement("select * from EmpSkill where ESId=?");
			pst.setInt(1,id);
			ResultSet rst=pst.executeQuery();
			if(rst!=null) {
				if(rst.next()) {
					esk=new EmpSkill();
					esk.setESId(rst.getInt(1));
					esk.setEmployeeId(rst.getInt(2));
					esk.setSkillId(rst.getInt(3));
					esk.setExpYear(rst.getInt(4));
				}
			}
		}
		catch(SQLException ex) {
			System.out.println(ex.getMessage());
		}
		return esk;
	}
	@Override
	public void updateEmpSkill(EmpSkill esk) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("update EmpSkill set ExpYear=? where ESId=? ");
			pst.setInt(1, esk.getExpYear());
			pst.setInt(2, esk.getESId());
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
	public void deleteEmpSkill(int id) {
		try {
			//creating PreparedStatement object by passing query string
			PreparedStatement pst=conn.prepareStatement("delete from EmpSkill where ESId=? ");
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
