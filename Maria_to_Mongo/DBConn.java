
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConn {
	
	public static Connection getConnection() throws ClassNotFoundException,SQLException {
		
	
		String jdbcDriver = "org.mariadb.jdbc.Driver";
		String jdbcUrl = "jdbc:mariadb://3.37.136.62:3306/data?serverTimezone=UTC";
		String dbUser = "root";
		String dbPwd = "1234";
		//Class.forName("com.mysql.cj.jdbc.Driver");
		Class.forName(jdbcDriver);
		return DriverManager.getConnection(jdbcUrl,dbUser,dbPwd);

	}
	
	
	
}
