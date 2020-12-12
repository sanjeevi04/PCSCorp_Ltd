package model;

public class Job {
	
	private int JobId;
	private String JobTitle;
	private String JobDescription;
	private String CompanyName;
	private String Location;
	private String Role;
	private String Skills;
	private String Salary;
	private String Activate;
	
	public Job() {
		
	}
	
	
    
	public Job(String jobTitle, String jobDescription, String companyName, String location, String role,
			String skills, String salary) {
		super();
		JobTitle = jobTitle;
		JobDescription = jobDescription;
		CompanyName = companyName;
		Location = location;
		Role = role;
		Skills = skills;
		Salary = salary;
	}



	public int getJobId() {
		return JobId;
	}



	public void setJobId(int jobId) {
		JobId = jobId;
	}



	public String getJobTitle() {
		return JobTitle;
	}



	public void setJobTitle(String jobTitle) {
		JobTitle = jobTitle;
	}



	public String getJobDescription() {
		return JobDescription;
	}



	public void setJobDescription(String jobDescription) {
		JobDescription = jobDescription;
	}



	public String getCompanyName() {
		return CompanyName;
	}



	public void setCompanyName(String companyName) {
		CompanyName = companyName;
	}



	public String getLocation() {
		return Location;
	}



	public void setLocation(String location) {
		Location = location;
	}



	public String getRole() {
		return Role;
	}



	public void setRole(String role) {
		Role = role;
	}



	public String getSkills() {
		return Skills;
	}



	public void setSkills(String skills) {
		Skills = skills;
	}



	public String getSalary() {
		return Salary;
	}



	public void setSalary(String salary) {
		Salary = salary;
	}



	public String getActivate() {
		return Activate;
	}



	public void setActivate(String activate) {
		Activate = activate;
	}



	@Override
	public String toString() {
		return "Job [JobId=" + JobId + ", JobTitle=" + JobTitle + ", JobDescription=" + JobDescription
				+ ", CompanyName=" + CompanyName + ", Location=" + Location + ", Role=" + Role + ", Skills=" + Skills
				+ ", Salary=" + Salary + ", Activate=" + Activate + "]";
	}



	

	
}
