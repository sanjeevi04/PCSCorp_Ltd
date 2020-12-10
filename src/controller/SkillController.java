package controller;

import java.io.*;
import java.sql.*;
import java.util.*;
import dao.ISkillDao;
import daoImpl.SkillDaoImpl;
import model.EmpSkill;
import model.Employee;
import model.Skill;

public class SkillController {

	ISkillDao skDao=null;
	public SkillController() throws ClassNotFoundException,SQLException
	{
		skDao=new SkillDaoImpl();
	}
	
	public Skill addSkill()  
	{
		Skill skill=new Skill();
		try {
		BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter Skill Description:");
		skill.setSkillDescription(reader.readLine());
		System.out.println("Enter Skill Name:");
		String skillName=reader.readLine();
		skill.setSkillName(skillName);
		if(skillName.equals("coding")) {
			skill.setActive("Active");
		}
		else {
			skill.setActive("Deactive");
		}
		skDao.addSkill(skill);
		
	}
		catch(IOException ex)
		{
			System.out.println(ex.getMessage());
		}
		return skill;
		
}
	
	public void getAllSkills() {
		List<Skill> allSkillList=skDao.getAllSkills();
		for (Skill skill:allSkillList) {
			System.out.println(skill);
		}
	}
	
	public void getSkillById() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to access:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skDao.getSkillById(id);
			System.out.println(sk);
			}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
			}
	}
	public void updateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			String skill, skilldescription;
			System.out.println("Enter SkillId of the record you want to update:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skDao.getSkillById(id);
			System.out.println("Add your new Skill:");
			skill=reader.readLine();
			System.out.println("Enter your new Skill description:");
			skilldescription=reader.readLine();
			sk.setSkillName(skill);
			sk.setSkillDescription(skilldescription);
			skDao.updateSkill(sk);
			System.out.println(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void deactivateSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to deactivate:");
			id=Integer.parseInt(reader.readLine());
			Skill sk=skDao.getSkillById(id);
			skDao.deactivateSkill(sk);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}
	public void DeleteSkill() {
		try {
			BufferedReader reader=new BufferedReader(new InputStreamReader(System.in));
			int id;
			System.out.println("Enter SkillId whose record you want to delete:");
			id=Integer.parseInt(reader.readLine());
			skDao.deleteSkill(id);
		}
		catch(IOException ex) {
			System.out.println(ex.getMessage());
		}
	}

	public void activateSkill(int s) {
		Skill sk=skDao.getSkillById(s);
		skDao.activateSkill(sk);
		
	}
	
}
