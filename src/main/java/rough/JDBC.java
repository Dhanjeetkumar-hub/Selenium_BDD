package rough;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.sql.Statement;


public class JDBC {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/dk", "root", "root");
		Statement stmt=con.createStatement();
		ResultSet rs=stmt.executeQuery("select * from dk");
		while(rs.next()) {
			System.out.println(rs.getString(0)+" "+rs.getString(1));
			
		}
		con.close();

	}

}
