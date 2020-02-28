import java.sql.*;
import javax.swing.*;

public abstract class DBConnection {
	
	private static Connection conn = null;

	public static boolean getConnection() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String DBURL = "jdbc:oracle:thin:@localhost:1521:orcl";
			String suname = "bebase";
			String spass = "oracle";
						
			if(conn == null || conn.isClosed()) 
				conn = DriverManager.getConnection(DBURL,suname,spass);
			
			return true;
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
			return false;
		}
	}
	
	public static boolean isAllConnectionClosed() {
		boolean result = false;
		try {
			result = conn.isClosed();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public static void closeAllConnection() {
		try	{
			conn.close();
			conn = null;
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
}