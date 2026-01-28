package rev.co.model;

public class Employee {
	 private int empId;
	    private String name;
	    private String role;
	    private int managerId;

	    public int getEmpId() { return empId; }
	    public void setEmpId(int empId) { this.empId = empId; }

	    public String getName() { return name; }
	    public void setName(String name) { this.name = name; }

	    public String getRole() { return role; }
	    public void setRole(String role) { this.role = role; }

	    public int getManagerId() { return managerId; }
	    public void setManagerId(int managerId) { this.managerId = managerId; }
	
}
