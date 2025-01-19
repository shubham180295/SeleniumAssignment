package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.io.File;

public class EnableExtensions {

    @Test
    public void enableExtension()
    {
        ChromeOptions options = new ChromeOptions();
        File f = new File("C:\\CRXFILES\\SelectorsHub-XPath-Helper-Chrome-Web-Store.crx");
        options.addExtensions(f);
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver= new ChromeDriver(options);
        driver.get("https://www.google.com/");

    }
}
