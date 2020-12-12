package model;

public class EmpJob {

	private int EJId;
	private int EmployeeId;
    private int JobId;
    private String Recruited;
    public EmpJob() {
    	
    }
	public EmpJob(int empId, int jobId, String recruited) {
		super();
		EmployeeId = empId;
		JobId = jobId;
		Recruited = recruited;
	}
	public int getEJId() {
		return EJId;
	}
	public void setEJId(int ejId) {
		EJId = ejId;
	}
	public int getEmployeeId() {
		return EmployeeId;
	}
	public void setEmployeeId(int empId) {
		EmployeeId = empId;
	}
	public int getJobId() {
		return JobId;
	}
	public void setJobId(int jobId) {
		JobId = jobId;
	}
	public String getRecruited() {
		return Recruited;
	}
	public void setRecruited(String recruited) {
		Recruited = recruited;
	}
	@Override
	public String toString() {
		return "EmpJob [EJId=" + EJId + ", EmployeeId=" + EmployeeId + ", JobId=" + JobId + ", Recruited=" + Recruited
				+ "]";
	}

	
	
	
	
}
