package ejb;

import java.time.LocalDateTime;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class HelloBean {

	 public String getMessage() {
	        return "Ritik";
	    }

	    public LocalDateTime getTime() {
	        return LocalDateTime.now();
	    }
	
}
