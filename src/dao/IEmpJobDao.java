package dao;

import java.util.List;
import model.EmpJob;


public interface IEmpJobDao {
  
	 List<EmpJob> getAllEmpJobs();
	void addEmpJob(EmpJob ej) ;
	EmpJob getEmpJobById(int id);
	void updateEmpJob(EmpJob ej);
	void deleteEmpJob(int id);
	
}
