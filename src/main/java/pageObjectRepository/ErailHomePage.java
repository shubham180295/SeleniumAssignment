package pageObjectRepository;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


public class ErailHomePage {
	WebDriver driver;
	
public ErailHomePage(WebDriver driver) {
	
	this.driver=driver;
	PageFactory. initElements(driver, this);
}

@FindBy(xpath="//input[@placeholder='From Station']")
private WebElement fromField;

@FindBy(xpath="(//div[@class='autocomplete'])[1]//div[4]")
private WebElement fourthPositionElement;

@FindBy(xpath="(//div[@class='autocomplete-w1']/child::div[@class ='autocomplete'])[1]")
private List<WebElement> allStations;

	@FindBy(xpath="(//div[@class='autocomplete'])[1]//div[@title =*]")
	private List<WebElement> DropDownStation;

	public List<WebElement> getDropDownStation() {
		return DropDownStation;
	}

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
	getFromField().sendKeys("DEl");
}

public void printFourthPositionElement() {

	System.out.println(getFourthPositionElement().getAttribute("title"));

}


	public void setSortDate(WebElement sortDate) {
		this.sortDate = sortDate;
	}

	public WebElement getSortDate() {
		return sortDate;
	}

@Test
public void sortFutureTime() {
	LocalDate currentDate = LocalDate.now();
	LocalDate futureDate = currentDate.plusDays(30);
	DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd");
	String formattedDate = futureDate.format(formatter);

	// Click on the date picker to open the calendar (modify selector as per actual element)
	WebElement dateField = driver.findElement(By.xpath("//*[@title='Select Departure date for availability']"));
	dateField.click();

	// Find the correct day in the calendar
	String day = String.valueOf(futureDate.getDayOfMonth());

	WebElement dayToSelect = driver.findElement(By.xpath("(//*[text()='"+day+"'])[2]"));
	dayToSelect.click();

	}}







