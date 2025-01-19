package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AlertHandle {

    @Test
    public void handleAlert()
    {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.get("https://testautomationpractice.blogspot.com/");
        driver.findElement(By.id("alertBtn")).click();
     Alert as =driver.switchTo().alert();

        as.accept();

        // //*[@class="svg-container"]//*[name()='svg']
    }
}
