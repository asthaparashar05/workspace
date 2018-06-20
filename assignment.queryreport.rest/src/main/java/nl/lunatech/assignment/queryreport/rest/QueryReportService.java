package nl.lunatech.assignment.queryreport.rest;

/**
 * Interface defining APIs of QueryReport Service
 *
 */

public interface QueryReportService {

	public String getQueryResultForCountryName(String strCountryName);
	
	public String getQueryResultForCountryCode(String strCountryCode);
	
	public String getCountriesWithHighestNumberOfAirports();
	
	public String getCountriesWithLowestNumberOfAirports();
	
	public String getRunwayTypesForCountries();
	
	public String getMostCommonRunwayIdent();
}
