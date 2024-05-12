package Action;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Drag_and_drop_in_frames {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://jqueryui.com/droppable/");
		driver.manage().window().maximize();
		// Switch to frame using web element
		// driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));

		//Count number of frames and print in console
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		//Another way
		//List<WebElement> iframeCount = driver.findElements(By.tagName("iframe"));
		//System.out.println("Total number of iframes are " + iframeCount.size());
		
		// Switch to frame using index(switch to frame using id or name also possible)
		driver.switchTo().frame(0);
		
		//Drag and drop
		Actions a = new Actions(driver);
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		a.dragAndDrop(source, target).build().perform();

		// Switch from frame to normal
		driver.switchTo().defaultContent();

	}

}
