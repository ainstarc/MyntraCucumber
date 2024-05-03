package pageObjects;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

	protected WebDriver driver;
	protected static Actions actions;
	static Properties p;
	protected static WebDriverWait wait;
	static JavascriptExecutor jse;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		actions = new Actions(driver);
		p = getProperties();
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		actions = new Actions(driver);
		jse = (JavascriptExecutor) driver;
	}

	public static void sleep(long time) {
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public static Properties getProperties() {
		FileReader file = null;
		try {
			file = new FileReader(System.getProperty("user.dir") + "\\src\\test\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		p = new Properties();
		try {
			p.load(file);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return p;
	}

	public static Boolean ExplicitlyWaitForElement(WebElement element) {
		return wait.until(ExpectedConditions.and(ExpectedConditions.visibilityOf(element),
				ExpectedConditions.elementToBeClickable(element)));
	}

	public static void highlightElement(WebElement element) {
		jse.executeScript("arguments[0].style.backgroundColor=arguments[1]", element, "yellow");
	}

	public static void jseClick(WebElement element) {
		jse.executeScript("arguments[0].click();", element);
	}
}
