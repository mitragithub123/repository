package Practical_Problems;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class utility_javascript_executor {
	public static void drawBorder(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.header-logo a img').style.border='3px solid red'");// border
	}

	// Get title
	public static String getTitleByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		return title;
	}

	// Click
	public static void clickByJs(WebElement element, WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.querySelector('.top-menu.notmobile>li:first-child>a:first-child').click()");

	}

	// Alert
	public static void generateJsAlert(WebDriver driver, String msg) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("alert('msg')");

	}

	// Refresh
	public static void refreshByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("history.go(0)");

	}

	// Scroll down
	public static void scrollToEndByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,document.body.scrollHeight");
	}

	// Scroll to top
	public static void scrollToTopByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight");
	}

	// Zoom
	public static void zoomByJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.body.style.zoom='10%'");
	}

	// Flash
	public static void flashElementByJs(WebDriver driver, WebElement element) {
		String bgcolor = element.getCssValue("backgroundcolor");
		for (int i = 0; i < 1000; i++) {
			changeColor("#000000", driver, element);
			changeColor(bgcolor, driver, element);
		}
	}

	public static void changeColor(String color, WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("argument[0].style.backgroundcolor='" + color + "'", element);
		try {
			Thread.sleep(20);
		} catch (InterruptedException e) {

		}
	}
}
