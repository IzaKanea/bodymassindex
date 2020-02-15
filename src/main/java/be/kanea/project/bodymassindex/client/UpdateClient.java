package be.kanea.project.bodymassindex.client;

import java.util.Date;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.Form;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import be.kanea.project.bodymassindex.BMIHistoric;

public class UpdateClient {
	
	public static void main(String[] args) throws JAXBException {
		/*
		 * Updating entry 5 from ("1.72","56") ("1.80","80") and "DATE" as current system date
		 * WARNING : InsertClient.java must be executed before
		 */
		Client client = ClientBuilder.newClient();
		Form form = new Form();
		form.param("id", "5");
		form.param("height", "1.80");
		form.param("weight", "80");
	    form.param("date", BMIHistoric.dateFormat.format(new Date()));
		
	    String xml = client.target("http://localhost:8080/bodymassindex/webapi/bmi/update")
	            .request(MediaType.APPLICATION_XML)
	            .put(Entity.entity(form,MediaType.APPLICATION_FORM_URLENCODED),String.class);
	    
	    System.out.println("BMI UPDATED\n"+xml);
	}
}
