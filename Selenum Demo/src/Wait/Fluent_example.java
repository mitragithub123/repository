//Dynamic loading
package Wait;

import java.time.Duration;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Fluent_example {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
		driver.manage().window().maximize();
		
//		WebDriverWait mywait=new WebDriverWait(driver,Duration.ofSeconds(20));

		driver.findElement(By.xpath("//button[text()='Start']")).click();
		
		
//		WebElement element = mywait.until(ExpectedConditions.visibilityOfElementLocated(
//				By.xpath("//button[text()='Start']")));

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30))
				.pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				if (driver.findElement(By.cssSelector("#finish h4")).isDisplayed()) {
					return driver.findElement(By.cssSelector("#finish h4"));
				} else {
					return null;
				}

			}
		});
		System.out.println(driver.findElement(By.cssSelector("#finish h4")).getText());
	}

}
