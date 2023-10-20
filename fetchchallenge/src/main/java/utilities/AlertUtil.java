package main.java.utilities;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import main.java.configuration.TestData;
import tests.BaseTest;

public class AlertUtil {
	
	private static int timeoutSeconds = TestData.timeoutSeconds;
	private static Duration timeout = Duration.ofSeconds(timeoutSeconds);
	private static WaitUtil waitSingleton = WaitUtil.getInstance(BaseTest.driver, timeout);
	private static WebDriverWait wait = waitSingleton.getWait();
	private static Alert alert = BaseTest.driver.switchTo().alert();
	
	public static String getAlertText() {
		return alert.getText();
	}
	
	public static void acceptAlert() {
		alert.accept();

	}
	
	public static void waitUntilAlertIsPresent() {
    	wait.until(ExpectedConditions.alertIsPresent());

	}
	
}
