package main.java.configuration;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import main.java.utilities.Json.JsonFileReader;
import main.java.utilities.Json.JsonUtil;

public class TestData {
	
	public static JSONObject testDataFile = JsonFileReader.readJsonFile("/testdata.json");
	public static JSONArray leftGoldBarsArray = (JSONArray) testDataFile.get("leftGoldBars");
    public static JSONArray rightGoldBarsArray = (JSONArray) testDataFile.get("rightGoldBars");
    
    public static String[] leftGoldBars = JsonUtil.jsonArrayToStringArray(leftGoldBarsArray);
    public static String[] rightGoldBars = JsonUtil.jsonArrayToStringArray(rightGoldBarsArray);
    public static String successMessage = (String) testDataFile.get("successMessage");
    public static String noResult = (String) testDataFile.get("noResult");
    public static String noString = (String) testDataFile.get("noString");
    public static String failureMessage = (String) testDataFile.get("failureMessage");
    public static int timeoutSeconds = Integer.parseInt(testDataFile.get("timeoutSeconds").toString());
    public static int firstIndex = Integer.parseInt(testDataFile.get("firstIndex").toString());
    public static int numberOfSquaresToBeFilled = Integer.parseInt(testDataFile.get("numberOfSquaresToBeFilled").toString());

}