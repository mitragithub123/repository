package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Enter_string_capital_search_box {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.amazon.in/");
		driver.manage().window().maximize();

		Actions a = new Actions(driver);

		// Hover an element and right click on it
		WebElement move = driver.findElement(By.id("nav-link-accountList"));
		a.moveToElement(move).contextClick().build().perform();

		// Composite actions
		// Enter a string in capital in search box and double click it
		a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("hello")
				.doubleClick().build().perform();

	}

}
