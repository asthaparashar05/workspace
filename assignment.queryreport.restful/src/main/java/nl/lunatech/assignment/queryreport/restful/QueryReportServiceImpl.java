package nl.lunatech.assignment.queryreport.restful;

import nl.lunatech.assignment.queryreport.restful.bo.Country;
import nl.lunatech.assignment.queryreport.restful.bo.RunwayDTO;
import nl.lunatech.assignment.queryreport.restful.io.QueryReportIO;
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

	@GetMapping("/query/countryName/{countryName}")
	public List<Country> getQueryResultForCountryName(@PathVariable("countryName") String strCountryName) {
		List<Country> countryList = null;
		try {
			System.out.println("strCountryName: "+strCountryName);
			countryList = QueryReportIO.getCountriesForCountryNameCode(true, strCountryName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return countryList;
	}

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

