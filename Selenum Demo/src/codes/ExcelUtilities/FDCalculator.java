package codes.ExcelUtilities;

import java.io.IOException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FDCalculator {

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.get(
				"https://www.moneycontrol.com/fixed-income/calculator/state-bank-of-india-sbi/fixed-deposit-calculator-SBI-BSB001.html");
		driver.manage().window().maximize();
		Thread.sleep(3000);

		String filePath = ".\\Testdata\\Worksheet.xlsx";
		int rows = ExcelUtils.getRowCount(filePath, "Sheet1");
		for (int i = 1; i <= rows; i++) {
			// Read data from excel
			String price = ExcelUtils.getCellData(filePath, "Sheet1", i, 0);
			String rateOfIntrest = ExcelUtils.getCellData(filePath, "Sheet1", i, 1);
			String period = ExcelUtils.getCellData(filePath, "Sheet1", i, 2);
			String time = ExcelUtils.getCellData(filePath, "Sheet1", i, 3);

			String expValue = ExcelUtils.getCellData(filePath, "Sheet1", i, 4);

			// Pass value in to app
			driver.findElement(By.cssSelector("#principal")).sendKeys(price);
			driver.findElement(By.cssSelector("#interest")).sendKeys(rateOfIntrest);
			driver.findElement(By.cssSelector("#tenure")).sendKeys(period);
			Select select = new Select(driver.findElement(By.cssSelector("#tenurePeriod")));
			select.selectByVisibleText(time);
			Select intrestSelect = new Select(driver.findElement(By.cssSelector("#frequency")));
			intrestSelect.selectByVisibleText(expValue);

			driver.findElement(
					By.cssSelector("img[src='https://images.moneycontrol.com/images/mf_revamp/btn_calcutate.gif']"))
					.click();

			// Validation
			String actValue = driver.findElement(By.cssSelector("span[id='resp_matval'] strong")).getText();
			if (Double.parseDouble(expValue) == Double.parseDouble(actValue)) {
				System.out.println("Test pass");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Pass");
				ExcelUtils.fillGreenColor(filePath, "Sheet1", i, 7);
			} else {
				System.out.println("Test fail");
				ExcelUtils.setCellData(filePath, "Sheet1", i, 7, "Fail");
				ExcelUtils.fillRedColor(filePath, "Sheet1", i, 7);
			}
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("img[class='PL5']")).clear();
		}

	}

}
