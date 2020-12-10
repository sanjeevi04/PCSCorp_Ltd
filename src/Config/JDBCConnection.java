package Config;


import java.sql.*;

public class JDBCConnection {
  public static Connection getDBConnection() throws ClassNotFoundException,SQLException{
	   String url="jdbc:mysql://localhost:3306/pcsdb";
	   String username="root";
	   String password="niit@123";
	   
	   
	   Class.forName("com.mysql.jdbc.Driver");
	   Connection conn=DriverManager.getConnection(url, username, password);
	   return conn;
	   
  }
}
