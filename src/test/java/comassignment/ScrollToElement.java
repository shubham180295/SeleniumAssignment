package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class ScrollToElement {

    @Test
    public void scrollToElement() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        Thread.sleep(1000);

        driver.get("https://www.tutorialspoint.com/selenium/practice/horizontal-scroll.php");
        Thread.sleep(5000);
        WebElement element = driver.findElement(By.xpath("//li[@class='list-group-item active']"));
        element.click();;
        Actions ac = new Actions(driver);


        //ac.moveToElement(element,170, 0);
        ac.dragAndDropBy(element,120, 309);

//        Thread.sleep(5000);
//        driver.findElement(By.xpath("//a[text()='Search']")).click();
//        Thread.sleep(5000);
//       WebElement Element = driver.findElement(By.xpath("class='rangeslider__handle'"));

    }}
