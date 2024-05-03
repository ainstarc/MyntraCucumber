package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.MyntraPage;

public class stepProductOrder {

	WebDriver driver;
	MyntraPage myntra;

	@Given("User is in Myntra Site")
	public void openSite() {
		this.myntra = new MyntraPage(BaseClass.getDriver());
//		this.myntra.openMyntra();
	}

	@When("User searches {string}")
	public void searchItem(String item) {
//		System.out.println(item);
		this.myntra.itemSearch(item);
	}

	@When("User hovers on {string}")
	public void hoverOnNav(String nav) {
		this.myntra.chooseHeader(nav);
	}
	
	@And("User clicks on {string}")
	public void hoverAndClickOnCategory(String cat) {
		this.myntra.chooseCategory(cat);
	}
	
	
	@Then("User gets searched items result")
	public void searchResults() {
	}

	@When("User selects a {string}")
	public void selectBrand(String brandName) {
		boolean flag = this.myntra.chooseBrand(brandName);
		Assert.assertTrue(flag);
	}

	@Then("User gets results of item")
	public void itemDetails() {
		this.myntra.productDetails();
	}

	@When("User clicks on item and switch to item tab")
	public void clikedItemTab() {
		this.myntra.clickAnItem();
	}

	@And("select {string}")
	public void chooseSize(String size) {
		try {
			this.myntra.selectSize(size);
		} catch (ElementClickInterceptedException e) {

		} catch (Exception e) {

		}
	}

	@And("add to bag")
	public void addToBag() {
		this.myntra.addProductToBag();

	}

	@And("move to bag")
	public void openBag() {
		this.myntra.checkBag();
	}

	@Then("bag opens with added item")
	public void bagPage() {
		this.myntra.cartDetails();
	}

	@When("User place order")
	public void placeOrder() {
		this.myntra.clickPlaceOrder();
	}

	@Then("login page appears")
	public void loginPage() {
		this.myntra.signInPage();
	}
}
