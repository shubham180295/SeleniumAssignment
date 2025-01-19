package pageObjectRepository;

import genericUtility.ExcelUtility;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.FileInputStream;
import java.io.IOException;

public class OrangeHRM {

    WebDriver driver;
    String path1 = "./src/ExcelFiles/Testing.xlsx";
    public OrangeHRM(WebDriver driver) {
        this.driver=driver;
        PageFactory. initElements(driver, this);
    }

    @FindBy(xpath="//*[@name='username']")
   private WebElement userName;

    @FindBy(xpath="//*[@name='password']")
    private  WebElement password;


    @FindBy(xpath="//button[@type='submit']")
    private WebElement loginButton;


    @FindBy(xpath="//*[text()='Invalid credentials']")
    private WebElement result;

public void clickLoginButton(){
        loginButton.click();

}

public  void enterValidDataIntoExcel() throws IOException {

    FileInputStream fis = new FileInputStream(path1);
    XSSFWorkbook workbook = new XSSFWorkbook(fis);
    String userName1  = workbook.getSheet("Testing1").getRow(1).getCell(0).getStringCellValue();
    String password2  = workbook.getSheet("Testing1").getRow(1).getCell(1).getStringCellValue();
        userName.sendKeys(userName1);
        password.sendKeys(password2);
        clickLoginButton();

    }

    public  void enterInValidDataIntoExcel() throws IOException {
        FileInputStream fis = new FileInputStream(path1);
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        String userName1  = workbook.getSheet("Testing1").getRow(2).getCell(0).getStringCellValue();
        String password2  = workbook.getSheet("Testing1").getRow(2).getCell(1).getStringCellValue();
        userName.sendKeys(userName1);
        password.sendKeys(password2);
        clickLoginButton();

    }

    public void assertValidation(){
          String   value =result.getText();
        Assert.assertEquals(value.contains("Invalid credentials") ,true);


    }
}
