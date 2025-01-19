package comassignment;

import genericUtility.ExcelUtility;
import genericUtility.ExtentReportManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjectRepository.ErailHomePage;
import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Listeners(ExtentReportManager.class)
public class TC001_UseCase_1  {

	public static WebDriver driver;

	@Test
	public void booking() throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		driver=new ChromeDriver();
		driver.get("https://erail.in/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		String path = "./data.xlsx";
		ExcelUtility excelUtility = new ExcelUtility(path);
		ErailHomePage er = new  ErailHomePage(driver);
		er.clearField();
		er.enterField();
		er.printFourthPositionElement();
		excelUtility.writeExpectedStationIntoExcel();
		List<WebElement> allData =er.getDropDownStation();
		int rowSize=allData.size();
		for(int i=0;i<rowSize;i++)
		{
			String data = allData.get(i).getText().trim().replaceAll("\\s+", " ");;
			excelUtility.setCellData("DropdownData", i ,0,data);
			}

      excelUtility.compareTwoExcelFiles();
	  er.sortFutureTime();
		driver.quit();
	}

}
