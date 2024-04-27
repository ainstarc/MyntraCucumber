package stepDefinitions;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
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
		this.myntra.openMyntra();
	}

	@When("User searches {string}")
	public void searchItem(String item) {
		System.out.println(item);
		this.myntra.itemSearch(item);
	}

	@Then("User gets searched items result")
	public void searchResults() {
	}

	@When("User selects an {string}")
	public void selectItem(String brandName) {
		this.myntra.chooseBrand(brandName);
	}

	@Then("Item details opens in new tab")
	public void itemDetails() {
	}

	@When("User switches to new tab")
	public void switchToItemTab() {
	}

	@When("select {string}")
	public void chooseSize(String size) {
		System.out.println(size);
	}

	@When("add to bag")
	public void addToBag() {
	}

	@When("move to bag")
	public void openBag() {
	}

	@Then("bag opens with added item")
	public void bagPage() {
	}

	@When("User place order")
	public void placeOrder() {
	}

	@Then("login page appears")
	public void loginPage() {
	}
}
