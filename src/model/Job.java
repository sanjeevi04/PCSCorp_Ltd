package model;

public class Job {
	
	private int jobId;
	private String jobTitle;
	private String jobDescription;
	private String companyName;
	private String location;
	private String role;
	private String Skills;
	private String Salary;
	private String activate;
	
	public Job() {
		
	}
	
	
	public void setJobTitle(String jobTitle) {
		jobTitle=jobTitle;
	}
    
	public Job(String jobTitle, String jobDescription, String companyName, String location, String role,
			String keySkill, String salary) {
		super();
		jobTitle = jobTitle;
		jobDescription = jobDescription;
		companyName = companyName;
		location = location;
		this.role = role;
		keySkill = keySkill;
		salary = salary;
	}


	public int getJobId() {
		return jobId;
	}


	public void setJobId(int jobId) {
		this.jobId = jobId;
	}


	public String getJobDescription() {
		return jobDescription;
	}


	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}


	public String getCompanyName() {
		return companyName;
	}


	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}


	public String getLocation() {
		return location;
	}


	public void setLocation(String location) {
		this.location = location;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}


	public String getSkills() {
		return Skills;
	}


	public void setSkills(String Skills) {
		this.Skills = Skills;
	}


	public String getSalary() {
		return Salary;
	}


	public void setSalary(String salary) {
		this.Salary = salary;
	}


	public String getActivate() {
		return activate;
	}


	public void setActivate(String activate) {
		this.activate = activate;
	}


	public String getJobTitle() {
		return jobTitle;
	}


	@Override
	public String toString() {
		return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", jobDescription=" + jobDescription
				+ ", companyName=" + companyName + ", location=" + location + ", role=" + role + ", Skills="
				+ Skills + ", Salary=" + Salary + ", activate=" + activate + "]";
	}


	




	


		
}
