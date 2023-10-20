package main.java.forms;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.configuration.TestData;
import main.java.utilities.WaitUtil;
import main.java.utilities.Logger.LoggerUtil;

public class GamePage {
	
    private WebDriver driver;
    private WebDriverWait wait;
    private WaitUtil waitSingleton;
	private WebElement[] leftSquares;
    private WebElement[] rightSquares;
    private WebElement weighButton;
    private WebElement resetButton;
    private WebElement resultElement;
    private WebElement fakeGoldBarElement;
    private WebElement parentWeighingsElement;
    private List<WebElement> weighingsList;
    private int numberOfSquaresToBeFilled;
    private int firstLeftSquare;
    private int firstRightSquare;
    private int timeoutSeconds = TestData.timeoutSeconds;
	private Duration timeout = Duration.ofSeconds(timeoutSeconds);
    private String noResult;
    private String noString;

    public GamePage(WebDriver driver) {
        this.driver = driver;
        waitSingleton = WaitUtil.getInstance(driver, timeout);
        this.wait = waitSingleton.getWait();
        initializeElements();
    }
    
    private void initializeElements() {
    	LoggerUtil.logInfo("Initializing elements..");
    	firstLeftSquare = TestData.firstIndex;
    	noResult = TestData.noResult;
    	firstRightSquare = TestData.firstIndex;
    	noString = TestData.noString;
    	numberOfSquaresToBeFilled = TestData.numberOfSquaresToBeFilled;
        leftSquares = new WebElement[numberOfSquaresToBeFilled];
        rightSquares = new WebElement[numberOfSquaresToBeFilled];
        for (int i = 0; i < numberOfSquaresToBeFilled; i++) {
        	leftSquares[i] = driver.findElement(By.xpath("//input[@id='left_" + i + "']"));
            rightSquares[i] = driver.findElement(By.xpath("//input[@id='right_" + i + "']"));
        }
        resetButton = driver.findElement(By.xpath("//div[4]//button[1]"));
        weighButton = driver.findElement(By.xpath("//button[@id='weigh']"));
        resultElement = driver.findElement(By.xpath("//div[@class='result']//button[@id='reset']"));
        parentWeighingsElement = driver.findElement(By.xpath("//div[@class='game-info']"));
        weighingsList = parentWeighingsElement.findElements(By.xpath("./*"));
    }
    
    public void fillSquares(String[] leftGoldBars,String[] rightGoldBars) {
    	LoggerUtil.logInfo("Filling squares..");
    	for (int i = 0; i < leftGoldBars.length; i++) {
        	leftSquares[i].clear();
        	leftSquares[i].sendKeys(leftGoldBars[i]);
        	rightSquares[i].clear();
        	rightSquares[i].sendKeys(rightGoldBars[i]);
        }
    }
    
    public void clickWeighButton() {
    	LoggerUtil.logInfo("Clicking Weigh Button..");
    	weighButton.click(); 	
    }
    
    public void clickResetButton() {
    	LoggerUtil.logInfo("Clicking Reset Button..");
    	resetButton.click();
    }
    
    public void waitUntilGridIsReseted() {
    	wait.until(ExpectedConditions.and(
    			ExpectedConditions.textToBePresentInElement(leftSquares[firstLeftSquare],noString),
    			ExpectedConditions.textToBePresentInElement(rightSquares[firstRightSquare],noString)
    		));
    }
    
    public String getResult() {
    	LoggerUtil.logInfo("Getting comparison result..");
    	return resultElement.getText();
    } 
    
    public void waitUntilResultIsDisplayed() {
        wait.until(ExpectedConditions.not(ExpectedConditions.textToBePresentInElement(resultElement, noResult)));
    }

    
    public void clickInTheFakeGoldBar(String fakeGoldBarNumber) {
    	LoggerUtil.logInfo("It looks like the fake bar is the number: "+fakeGoldBarNumber);
    	LoggerUtil.logInfo("Clicking the gold bar number: "+fakeGoldBarNumber+"..");
    	fakeGoldBarElement = driver.findElement(By.xpath("//button[@id='coin_" + fakeGoldBarNumber + "']"));
    	fakeGoldBarElement.click();
    }
    
    public List<WebElement> getWeighingsList() {
    	LoggerUtil.logInfo("Getting Weighings List..");
        return weighingsList;
    }
 
}