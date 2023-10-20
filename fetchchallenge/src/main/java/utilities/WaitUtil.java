package main.java.utilities;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitUtil {
	

	    private static WaitUtil instance;
	    private WebDriverWait wait;

	    private WaitUtil(WebDriver driver, Duration timeout) {
	        this.wait = new WebDriverWait(driver, timeout);
	    }

	    public static WaitUtil getInstance(WebDriver driver, Duration timeout) {
	        if (instance == null) {
	            instance = new WaitUtil(driver, timeout);
	        }
	        return instance;
	    }

	    public WebDriverWait getWait() {
	        return wait;
	    }
}


