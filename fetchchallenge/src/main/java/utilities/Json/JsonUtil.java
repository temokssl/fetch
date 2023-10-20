package main.java.utilities.Json;

import org.json.simple.JSONArray;

public class JsonUtil {
	public static String[] jsonArrayToStringArray(JSONArray jsonArray) {
        String[] result = new String[jsonArray.size()];
        for (int i = 0; i < jsonArray.size(); i++) {
            result[i] = (String) jsonArray.get(i);
        }
        return result;
    }
}