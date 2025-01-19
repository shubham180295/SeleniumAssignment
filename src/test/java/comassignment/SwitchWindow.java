package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class SwitchWindow {

    @Test
    public void switchToWindow() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.google.com/");
        String parent =driver.getWindowHandle();
        driver.findElement(By.name("q")).sendKeys("gmail"+ Keys.ENTER);

        Thread.sleep(5000);
       WebElement link=driver.findElement(By.xpath("//h3[text()='Gmail - Google']"));
       Actions a = new Actions(driver);
        a.keyDown(Keys.CONTROL).click(link).keyUp(Keys.CONTROL).perform();
        Set<String> allId=driver.getWindowHandles();

        for( String id:allId)
        {
            if(!id.equals(parent))
            {
                driver.switchTo().window(id);
                break;



            }


        }


        WebElement element=driver.findElement(By.xpath("(//span[contains(text(),'Gmail')])[2]"));
        Assert.assertTrue(element.isDisplayed());
        driver.switchTo().window(parent);
        

//        ArrayList<String> as = new ArrayList<>(allId);
//        String ParentWindow= as.get(0);
//          String  ChildWindow= as.get(1);
//          driver.switchTo().window(ParentWindow);
//          WebElement element=driver.findElement(By.xpath("(//span[contains(text(),'Gmail')])[2]"));
//          Assert.assertTrue(element.isDisplayed());
//        driver.switchTo().window(ChildWindow);
//        Thread.sleep(5000);
//        driver.close();


          }


      }





