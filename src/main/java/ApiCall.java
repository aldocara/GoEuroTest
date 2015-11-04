import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;


/**
 * @author Aldo
 * Handles API calls and JSON parsing.
 */


public class ApiCall {
	
	private final static String URL = "http://api.goeuro.com/api/v2/position/suggest/en/";





	/**
	 * 
	 * @param rd
	 * @return JSON data as a String
	 * @throws IOException if there is an IO error when calling the API.
	 */
	private static String readURL(Reader rd) throws IOException {
		
	    StringBuilder sb = new StringBuilder();
	    int cp;
	    while ((cp = rd.read()) != -1) {
	      sb.append((char) cp);
	    }
	    return sb.toString();
	  }
	
	
	/**
	 *  Calls the API for the given city and returns a JSON Array.
	 * 
	 * @param CITY_NAME - Name of the city to call the API with.
	 * @return JSONArray.
	 * @throws java.io.IOException if the call fails because of an IO error.
	 * @throws JSONException if there is a problem with the JSON API.
	 * 
	 */
	public static JSONArray JSONfromURL (String CITY_NAME) throws IOException, JSONException {
		
		InputStream is = new URL(URL+CITY_NAME).openStream();
		
		try {
		      BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
		      String jsonText = readURL(rd);
		      JSONArray json = new JSONArray(jsonText);
		      return json;
		    } finally {
		      is.close();
		    }
	}


}
