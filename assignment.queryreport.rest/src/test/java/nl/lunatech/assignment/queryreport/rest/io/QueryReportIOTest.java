package nl.lunatech.assignment.queryreport.rest.io;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import nl.lunatech.assignment.queryreport.rest.bo.Country;


public class QueryReportIOTest {
	
	@Test
	public void testGetCountriesWithHighestNumberOfAirports() {
		List<Country> countryList;
		try {
			countryList = QueryReportIO.getCountriesWithHighestNumberOfAirports();
			assertNotNull(countryList);
		} catch (IOException e) {
			fail("Caught exception");
		}		
	}

	@Test
	public void testGetCountriesWithLowestNumberOfAirports() {
		List<Country> countryList;
		try {
			countryList = QueryReportIO.getCountriesWithLowestNumberOfAirports();
			assertNotNull(countryList);
		} catch (IOException e) {
			fail("Caught exception");
		}
	}

	@Test
	public void testGetMapOfRunwayTypesForAllCountries() {
		Map<String, String> mapOfRunways;
		try {
			mapOfRunways = QueryReportIO.getMapOfRunwayTypesForAllCountries();
			assertNotNull(mapOfRunways);
		} catch (IOException e) {
			fail("Caught exception");
		}
	}

	@Test
	public void testGetCountriesForCountryNameCode() {
		List<Country> countryList;
		try {
			countryList = QueryReportIO.getCountriesForCountryNameCode(true, "United");
			assertNotNull(countryList);
		} catch (IOException e) {
			fail("Caught exception");
		}
	}

	@Test
	public void testGetMostCommonRunwaysIdent() {
		List<String> runwayList;
		try {
			runwayList = QueryReportIO.getMostCommonRunwaysIdent();
			assertNotNull(runwayList);
		} catch (IOException e) {
			fail("Caught exception");
		}
	}

}
