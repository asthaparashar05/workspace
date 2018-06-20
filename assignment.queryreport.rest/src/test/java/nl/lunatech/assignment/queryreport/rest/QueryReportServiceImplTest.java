package nl.lunatech.assignment.queryreport.rest;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

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
		String jsonStrng=service.getQueryResultForCountryName(strCountryName);
		assertNotNull(jsonStrng);
	}

	@Test
	public void testGetQueryResultForCountryCode() {
		String strCountryCode="US";
		String jsonStrng=service.getQueryResultForCountryCode(strCountryCode);
		assertNotNull(jsonStrng);
	}

	@Test
	public void testGetCountriesWithHighestNumberOfAirports() {
		String jsonStrng=service.getCountriesWithHighestNumberOfAirports();
		assertNotNull(jsonStrng);
	}

	@Test
	public void testGetCountriesWithLowestNumberOfAirports() {
		String jsonStrng=service.getCountriesWithLowestNumberOfAirports();
		assertNotNull(jsonStrng);
	}

	@Test
	public void testGetRunwayTypesForCountries() {
		String jsonStrng=service.getRunwayTypesForCountries();
		assertNotNull(jsonStrng);
	}

	@Test
	public void testGetMostCommonRunwayIdent() {
		String jsonStrng=service.getMostCommonRunwayIdent();
		assertNotNull(jsonStrng);
	}

}
