package be.kanea.project.bodymassindex.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

public class SelectClient {
	
	public static void main(String[] args) throws JAXBException {
		/*
		 * Select and display all BMI entries on database.
		 * 
		 * OUTPUT TYPE : JSON, XML, HTML, PLAIN-TEXT
		 * 
		 * Next Select By id entry 1 using the path
		 */

		Client client = ClientBuilder.newClient();
		WebTarget target = client.target("http://localhost:8080/bodymassindex/webapi/bmi");
		String json = target.request(MediaType.APPLICATION_JSON).get(String.class);
		String xml = target.request(MediaType.APPLICATION_XML).get(String.class);
		String html = target.request(MediaType.TEXT_HTML).get(String.class);
		String text = target.request(MediaType.TEXT_PLAIN).get(String.class);

		System.out.println("JSON\n"+json+"\n");
		System.out.println("XML\n"+xml+"\n");
		System.out.println("HTML\n"+html+"\n");
		System.out.println("TEXT PLAIN\n"+text+"\n");
		
		target = client.target("http://localhost:8080/bodymassindex/webapi/bmi/1");
	    xml = target.request(MediaType.APPLICATION_XML).get(String.class);
	    
	    System.out.println("XML by id \n"+xml);
	    
	    /* 
		 * These code is about create your own object from a xml formatted string
		 * // try and catch block or throws is required
		 *  throws JAXBException
		 *  
		 * // IMPORT
		 * import java.io.StringReader;
		 * import javax.ws.rs.client.Client;
		 * import javax.ws.rs.client.ClientBuilder;
		 * import javax.ws.rs.client.WebTarget;
		 * import javax.ws.rs.core.MediaType;
		 * import javax.xml.bind.JAXBContext;
		 * import javax.xml.bind.JAXBException;
		 * import javax.xml.bind.Unmarshaller;
		 * 
		 * 
		 * // from XML to a BMIHistoric 
		 * Client client = ClientBuilder.newClient();
		 * JAXBContext jaxbContextBMI = JAXBContext.newInstance(BMIList.class);
		 * Unmarshaller jaxbUnmarshallerBMI = jaxbContextBMI.createUnmarshaller();
		 * WebTarget target = client.target("http://localhost:8080/bodymassindex/webapi/bmi/1");
		 * String xml = target.request(MediaType.APPLICATION_XML).get(String.class);
		 * BMIHistoric bmi = (BMIHistoric) jaxbUnmarshallerBMI.unmarshal( new StringReader(xml));
		 * System.out.println(bmi);
		 * 
		 * 
		 * // from XML to BMIList (a list of BMIHistoric)  
		 * //Class BMIList is required
		 * Client client = ClientBuilder.newClient();
		 * WebTarget target;
		 * JAXBContext jaxbContextBMI = JAXBContext.newInstance(BMIList.class);
		 * Unmarshaller jaxbUnmarshallerBMI = jaxbContextBMI.createUnmarshaller();
		 * target = client.target("http://localhost:8080/bodymassindex/webapi/bmi");
		 * String xml = target.request(MediaType.APPLICATION_XML).get(String.class);
		 * BMIList liste = (BMIList) jaxbUnmarshallerBMI.unmarshal( new StringReader(xml));
		 * for(BMIHistoric bmi : liste.getListe()) {
		 *	 System.out.println(bmi);
		 * }
		 * */
	}
	
}
