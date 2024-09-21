package genericUtility;

import java.io.*;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import pageObjectRepository.ErailHomePage;

import static genericUtility.BaseClass.driver;

public class ExcelUtility {

public  WebDriver driver;

	@Test(priority = 2)
	public void compareTwoExcelFiles() throws IOException {

		String filePath1 = "DropdownSheet.xlsx";
		String filePath2 = "StationSheet.xlsx";

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




	@Test(priority = 1)
	public void writeExpectedStationIntoExcel() throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("expectedStations");
		sheet.createRow(0).createCell(0).setCellValue("Denduluru");
		sheet.createRow(1).createCell(0).setCellValue("DEL");
		sheet.createRow(2).createCell(0).setCellValue("Delang");
		sheet.createRow(3).createCell(0).setCellValue("DEG");
		sheet.createRow(4).createCell(0).setCellValue("Delhi");
		sheet.createRow(5).createCell(0).setCellValue("DLI");
		sheet.createRow(6).createCell(0).setCellValue("Delhi Azadpur");
		sheet.createRow(7).createCell(0).setCellValue("DAZ");
		sheet.createRow(8).createCell(0).setCellValue("Delhi Cantt");
		sheet.createRow(9).createCell(0).setCellValue("DEC");
		sheet.createRow(10).createCell(0).setCellValue("Delhi Indrapuri");
		sheet.createRow(11).createCell(0).setCellValue("DLPI");
		sheet.createRow(12).createCell(0).setCellValue("Delhi Kishanganj");
		sheet.createRow(13).createCell(0).setCellValue("DKZ");
		sheet.createRow(14).createCell(0).setCellValue("Delhi S Rohilla");
		sheet.createRow(15).createCell(0).setCellValue("DEE");
		sheet.createRow(16).createCell(0).setCellValue("Delhi Safdarjng");
		sheet.createRow(17).createCell(0).setCellValue("DSJ");
		sheet.createRow(18).createCell(0).setCellValue("Delhi Shahdara");
		sheet.createRow(19).createCell(0).setCellValue("DSA");
		sheet.createRow(20).createCell(0).setCellValue("Delhi Shahdara A Panel");
		sheet.createRow(21).createCell(0).setCellValue("DSAP");
		sheet.createRow(22).createCell(0).setCellValue("Delvada");
		sheet.createRow(23).createCell(0).setCellValue("DVA");
		sheet.createRow(24).createCell(0).setCellValue("Adarsh Nagar Delhi");
		sheet.createRow(25).createCell(0).setCellValue("ANDI");
		sheet.createRow(26).createCell(0).setCellValue("Bandel Jn");
		sheet.createRow(27).createCell(0).setCellValue("BDC");
		sheet.createRow(28).createCell(0).setCellValue("Bodeli");
		sheet.createRow(29).createCell(0).setCellValue("BDE");
		sheet.createRow(30).createCell(0).setCellValue("Coromandel");
		sheet.createRow(31).createCell(0).setCellValue("COL");
		// Denduluru
		//DEL
		//Delang
		//DEG
		//Delhi
		//DLI
		//Delhi Azadpur
		//DAZ
		//Delhi Cantt
		//DEC
		//Delhi Indrapuri
		//DLPI
		//Delhi Kishanganj
		//DKZ
		//Delhi S Rohilla
		//DEE
		//Delhi Safdarjng
		//DSJ
		//Delhi Shahdara
		//DSA
		//Delhi Shahdara A Panel
		//DSAP
		//Delvada
		//DVA
		//Adarsh Nagar Delhi
		//ANDI
		//Bandel Jn
		//BDC
		//Bodeli
		//BDE
		//Coromandel
		//COL

		// create a new excel sheet in current project
		FileOutputStream fos = new FileOutputStream("StationSheet.xlsx");
		workbook.write(fos);
		workbook.close();

	}


}