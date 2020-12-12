package controller;

import java.io.*;
import java.sql.*;
import java.util.*;

import dao.IJobDao;
import daoImpl.JobDaoImpl;
import model.Job;

public class JobController {
	
	IJobDao jobDao=null;
	public JobController() throws ClassNotFoundException, SQLException{
		jobDao=new JobDaoImpl();
	}
	
	public void addJob(String s1, String s2, String s3, String s4, String s5, String s6) {
		  
		 Job jb=new Job();		  	      
	      jb.setJobTitle(s1);
	      jb .setJobDescription(s2);
		  jb.setCompanyName(s3);
		  jb.setLocation(s4);
		  jb.setSkills(s5);
		  jb.setSalary(s6);
	      if(s1.equals("HRA")) {
	    	  jb.setActivate("Activated");  
	      }
	      else {
	    	  jb.setActivate("Deactivated");
	    	  
	      }
	      jobDao.addJob(jb);
		   
	  }
	
	public void getAllJob()
	{
		List<Job> allJobList=jobDao.getAllJob();
		for(Job job:allJobList)
		{
			System.out.println(job);
		}
		
	}
	
	public void getJobById()
	{
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the EmployeeID whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Job job=jobDao.getJobById(id);
			System.out.println(job);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void updateJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String location, confirmlocation;
			System.out.println("Enter JobId whose record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Job jb=jobDao.getJobById(id);
			System.out.println("Enter your new location:");
			location=reader.readLine();
			System.out.println("re-enter same Location to confirm:");
			confirmlocation=reader.readLine();
			if(location.contentEquals(confirmlocation)) {
				jb.setLocation(location);
				jobDao.updateJob(jb);
			}
			else {
				System.out.println("Sorry! you have entered different location");
			}
			System.out.println(jb);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	

	public void deactivateJob() throws NumberFormatException, IOException {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		int id;
		System.out.println("Enter JobId whose record you want to deactivate:");
		id=Integer.parseInt(reader.readLine());
		Job job=jobDao.getJobById(id);
		jobDao.deactivateJob(job);
	}
	
	
	public void deleteJob() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter the JobId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			jobDao.deleteJob(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void activateJob(int j) {
		Job job=jobDao.getJobById(j);
		jobDao.activateJob(job);
		
	}
	
	
}
