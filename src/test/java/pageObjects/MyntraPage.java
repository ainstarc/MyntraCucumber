package pageObjects;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
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

	@FindBy(xpath = "//div[@class='desktop-navLink']/a")
	List<WebElement> navBars;

	int navBarIndex;

//	@FindBy(xpath = "(//div[@class='desktop-navLink'])[1]//a[@class='desktop-categoryLink']")
	List<WebElement> categoryLinks;

	public void chooseHeader(String header) {
		int index = 0;
		for (WebElement nav : navBars) {
			index++;
//			System.out.println(nav.getText() + " " + index);
			if (nav.getText().equalsIgnoreCase(header)) {
				highlightElement(nav);
				navBarIndex = index;
				sleep(1000);
				actions.moveToElement(nav).build().perform();
				break;
			}
		}
	}

	public void chooseCategory(String category) {
		categoryLinks = driver.findElements(
				By.xpath("(//div[@class='desktop-navLink'])[" + navBarIndex + "]//a[@class='desktop-categoryLink']"));
		sleep(5000);
		for (WebElement cat : categoryLinks) {
//			System.out.println(cat.getText());
			if (cat.getText().equalsIgnoreCase(category)) {
				highlightElement(cat);
				sleep(1000);
				actions.moveToElement(cat).build().perform();
//				cat.click();
				jseClick(cat);
				sleep(1000);
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

	public boolean chooseBrand(String brandName) {
		if (!chooseBrandFromOptions(brandName)) {
			brandSearchFilter.click();
			brandSearchBar.sendKeys(brandName);
			return chooseBrandFromOptions(brandName);
		} else {
			return true;
		}
	}

	boolean chooseBrandFromOptions(String brandName) {
		boolean flag = false;
		String brandText;

		for (WebElement brand : brandList) {
			brandText = brand.getText().replaceAll("\\(\\d+\\)", "").toUpperCase();
//			System.out.println(brandText);

			if (brandText.matches(brandName.toUpperCase())) {
				brand.click();
				flag = true;
				break;
			}
		}
		return flag;
	}

	@FindBy(xpath = "//li[@class='product-base']//div[@class='product-productMetaInfo']")
	List<WebElement> productList;

	public void productDetails() {
		sleep(5000);
//		System.out.println(productList.size());
		for (WebElement product : productList) {
			// TO-DO store PRODUCT - DATA in EXCEL
		}
	}

	@FindBy(xpath = "//div[@id='sizeButtonsContainer']//p")
	List<WebElement> sizes;

	public void clickAnItem() {
		productList.get(productList.size() / 5).click();
		sleep(5000);
		String currWindow = driver.getWindowHandle();

		Set<String> windows = driver.getWindowHandles();

		for (String window : windows) {
			if (window != currWindow) {
				driver.switchTo().window(window);
			}
		}
	}

	@FindBy(xpath = "//div[@class='size-price']")
	WebElement priceBox;

	public void selectSize(String size) {
		String sizeDetails;
		for (WebElement s : sizes) {
			sizeDetails = s.getText().toUpperCase().replaceAll("RS\\..*", "").trim();

			if (size.contains(sizeDetails)) {
				s.click();
				ExplicitlyWaitForElement(priceBox);
				try {
					System.out.println(priceBox.getText());
				} catch (Exception e) {
				}
			}
		}
	}

	@FindBy(xpath = "//div[contains(text(), 'ADD TO BAG')]")
	WebElement addToBag;

	@FindBy(xpath = "//span[@class='size-buttons-size-error-message']")
	WebElement sizeError;

	public void addProductToBag() {
		addToBag.click();
		try {
			if (sizeError.getText().equals("Please select a size")) {
				System.out.println("Product Unavailable!");
			}
		} catch (Exception e) {
			System.out.println("PRODUCT AVAILABLE!");
		}
	}

	@FindBy(xpath = "//a/*[text()='Bag']")
	WebElement cart;

	public void checkBag() {
		cart.click();
		sleep(5000);
	}

	@FindBy(xpath = "//div[@class='emptyCart-base-emptyText']")
	WebElement emptyCart;

	@FindBy(xpath = "//div[@class='priceDetail-base-total ']")
	WebElement totalPrice;

	public void cartDetails() {
		try {
			System.out.println(totalPrice.getText());
		} catch (Exception e) {
		}
	}

	@FindBy(xpath = "//div[text()='PLACE ORDER']")
	WebElement placeOrder;

	public void clickPlaceOrder() {
		try {
			placeOrder.click();
		} catch (Exception e) {

		}
	}

	@FindBy(xpath = "//div[@class='signInContainer']")
	WebElement signIN;

	public void signInPage() {
		try {
			if (signIN.isDisplayed()) {
				System.out.println("SIGN-IN Page Loaded!");
			}
		} catch (Exception e) {
			System.out.println("SIGN-IN Page Not-Loaded!");
		}
	}

}
