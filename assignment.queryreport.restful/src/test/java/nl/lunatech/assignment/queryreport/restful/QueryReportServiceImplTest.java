package nl.lunatech.assignment.queryreport.restful;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import nl.lunatech.assignment.queryreport.restful.bo.Country;
import nl.lunatech.assignment.queryreport.restful.bo.RunwayDTO;

public class QueryReportServiceImplTest {
	
	private QueryReportServiceImpl service;
	
	@Before
	public void getService() 
    { 
		this.service=new QueryReportServiceImpl();
    }
	
	@Test
	public void testGetQueryResultForCountryName() {
		String strCountryName="United";
		List<Country> strCountries=service.getQueryResultForCountryName(strCountryName);
		assertNotNull(strCountries);
	}

	@Test
	public void testGetQueryResultForCountryCode() {
		String strCountryCode="US";
		List<Country> strCountries=service.getQueryResultForCountryCode(strCountryCode);
		assertNotNull(strCountries);
	}

	@Test
	public void testGetCountriesWithHighestNumberOfAirports() {
		List<Country> countries=service.getCountriesWithHighestNumberOfAirports();
		assertNotNull(countries);
	}

	@Test
	public void testGetCountriesWithLowestNumberOfAirports() {
		List<Country> countries=service.getCountriesWithLowestNumberOfAirports();
		assertNotNull(countries);
	}

	@Test
	public void testGetRunwayTypesForCountries() {
		List<RunwayDTO> runways=service.getRunwayTypesForCountries();
		assertNotNull(runways);
	}

	@Test
	public void testGetMostCommonRunwayIdent() {
		List<String> runwayIdents=service.getMostCommonRunwayIdent();
		assertNotNull(runwayIdents);
	}
}
