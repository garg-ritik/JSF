package ejb;
import java.util.ArrayList;

import javax.ejb.Local;

@Local
public interface JsfServiceRemote {
	
	void add();
	
	void resetAdd();
	
	ArrayList<Student> getRecords();
	
	void delete(int id);
	
	String edit(int id);
	
	String update(Student s);
	
	String createNewUser();
}
