package ejb;
//import java.util.Properties;
//
//import javax.naming.Context;
//import javax.naming.InitialContext;
//import javax.naming.NamingException;
//
//public class TestEjb {
//
//	public static void main(String[] args) throws NamingException {
//
//		Properties properties = new Properties();
//        properties.setProperty(Context.INITIAL_CONTEXT_FACTORY, 
//          "org.apache.openejb.client.LocalInitialContextFactory");
//        properties.setProperty(Context.PROVIDER_URL, "http://localhost:8081/");
//
//        Context context = new InitialContext(properties);
//
//        JsfService jsfService = (JsfService) context.lookup("JsfService");
//        
//        jsfService.sayHello("Ritik");
//	}
//
//}
