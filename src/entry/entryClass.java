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
		int option,menu;
		String TableName;
		char ch='y',mn='y';
		while(mn=='y' || mn=='Y') {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Controller Menu:");
		System.out.println("1.EmployeeController");
		System.out.println("2.JobController");
		System.out.println("3.SkillContoller");
		System.out.println("4.Exit ");
		System.out.println("Choose Menu:");
		menu=sc.nextInt();
		switch(menu)
		{
		case 1:
		{
		while(ch=='y' || ch=='Y') {
			System.out.println("Menu:");
			System.out.println("1. View all Employees records");
			System.out.println("2. View single Employees record");
			System.out.println("3. Add an Employee");
			System.out.println("4. Update an Employee record");
			System.out.println("5. Deactive an Employee record");
			System.out.println("6. Delete an Employees record");
			System.out.println("7. Exit");
			System.out.println("Enter your choice:");
			option=sc.nextInt();
			switch(option) {
			case 1:
				System.out.println("Following are all Employees Detail:");
				empController.getAllEmployees();
				break;
			case 2:
				empController.getEmployeeById();
				break;
			case 3:
				System.out.println("Enter Employee Detail:");
				empController.addEmployee();
				break;
			case 4:
				empController.updateEmployee();
				break;
			case 5:
				empController.deactiveEmployee();
				break;
			case 6:
				empController.deleteEmployee();
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
		
		case 2:
		{
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
					jbController.addJob();
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
		
		case 3:
		{
			while(ch=='y' || ch=='Y')
			{
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
				skController.getSkillById();
				break;
				case 3: 
				System.out.println("Enter Skill Detail:");
				skController.addSkill();
				break;
				case 4:
				skController.updateSkill();
				break;
				case 5:
				skController.deactivateSkill();
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
			break;
		}
		case 4:
			System.exit(0);
			break;
		default:
			System.out.println("Wrong input");
		}
	
	System.out.println("Do you want to continue?(y/n)");
	ch=sc.next().charAt(0);
}
	
	System.out.println("Do you want perfom CRUD operation on other tables?(y/n)");
	mn=sc.next().charAt(0);
		
	}

	}




