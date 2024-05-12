package Practical_Problems;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link_count {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// Prints the total links count in the page
		System.out.println("Total links count: " + driver.findElements(By.tagName("a")).size());

		// Limiting the WebDriver scope

		// Prints the links count in the footer section
		WebElement footerDriver = driver.findElement(By.id("gf-BIG"));
		System.out.println("Total links count in footer: " + footerDriver.findElements(By.tagName("a")).size());

		// Prints the links count in the footer section 1st column
		WebElement miniDriver = footerDriver.findElement(By.cssSelector("tbody tr td:first-child ul:nth-child(1)"));
		System.out
				.println("Total links count in footer 1st column: " + miniDriver.findElements(By.tagName("a")).size());

		// Check whether the links in footer section 1st column are opening or not
		// How to open links in separate tabs
		// Open in new tab-->CTRL+click/enter
		for(int i=1;i<miniDriver.findElements(By.tagName("a")).size();i++)
		{
			
			String clickonlinkTab=Keys.chord(Keys.CONTROL,Keys.ENTER);
			miniDriver.findElements(By.tagName("a")).get(i).sendKeys(clickonlinkTab);
			Thread.sleep(5000L);
			
		}
		
		// Get the titles of child tabs
					Set<String> windows = driver.getWindowHandles();
					Iterator<String> it = windows.iterator();
		while (it.hasNext()) {/*
								 * it.hasNext() tells that whether the next index is present if it is present
								 * then enter loop or returns true if the iteration has more elements.
								 */

			driver.switchTo().window(it.next());
			// it.next() actually moves to next index
			// it.next()---iterator contol moves to base i.e 0th index
			// it.next()---prints window id
			System.out.println(driver.getTitle());

		}

	}

}
