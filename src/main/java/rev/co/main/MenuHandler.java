package rev.co.main;

import rev.co.model.Employee;
import rev.co.util.InputUtil;
import rev.io.Service.EmployeeService;

public class MenuHandler {

    public void employeeMenu() {
        EmployeeService service = new EmployeeService();

        while (true) {
            System.out.println("\n1.Apply Leave");
            System.out.println("2.Logout");

            int choice = InputUtil.sc.nextInt();

            if (choice == 1) {
                service.applyLeave();
            } else {
                System.out.println("Logged out");
                return;
            }
        }
    }
    public void adminMenu() {
        AdminService adminService = new AdminService();

        while (true) {
            System.out.println("\n===== ADMIN MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. Assign Manager");
            System.out.println("3. Configure Leave");
            System.out.println("4. View Reports");
            System.out.println("5. Logout");

            int choice = InputUtil.sc.nextInt();

            switch (choice) {
                case 1:
                    adminService.addEmployee();
                    break;
                case 2:
                    adminService.assignManager();
                    break;
                case 3:
                    adminService.configureLeave();
                    break;
                case 4:
                    adminService.viewReports();
                    break;
                case 5:
                    System.out.println("Logged out");
                    return;
                default:
                    System.out.println("Invalid Choice");
            }
        }
    }
 

    public class AdminService {

        public void addEmployee() {
            System.out.println("Add Employee functionality here");
            // You will take input: name, password, role, managerId, etc
            // Then insert into EMPLOYEE and LOGIN tables using JDBC
        }

        public void assignManager() {
            System.out.println("Assign Manager functionality here");
            // Update EMPLOYEE table to set MANAGER_ID
        }

        public void configureLeave() {
            System.out.println("Configure Leave functionality here");
            // Update LEAVE_BALANCE table for employees
        }

        public void viewReports() {
            System.out.println("View Reports functionality here");
            // Query tables and show statistics
        }
    
    }
    public void showMenu(Employee user) {
        String role = user.getRole();

        if ("EMPLOYEE".equalsIgnoreCase(role)) {
            System.out.println("Employee menu here...");
        } else if ("ADMIN".equalsIgnoreCase(role)) {
            System.out.println("Admin menu here...");
        } else if ("MANAGER".equalsIgnoreCase(role)) {
            System.out.println("Manager menu here...");
        } else {
            System.out.println("Unknown role!");
        }
    }
}
