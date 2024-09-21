package comassignment;

import genericUtility.ExcelUtility;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import genericUtility.BaseClass;
import pageObjectRepository.ErailHomePage;

import java.io.IOException;

public class TC001_Booking extends BaseClass {

	@Test
	public void booking() throws InterruptedException, IOException {

		//  Create an object (instance) of the ErailHomepage class
		ExcelUtility excelUtility = new ExcelUtility();
		ErailHomePage er = new  ErailHomePage(driver);

		//Now, you can call the methods of ErailHomepage using this object
		er.clearField();
		er.enterField();
		er.dropDownStationValues();
		er.printFourthPositionElement();
		excelUtility.writeExpectedStationIntoExcel();
      excelUtility.compareTwoExcelFiles();
	  er.sortFutureTime();
	}



}
