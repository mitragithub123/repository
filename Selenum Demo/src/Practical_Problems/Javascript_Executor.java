package Practical_Problems;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Javascript_Executor {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		// Use utility class to solve these
		// Class name: utility_javascript_executor
		// All actions will be stored in the class, here we just call the methods

//		// Drawing border
//		WebElement logo = driver.findElement(By.cssSelector(".header-logo a img"));
//		utility_javascript_executor.drawBorder(logo, driver);
//
//		// Getting title of the page
//		String title = utility_javascript_executor.getTitleByJs(driver);
//		System.out.println(title);
//
//		// Click action
//		WebElement element = driver.findElement(By.cssSelector(".top-menu.notmobile>li:first-child>a:first-child"));
//		utility_javascript_executor.clickByJs(element, driver);
//
//		// Generate alert
//		String msg = "I am an alert box!";
//		utility_javascript_executor.generateJsAlert(driver, msg);
//
//		// Refreshing the page
//		utility_javascript_executor.refreshByJs(driver);
//
//		// Scroll to end of page
//		utility_javascript_executor.scrollToEndByJs(driver);
//		Thread.sleep(3000);
//
//		// Scroll to top of page
//		utility_javascript_executor.scrollToTopByJs(driver);
//
//		// Zoom page
//		utility_javascript_executor.zoomByJs(driver);

		// Flash
		WebElement logo1 = driver.findElement(By.cssSelector(".header-logo img"));
		utility_javascript_executor.flashElementByJs(driver, logo1);

		// This program will not run. Try to comment other blocks while running

	}

}
