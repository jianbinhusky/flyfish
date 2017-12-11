package sql;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCTest {

	public static void main(String[] args){
		String url = "";
		String user = "";
		String password = "";
		String sql1 = "";
		String sql2 = "";
		try {
			Class.forName("com.mysql.jdbc.driver");
			Connection conn = DriverManager.getConnection(url, user, password);
			Statement statement = conn.createStatement();
			ResultSet rs =  statement.executeQuery(sql1);
			statement.executeUpdate(sql2);
			while(rs.next()){
				
			}
			rs.close();
			statement.close();
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
