package codes;

import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {
	public static void main(String[] args) throws IOException {
		// Excel file-->Workbook-->Sheet-->Row-->Cell
		// FileInputStream: Read and FileOutputStream: Write
		// FileInputStream/FileOutputStream-->XSSFWorkbook-->XSSFSheet-->XSSFCell

		FileInputStream file = new FileInputStream(System.getProperty("user.dir") + "\\Testdata\\testData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		XSSFSheet sheet = workbook.getSheet("Sheet1");

		int totalRows = sheet.getLastRowNum();
		int totalCells = sheet.getRow(0).getLastCellNum();

		System.out.println("Toal rows: " + totalRows);// 2
		System.out.println("Toal cells: " + totalCells);// 3

		// Row starts from 0 but cell starts from 1

		for (int i = 0; i <= totalRows; i++) {

			XSSFRow row = sheet.getRow(i);

			for (int j = 0; j < totalCells; j++) {

				XSSFCell cell = row.getCell(j);
				System.out.print(cell.toString() + "\t");
			}
			System.out.println();
		}
		workbook.close();
		file.close();

	}
}
