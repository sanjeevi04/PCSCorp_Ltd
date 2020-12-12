package dao;

import java.util.List;

import model.EmpSkill;
import model.Skill;

public interface ISkillDao {

	List<Skill> getAllSkills();
	void addSkill(Skill ski);
	Skill getSkillById(int id);
	void updateSkill(Skill sk);
	void deactivateSkill(Skill sk);
	void deleteSkill(int id);
	void activateSkill(Skill sk);
	
}
