package controller;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.imageio.IIOException;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import dao.IEmployeeDao;
import daoImpl.EmployeeDaoImpl;
import model.Employee;
import dao.IEmpSkillDao;
import daoImpl.EmpSkillDaoImpl;
import model.EmpSkill;
import dao.IEmpJobDao;
import daoImpl.EmpJobDaoImpl;
import model.EmpJob;

public class EmployeeController {
	
	IEmployeeDao empDao=null;
	IEmpSkillDao empskillDao=null;
	IEmpJobDao empjobDao=null;
	public EmployeeController() throws ClassNotFoundException,SQLException {
		empDao=new EmployeeDaoImpl();
		empskillDao=new EmpSkillDaoImpl();
		empjobDao=new EmpJobDaoImpl();
	}
	public Employee checkLogin(String userId,String password) {
		Employee emp=empDao.checkLogin(userId, password);
		return emp;
	}
	
  public void addEmployee(String s1, String s2, String s3, String s4, String s5, String s6) {
	  
	  Employee emp=new Employee();
      emp.setFirstName(s1);
      emp.setLastName(s2);
      emp.setUserId(s3);
      emp.setPassword(s4);
      emp.setRole(s5);
      emp.setGender(s6);
      
      if(s5.equals("HRA")   || s5.equals("EMP") || s5.equals("PME")) {
    	  emp.setActive("Active");  
      }
      else {
    	  emp.setActive("Deactive");  
      }
      empDao.addEmployee(emp); 
  }  
  
  public List<Employee> getAllEmployees() {
	  List<Employee>  allEmpList=empDao.getAllEmployees();
	  for(Employee emp:allEmpList) {
			System.out.println(emp);
		}
	 return allEmpList;
  }
  
  public void getEmployeeById(int id)  {
	  Employee emp=empDao.getEmployeeById(id);
	  System.out.println(emp);
	  }
  
   public void updateEmployee(int id,String s1,String s2) {
			  BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			  Employee emp=empDao.getEmployeeById(id);
			  JFrame f =new JFrame();
			  if(s1.equals(s2)) {
				 emp.setPassword(s1);
				 empDao.updateEmployee(emp);
			 }
			 else {
				 JOptionPane.showMessageDialog(f,"You have entered differenr password");
				 
			 }
   }
   
   public void deactiveEmployee(int id)  {
			  Employee emp=empDao.getEmployeeById(id);
			  empDao.deactivateEmployee(emp);
   }
   
   public void activateEmployee(int id) {
			  Employee emp=empDao.getEmployeeById(id);
			  empDao.activateEmployee(emp);
   }
   
   
   public void deleteEmployee() {
	   try {
			  BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			  int id;
			  System.out.println("Enter EmployeeId whose record you want to delete:");
			  id=Integer.parseInt(reader.readLine());
			  empDao.deleteEmployee(id);
			  }
		  catch(IOException ex) {
			  System.out.println(ex.getMessage());
			  }
   }
   public void addEmpSkill(int s1, int s2, int s3) {
		EmpSkill esk=new EmpSkill();
		//BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc=new Scanner(System.in);
		//System.out.println("Enter year of Expiry:");
		esk.setEmployeeId(s1);
		esk.setSkillId(s2);
		esk.setExpYear(s3);
		empskillDao.addEmpSkill(esk);
	}
	public void getAllEmpSkills() {
		
		List<EmpSkill> allEmpSkillList=empskillDao.getAllEmpSkills();
		for(EmpSkill esk:allEmpSkillList) {
			System.out.println(esk);
		}
	}
	public void getEmpSkillById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmpSkillId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			EmpSkill esk=empskillDao.getEmpSkillById(id);
			System.out.println(esk);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
	}
	public void updateEmpSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			Scanner sc=new Scanner(System.in);
			int id;
			int expyear;
			System.out.println("Enter ESId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			EmpSkill esk=empskillDao.getEmpSkillById(id);
			System.out.println("Enter your new Expiry Year:");
			expyear=sc.nextInt();
			esk.setExpYear(expyear);
			empskillDao.updateEmpSkill(esk);
			System.out.println(esk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void DeleteEmpSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter ESId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			empskillDao.deleteEmpSkill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void addEmpJob(int id, int s1, String s2) {
		EmpJob ej=new EmpJob();
	
		ej.setEmployeeId(id);
		ej.setJobId(s1);
		ej.setRecruited(s2);
		empjobDao.addEmpJob(ej);
	}
public void getAllEmpJobs() {
		
		List<EmpJob> allEmpJobList=empjobDao.getAllEmpJobs();
		for(EmpJob ej:allEmpJobList) {
			System.out.println(ej);
		}
	}
	public void getEmpJobById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EmpJobId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			EmpJob ej=empjobDao.getEmpJobById(id);
			System.out.println(ej);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
	}
	public void updateEmpJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String recruited;
			System.out.println("Enter EJId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			EmpJob ejb=empjobDao.getEmpJobById(id);
			System.out.println("Enter your new recruited info:");
			recruited=reader.readLine();
			ejb.setRecruited(recruited);
			empjobDao.updateEmpJob(ejb);
			System.out.println(ejb);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void DeleteEmpJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter EJId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			empjobDao.deleteEmpJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
}

