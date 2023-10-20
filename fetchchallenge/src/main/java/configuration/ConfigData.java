package main.java.configuration;
import org.json.simple.JSONObject;

import main.java.utilities.Json.*;

public class ConfigData {
	public static JSONObject configurationFile = JsonFileReader.readJsonFile("/config.json");
	public static String web = (String) configurationFile.get("web_url");
}
