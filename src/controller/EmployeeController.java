package controller;

import java.io.*;
import java.sql.*;
import java.util.*;
import javax.imageio.IIOException;

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
      String role=s6;
      emp.setGender(s6);
      
      if(role.equals("HRA")   || role.equals("EMP") || role.equals("PME")) {
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
  
   public void updateEmployee() {
	   try {
			  BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			  int id;
			  String password,confirmPassword;
			  
			  System.out.println("Enter EmployeeId whose record you want update:");
			  id=Integer.parseInt(reader.readLine());
			  Employee emp=empDao.getEmployeeById(id);
			  
			  System.out.println("Enter your new password:");
			  password=reader.readLine();
			  
			  System.out.println("COnfirm your new password:");
			  confirmPassword=reader.readLine();
			  if(password.equals(confirmPassword)) {
				 emp.setPassword(password);
				 empDao.updateEmployee(emp);
			 }
			 else {
				 System.out.println("You have entered differenr password");
				 
			 }
			 
			 
			  }
		  catch(IOException ex) {
			  System.out.println(ex.getMessage());
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
}

