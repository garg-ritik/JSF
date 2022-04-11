package ejb;
import java.io.IOException;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import connection.ConnectionDB;

@ManagedBean(name = "obj")
public class JsfExampleBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private ArrayList<Student> list;
	private Student item = new Student();
	ConnectionDB condb = new ConnectionDB();
	Connection con;
	
	public void add() {
		int result = 0;
		try {
			con = condb.connect();
			PreparedStatement stmt = con.prepareStatement("insert into student(name,email,gender) values(?,?,?)");
			stmt.setString(1, item.getName());
			stmt.setString(2, item.getEmail());
			stmt.setString(3, item.getGender());
			result = stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		if (result != 0) {
			System.out.println("Added Successful");
			item = new Student();
		} else {
			System.out.println("Failed to add");
		}
	}

    public void resetAdd() {
    	item = new Student();
    }

    public ArrayList<Student> getRecords(){  
    	try {
			list = new ArrayList<Student>();
			con = condb.connect();
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select * from student");
			while (rs.next()) {
				item = new Student();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setEmail(rs.getString("email"));
				item.setGender(rs.getString("gender"));
				list.add(item);
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return list;
	}

    public void delete(int id) throws IOException {
    	try {
			con = condb.connect();
			PreparedStatement stmt = con.prepareStatement("delete from student where id = " + id);
			stmt.executeUpdate();
		} catch (Exception e) {
			System.out.println(e);
		}
    }
    
	public String edit(int id) {
		try {
			con = condb.connect();
			Statement stmt = condb.connect().createStatement();
			ResultSet rs = stmt.executeQuery("select * from student where id = " + (id));
			rs.next();
			item = new Student();
			item.setId(rs.getInt("id"));
			item.setName(rs.getString("name"));
			item.setEmail(rs.getString("email"));
			item.setGender(rs.getString("gender"));
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return "edit.xhtml";
	}
	
	public String update(Student s){  
		try {
			con = condb.connect();
			PreparedStatement stmt = condb.connect()
					.prepareStatement("update student set name=?,email=?,gender=? where id=?");
			stmt.setString(1, s.getName());
			stmt.setString(2, s.getEmail());
			stmt.setString(3, s.getGender());
			stmt.setInt(4, s.getId());
			stmt.executeUpdate();
			con.close();
		} catch (Exception e) {
			System.out.println();
		}
		return "studentRecords.xhtml";
	}
	
	public String createNewUser() {
		item = new Student();
		return "page1.xhtml";
	}
	
	public ArrayList<Student> getList() {
        return list;
    }

    public Student getItem() {
        return this.item;
    }

}
