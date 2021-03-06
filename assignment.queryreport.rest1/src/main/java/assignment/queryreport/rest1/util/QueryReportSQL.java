package assignment.queryreport.rest1.util;

/**
 * Utility Class with SQLs
 *
 */
public class QueryReportSQL {

	public static final String GET_COUNTRY_DETAILS_FOR_COUNTRY_NAME="SELECT C.ID, C.NAME, C.CODE, A.ID, A.NAME, A.IDENT, A.ISO_COUNTRY, R.ID, R.SURFACE, R.LENGTH_FT, " + 
			"R.WIDTH_FT, R.AIRPORT_REF, R.AIRPORT_IDENT FROM ((COUNTRY C INNER JOIN AIRPORT A ON C.CODE = A.ISO_COUNTRY) " + 
			"INNER JOIN RUNWAY R ON A.ID = R.AIRPORT_REF) WHERE UPPER(C.NAME) LIKE upper('%?%')";
	
	public static final String GET_COUNTRY_DETAILS_FOR_COUNTRY_CODE="SELECT C.ID, C.NAME, C.CODE, A.ID, A.NAME, A.IDENT, A.ISO_COUNTRY, R.ID, R.SURFACE, R.LENGTH_FT, " + 
			"R.WIDTH_FT, R.AIRPORT_REF, R.AIRPORT_IDENT FROM ((COUNTRY C INNER JOIN AIRPORT A ON C.CODE = A.ISO_COUNTRY) " + 
			"INNER JOIN RUNWAY R ON A.ID = R.AIRPORT_REF) WHERE UPPER(C.CODE) LIKE upper('%?%')";
	
	public static final String GET_COUNTRY_WITH_HIGHEST_AIRPORTS="SELECT DISTINCT(A.ISO_COUNTRY), COUNT(A.ISO_COUNTRY) FROM AIRPORT A group BY A.ISO_COUNTRY ORDER BY COUNT(A.ISO_COUNTRY) DESC"; 
	
	public static final String GET_COUNTRY_WITH_LOWEST_AIRPORTS="SELECT DISTINCT(A.ISO_COUNTRY), COUNT(A.ISO_COUNTRY) FROM AIRPORT A group BY A.ISO_COUNTRY ORDER BY COUNT(A.ISO_COUNTRY) ASC";
	
	public static final String GET_RUNWAY_TYPE_FOR_ALL_COUNTRIES="SELECT C.NAME, R.SURFACE FROM ((COUNTRY C INNER JOIN AIRPORT A ON C.CODE = A.ISO_COUNTRY) " + 
			"INNER JOIN RUNWAY R ON A.ID = R.AIRPORT_REF) GROUP BY C.NAME, R.SURFACE";
	
	public static final String GET_HIGHEST_USED_RUNWAY_IDENT="SELECT R.LE_IDENT, COUNT(R.LE_IDENT) FROM RUNWAY R GROUP BY R.LE_IDENT ORDER BY COUNT(R.LE_IDENT) DESC";
}
