package genericUtility;
import java.io.*;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class ExcelUtility {
public  WebDriver driver;
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	public String path;
	public ExcelUtility(String path) {
		this. path = path;
	}

	@Test
	public void compareTwoExcelFiles() throws IOException {

		String filePath1 = "data.xlsx";
		String filePath2 = "ExpectedStationSheet.xlsx";

		boolean isEqual = compareExcelFiles(filePath1, filePath2);
		System.out.println("Files are " + (isEqual ? "equal" : "not equal"));
	}
		public  boolean compareExcelFiles(String filePath1, String filePath2) throws IOException {
		Workbook workbook1 = WorkbookFactory.create(new FileInputStream(new File(filePath1)));
		Workbook workbook2 = WorkbookFactory.create(new FileInputStream(new File(filePath2)));


		for (int i = 0; i < workbook1.getNumberOfSheets(); i++) {
			Sheet sheet1 = workbook1.getSheetAt(i);
			Sheet sheet2 = workbook2.getSheetAt(i);
		if (!compareSheets(sheet1, sheet2)) {
			return false;
		}
	}
        return true;
}

	public static boolean compareSheets(Sheet sheet1, Sheet sheet2) {
		int lastRow1 = sheet1.getLastRowNum();
		int lastRow2 = sheet2.getLastRowNum();

		if (lastRow1 != lastRow2) {
			return false;
		}

		for (int i = 0; i <= lastRow1; i++) {
			Row row1 = sheet1.getRow(i);
			Row row2 = sheet2.getRow(i);

			if (!compareRows(row1, row2)) {
				return false;
			}
		}
		return true;
	}

	public static boolean compareRows(Row row1, Row row2) {
		if (row1 == null && row2 == null) return true;
		if (row1 == null || row2 == null) return false;

		int lastCell1 = row1.getLastCellNum();
		int lastCell2 = row2.getLastCellNum();

		if (lastCell1 != lastCell2) {
			return false;
		}

		for (int i = 0; i < lastCell1; i++) {
			Cell cell1 = row1.getCell(i);
			Cell cell2 = row2.getCell(i);

			if (!compareCells(cell1, cell2)) {
				return false;
			}
		}
		return true;
	}

	public static boolean compareCells(Cell cell1, Cell cell2) {
		if (cell1 == null && cell2 == null) return true;
		if (cell1 == null || cell2 == null) return false;

		switch (cell1.getCellType()) {
			case STRING:
				return cell1.getStringCellValue().equals(cell2.getStringCellValue());
			case NUMERIC:
				return cell1.getNumericCellValue() == cell2.getNumericCellValue();
			case BOOLEAN:
				return cell1.getBooleanCellValue() == cell2.getBooleanCellValue();
			default:
				return false;
		}
	}
	@Test
	public void writeExpectedStationIntoExcel() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("expectedStations");
		sheet.createRow(0).createCell(0).setCellValue("Denduluru DEL");
		sheet.createRow(1).createCell(0).setCellValue("Delang DEG");
		sheet.createRow(2).createCell(0).setCellValue("Delhi DLI");
		sheet.createRow(3).createCell(0).setCellValue("Delhi Azadpur DAZ");
		sheet.createRow(4).createCell(0).setCellValue("Delhi Cantt DEC");
		sheet.createRow(5).createCell(0).setCellValue("Delhi Indrapuri DLPI");
		sheet.createRow(6).createCell(0).setCellValue("Delhi Kishanganj DKZ");
		sheet.createRow(7).createCell(0).setCellValue("Delhi S Rohilla DEE");
		sheet.createRow(8).createCell(0).setCellValue("Delhi Safdarjng DSJ");
		sheet.createRow(9).createCell(0).setCellValue("Delhi Shahdara DSA");
		sheet.createRow(10).createCell(0).setCellValue("Delhi Shahdara A Panel DSAP");
		sheet.createRow(11).createCell(0).setCellValue("Delvada DVA");
		sheet.createRow(12).createCell(0).setCellValue("Adarsh Nagar Delhi ANDI");
		sheet.createRow(13).createCell(0).setCellValue("Bandel Jn BDC");
		sheet.createRow(14).createCell(0).setCellValue("Bodeli BDE");
		sheet.createRow(15).createCell(0).setCellValue("Coromandel COL");



		// create a new excel sheet in current project
		FileOutputStream fos = new FileOutputStream("ExpectedStationSheet.xlsx");
		workbook.write(fos);
		workbook.close();
	}
	public String readDataFromExcel(String sheetName, int row, int cell) throws
			EncryptedDocumentException, IOException{
		FileInputStream fis = new FileInputStream(path);
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		String data = workbook.getSheet(sheetName).getRow(row).getCell(cell).getStringCellValue();
        return data;
	}

	public void setCellData(String sheetName, int rownum, int colnum, String data) throws IOException {
		File xlfile = new File(path);
		if (!xlfile.exists())    // If file not exists then create new file
		{
			workbook = new XSSFWorkbook();
			fo = new FileOutputStream(path);
			workbook.write(fo);
		}

		fi = new FileInputStream(path);
		workbook = new XSSFWorkbook(fi);

		if (workbook.getSheetIndex(sheetName) == -1) // If sheet not exists then create new Sheet
			workbook.createSheet(sheetName);
		sheet = workbook.getSheet(sheetName);

		if (sheet.getRow(rownum) == null)   // If row not exists then create new Row
			sheet.createRow(rownum);
		row = sheet.getRow(rownum);

		cell = row.createCell(colnum);
		cell.setCellValue(data);
		fo = new FileOutputStream(path);
		workbook.write(fo);
		workbook.close();
		fi.close();
		fo.close();
	}

}