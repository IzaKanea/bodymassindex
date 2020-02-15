package be.kanea.project.bodymassindex.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;


public class DeleteClient {
	public static void main(String[] args) throws JAXBException {
		/*
		 * Deleting entry 9
		 * WARNING : InsertClient.java must be executed before
		 */
		Client client = ClientBuilder.newClient();
		
	    String text = client
	            .target("http://localhost:8080/bodymassindex/webapi/bmi/delete")
	            .path("/{id}")
	            .resolveTemplate("id", 9)
	            .request(MediaType.TEXT_PLAIN)
	            .delete(String.class);
	    
	    System.out.println("TEXT Delete \n"+text);
	}
}
