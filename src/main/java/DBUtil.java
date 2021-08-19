import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/*
 * 1.Register the DB driver
 * 2.Establish the connection with the DB
 * 3.Prepare a statement(SQL)
 * 4.Execute the query
 * 5.close all the connections
 *
 *vendor :MySql,Oracle,Sqlplus---->driver
 *
 * */



public class DBUtil {
    public final static String url="jdbc:mysql://localhost:3306/emp";
    public final static String username="root";
    public final static String password="123456";
    
    
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
   	 Class.forName("com.mysql.jdbc.Driver");
   	 Connection con=DriverManager.getConnection(url,username,password);
    return con;
  
   
    }
}
