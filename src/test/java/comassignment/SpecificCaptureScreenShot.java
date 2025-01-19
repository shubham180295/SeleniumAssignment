package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;

public class SpecificCaptureScreenShot {

    @Test
    public void caputureScreenShotOfSpecific()
    {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com/");
      WebElement element =driver.findElement(By.xpath("//img[@alt='Google']"));
      File element1=element.getScreenshotAs(OutputType.FILE);
      File f = new File("./screenshot/first.png");
      element1.renameTo(f);

    }
}
