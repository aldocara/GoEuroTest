import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


/**
 * 
 * @author Aldo
 * Reads an argument from the command line and writes the data of the city to a CSV file.
 *
 */
public class GoEuroTest {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		
		
		//Reads the command line argument
		String CITY_NAME = args[0];
		
		JSONArray json = ApiCall.JSONfromURL(CITY_NAME);
		JSONtoCSV(json);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		

	}
	
	
	/**
	 * Writes the JSON data of the city to a CSV file.
	 * 
	 * @param json - JSON array containing the data of the city
	 */
	
	public static void JSONtoCSV (JSONArray json){
		
		
		try {
			
			
			FileWriter writer = new FileWriter("locations.csv");
			
			writer.append("_id,name,type,latitude,longitude");
			writer.append('\n');
		    
			for (int i = 0; i < json.length(); i++) {
				
				
				
				
			    JSONObject location = json.getJSONObject(i);
			    writer.append(""+location.get("_id")+",");
			    writer.append(""+location.get("name")+",");
			    writer.append(""+location.get("type")+",");
			    writer.append(""+location.getJSONObject("geo_position").get("latitude")+",");
			    writer.append(""+location.getJSONObject("geo_position").get("longitude")+",");
			    writer.append('\n');
			    
			    
			    
			    
			   
			}
			writer.flush();
		    writer.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
	}
	
	
	
	
	}
	
	


