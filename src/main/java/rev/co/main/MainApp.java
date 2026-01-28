package rev.co.main;

import rev.co.model.Employee;
import rev.co.util.InputUtil;
import rev.co.util.SessionManager;
import rev.io.Service.AuthService;

public class MainApp {
	public static void main(String[] args) {
		AuthService authService = new AuthService();
		MenuHandler menu = new MenuHandler();

		System.out.print("Employee ID: ");
		int empId = InputUtil.sc.nextInt();
		InputUtil.sc.nextLine(); // consume leftover newline

		System.out.print("Password: ");
		String pwd = InputUtil.sc.nextLine();

		// Login returns role string
		String role = authService.login(empId, pwd);

		if (role != null) {
		    System.out.println("Login Success: " + SessionManager.getName() +
		                       " (" + SessionManager.getRole() + ")");

		    // Create Employee object for menu
		    Employee user = new Employee();
		    user.setEmpId(empId);
		    user.setName(SessionManager.getName());
		    user.setRole(SessionManager.getRole());

		    // Call menu
		    menu.showMenu(user);

		} else {
		    System.out.println("Invalid Credentials");
		}

	}
}