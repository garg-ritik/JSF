package ejb;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import connection.ConnectionDB;

@ManagedBean(name = "login")
@SessionScoped
public class LoginBean {
	
	private String username;
	private String password;
	private String dbusername;
	private String dbpassword;
	ConnectionDB condb = new ConnectionDB();
	
	public LoginBean() {}
	public LoginBean(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public void getDbData() throws SQLException {
		Connection con = condb.connect();
		Statement statement = con.createStatement();
        String SQL = "Select * from login where username like ('" + username +"')";
        ResultSet resultSet = statement.executeQuery(SQL);
        resultSet.next();
        dbusername = resultSet.getString(1).toString();
        dbpassword = resultSet.getString(2).toString();
		//System.out.println(con);
	}
	
	public String checkUser() throws SQLException {
		getDbData();
		if(username.equals(dbusername)) {
			if(password.equals(dbpassword)) {
				return "home";
			}else {
				return "loginfail";
			}
		}else {
			return "loginfail";
		}
	}
	

}
