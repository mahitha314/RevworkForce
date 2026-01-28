package rev.co.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import rev.co.util.*;
public class AuthRepository {
	public String validateLogin(int empId, String password) {
        String role = null;
        try (Connection con = DButil.getConnection()) {
            String sql =  "SELECT e.NAME, e.ROLE " +
                    "FROM EMPLOYEE e " +
                    "JOIN LOGIN l ON e.EMP_ID = l.EMP_ID " +
                    "WHERE l.EMP_ID = ? AND l.PASSWORD = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Save session info
                SessionManager.setSession(empId, rs.getString("NAME"), rs.getString("ROLE"));
                role = rs.getString("ROLE");
            }
        } catch (Exception e) {
        e.printStackTrace();
    }
    return role;
}
}
