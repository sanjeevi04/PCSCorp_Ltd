package model;

public class EmpSkill {

	private int esId;
	private int employeeId;
	private int skillId;
	private int expYear;
	public EmpSkill() {
			
	}	
	public EmpSkill(int employeeId, int skillId, int expYear) {
		super();
		employeeId = employeeId;
		skillId = skillId;
		expYear = expYear;
	}
	public int getESId() {
		return esId;
	}
	public void setESId(int esId) {
		this.esId = esId;
	}
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public int getExpYear() {
		return expYear;
	}
	public void setExpYear(int expYear) {
		this.expYear = expYear;
	}
	@Override
	public String toString() {
		return "EmpSkill [esId=" + esId + ", employeeId=" + employeeId + ", skillId=" + skillId + ", expYear=" + expYear
				+ "]";
	}
	
	
	
}
