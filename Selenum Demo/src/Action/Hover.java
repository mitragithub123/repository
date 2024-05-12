package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Hover {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.id("nav-link-accountList"))).build().perform();// Move to an element
	}

}
