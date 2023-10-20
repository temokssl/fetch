package main.java.utilities.Json;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JsonFileReader {
    public static JSONObject readJsonFile(String filePath) {
        JSONParser parser = new JSONParser();
        JSONObject jsonData = null;

        try {
            InputStream inputStream = JsonFileReader.class.getResourceAsStream(filePath);
            InputStreamReader reader = new InputStreamReader(inputStream);

            jsonData = (JSONObject) parser.parse(reader);

            reader.close();
            inputStream.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }

        return jsonData;
    }
}