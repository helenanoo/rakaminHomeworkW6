package stepDefinition;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.junit.Assert;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    private WebDriver driver;

    @Given("the user is on the saucedemo login page")
    public void navigateToSaucedemoLoginPage() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
    }

    @When("the user enters valid username and password")
    public void enterValidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }
    
    @When("the user enters invalid username and password")
    public void enterInvalidCredentials() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secreat_sauce");
    }
    
    @When("clicks the login button")
    public void clickLoginButton() {
        driver.findElement(By.id("login-button")).click();
    }

    @Then("the user should be logged in")
    public void verifyLogin() {
    	Assert.assertTrue(driver.getCurrentUrl().contains("inventory.html"));
    	driver.quit();
    }
    
    @Then("the user should see an error message")
    public void verifyUnsuccessfulLogin() {
        WebElement errorElement = driver.findElement(By.cssSelector("h3[data-test='error']"));
        Assert.assertTrue(errorElement.isDisplayed());
        driver.quit();
    }
}
