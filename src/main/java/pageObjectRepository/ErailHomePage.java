package pageObjectRepository;

import java.io.FileOutputStream;
import java.io.IOException;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



public class ErailHomePage {
	WebDriver driver;
	
public ErailHomePage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory. initElements(driver, this);
}

@FindBy(xpath="//input[@placeholder='From Station']")
private WebElement fromField;

@FindBy(xpath="//*[@title='Delhi Azadpur']")
private WebElement fourthPositionElement;

@FindBy(xpath="(//div[@class='autocomplete-w1']/child::div[@class ='autocomplete'])[1]")
private List<WebElement> allStations;


@FindBy(xpath ="//*[@title='Select Departure date for availability']")
private  WebElement sortDate;
public WebElement getFromField() {
	return fromField;
}

public void setFromField(WebElement fromField) {
	this.fromField = fromField;
}

public WebElement getFourthPositionElement() {
	return fourthPositionElement;
}

public List<WebElement> getAllStations() {
	return allStations;
}

public void setAllStations(List<WebElement> allStations) {
	this.allStations = allStations;
}

public void setFourthPositionElement(WebElement fourthPositionElement) {
	this.fourthPositionElement = fourthPositionElement;
}


public void clearField() {
	getFromField().clear();
}
public void enterField() {
	getFromField().sendKeys("DEL");
}

public void printFourthPositionElement() {
	System.out.println(fourthPositionElement.getText());

	//
}



	public void dropDownStationValues() throws IOException {
		// Create a new Excel workbook
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("DropdownStations");

		// Retrieve the station list
		List<WebElement> stations = getAllStations();

		// Loop through all stations and add them to the sheet
		for (int i = 0; i < stations.size(); i++) {
			// Create a new row for each station and set its value in the first column
			sheet.createRow(i).createCell(0).setCellValue(stations.get(i).getText());
		}

		// Create a new Excel file in the current project directory
		 FileOutputStream fos = new FileOutputStream("DropdownSheet.xlsx");
			workbook.write(fos);


		// Close the workbook
		workbook.close();
	}

	public void setSortDate(WebElement sortDate) {
		this.sortDate = sortDate;
	}

	public WebElement getSortDate() {
		return sortDate;
	}


	public void sortFutureTime(){
		LocalDate currentDate = LocalDate.now();
		LocalDate futureDate = currentDate.plusDays(30);

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yy");
		String formattedDate = futureDate.format(formatter);
System.out.println(formattedDate);
		System.out.println(formattedDate);
		getFourthPositionElement().click();
		getSortDate().click();
		 getSortDate().sendKeys(formattedDate);

	}



}




