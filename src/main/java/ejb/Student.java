package ejb;
import java.io.Serializable;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class Student implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private int id;
	
	private String name;
	
	private String email;

	private String gender;
	
	public Student() {}
	public Student(int id, String name, String email, String gender) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	/*
	 * @Override public Student clone() { return new Student(id, name,email,gender);
	 * }
	 */

//	public void restore(Student student) {
//		this.id = student.getId();
//		this.name = student.getName();
//		this.email = student.getEmail();
//		this.gender = student.getGender();
//	}
	
}
