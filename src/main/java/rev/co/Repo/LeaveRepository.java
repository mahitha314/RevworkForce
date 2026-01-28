package rev.co.Repo;
import java.sql.Connection;
import java.sql.PreparedStatement;

import rev.co.model.LeaveApplication;
import rev.co.util.DButil;
public class LeaveRepository {
	 public void insertLeave(LeaveApplication leave) {

	        try (Connection con = DButil.getConnection()) {
	            String sql =
	              "INSERT INTO LEAVE_APPLICATION VALUES " +
	              "(LEAVE_SEQ.NEXTVAL,?,?,?,?, 'PENDING')";

	            PreparedStatement ps = con.prepareStatement(sql);
	            ps.setInt(1, leave.getEmpId());
	            ps.setString(2, leave.getLeaveType());
	            ps.setDate(3, leave.getFromDate());
	            ps.setDate(4, leave.getToDate());
	            ps.setString(5, leave.getReason());

	            ps.executeUpdate();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }
}
