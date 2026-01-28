package rev.co.util;

public class SessionManager {
	private static int empId;
    private static String name;
    private static String role;

    public static void setSession(int id, String empName, String empRole) {
        empId = id;
        name = empName;
        role = empRole;
    }

    public static int getEmpId() { return empId; }
    public static String getName() { return name; }
    public static String getRole() { return role; }

	
}
