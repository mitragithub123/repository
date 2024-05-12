package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Double_click {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://www.w3schools.com/tags/tryit.asp?filename=tryhtml5_ev_ondblclick3");
		driver.manage().window().maximize();

		// Switch to frame using name
		driver.switchTo().frame("iframeResult");

		WebElement field1 = driver.findElement(By.cssSelector("#field1"));
		field1.clear();
		field1.sendKeys("Jai Sriram");

		WebElement copyBtn = driver.findElement(By.cssSelector("button[ondblclick='myFunction()']"));

		Actions act = new Actions(driver);
		act.doubleClick(copyBtn).perform();// Double click

	}

}
