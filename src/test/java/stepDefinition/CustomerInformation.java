package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;

public class CustomerInformation {
	private WebDriver driver;

	@Given("User login with valid credentials")
	public void userLoginWithValidCredentials() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.id("user-name")).sendKeys("standard_user");
		driver.findElement(By.id("password")).sendKeys("secret_sauce");
		driver.findElement(By.id("login-button")).click();

	}

	@When("User add product to cart")
	public void userAddProductToCart() {
		WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCartButton.click();
        WebElement addToCartButton1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        addToCartButton1.click();
	}

	@And("User navigates to the cart page")
	public void userNavigatesToCartPage() {
		WebElement cart = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a[1]"));
        cart.click();
	}

	@And("User clicks checkout")
	public void userClicksCheckout() {
		WebElement checkout = driver.findElement(By.id("checkout"));
		checkout.click();
	}

	@And("User fills the first name, last name and zip code correctly")
	public void userFillsInfoCorrectly() {
		driver.findElement(By.id("first-name")).sendKeys("Bill");
		driver.findElement(By.id("last-name")).sendKeys("Gates");
		driver.findElement(By.id("postal-code")).sendKeys("1234");
	}

	@And("User clicks continue")
	public void userClicksContinue() {
		WebElement continueProcess= driver.findElement(By.id("continue"));
		continueProcess.click();
	}

	@And("User clicks finish")
	public void userClicksFinish() {
		WebElement finishProcess= driver.findElement(By.id("finish"));
		finishProcess.click();
	}

	@Then("The order is successfully placed")
	public void orderSuccessfullyPlaced() {
		WebElement confirmationMessage = driver.findElement(By.xpath("//h2[@class='complete-header']"));
        assert confirmationMessage.isDisplayed() : "Order placement failed";
	}
	
	@Then("The error message should be appear")
	public void errorMessageAppear() {
		WebElement errorMessage = driver.findElement(By.cssSelector(".error-message-container"));
        Assert.assertTrue(errorMessage.isDisplayed());
	}

}
