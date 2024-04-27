package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyntraPage extends BasePage {

	public MyntraPage(WebDriver driver) {
		super(driver);
	}

	public void openMyntra() {
		this.driver.get(p.getProperty("URL"));
	}

	@FindBy(xpath = "//input[@class='desktop-searchBar']")
	WebElement searchBar;

	@FindBy(xpath = "//ul[@class='desktop-group']/li")
	List<WebElement> searchSuggestions;

	public void itemSearch(String item) {
		ExplicitlyWaitForElement(searchBar);
		searchBar.sendKeys(item);

		for (WebElement suggestion : searchSuggestions) {
			if (suggestion.getText().equalsIgnoreCase(item)) {
				suggestion.click();
				break;
			}
		}
	}

	@FindBy(xpath = "//ul[@class='brand-list']/li")
	List<WebElement> brandList;

	@FindBy(xpath = "(//div[@class='filter-search-filterSearchBox']/span)[1]")
	WebElement brandSearchFilter;

	@FindBy(xpath = "//input[@class='filter-search-inputBox']")
	WebElement brandSearchBar;

	public void chooseBrand(String brandName) {
		if (!chooseBrandFromOptions(brandName)) {
			System.out.println();
			brandSearchFilter.click();
			brandSearchBar.sendKeys(brandName);
			System.out.println();
			chooseBrandFromOptions(brandName);
		}
	}

	boolean chooseBrandFromOptions(String brandName) {
		boolean flag = false;
		int i = 0;
		for (WebElement brand : brandList) {
//			System.out.println(brand.getText());
			i++;
		}

		return flag;
	}

}
