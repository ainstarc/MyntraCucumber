package stepDefinitions;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class Hooks {

	WebDriver driver;
	Properties p;

	@Before
	public void setup() throws IOException {
		driver = BaseClass.initializeBrowser();
		driver.manage().window().maximize();

	}

	@After
	public void tearDown(Scenario scenario) {
		driver.quit();

	}
}
