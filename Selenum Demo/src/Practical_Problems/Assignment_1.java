package Practical_Problems;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_1 {

	public static void main(String[] args) {
		// Select 1 checkbox
		// Grab the lebel present in the selected checkbox
		// Select an option in dropdown s.t option to select should come from step 2 dynamically
		// Enter step 2 grabbed lebel text in editbox dynamically
		// click alert and verify text grabbed from step 2 is present in the popup message

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// Select 1 checkbox
		// Grab the lebel present in the selected checkbox
		driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]/input")).click();
		String checkbox_msg=driver.findElement(By.xpath("//*[@id='checkbox-example']/fieldset/label[1]")).getText();
		System.out.println(checkbox_msg);
		

		// Select an option in dropdown s.t option to select should come from step 2 dynamically
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select s=new Select(dropdown);
		s.selectByVisibleText(checkbox_msg);
		
		
		// click alert and verify text grabbed from step 2 is present in the popup message
		driver.findElement(By.id("name")).sendKeys(checkbox_msg);
		driver.findElement(By.id("alertbtn")).click();
		System.out.println(driver.switchTo().alert().getText());
		String popup_msg=driver.switchTo().alert().getText();
		if(popup_msg.contains(checkbox_msg)) {
			System.out.println("Pass");
		}
		else {
			System.out.println("Fail");
		}

		

	}

}
