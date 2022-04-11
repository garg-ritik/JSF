package connection;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
	
	public Connection connect() {
		
		Connection con = null;
		String url = "jdbc:postgresql://localhost:5432/userDB";
		String user = "postgres";
		String pwd = "Rsi@1234!";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(url, user, pwd);
			
			if(con != null)
				System.out.println("Connection successful");
			else
				System.out.println("Connection Failed");
		}catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}  
		return con;
		
	}
	

}
