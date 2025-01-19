package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;




public class IncognitoMode {

    @Test
    public void openBrowserIncognito()
    {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver= new ChromeDriver(options);

//        WebDriverManager.firefoxdriver().setup();
//        WebDriver driver = new FirefoxDriver(options);
        driver.get("https://www.google.com/");

    }

}
