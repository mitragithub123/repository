package Action;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Assignment_1 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[text()='Multiple Windows']")).click();
		driver.findElement(By.xpath("//a[text()='Click Here']")).click();
		
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		String parentid = it.next();
		String childid = it.next();
		driver.switchTo().window(childid);
		
		String childText=driver.findElement(By.tagName("h3")).getText();
		System.out.println(childText);
		
		driver.switchTo().window(parentid);
		
		String parentText=driver.findElement(By.tagName("h3")).getText();
		System.out.println(parentText);
		
		
		

	}

}
