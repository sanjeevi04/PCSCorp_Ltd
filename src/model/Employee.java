package model;

public class Employee {
private int empId;
private String FirstName;
private String LastName;
private String UserId;
private String Password;
private String Role;
private String Gender;
private String Active;
public Employee() {
	
	
}
public Employee(String firstName, String lastName, String userId, String password, String role, String gender) {
	super();
	FirstName = firstName;
	LastName = lastName;
	UserId = userId;
	Password = password;
	Role = role;
	Gender = gender;
	
}
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getFirstName() {
      return FirstName;
}
public void setFirstName(String firstName) {
	FirstName = firstName;
}
public String getLastName() {
	return LastName;
}
public void setLastName(String lastName) {
	LastName = lastName;
}
public String getUserId() {
	return UserId;
}
public void setUserId(String userId) {
	UserId = userId;
}
public String getPassword() {
	return Password;
}
public void setPassword(String password) {
	Password = password;
}
public String getRole() {
	String r="Role";
	return r;
}
public void setRole(String role) {
	Role = role;
}
public String getGender() {
	return Gender;
}
public void setGender(String gender) {
	Gender = gender;
}
public String getActive() {
	String s1="Active";
	return s1;
}
public void setActive(String active) {
	Active = active;
}
@Override
public String toString() {
	return "Employee [empId=" + empId + ", FirstName=" + FirstName + ", LastName=" + LastName + ", UserId=" + UserId
			+ ", Password=" + Password + ", Role=" + Role + ", Gender=" + Gender + ", Active=" + Active + "]";
}




}
