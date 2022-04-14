package ejb;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponentBase;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;

@FacesComponent(createTag = true, tagName = "helloComponent", namespace = "http://ritikgarg.com/customcomponent" )
public class HelloComponent extends UIComponentBase{

	@Override
	public String getFamily() {
		return "hello";
	}
	
	@Override
	public void encodeBegin(FacesContext context) throws IOException {

		String message = (String) getAttributes().get("message");
        LocalDateTime time = (LocalDateTime) getAttributes().get("time");
        String formattedTime = time.format(
                DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM));

        ResponseWriter writer = context.getResponseWriter();
        writer.startElement("h1", this);
        writer.write("Hello: " + message);
        writer.endElement("h1");

        writer.startElement("p", this);
        writer.write("Time: " + formattedTime);
        writer.endElement("p");
	}

}
