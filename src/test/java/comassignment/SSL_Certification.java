package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

public class SSL_Certification {

    @Test
    public void browserOpen()
    {

        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true);
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver= new ChromeDriver(options);
    }

}
