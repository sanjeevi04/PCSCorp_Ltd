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
	
	public void addSkill(String s1, String s2)  
	{
		Skill skill=new Skill();
		skill.setSkillName(s1);
		skill.setSkillDescription(s2);
		if(s1.equals("coding")) {
			skill.setActive("Active");
		}
		else {
			skill.setActive("Deactive");
		}
		skDao.addSkill(skill);		
	}	
	
	public void getAllSkills() {
		List<Skill> allSkillList=skDao.getAllSkills();
		for (Skill skill:allSkillList) {
			System.out.println(skill);
		}
	}
	
	public Skill getSkillById(int id) {
			Skill sk=skDao.getSkillById(id);
		    return sk;
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
	public void deactivateSkill(int id) {
		Skill skill=skDao.getSkillById(id);
		skDao.deactivateSkill(skill);
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
