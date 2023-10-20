package main.java.utilities;

import java.util.ArrayList;
import java.util.List;

import main.java.utilities.Logger.LoggerUtil;

public class WeighingUtil {
	
	public static List<String[]> compareWeighings(String result,String[] leftGoldBars,String[] rightGoldBars) {
    	LoggerUtil.logInfo("Comparing Weighings..");
    	int arrayLength = leftGoldBars.length;
        int midPoint = arrayLength/2;
        String[] newLeftGoldBars = new String[midPoint];
        String[] newRightGoldBars = new String[midPoint];
        List<String[]> resultArrays = new ArrayList<>();
        if(arrayLength>1) {
        	if (result.equals("<")) {
	            for (int i = 0; i < midPoint; i++) {
	                newLeftGoldBars[i] = leftGoldBars[i];
	                newRightGoldBars[i] = leftGoldBars[i + midPoint]; // Adjust the index
	                resultArrays.add(newLeftGoldBars);
	            	resultArrays.add(newRightGoldBars);
	            }
	            
	        } else if (result.equals(">")) {
	            for (int i = 0; i < midPoint; i++) {
	                newLeftGoldBars[i] = rightGoldBars[i];
	                newRightGoldBars[i] = rightGoldBars[i + midPoint]; // Adjust the index
	                resultArrays.add(newLeftGoldBars);
	            	resultArrays.add(newRightGoldBars);
	            }
	        }
       
	        else if(result.equals("=")) {
	        	String[] newArray = {"8"};
	        	resultArrays.add(newArray);
	        }
        }
        
        else {
        	if (result.equals("<")) {
	            resultArrays.add(leftGoldBars);
	        }
        	else if (result.equals(">")) {
        		resultArrays.add(rightGoldBars);
        		
	        }
        }
        return resultArrays;
    }

}