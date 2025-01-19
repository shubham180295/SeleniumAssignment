package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;
import java.io.File;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class CaptureScreenShotOfSpecificArea {

    @Test
    public void captureScreenShot()
    {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        TakesScreenshot ts = (TakesScreenshot) driver;
        File sourceFile = ts.getScreenshotAs(OutputType.FILE);
        File f = new File("./screenshots/screenshot.png");
        sourceFile.renameTo(f);



    }
}
