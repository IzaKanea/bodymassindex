package be.kanea.project.bodymassindex;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "record") 
@Entity
@Table(name = "BMIHistoric" ,catalog = "bmi_historic")
public class BMIHistoric {

	public static SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
	private static DecimalFormat decimalFormat = new DecimalFormat("0.00");
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Integer id;
	
	@Column(name="height")
	private Double height;
	
	@Column(name="weight")
	private Double weight;

	@Basic
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="date")
	private Date date;

	public BMIHistoric() {
		date = new Date();
	}
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	@XmlElement(name="height")
	public double getHeight() {
		return height;
	}

	public void setHeight(double height) {
		this.height = height;
	}
	@XmlElement(name="weight")
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@XmlElement(name="date")
	public String getDate() {
		return dateFormat.format(date);
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public void setDate(String date) {
		try {
			this.date = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
	
	
	@XmlElement(name="bmi")
	public Double getBmi() {
		decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
		return Double.parseDouble(decimalFormat.format(getWeight()/Math.pow(getHeight(),2)).replace(",", "."));
	}
	
	public String toString() {
		return "historic : [ ID : " + getId() + ", HEIGHT : " + getHeight()
			+ ", WEIGHT : " + getWeight() + ", BMI : " + getBmi() +  ", DATE : " + getDate() + " ]";
	}
	
	public String toHTML() {
		String ul = "<fieldset><legend>Historic "+getDate()+"</legend><ul>";
		ul+="<li> ID : "+getId()+"</li>";
		ul+="<li> HEIGHT : "+getHeight()+"</li>";
		ul+="<li> WEIGHT : "+getWeight()+"</li>";
		ul+="<li> BMI : "+getBmi()+"</li>";
		return ul + "</ul></fieldset>";
	}
}
