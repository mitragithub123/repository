package Action;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Keyboard_actions1 {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		driver.get("https://text-compare.com/");
		driver.manage().window().maximize();
		
		WebElement field1 = driver.findElement(By.cssSelector("#inputText1"));
		WebElement field2 = driver.findElement(By.cssSelector("#inputText2"));
		
		field1.sendKeys("Jai Sriram");
		
		Actions act=new Actions(driver);
		
		//CTRL A
		act.keyDown(Keys.CONTROL);//press control
		act.sendKeys("a");
		act.keyUp(Keys.CONTROL);//release control
		act.perform();
		
		//CTRL C
		act.keyDown(Keys.CONTROL).sendKeys("c").keyUp(Keys.CONTROL).perform();
		
		//Tab
		act.sendKeys(Keys.TAB).perform();
		
		//CTRL V
	    act.keyDown(Keys.CONTROL).sendKeys("v").keyUp(Keys.CONTROL).perform();
	    
	    driver.findElement(By.cssSelector("#compareButton")).click();
	    Thread.sleep(3000);
	    
	    System.out.println(driver.findElement(By.cssSelector(".messageForUser")).getText());
				
	}

}
