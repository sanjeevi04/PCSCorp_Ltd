package dao;

import java.util.List;
import model.EmpSkill;

public interface IEmpSkillDao {
   
	List<EmpSkill> getAllEmpSkills();
	void addEmpSkill(EmpSkill esk);
	EmpSkill getEmpSkillById(int id);
	void updateEmpSkill(EmpSkill esk);
	void deleteEmpSkill(int id);
	
}
