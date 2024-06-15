package codes.ExcelUtilities;

import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WriteDataIntoExcel {
	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\Testdata\\myFile.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data1");

		XSSFRow row1 = sheet.createRow(0);
		row1.createCell(0).setCellValue("Java");
		row1.createCell(1).setCellValue(19);
		row1.createCell(2).setCellValue("Automation1");

		XSSFRow row2 = sheet.createRow(1);
		row2.createCell(0).setCellValue("Python");
		row2.createCell(1).setCellValue(20);
		row2.createCell(2).setCellValue("Automation2");

		XSSFRow row3 = sheet.createRow(2);
		row3.createCell(0).setCellValue("Ruby");
		row3.createCell(1).setCellValue(21);
		row3.createCell(2).setCellValue("Automation3");
		
		workbook.write(file); //Attach workbook to file
		workbook.close();
		file.close();

		System.out.println("File is created....");
	}
}
