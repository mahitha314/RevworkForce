package rev.co.util;

import java.sql.Connection;
import java.sql.DriverManager;
public class DButil {
	private static final String URL =
	        "jdbc:oracle:thin:@localhost:1521:XE";
	    private static final String USER = "system";
	    private static final String PASS = "system";

	    public static Connection getConnection() {
	        try {
	            Class.forName("oracle.jdbc.driver.OracleDriver");
	            return DriverManager.getConnection(URL, USER, PASS);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return null;
	    }
}
