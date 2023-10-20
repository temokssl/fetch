package tests;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import main.java.configuration.TestData;
import main.java.forms.GamePage;
import main.java.utilities.AlertUtil;
import main.java.utilities.WeighingUtil;
import main.java.utilities.Logger.LoggerUtil;

public class MainTest extends BaseTest{
	
	private int firstIndex = TestData.firstIndex;
	private String result;
	private String successMessage = TestData.successMessage;
	private String failureMessage = TestData.failureMessage;
	private String[] leftGoldBars = TestData.leftGoldBars;
	private String[] rightGoldBars = TestData.rightGoldBars;
	private List<String[]> goldBarsList = new ArrayList<>();
	private List<WebElement> weighingsList;
	
	@Test
	public void test(){
	    
	    GamePage gamePage = new GamePage(driver);		
		do {
			gamePage.fillSquares(leftGoldBars,rightGoldBars);
			gamePage.clickWeighButton();
			gamePage.waitUntilResultIsDisplayed();
			result = gamePage.getResult();
			gamePage.clickResetButton();
			gamePage.waitUntilGridIsReseted();
			goldBarsList = WeighingUtil.compareWeighings(result,leftGoldBars,rightGoldBars);
			if(goldBarsList.size()>1) {
				leftGoldBars = goldBarsList.get(0);
				rightGoldBars = goldBarsList.get(1);
			}
			else if(goldBarsList.size()==1) {
				leftGoldBars = goldBarsList.get(0);
			}				
		}while(goldBarsList.size()>1 && !result.equals("="));
			
		String fakeGoldBarNumber = goldBarsList.get(firstIndex)[firstIndex];
		gamePage.clickInTheFakeGoldBar(fakeGoldBarNumber);	
		AlertUtil.waitUntilAlertIsPresent();
		Assert.assertEquals(AlertUtil.getAlertText(), successMessage,failureMessage);
		AlertUtil.acceptAlert();
		weighingsList = gamePage.getWeighingsList();
		for (WebElement element : weighingsList) {
		     String text = element.getText();
		     LoggerUtil.logInfo(text);
		}
	}
}