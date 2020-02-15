package be.kanea.project.bodymassindex;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.OPTIONS;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.google.gson.Gson;;

@Path("bmi")
public class BMIResource {
	
	@OPTIONS
	@Produces(MediaType.TEXT_PLAIN)
	public Response getSupportedOperations(){
		return Response.status(200)
		        .header("Allow","POST, PUT, GET, DELETE, OPTIONS")
		        .build();
	}
	
	@GET
	@Path("{id}")
    @Produces(MediaType.APPLICATION_XML)
	public Response getList(@PathParam("id") Integer id) {
		
		BMIHistoricDAO bmiHistoricDAO = new BMIHistoricDAO();

		BMIHistoric bmi = bmiHistoricDAO.selectById(id);
        
        GenericEntity<BMIHistoric> entity = new GenericEntity<BMIHistoric>(bmi) {};
        return Response.ok(entity).build();
    }
	
	
	
	@GET
    @Produces(MediaType.APPLICATION_XML)
	public Response getListXML() {
		
		BMIHistoricDAO bmiHistoricDAO = new BMIHistoricDAO();

        List <BMIHistoric> liste = bmiHistoricDAO.selectAll();
        
        GenericEntity<List<BMIHistoric>> entities = new GenericEntity<List<BMIHistoric>>(liste){};
        return Response.ok(entities).build();
    }
	
	@GET
    @Produces(MediaType.APPLICATION_JSON)
	public String getListJSON() {
		BMIHistoricDAO bmiHistoricDAO = new BMIHistoricDAO();
        List <BMIHistoric> liste = bmiHistoricDAO.selectAll();
        return new Gson().toJson(liste);
    }

	@GET
    @Produces(MediaType.TEXT_PLAIN)
	public String getListTEXT() {
		BMIHistoricDAO bmiHistoricDAO = new BMIHistoricDAO();
        List <BMIHistoric> liste = bmiHistoricDAO.selectAll();
        String text ="";
		for (BMIHistoric historic : liste) {
			text += historic.toString() + "\n";
		}
        return text;
    }

	@GET
    @Produces(MediaType.TEXT_HTML)
	public String getListHTML() {
		BMIHistoricDAO bmiHistoricDAO = new BMIHistoricDAO();
        List <BMIHistoric> liste = bmiHistoricDAO.selectAll();
        String text ="";
		for (BMIHistoric historic : liste) {
			text += historic.toHTML() + "\n";
		}
        return "<html><head><title>Body Mass Index calculator</title></head><h1>Body Mass Index calculator</h1><body>"+text+"</body></html>";
    }
	
	
	@DELETE
	@Path("/delete/{id}")
	@Produces(MediaType.TEXT_PLAIN)
	public String deleteBMI(@PathParam("id") Integer id){
		BMIHistoricDAO bmiHistoricDAO = new BMIHistoricDAO();
		bmiHistoricDAO.delete(id);
		
        return getListTEXT();
	}
	
	
	@POST
	@Path("/insert")
	@Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response InsertBMI(@FormParam("height") Double height, @FormParam("weight") Double weight,
			@Context HttpServletResponse servletResponse) throws IOException{
		BMIHistoricDAO bmiHistoricDAO = new BMIHistoricDAO();
		BMIHistoric bmi =  new BMIHistoric();
		bmi.setHeight(height);
		bmi.setWeight(weight);
		
		int id = bmiHistoricDAO.insert(bmi);
		GenericEntity<BMIHistoric> entity = new GenericEntity<BMIHistoric>(bmiHistoricDAO.selectById(id)){};
        return Response.ok(entity).build();
	      
	}
	
	
	@PUT
	@Path("/update")
    @Produces(MediaType.APPLICATION_XML)
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	public Response updateBMI(@FormParam("id") Integer id,
			@FormParam("height") Double height,@FormParam("weight") Double weight,@FormParam("date") String date,
			@Context HttpServletResponse servletResponse) throws IOException{
		
		BMIHistoricDAO bmiHistoricDAO = new BMIHistoricDAO();

        BMIHistoric bmi = new BMIHistoric();
        bmi.setId(id);
        bmi.setHeight(height);
        bmi.setWeight(weight);
        bmi.setDate(date);
        
        bmiHistoricDAO.update(bmi);
        
        GenericEntity<BMIHistoric> entity = new GenericEntity<BMIHistoric>(bmiHistoricDAO.selectById(id)){};
        return Response.ok(entity).build();
    }
}
