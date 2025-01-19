package comassignment;

import genericUtility.BaseClass;
import genericUtility.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjectRepository.OrangeHRM;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

@Listeners(ExtentReportManager.class)
public class TC002_UseCase_2

{
    public static WebDriver driver;

    @Test(priority = 1)
    public void loginWithValidCredentials() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        OrangeHRM org = new OrangeHRM(driver);
             org.enterValidDataIntoExcel();
        driver.quit();

    }
    @Test(priority = 2)
    public void loginWithInValidCredentials() throws IOException, InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        OrangeHRM org = new OrangeHRM(driver);
        org.enterInValidDataIntoExcel();
        driver.quit();


    }

}