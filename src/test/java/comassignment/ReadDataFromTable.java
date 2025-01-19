package comassignment;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class ReadDataFromTable {

    String allData;
    @Test
    public void readDataFromTable() throws InterruptedException {
        WebDriverManager.chromiumdriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.get("https://demo.opencart.com/admin/index.php");
//        driver.findElement(By.name("username")).sendKeys("demo");
//        driver.findElement(By.name("password")).sendKeys("demo");
  Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        Thread.sleep(5000);
        driver.findElement(By.xpath("(//a[text()=' Customers'])[1]")).click();

        driver.findElement(By.xpath("//ul[@class='collapse show']/descendant::a[text()='Customers']")).click();
     String totalRow =driver.findElement(By.xpath("//div[contains(text(),'Showing 1 to 10 ')]")).getText();
                 int   totalPages=Integer.parseInt( totalRow.substring(totalRow.indexOf("(")+1, totalRow.indexOf("Pages")-1));
        System.out.println(totalPages);
   int totalrows=driver.findElements(By.xpath("//table[@class='table table-bordered table-hover']//tr")).size();
        for(int i=1;i<5;i++)

        {
            if(i>1)
            {
                WebElement element = driver.findElement(By.xpath("//ul[@class='pagination']//*[text()='"+i+"']"));
                ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
                Thread.sleep(5000);
                element.click();
            }

        for(int j=1;j<totalrows;j++)
        {
            Thread.sleep(5000);
       String allData=driver.findElement(By.xpath("//table[@class='table table-bordered table-hover']//tr["+j+"]/td[3]")).getText();
            System.out.println(allData +"\t");
        }



    }}
}
