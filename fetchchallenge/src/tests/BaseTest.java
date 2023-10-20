package tests;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import main.java.configuration.ConfigData;
import main.java.configuration.TestData;
import main.java.utilities.Driver.DriverManager;
public class BaseTest {
	
	public static WebDriver driver;
	private int timeoutSeconds = TestData.timeoutSeconds;
	private Duration timeout = Duration.ofSeconds(timeoutSeconds);
	private String web_url = ConfigData.web;

    @BeforeMethod
    protected void beforeTest() {
    	driver = DriverManager.getDriver();
        driver.manage().window().maximize();
        driver.navigate().to(web_url);
        DriverManager.waitForPageToLoad(driver, timeout);
 
		
    }
    @AfterMethod
    protected void afterTest() {
    	DriverManager.closeDriver();
    }
    
}