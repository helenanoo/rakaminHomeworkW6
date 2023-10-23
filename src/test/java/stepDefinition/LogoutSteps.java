package stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.And;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LogoutSteps {
	private WebDriver driver;
	
	@Given("The user is login")
	public void userisLoggedIn() {
		WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
	}
	
	@When("The user clicks on the logout option")
	public void userClicksLogout() {
        WebElement menuButton = driver.findElement(By.id("react-burger-menu-btn"));
        WebElement logout = driver.findElement(By.xpath("//a[@id='logout_sidebar_link']"));
        menuButton.click();
        Actions s = new Actions(driver);
        s.moveToElement(menuButton);
        s.click(logout);
        s.build().perform();
    }
	
	@And("The user go to the inventory page")
	public void openInventoryPage() {
		driver.get("https://www.saucedemo.com/inventory.html");
	}
	
	@Then("The user should be logged out")
	public void userLoggedOut() {
		boolean isLoginPageDisplayed = driver.findElement(By.id("login-button")).isDisplayed();
		assert isLoginPageDisplayed : "User is not logged out";
		driver.quit();
	}
	
	@Then("The user should get the error message")
	public void userShouldGetErrorMessage() {
		WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertTrue(errorElement.isDisplayed());
        driver.quit();
	}

}
