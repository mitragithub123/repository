package Practical_Problems;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Scroll {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		JavascriptExecutor j = (JavascriptExecutor) driver;
		// you can do like this without typecasting
		// ChromeDriver driver = new ChromeDriver();
		// JavascriptExecutor j = driver;

		j.executeScript("window.scrollBy(0,500)");
		Thread.sleep(3000);
		j.executeScript("document.querySelector('.tableFixHead').scrollTop=500");// vertical scroll bar
		// For horizontal scroll bar use scrollLeft
		// querySelector--css
		// getElementById--id

	}

}
