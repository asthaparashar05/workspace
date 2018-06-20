package nl.lunatech.assignment.queryreport.rest.bo;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Business Object for Country
 *
 */
@XmlRootElement(name = "country")
public class Country {

	private int id;
	private String code;
	private String name;
	private String continent;
	private String wikipedia_link;
	private String keywords;
	private List<Airport> airports;
	
	
	/**
	 * @return the id
	 */
	 @XmlElement(name = "id")
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the code
	 */
	@XmlElement(name = "code")
	public String getCode() {
		return code;
	}
	/**
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}
	/**
	 * @return the name
	 */
	@XmlElement(name = "name")
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the continent
	 */
	@XmlElement(name = "continent")
	public String getContinent() {
		return continent;
	}
	/**
	 * @param continent the continent to set
	 */
	
	public void setContinent(String continent) {
		this.continent = continent;
	}
	/**
	 * @return the wikipedia_link
	 */
	@XmlElement(name = "wikipedia_link")
	public String getWikipedia_link() {
		return wikipedia_link;
	}
	/**
	 * @param wikipedia_link the wikipedia_link to set
	 */
	public void setWikipedia_link(String wikipedia_link) {
		this.wikipedia_link = wikipedia_link;
	}
	/**
	 * @return the keywords
	 */
	@XmlElement(name = "keywords")
	public String getKeywords() {
		return keywords;
	}
	/**
	 * @param keywords the keywords to set
	 */
	public void setKeywords(String keywords) {
		this.keywords = keywords;
	}
	
	/**
	 * @return the airports
	 */
	@XmlElement(name = "airports")
	public List<Airport> getAirports() {
		return airports;
	}
	/**
	 * @param airports the airports to set
	 */
	public void setAirports(List<Airport> airports) {
		this.airports = airports;
	}
	
}
