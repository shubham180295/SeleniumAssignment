package genericUtility;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	public static WebDriver  driver;
	FileInput f = new FileInput();

	@BeforeClass
	public void configBrowser() throws IOException {
		
         // Open the Browser
		String Browser = f.fileinputMethod("Browser");
		if(Browser.equalsIgnoreCase("chrome")) {
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		}
		else {
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
		}
		String url = f.fileinputMethod("url");
		driver.get(url);

	}
	@AfterClass
	public void closeBrowser() {
    // close all the child browser
		// driver.quit();
	}

}




