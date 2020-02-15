package be.kanea.project.bodymassindex.client;

import java.io.StringReader;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;

import javax.xml.bind.Unmarshaller;

import be.kanea.project.bodymassindex.BMIHistoric;


public class MyClient {

	public static void main(String[] args) throws JAXBException {
		Client client = ClientBuilder.newClient();
		WebTarget target;

		  JAXBContext jaxbContextBMI = JAXBContext.newInstance(BMIList.class);
		  Unmarshaller jaxbUnmarshallerBMI = jaxbContextBMI.createUnmarshaller();
		  target = client.target("http://localhost:8080/bodymassindex/webapi/bmi");
		  String xml = target.request(MediaType.APPLICATION_XML).get(String.class);
		  // from XML to BMIHistoric 
		  // from XML to BMIList (a list of BMIHistoric)
		 BMIList liste = (BMIList) jaxbUnmarshallerBMI.unmarshal( new StringReader(xml));
		 for(BMIHistoric bmi : liste.getListe()) {
			 System.out.println(bmi);
		 }
		 
	}
}
