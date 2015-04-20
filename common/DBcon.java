package shoeseholic.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.CallableStatement;

public class DBcon {
	public static void loadOracleDriver() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		} catch (Exception e) {
		e.printStackTrace();
		}
		}
		public static Connection getConnection(String url, String id,
		String passwd) throws SQLException {
		return DriverManager.getConnection(url, id, passwd); 
		}


		public static Connection getOracleConnection()
		throws SQLException {
		String url = "jdbc:oracle:thin:@192.168.234.133:1521:orcl";
		//String url = "jdbc:oracle:thin:@localhost:1521:xe";			
		String id = "shop";
		String passwd = "shop";
		//String id = "hr";
		//String passwd = "hr";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver").newInstance();
		} catch (Exception e) {
		e.printStackTrace();
		}
		return DriverManager.getConnection(url, id, passwd);
		}
		
		public void disconnect(Connection conn){
            if(conn !=null)
            	try {
                            conn.close();
            	} catch (SQLException e) {e.printStackTrace();}
    }

}


