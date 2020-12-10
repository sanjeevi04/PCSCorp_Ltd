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
	
  public Employee addEmployee() {
	  
	  Employee emp=new Employee();
	  
	  try {
      BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
      
      System.out.println("Enter First Name:");
      emp.setFirstName(reader.readLine());
      
      System.out.println("Enter Lirst Name:");
      emp.setLastName(reader.readLine());
      
      System.out.println("Enter UserID:");
      emp.setUserId(reader.readLine());
      
      System.out.println("Enter Password:");
      emp.setPassword(reader.readLine());
      
      System.out.println("Role:");
      String role=reader.readLine();
      emp.setRole(role);
      
      System.out.println("Enter Gender:");
      emp.setGender(reader.readLine());
      
      if(role.equals("HRA")) {
    	  emp.setActive("Active");  
      }
      else {
    	  emp.setActive("Deactive");
    	  
      }
      empDao.addEmployee(emp);
	  }
	  catch(IOException ex) {
		 System.out.println(ex.getMessage()); 
	  }
	return emp;  
  }
  
  public void getAllEmployees() {
	  List<Employee>  allEmpList=empDao.getAllEmployees();
	 
	  for(Employee emp:allEmpList) {
		  System.out.println(emp);
	  }
  }
  public void getEmployeeById() throws NumberFormatException, IOException {
	BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
	int id ;
	System.out.println("Enter EmployeeId whose record you want to access:");
		id=Integer.parseInt(reader.readLine());
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
   public void deactiveEmployee() throws NumberFormatException, IOException {
	 
			  BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			  int id;
			  System.out.println("Enter EmployeeId whose record you want to deactivate:");
			  id=Integer.parseInt(reader.readLine());
			  Employee emp=empDao.getEmployeeById(id);
			  empDao.deactivateEmployee(emp);
   }
   public void activateEmployee(int e) {
	   try {
			  BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			  int id;
			  System.out.println("Enter EmployeeId whose record you want to Activate:");
			  id=Integer.parseInt(reader.readLine());
			  Employee emp=empDao.getEmployeeById(e);
			  empDao.activateEmployee(emp);
			  }
		  catch(IOException ex) {
			  System.out.println(ex.getMessage());
			  }
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

