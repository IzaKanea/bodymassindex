package be.kanea.project.bodymassindex.client;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlRootElement;

import be.kanea.project.bodymassindex.BMIHistoric;
/*
 * This class used to create a list of objects from a xml formatted string
 */

@XmlRootElement(name = "bMIHistorics")
@XmlAccessorType (XmlAccessType.FIELD)
public class BMIList  {
	
	@XmlElement(name = "record")
    private List<BMIHistoric> liste = null;
 
    
    public List<BMIHistoric> getListe() {
        return liste;
    }
 
    public void setBMIListe (List<BMIHistoric> liste) {
        this.liste = liste;
    }
}
