import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import com.mysql.jdbc.Connection;

public class ConnectionMySQL {
	public static void main(String [] args){
		try{
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost/testing","root","");
			String query="Select * from products limit 5;";
			Statement stmt = conn.createStatement();
			ResultSet rs= stmt.executeQuery(query);
			
			while(rs.next()){
				System.out.println("NAME: "+rs.getString("name")+" PRICE:"+rs.getString("price"));
			}
			
			//System.out.println("Connection Success");
		} catch(Exception e) {
			System.err.println(e);
		}
	}
}
