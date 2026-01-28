package rev.co.Repo;

import java.sql.Connection;
import java.sql.PreparedStatement;

import rev.co.util.DButil;
public class NotificationRepository {
	public void saveNotification(int empId, String msg) {
        try (Connection con = DButil.getConnection()) {
            String sql =
              "INSERT INTO NOTIFICATION VALUES " +
              "(NOTI_SEQ.NEXTVAL, ?, ?, SYSDATE, 'UNREAD')";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, empId);
            ps.setString(2, msg);

            ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
