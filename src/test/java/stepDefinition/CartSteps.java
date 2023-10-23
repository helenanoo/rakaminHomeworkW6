package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CartSteps {
	private WebDriver driver;
	
	@Given("User login")
	public void userisLoggedIn() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
	}
	
	
	@When("The user adds an item to the cart")
	public void userAddtoCart() {
		WebElement addToCartButton = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']"));
        addToCartButton.click();
        WebElement addToCartButton1 = driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']"));
        addToCartButton1.click();
	}
	
	@And("The user removes an item from the cart")
	public void userRemovefromCart() {
		WebElement cart = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a[1]"));
        cart.click();
        WebElement removeProduct = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        removeProduct.click();
	}
	
	@When("The user navigates to the cart page")
	public void userNavigateToCart() {
		WebElement carts = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a[1]"));
        carts.click();
	}
	
	@And("The user click checkout button")
	public void userClickCheckoutButton() {
		WebElement checkout = driver.findElement(By.id("checkout"));
        checkout.click();
	}
	
	@Then("The cart should contain the added item")
	public void cartShouldCountainAddedItem() {
		WebElement cartPage = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a[1]"));
        cartPage.click();
        driver.quit();
	}
	
	@Then("The product should be remove from the cart")
	public void productShouldbeRemoved() {
		WebElement cart = driver.findElement(By.xpath("//div[@id='shopping_cart_container']/a[1]"));
        cart.click();
        driver.quit();
	}
	
	@Then("The error message should appear")
	public void errorMessageShouldAppear() {
		driver.quit();
	}
}
