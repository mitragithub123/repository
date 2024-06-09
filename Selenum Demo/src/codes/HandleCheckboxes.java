package codes;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class HandleCheckboxes {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();

		List<WebElement> checkboxes = driver
				.findElements(By.cssSelector("input[class='form-check-input'][type='checkbox']"));
		//Select all check boxes using for loop
		/*

		}*/
		
		//Select all check boxes using enhanced for loop
		/*for(WebElement checkbox:checkboxes) {
			checkbox.click();
		}*/
		
		//Select last 3 check boxes
		/*for (int i = 4; i < checkboxes.size(); i++) {
			checkboxes.get(i).click();
		}*/
		
		//Select first 3 check boxes
		/*for (int i = 0; i < 3; i++) {
			checkboxes.get(i).click();
		}*/
		
		//Reselect check boxes if they are selected
		for (int i = 0; i < 3; i++) {
			checkboxes.get(i).click();
		}
		Thread.sleep(5000);
		for (int i = 0; i < checkboxes.size(); i++) {
			if (checkboxes.get(i).isSelected()) {
				checkboxes.get(i).click();
			}
		}

	}
}
