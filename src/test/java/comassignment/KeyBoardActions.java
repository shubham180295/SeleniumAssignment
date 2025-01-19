package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.time.Duration;

public class KeyBoardActions {

    @Test
    public void keyboardActions()
    {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://text-compare.com/");

   driver.findElement(By.xpath("//textarea[@class=\"inputText\"]")).sendKeys("hdfjh");
        Actions ac = new Actions(driver);
        ac.keyDown(Keys.CONTROL).sendKeys("A").perform();
        ac.keyUp(Keys.CONTROL).perform();

        ac.keyDown(Keys.CONTROL).sendKeys("C").perform();
        ac.keyUp(Keys.CONTROL);
        ac.keyDown(Keys.TAB).keyUp(Keys.TAB).perform();
        ac.keyDown(Keys.CONTROL).sendKeys("V").keyUp(Keys.CONTROL).perform();

    }

}
