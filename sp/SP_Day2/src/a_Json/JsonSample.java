package a_Json;

import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.stream.JsonReader;

public class JsonSample {
	public static void main(String[] args) throws FileNotFoundException {
		String filePath = "sample.json";
		Gson gson = new Gson();
		JsonReader reader = new JsonReader(new FileReader(filePath));
		JsonElement je = JsonParser.parseReader(reader);

//		JsonObject jsonObj = gson.fromJson(reader, JsonObject.class);
		
//		JsonElement je = JsonParser.parseString("{ \"key\":\"value\" }");
		System.out.println(je.toString());
	}
}
