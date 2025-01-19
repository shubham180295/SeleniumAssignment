package comassignment;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadDataFromExcel {

    @Test
    public void readDataFromExcl() throws IOException {

        FileInputStream file = new FileInputStream("./ExpectedStationSheet.xlsx");
        Workbook xs = new XSSFWorkbook(file);
      Sheet sheet= xs.getSheet("expectedStations");
      int totalrows= sheet.getLastRowNum();
      int cellcount=sheet.getRow(0).getLastCellNum();

      for (int i=1;i<totalrows;i++)
      {
          for(int j=0;j<cellcount;j++)
          {
           String   storeData=sheet.getRow(i).getCell(j).getStringCellValue();
              System.out.print(storeData);
              System.out.println("\t");
          }
      }






    }

}
