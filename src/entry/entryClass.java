package entry;

import java.sql.SQLException;
import java.util.*;
import Config.JDBCConnection;
import controller.EmployeeController;
import java.io.*;
import controller.SkillController;
import controller.JobController;
import java.lang.String;


public class entryClass  {
public void testConnection() throws ClassNotFoundException, SQLException{
	if(JDBCConnection.getDBConnection().isClosed()){
		System.out.println("Connection is closed");
	}
	else {
		System.out.println("Connection is open");
	}

}

	public static void main(String[] args) throws ClassNotFoundException, SQLException, NumberFormatException, IOException {
		
		EmployeeController empController=new EmployeeController();
		JobController jbController =new JobController();
		SkillController skController =new SkillController();
		
		Scanner sc=new Scanner(System.in);
		int option;
		String TableName;
		char ch='y',mn='y';
        BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		
		while(mn=='y' || mn=='Y') {
		System.out.println("Enter the table name to open CRUD Menu(Employee/Skill/Job/EmpSkill/EmpJob): ");
		TableName=reader.readLine();
		if(TableName.equals("Employee")) {
		

		while(ch=='y' || ch=='Y') {
			System.out.println("CRUD  Menu:");
			System.out.println("1. View all Employees records");
			System.out.println("2. View single Employees record");
			System.out.println("3. Add an Employee");
			System.out.println("4. Update an Employee record");
			System.out.println("5. Deactive an Employee record");
			System.out.println("6. Active an Employee record");
			System.out.println("7. Delete an Employees record");
			System.out.println("8. Exit");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
			case 1:
				
				empController.getAllEmployees();
				break;
			case 2:
				int id;
				System.out.println("Enter the Id:");
				id=sc.nextInt();
				empController.getEmployeeById(id);
				break;
			case 3:
				System.out.println("Enter Employee Detail:");
				String s1,s2,s3,s4,s5,s6;
				System.out.println("Enter Employee Detail:");
				System.out.println("Enter First Name:");
				s1=sc.next();
				System.out.println("Enter Last Name:");
				s2=sc.next();
				System.out.println("Enter UserId:");
				s3=sc.next();
				System.out.println("Enter Password:");
				s4=sc.next();
				System.out.println("Enter Gender:");
				s5=sc.next();
				System.out.println("Enter Role:");
				s6=sc.next();
				empController.addEmployee(s1,s2,s3,s4,s5,s6);
				break;
			case 4:
				empController.updateEmployee();
				break;
			case 5:
				System.out.println("Enter EmployeeId whose record you want to deactivate:");
				id=sc.nextInt();
				empController.deactiveEmployee(id);
				break;
			case 6:
				System.out.println("Enter EmployeeId whose record you want to activate:");
				id=sc.nextInt();
				empController.activateEmployee(id);
				break;
			case 7:
				empController.deleteEmployee();
				break;
			case 8:
				System.exit(0);
				break;
			default:
				System.out.println("Wrong input");
				}
			System.out.println("Do you want to continue?(y/n)");
			ch=sc.next().charAt(0);
			}
		}
		else if(TableName.equals("Job")) {
		while(ch=='y' || ch=='Y') {
			System.out.println(" Menu:");
			System.out.println("1. View all Job records");
			System.out.println("2. View single Job record");
			System.out.println("3. Add an Job");
			System.out.println("4. Update an Job record");
			System.out.println("5. Deactive an Job record");
			System.out.println("6. Delete an Job record");
			System.out.println("7. Exit");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
				case 1: 
					System.out.println("Following are all Job Detail:");
					jbController.getAllJob();
					break;
				case 2:
					jbController.getJobById();
					break;
				case 3: 
					System.out.println("Enter Job Detail:");
					String s1,s2,s3,s4,s5,s6;
					System.out.println("Enter Job Title :");
					s1=sc.next();
					System.out.println("Enter Job Description:");
					s2=sc.next();
					System.out.println("Enter Company Name :");
					s3=sc.next();
					System.out.println("Enter Location:");
					s4=sc.next();
					System.out.println("Enter KeySkill:");
					s5=sc.next();
					System.out.println("Enter Salary:");
					s6=sc.next();
					jbController.addJob(s1,s2,s3,s4,s5,s6);
					break;
				case 4:
					jbController.updateJob();
					break;
				case 5:
					jbController.deactivateJob();
					break;
				case 6:
					jbController.deleteJob();
					break;
				case 7:
					System.exit(0);
					break;
				default:
					System.out.println("Wrong input");
			}
			
			System.out.println("Do you want to continue?(y/n)");
			ch=sc.next().charAt(0);
		}

		}
		else if(TableName.equals("Skill")) {
			while(ch=='y' || ch=='Y')	{
				System.out.println("Menu:");
				System.out.println("1. View all Skill records");
				System.out.println("2. View single Skill record");
				System.out.println("3. Add an Skill");
				System.out.println("4. Update an Skill record");
				System.out.println("5. Deactive an Skill record");
				System.out.println("6. Delete an Skill record");
				System.out.println("7. Exit");
				System.out.println("Enter your choice:");
				option=sc.nextInt();
				switch(option) 
				{
				case 1: 
				System.out.println("Following are all Skill Detail:");
				skController.getAllSkills();
				break;
				case 2:
				System.out.println("Enter the Id:");
				int id=sc.nextInt();
				skController.getSkillById(id);
				break;
				case 3: 
				System.out.println("Enter Skill Detail:");
				String s1,s2;
				System.out.println("Enter Skill name:");
				s1=sc.next();
				System.out.println("Enter Skill Description:");
				s2=sc.next();
				skController.addSkill(s1,s2);
				break;
				case 4:
				skController.updateSkill();
				break;
				case 5:
				System.out.println("Enter SkillId whose record you want to deactivate:");
				id=sc.nextInt();
				skController.deactivateSkill(id);
				break;
				case 6:
				skController.DeleteSkill();
				break;
				case 7:
				System.exit(0);
				break;
				default:
				System.out.println("Wrong input");
				}
		
				System.out.println("Do you want to continue?(y/n)");
				ch=sc.next().charAt(0);
			}
		}
	
		System.out.println("Do you want perfom CRUD Menu on other tables?(y/n)");
		ch=sc.next().charAt(0);
		}
	}
}





