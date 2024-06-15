package codes.ExcelUtilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		FileOutputStream file = new FileOutputStream(System.getProperty("user.dir") + "\\Testdata\\myFileDynamic.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Data1");

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter rows");
		int rows = sc.nextInt();

		System.out.println("Enter columns");
		int cols = sc.nextInt();

		for (int i = 0; i <= rows; i++) {
			XSSFRow currentRow = sheet.createRow(i);
			for (int j = 0; j < cols; j++) {
				XSSFCell cell = currentRow.createCell(j);
				cell.setCellValue(sc.next());
			}
		}

		workbook.write(file);
		workbook.close();
		file.close();
		sc.close();

		System.out.println("File is created....");

	}

}
