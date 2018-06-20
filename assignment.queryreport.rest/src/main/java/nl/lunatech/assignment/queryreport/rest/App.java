package nl.lunatech.assignment.queryreport.rest;

/**
 * main method call
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Application main!" );
        QueryReportService queryReportService=new QueryReportServiceImpl();
		String countries = queryReportService.getQueryResultForCountryName("United");
		System.out.println("Country: "+countries);		
    }
}