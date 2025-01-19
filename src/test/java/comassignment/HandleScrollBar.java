package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class HandleScrollBar {

    @Test
    public void handleScrolBar() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.tutorialspoint.com/selenium/practice/slider.php");
        driver.findElement(By.xpath("//li[@class=\"list-group-item active\"]")).click();
     WebElement element =  driver.findElement(By.xpath("(//input[@type=\"range\"])[1]"));
        System.out.println(element.getLocation());
     Actions ac = new Actions(driver);
     Thread.sleep(5000);
//     ac.clickAndHold(element).moveByOffset(600,198).perform();
        ac.dragAndDropBy(element, 50,0).perform();
        System.out.println(element.getLocation());
    }
}
