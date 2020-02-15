package be.kanea.project.bodymassindex.client;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.xml.bind.JAXBException;

public class OptionsClient {
	public static void main(String[] args) throws JAXBException {
		/*
		 * Selecting restfull web service options
		 */
		Client client = ClientBuilder.newClient();
		Response option = client
	            .target("http://localhost:8080/bodymassindex/webapi/bmi")
	            .request(MediaType.TEXT_PLAIN).options();
		
	    System.out.println("TEXT OPTION \n"+option.getHeaders());
	}
}
