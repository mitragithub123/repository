package Action;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Switch_new_tab_window {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.manage().window().maximize();

		driver.findElement(By.cssSelector(".blinkingText")).click();

		// Switch to next tab/window
		Set<String> windows = driver.getWindowHandles();// grabs parentid and childid
		Iterator<String> it = windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);

		System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());
		System.out.println(
				driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split(" ")[0]);

	}

}
