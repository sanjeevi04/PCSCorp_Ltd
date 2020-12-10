package model;

public class EmpJob {

	private int ejId;
	private int empId;
    private int jobId;
    private String recruited;
    public EmpJob() {
    	
    }
	public EmpJob(int empId, int jobId, String recruited) {
		super();
		empId = empId;
		jobId = jobId;
		recruited = recruited;
	}
	public int getEJId() {
		return ejId;
	}
	public void setEJId(int ejId) {
		this.ejId = ejId;
	}
	public int getEmployeeId() {
		return empId;
	}
	public void setEmployeeId(int empId) {
		this.empId = empId;
	}
	public int getJobId() {
		return jobId;
	}
	public void setJobId(int jobId) {
		this.jobId = jobId;
	}
	public String getRecruited() {
		return recruited;
	}
	public void setRecruited(String recruited) {
		this.recruited = recruited;
	}
	@Override
	public String toString() {
		String EmployeeId = null;
		return "EmpJob [ejId=" + ejId + ", employeeId=" + EmployeeId + ", jobId=" + jobId + ", recruited=" + recruited + "]";
	}
	
	
	
}
