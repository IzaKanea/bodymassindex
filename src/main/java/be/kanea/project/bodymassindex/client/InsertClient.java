package be.kanea.project.bodymassindex.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

public class InsertClient {

	static Client client = ClientBuilder.newClient();
	static String xml;
	public static void main(String[] args) throws JAXBException {
		/*
		 * CREATING 10 NEW ENTRIES
		 * 
		 * 1. We create a form with heigt and weight and send it to the server with post method
		 * 2. Server insert these new data and add an id and insertion date
		 * 3. Next, it select them from database and send them back to the client
		 * 4. Finally client display these data
		 * 
		 */
		doit("1.59","49");
		doit("1.61","50");
		doit("1.65","73");
		doit("1.68","56");
		doit("1.72","56");
		doit("1.75","69");
		doit("1.81","98");
		doit("1.87","84");
		doit("1.92","114");
		doit("1.95","112");
	}
	
	private static void doit(String height,String weigth) {
		Form form = new Form();
		form.param("height", height);
		form.param("weight", weigth);
		
	    xml = client.target("http://localhost:8080/bodymassindex/webapi/bmi/insert")
	            .request(MediaType.APPLICATION_XML)
	            .post(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),String.class);
	    
	    System.out.println(xml);
	}
}
