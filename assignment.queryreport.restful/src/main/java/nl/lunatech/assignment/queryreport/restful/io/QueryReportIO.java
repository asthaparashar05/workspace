package nl.lunatech.assignment.queryreport.restful.io;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.io.*;

import nl.lunatech.assignment.queryreport.restful.bo.Airport;
import nl.lunatech.assignment.queryreport.restful.bo.Country;
import nl.lunatech.assignment.queryreport.restful.bo.Runway;
import nl.lunatech.assignment.queryreport.restful.util.Constants;

/**
 * Class to fetch and process data from files
 *
 */
public class QueryReportIO {

	/**
	 * Retrieves the top 10 Countries with highest number of airports.
	 *
	 * @return List<Country>
	 * @throws IOException
	 */
	public static List<Country> getCountriesWithHighestNumberOfAirports() throws IOException{
		List<Country> countries=getAllCountries();
		Collections.sort(countries, (country1, country2) -> country1.getAirports().size() - country2.getAirports().size());
		Collections.reverse(countries);
		return countries.subList(0, 10);
	}

	/**
	 * Retrieves the bottom 10 Countries with lowest number of airports.
	 * 
	 * @return List<Country>
	 * @throws IOException
	 */
	public static List<Country> getCountriesWithLowestNumberOfAirports() throws IOException{
		List<Country> countries=getAllCountries();
		Collections.sort(countries, (country1, country2) -> country1.getAirports().size() - country2.getAirports().size());
		return countries.subList(0, 10);
	}

	/**
	 * Returns map of containing country name and runway type.
	 * 
	 * @return Map<String,String>
	 * @throws IOException
	 */
	public static Map<String,String> getMapOfRunwayTypesForAllCountries() throws IOException{
		Map<String,String> mapCountryRunwayTypes=new HashMap<>();
		List<Country> countries=getAllCountries();
		countries.forEach(country -> {
			Set<String> runwayTypeSet = new HashSet<>();
			country.getAirports().forEach(airport -> {
				airport.getRunways()
						.forEach(runway -> runwayTypeSet.add(runway.getSurface()));
			});
			String strRunwayTypes= runwayTypeSet.stream()
					.map(String::toString)
					.collect(Collectors.joining (", "));
			mapCountryRunwayTypes.put(country.getName(), strRunwayTypes);
		});
		return mapCountryRunwayTypes;
	}


	/**
	 * Retrieves list of countries based on country name or code.
	 *
	 * @param isCountryName
	 * @param strValue
	 * @return List<Country>
	 * @throws IOException
	 */
	public static List<Country> getCountriesForCountryNameCode(boolean isCountryName, String strValue) throws IOException{
		List<Country> countries=new ArrayList<>();		
		List<Country> allCountries=getAllCountries();
		System.out.println("strValue: "+strValue);
		if(isCountryName) {
			countries=allCountries.stream().filter(country -> country.getName().toUpperCase().contains(strValue.toUpperCase())).collect(Collectors.toList());
		}else {
			countries=allCountries.stream().filter(country -> country.getCode().toUpperCase().contains(strValue.toUpperCase())).collect(Collectors.toList());
		}
		return countries;
	}

	/**
	 * Retrieves top ten most common runway ident.
	 *
	 * @return List<String>
	 * @throws IOException
	 */
	public static List<String> getMostCommonRunwaysIdent() throws IOException{
		String strLine=null;
		File file = null;
		BufferedReader bReaderRunway = null;
		ClassLoader classLoader=null;
		Map<String,Integer> mapOfRunways=new HashMap<>();
		List<String> sortedList = new LinkedList<>();
		try {
			classLoader=QueryReportIO.class.getClassLoader();		
			file = new File(classLoader.getResource(Constants.RUNWAYS_CVS).getFile());
			bReaderRunway = new BufferedReader(new FileReader(file));		 
			bReaderRunway.readLine(); //To skip the first line
			while ((strLine = bReaderRunway.readLine()) != null) {
				if(null!=strLine && !strLine.isEmpty()) {
					
					String[] arrRunway=strLine.split(",");
					if(null!=arrRunway && arrRunway.length==20) {
						if(mapOfRunways.containsKey(arrRunway[8])) {
							int iCount=mapOfRunways.get(arrRunway[8])+1;
							mapOfRunways.put(arrRunway[8], iCount);
						}
						else {
							mapOfRunways.put(arrRunway[8], 1);
						}
					}
				}
			}			

			mapOfRunways.entrySet().stream()
			.sorted(Map.Entry.<String, Integer>comparingByValue())
			.forEachOrdered(x -> sortedList.add(x.getKey()));
			Collections.reverse(sortedList);
		}
		finally {
			bReaderRunway.close();
		}

		return sortedList.subList(0, 10);
	}

	/**
	 * Retrieves all the counties.
	 *
	 * @return List<Country>
	 * @throws IOException
	 */
	private static List<Country> getAllCountries() throws IOException{
		String strLine=null;
		File file = null;
		BufferedReader bReaderCountry = null;
		ClassLoader classLoader=null;
		List<Country> countries=new ArrayList<>();
		Map<String,List<Airport>> mapOfAirports=null;
		Map<String,List<Runway>> mapOfRunways=null;

		try {
			mapOfRunways=getRunwayData();
			mapOfAirports=getAirportData(mapOfRunways);
			classLoader=QueryReportIO.class.getClassLoader();
			file = new File(classLoader.getResource(Constants.COUNTRIES_CVS).getFile());
			bReaderCountry = new BufferedReader(new FileReader(file));
			bReaderCountry.readLine(); //To skip the first line
			while ((strLine = bReaderCountry.readLine()) != null) {
				if(null!=strLine && !strLine.isEmpty()) {
					String[] arrCountry=strLine.split(",");
					Country country=new Country();
					country.setId(Integer.parseInt(arrCountry[0]));
					country.setCode(arrCountry[1]);
					country.setName(arrCountry[2]);
					country.setContinent(arrCountry[3]);
					country.setWikipedia_link(arrCountry[4]);
					country.setKeywords(arrCountry[5].trim());
					if(null==mapOfAirports.get(country.getCode())) {
						country.setAirports(new ArrayList<>());
					}else {
						country.setAirports(mapOfAirports.get(country.getCode()));
					}
					countries.add(country);
				}
			}
		}
		finally{
			bReaderCountry.close();
		}
		return countries;
	}

	/**
	 * Retrieves map of all the runways with airport ident as key.
	 *
	 * @return Map<String,List<Runway>>
	 * @throws IOException
	 */
	private static Map<String,List<Runway>> getRunwayData() throws IOException{
		String strLine=null;
		File file = null;
		BufferedReader bReaderRunway = null;
		ClassLoader classLoader=null;
		Map<String,List<Runway>> mapOfRunways=new HashMap<>();

		try {
			classLoader=QueryReportIO.class.getClassLoader();		
			file = new File(classLoader.getResource(Constants.RUNWAYS_CVS).getFile());
			bReaderRunway = new BufferedReader(new FileReader(file));		 
			bReaderRunway.readLine(); //To skip the first line
			while ((strLine = bReaderRunway.readLine()) != null) {
				if(null!=strLine && !strLine.isEmpty()) {
					String[] arrRunway=strLine.split(",");
					if(null!=arrRunway && arrRunway.length==20) {
						Runway runway=new Runway();
						runway.setId(Integer.parseInt(arrRunway[0]));
						runway.setAirport_ref(arrRunway[1]);
						runway.setAirport_ident(arrRunway[2]);
						runway.setLength_ft(arrRunway[3]);
						runway.setWidth_ft(arrRunway[4]);
						runway.setSurface(arrRunway[5]);
						runway.setLighted(arrRunway[6]);
						runway.setClosed(arrRunway[7]);
						runway.setLe_ident(arrRunway[8]);
						runway.setLe_latitude_deg(arrRunway[9]);
						runway.setLe_longitude_deg(arrRunway[10]);
						runway.setLe_elevation_ft(arrRunway[11]);
						runway.setLe_heading_degT(arrRunway[12]);
						runway.setLe_displaced_threshold_ft(arrRunway[13]);
						runway.setHe_ident(arrRunway[14]);
						runway.setHe_latitude_deg(arrRunway[15]);
						runway.setHe_longitude_deg(arrRunway[16]);
						runway.setHe_elevation_ft(arrRunway[17]);
						runway.setHe_heading_degT(arrRunway[18]);
						runway.setHe_displaced_threshold_ft(arrRunway[19]);

						if(null==mapOfRunways.get(arrRunway[2])) {
							List<Runway> runwayList=new ArrayList<Runway>();
							runwayList.add(runway);
							mapOfRunways.put(arrRunway[2], runwayList);
						}else {
							mapOfRunways.get(arrRunway[2]).add(runway);
						}
					}
				}
			}
		}
		finally {
			bReaderRunway.close();
		}
		return mapOfRunways;
	}

	/**
	 * Retrieves map of all the airports with country code as key.
	 *
	 * @return Map<String,List<Airport>>
	 * @throws IOException
	 */
	private static Map<String,List<Airport>> getAirportData(Map<String,List<Runway>> mapOfRunways) throws IOException {
		String strLine=null;
		File file = null;
		BufferedReader bReaderAirport = null;
		ClassLoader classLoader=null;
		Map<String,List<Airport>> mapOfAirports=new HashMap<>();

		try {
			classLoader=QueryReportIO.class.getClassLoader();
			file = new File(classLoader.getResource(Constants.AIRPORTS_CSV).getFile());
			bReaderAirport = new BufferedReader(new FileReader(file));
			bReaderAirport.readLine(); //To skip the first line
			while ((strLine = bReaderAirport.readLine()) != null) {
				if(null!=strLine && !strLine.isEmpty()) {
					String[] arrAirport=strLine.split(",");
					if(null!=arrAirport && arrAirport.length==18) {
						Airport airport=new Airport();
						airport.setId(Integer.parseInt(arrAirport[0]));
						airport.setIdent(arrAirport[1]);
						airport.setType(arrAirport[2]);
						airport.setName(arrAirport[3]);
						airport.setLatitude_deg(arrAirport[4]);
						airport.setLongitude_deg(arrAirport[5]);
						airport.setElevation_ft(arrAirport[6]);
						airport.setContinent(arrAirport[7]);
						airport.setIso_country(arrAirport[8]);
						airport.setIso_region(arrAirport[9]);
						airport.setMunicipality(arrAirport[10]);
						airport.setScheduled_service(arrAirport[11]);
						airport.setGps_code(arrAirport[12]);
						airport.setIata_code(arrAirport[13]);
						airport.setLocal_code(arrAirport[14]);
						airport.setHome_link(arrAirport[15]);
						airport.setWikipedia_link(arrAirport[16]);
						airport.setKeywords(arrAirport[17]);

						if(null==mapOfRunways.get(arrAirport[1])) {
							airport.setRunway(new ArrayList<>());
						}else {
							airport.setRunway(mapOfRunways.get(arrAirport[1]));
						}						

						if(null==mapOfAirports.get(arrAirport[8])) {
							List<Airport> airportList=new ArrayList<Airport>();
							airportList.add(airport);
							mapOfAirports.put(arrAirport[8], airportList);
						}else {
							mapOfAirports.get(arrAirport[8]).add(airport);
						}
					}
				}
			}

		}
		finally {
			bReaderAirport.close();
		}

		return mapOfAirports;
	}
}
