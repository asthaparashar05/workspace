package nl.lunatech.assignment.queryreport.rest;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.json.JSONArray;
import org.json.JSONObject;

import nl.lunatech.assignment.queryreport.rest.bo.Airport;
import nl.lunatech.assignment.queryreport.rest.bo.Country;
import nl.lunatech.assignment.queryreport.rest.bo.Runway;
import nl.lunatech.assignment.queryreport.rest.io.QueryReportIO;
import nl.lunatech.assignment.queryreport.rest.util.Constants;

/**
 * Implementation class of QueryReportService
 *
 */

@Path("/queryreportservice")
public class QueryReportServiceImpl implements QueryReportService{

	
	
	@Override
	@GET
	@Path("/query/countryName/{countryName}")
	@Produces("application/json")
	public String getQueryResultForCountryName(@PathParam("countryName") String strCountryName) {
		List<Country> countryList=null;
		JSONArray jsonArrCountries=null;
		try {
			countryList=QueryReportIO.getCountriesForCountryNameCode(true,strCountryName);
			jsonArrCountries=getJsonObjectForCountries(countryList);
			System.out.println("jsonArrCountries: "+jsonArrCountries.toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonArrCountries.toString();
	}

	@Override
	@GET
	@Path("/query/countryCode/{countryCode}")
	@Produces("application/json")
	public String getQueryResultForCountryCode(@PathParam("countryCode") String strCountryCode) {
		List<Country> countries=null;
		JSONArray jsonArrCountries=null;
		try {
			countries=QueryReportIO.getCountriesForCountryNameCode(false,strCountryCode);
			jsonArrCountries=getJsonObjectForCountries(countries);
			System.out.println("jsonArrCountries: "+jsonArrCountries);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonArrCountries.toString();
	}
	
	@Override
	@GET
	@Path("/report/highestairports")
	@Produces("application/json")
	public String getCountriesWithHighestNumberOfAirports() {
		List<Country> countries=null;
		JSONArray jsonArrayCountries=null;
		try {
			countries=QueryReportIO.getCountriesWithHighestNumberOfAirports();
			jsonArrayCountries=new JSONArray();
			for(Country country:countries) {
				JSONObject jsonObjCountry=new JSONObject();
				jsonObjCountry.put("CountryName", country.getName());
				jsonObjCountry.put("AirportCount", country.getAirports().size());
				jsonArrayCountries.put(jsonObjCountry);
			}
			System.out.println("jsonArrayCountries: "+jsonArrayCountries);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonArrayCountries.toString();
	}
	
	@Override
	@GET
	@Path("/report/lowestairports")
	@Produces("application/json")
	public String getCountriesWithLowestNumberOfAirports() {
		List<Country> countries=null;
		JSONArray jsonArrayCountries=null;
		try {
			countries=QueryReportIO.getCountriesWithLowestNumberOfAirports();
			jsonArrayCountries=new JSONArray();
			for(Country country:countries) {
				JSONObject jsonObjCountry=new JSONObject();
				jsonObjCountry.put("CountryName", country.getName());
				jsonObjCountry.put("AirportCount", country.getAirports().size());
				jsonArrayCountries.put(jsonObjCountry);
			}
			System.out.println("jsonArrayCountries: "+jsonArrayCountries);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonArrayCountries.toString();
	}
	
	@Override
	@GET
	@Path("/report/runwaytypes")
	@Produces("application/json")
	public String getRunwayTypesForCountries() {
		Map<String, String> mapOfRTypesForCountries=null;
		JSONArray jsonArray=null;
		try {
			mapOfRTypesForCountries=QueryReportIO.getMapOfRunwayTypesForAllCountries();
			jsonArray=new JSONArray();
			for(String strCountry:mapOfRTypesForCountries.keySet()) {
				JSONObject jsonObj=new JSONObject();
				jsonObj.put("CountryName", strCountry);
				jsonObj.put("RunwayTypes", mapOfRTypesForCountries.get(strCountry));
				jsonArray.put(jsonObj);
			}
			System.out.println("jsonArrayCountries: "+jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonArray.toString();
	}
	
	@Override
	@GET
	@Path("/report/mostcommonrunway")
	@Produces("application/json")
	public String getMostCommonRunwayIdent() {
		List<String> runwayTypes=null;
		JSONArray jsonArray=null;
		try {
			runwayTypes=QueryReportIO.getMostCommonRunwaysIdent();
			jsonArray=new JSONArray();
			for(String strRunwayType:runwayTypes) {
				JSONObject jsonObj=new JSONObject();
				jsonObj.put("RunwayIdent", strRunwayType);
				jsonArray.put(jsonObj);
			}
			System.out.println("jsonArrayCountries: "+jsonArray);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return jsonArray.toString();
	}
	
	
	
	private JSONArray getJsonObjectForCountries(List<Country> countries) {
		JSONArray jsonArrayCountries=new JSONArray();
		for(Country country:countries) {
			JSONObject jsonObjCountry=new JSONObject();
			jsonObjCountry.put("CountryName", country.getName());
			JSONArray jsonArrayAirports=new JSONArray();
			if(null!=country.getAirports() && !country.getAirports().isEmpty()) {
				for(Airport airport:country.getAirports()) {
					JSONObject jsonObjAirport=new JSONObject();
					jsonObjAirport.put(Constants.AIRPORT_NAME, airport.getName());
					jsonObjAirport.put(Constants.AIRPORT_ID, airport.getId());
					jsonObjAirport.put(Constants.AIRPORT_IDENT, airport.getIdent());
					JSONArray jsonArrayRunways=new JSONArray();
					if(null!=airport.getRunways() && !airport.getRunways().isEmpty()) {
						for(Runway runway:airport.getRunways()) {
							JSONObject jsonObjRunway=new JSONObject();
							jsonObjRunway.put(Constants.RUNWAY, runway.getSurface());
							jsonArrayRunways.put(jsonObjRunway);
						}
					}
					jsonObjAirport.put(Constants.RUNWAYS, jsonArrayRunways);
					jsonArrayAirports.put(jsonObjAirport);
				}
			}				
			jsonObjCountry.put(Constants.AIRPORTS, jsonArrayAirports);
			jsonArrayCountries.put(jsonObjCountry);
		}
		return jsonArrayCountries;
	}
	
	

}
