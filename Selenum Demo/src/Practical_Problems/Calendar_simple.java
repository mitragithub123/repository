package Practical_Problems;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
//Today's date 27-06-2022
//To select 21-May-2023
public class Calendar_simple {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.path2usa.com/travel-companions");
		Thread.sleep(3000);
		driver.manage().window().maximize();

		driver.findElement(By.id("travel_date")).click();

		while (!driver.findElement(By.cssSelector(".datepicker-days .datepicker-switch")).getText()
				.contains("May")) {
			driver.findElement(By.cssSelector(".datepicker-days .next")).click();
		}
		//while(condition)-->condition is true then loop will execute else returns out of the loop
		//Here condition--->driver.findElement(By.cssSelector("[class='datepicker-days'] [class='datepicker-switch']")).getText()
		//Condition is June i.e not May. 
		//So condition is false to make it true add a negation
		

		List<WebElement> dates = driver.findElements(By.className("day"));
		int count = driver.findElements(By.className("day")).size();

		for (int i = 0; i < count; i++) {
			String text = driver.findElements(By.className("day")).get(i).getText();
			if (text.equalsIgnoreCase("21")) {
				driver.findElements(By.className("day")).get(i).click();
				break;
			}
		}
	}

}
