package model;

public class Skill {

	private int skillId;
	private String skillName;
	private String skillDescription;
	private String active;
	
	public Skill() {
		
	}
	public Skill(String skillName, String skillDescription) {
		super();
		skillName = skillName;
		skillDescription = skillDescription;
	}
	public int getSkillId() {
		return skillId;
	}
	public void setSkillId(int skillId) {
		this.skillId = skillId;
	}
	public String getSkillName() {
		return skillName;
	}
	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}
	public String getSkillDescription() {
		return skillDescription;
	}
	public void setSkillDescription(String skillDescription) {
		this.skillDescription = skillDescription;
	}
	public String getActive() {
		return active;
	}
	public void setActive(String active) {
		this.active = active;
	}
	@Override
	public String toString() {
		return "Skill [skillId=" + skillId + ", skillName=" + skillName + ", skillDescription=" + skillDescription
				+ ", active=" + active + "]";
	}
	
	
	
	
}
