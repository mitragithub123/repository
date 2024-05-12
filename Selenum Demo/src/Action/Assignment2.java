package Action;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

//Nested frame
public class Assignment2 {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		driver.get("https://the-internet.herokuapp.com/");
		driver.manage().window().maximize();

		driver.findElement(By.xpath("//a[text()='Nested Frames']")).click();

		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));
		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_middle']")));
		System.out.println(driver.findElement(By.xpath("//div[@id='content']")).getText());
//		driver.switchTo().defaultContent();
//		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='/frame_top']")));
//		driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='//frame_right']")));
//		System.out.println(driver.findElement(By.xpath("//body")).getText());
//		
		

		/* From Parent to Son/daughter */

		// driver.switchTo().frame("Frame_Son");
		// driver.switchTo().frame("Frame_Daughter");

		/* From Son/daughter to Parent */

		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("Frame_Parent");

		/*
		 * From Son to Daughter: If your sister does some mistake don't yell at her,
		 * just reach out to your Parent. Similarly, you give control to parent frame
		 * and then to daughter frame.
		 */

		// driver.switchTo().frame("Frame_Son");
		// driver.switchTo().defaultContent();
		// driver.switchTo().frame("Frame_Parent");
		// driver.switchTo().frame("Frame_Daughter");

	}

}
