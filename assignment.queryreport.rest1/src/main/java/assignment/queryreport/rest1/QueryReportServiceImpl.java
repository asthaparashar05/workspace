package assignment.queryreport.rest1;

import assignment.queryreport.rest1.bo.Country;
import assignment.queryreport.rest1.bo.RunwayDTO;
import assignment.queryreport.rest1.io.QueryReportIO;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Implementation class of QueryReportService
 *
 */

@RestController
public class QueryReportServiceImpl {

	/**
     	  * Method to fetch Country details based on country name sent in the parameters. 
     	  * Handles GET request on path /query/countryName/{countryName}.
     	  *
     	  * @param strCountryName
     	  * @return List<Country>
     	  */ 
	@GetMapping("/query/countryName/{countryName}")
	public List<Country> getQueryResultForCountryName(@PathVariable("countryName") String strCountryName) {
		List<Country> countryList = null;
		try {
			countryList = QueryReportIO.getCountriesForCountryNameCode(true, strCountryName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return countryList;
	}

	/**
     	  * Method to fetch Country details based on country code sent in the parameters. 
     	  * Handles GET request on path /query/countryCode/{countryCode}.
     	  *
     	  * @param strCountryCode
     	  * @return List<Country>
     	  */
	@GetMapping("/query/countryCode/{countryCode}")
	public List<Country> getQueryResultForCountryCode(@PathVariable("countryCode") String strCountryCode) {
		List<Country> countries = null;
		try {
			countries = QueryReportIO.getCountriesForCountryNameCode(false, strCountryCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return countries;
	}

	/**
     	  * Method retrieves 10 countries with highest number of airports. 
     	  * Handles GET request on path /report/highestairports.
     	  *
     	  * @return List<Country>
     	  */ 
	@GetMapping("/report/highestairports")
	public List<Country> getCountriesWithHighestNumberOfAirports() {
		List<Country> countries = null;
		try {
			countries = QueryReportIO.getCountriesWithHighestNumberOfAirports();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return countries;
	}

	/**
     	  * Method retrieves 10 countries with lowest number of airports. 
     	  * Handles GET request on path /report/lowestairports.
     	  *
     	  * @return List<Country>
     	  */
	@GetMapping("/report/lowestairports")
	public List<Country> getCountriesWithLowestNumberOfAirports() {
		List<Country> countries = null;
		try {
			return QueryReportIO.getCountriesWithLowestNumberOfAirports();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return countries;
	}

	/**
     	  * Method retrieves runway types for all the countries. 
     	  * Handles GET request on path /report/runwaytypes.
     	  *
     	  * @return List<RunwayDTO>
     	  */
	@GetMapping("/report/runwaytypes")
	public List<RunwayDTO> getRunwayTypesForCountries() {
		Map<String, String> mapOfRTypesForCountries = null;
		try {
			mapOfRTypesForCountries = QueryReportIO.getMapOfRunwayTypesForAllCountries();
			Set<String> strings = mapOfRTypesForCountries.keySet();
			Map<String, String> finalMapOfRTypesForCountries = mapOfRTypesForCountries;
			return strings.stream().map(key -> {
				RunwayDTO runwayDTO = new RunwayDTO();
				runwayDTO.setA(key);
				runwayDTO.setB(finalMapOfRTypesForCountries.get(key));
				return runwayDTO;
			}).collect(Collectors.toList());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
     	  * Method retrieves 10 most common runway identities. 
     	  * Handles GET request on path /report/mostcommonrunway.
     	  *
     	  * @return List<String>
     	  */
	@GetMapping("/report/mostcommonrunway")
	public List<String> getMostCommonRunwayIdent() {
		List<String> runwayTypes = null;
		try {
			runwayTypes = QueryReportIO.getMostCommonRunwaysIdent();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return runwayTypes;
	}
}

