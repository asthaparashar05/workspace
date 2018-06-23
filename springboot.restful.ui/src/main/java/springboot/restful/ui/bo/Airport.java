package springboot.restful.ui.bo;


import java.util.List;

/**
 * Business Object for Airport
 *
 */
public class Airport {

	private int id;
	private String ident;
	private String type;
	private String name;
	private String latitude_deg;
	private String longitude_deg;
	private String elevation_ft;
	private String continent;
	private String iso_country;
	private String iso_region;
	private String municipality;
	private String scheduled_service;
	private String gps_code;
	private String iata_code;
	private String local_code;
	private String home_link;
	private String wikipedia_link;
	private String keywords;
	private List<Runway> runways;
	
	/**
	 * @return the id
	 */
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
	 * @return the ident
	 */
	public String getIdent() {
		return ident;
	}
	/**
	 * @param ident the ident to set
	 */
	public void setIdent(String ident) {
		this.ident = ident;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the name
	 */
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
	 * @return the latitude_deg
	 */
	public String getLatitude_deg() {
		return latitude_deg;
	}
	/**
	 * @param latitude_deg the latitude_deg to set
	 */
	public void setLatitude_deg(String latitude_deg) {
		this.latitude_deg = latitude_deg;
	}
	/**
	 * @return the longitude_deg
	 */
	public String getLongitude_deg() {
		return longitude_deg;
	}
	/**
	 * @param longitude_deg the longitude_deg to set
	 */
	public void setLongitude_deg(String longitude_deg) {
		this.longitude_deg = longitude_deg;
	}
	/**
	 * @return the elevation_ft
	 */
	public String getElevation_ft() {
		return elevation_ft;
	}
	/**
	 * @param elevation_ft the elevation_ft to set
	 */
	public void setElevation_ft(String elevation_ft) {
		this.elevation_ft = elevation_ft;
	}
	/**
	 * @return the continent
	 */
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
	 * @return the iso_country
	 */
	public String getIso_country() {
		return iso_country;
	}
	/**
	 * @param iso_country the iso_country to set
	 */
	public void setIso_country(String iso_country) {
		this.iso_country = iso_country;
	}
	/**
	 * @return the iso_region
	 */
	public String getIso_region() {
		return iso_region;
	}
	/**
	 * @param iso_region the iso_region to set
	 */
	public void setIso_region(String iso_region) {
		this.iso_region = iso_region;
	}
	/**
	 * @return the municipality
	 */
	public String getMunicipality() {
		return municipality;
	}
	/**
	 * @param municipality the municipality to set
	 */
	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}
	/**
	 * @return the scheduled_service
	 */
	public String getScheduled_service() {
		return scheduled_service;
	}
	/**
	 * @param scheduled_service the scheduled_service to set
	 */
	public void setScheduled_service(String scheduled_service) {
		this.scheduled_service = scheduled_service;
	}
	/**
	 * @return the gps_code
	 */
	public String getGps_code() {
		return gps_code;
	}
	/**
	 * @param gps_code the gps_code to set
	 */
	public void setGps_code(String gps_code) {
		this.gps_code = gps_code;
	}
	/**
	 * @return the iata_code
	 */
	public String getIata_code() {
		return iata_code;
	}
	/**
	 * @param iata_code the iata_code to set
	 */
	public void setIata_code(String iata_code) {
		this.iata_code = iata_code;
	}
	/**
	 * @return the local_code
	 */
	public String getLocal_code() {
		return local_code;
	}
	/**
	 * @param local_code the local_code to set
	 */
	public void setLocal_code(String local_code) {
		this.local_code = local_code;
	}
	/**
	 * @return the home_link
	 */
	public String getHome_link() {
		return home_link;
	}
	/**
	 * @param home_link the home_link to set
	 */
	public void setHome_link(String home_link) {
		this.home_link = home_link;
	}
	/**
	 * @return the wikipedia_link
	 */
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
	 * @return the runways
	 */
	public List<Runway> getRunways() {
		return runways;
	}
	/**
	 * @param runways the runways to set
	 */
	public void setRunway(List<Runway> runways) {
		this.runways = runways;
	}
	
	
	@Override
	public String toString() {
		return "Airport{" +
				"id=" + id +
				", ident='" + ident + '\'' +
				", type='" + type + '\'' +
				", name='" + name + '\'' +
				", latitude_deg='" + latitude_deg + '\'' +
				", latitude_deg='" + latitude_deg + '\'' +
				", elevation_ft='" + elevation_ft + '\'' +
				", continent='" + continent + '\'' +
				", iso_country='" + iso_country + '\'' +
				", iso_region='" + iso_region + '\'' +
				", municipality='" + municipality + '\'' +
				", scheduled_service='" + scheduled_service + '\'' +
				", gps_code='" + gps_code + '\'' +
				", iata_code='" + iata_code + '\'' +
				", local_code='" + continent + '\'' +
				", home_link='" + home_link + '\'' +
				", wikipedia_link='" + wikipedia_link + '\'' +
				", keywords='" + keywords + '\'' +
				", runways=" + runways.toString() +
				'}';
	}
}
