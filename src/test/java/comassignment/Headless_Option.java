package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;



public class Headless_Option {

    @Test
    public void openTheBrowser()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless=true");


//
//        FirefoxOptions options=new FirefoxOptions();
//        options.addArguments("--headless=new");

//        EdgeOptions options = new EdgeOptions();
//        options.


        WebDriverManager.chromiumdriver().setup();
        WebDriver driver= new ChromeDriver(options);

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.google.com/");



    }

}
