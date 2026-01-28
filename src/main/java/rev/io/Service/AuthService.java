package rev.io.Service;

import rev.co.Repo.AuthRepository;
import rev.co.util.SessionManager;

public class AuthService {
	private AuthRepository authRepo = new AuthRepository();

    // Login returns role as String (EMPLOYEE, ADMIN, MANAGER) or null if invalid
    public String login(int empId, String password) {
        return authRepo.validateLogin(empId, password);
    }
}
