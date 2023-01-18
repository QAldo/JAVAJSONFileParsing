package jsonproject;

//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class ReadDataFromJSON {

	public static void main(String[] args) throws IOException, ParseException {
		JSONParser jsonparser = new JSONParser();
		
		FileReader reader = new FileReader(".//jsonfile//employee.json");
		
		Object obj = jsonparser.parse(reader);
		
		JSONObject employeejsonobj = (JSONObject) obj;
		
		String fName = (String) employeejsonobj.get("firstName");
		String lName = (String) employeejsonobj.get("lastName");
		
		System.out.println("First Name: " + fName);
		System.out.println("Last Name: " + lName);
		System.out.println("--------------------------------");
		
		JSONArray array = (JSONArray) employeejsonobj.get("address");
		for (int i = 0; i<array.size();i++) {
			JSONObject address = (JSONObject) array.get(i);		// calling the whole street+city+state
			String street = (String) address.get("street");
			String city = (String) address.get("city");
			String state = (String) address.get("state");

			System.out.println("Address " + (i+1) + " is:");
			System.out.println("Street: " + street);
			System.out.println("City: " + city);
			System.out.println("State " + state);
			System.out.println("--------------------------------");
		}
	}

}
 