package Practical_Problems;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Handling_tabale_grid {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		JavascriptExecutor j = (JavascriptExecutor) driver;
		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		j.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		List<WebElement> values=driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		int sum=0;
		for(int i=0;i<values.size();i++) {
			System.out.println(Integer.parseInt(values.get(i).getText()));
			sum=sum+Integer.parseInt(values.get(i).getText());
		}
		System.out.println("Sum is: "+sum);
		int total=Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, total);
		if(sum==total) {
			System.out.println("Test pass");
		}
		else {
			System.out.println("Test fail");
		}
		
		
	}

}
