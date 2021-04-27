package cucumber;

import drivers.PageManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.*;

import java.time.Duration;

public class CartStepsTest {

    WebDriver driver = CucumberSteps.getInstance().getDriver();
    PageManager pageManager = CucumberSteps.getInstance().getPageManager();
    private static final Logger logger = LogManager.getLogger( CartStepsTest.class.getSimpleName());


    protected WebElement waitToBeVisible(WebElement element, WebDriver driver) {
        WebElement visibleElement = null;
        try {
            visibleElement = new WebDriverWait(driver, Duration.ofSeconds(5))
                    .until(ExpectedConditions.visibilityOf(element));
        } catch (Exception e) {
            System.out.println("Element was not loaded!");
        }
        return visibleElement;
    }

    @Given("^The user opens home page$")
    public void theUserOpensHomePage() {
        pageManager.homePage().open();
    }

    @When("The user clicks on the cart button on main page")
    public void clickOnCartButton() {
        waitToBeVisible(pageManager.homePage().cartButton,driver);
        pageManager.homePage().clickOnTheCartButton();
    }

    @Then("Page with text about cart status is displayed")
    public void CartStatusIsDisplayed() {
        logger.info("Verifying text on page");
        Assert.assertTrue(waitToBeVisible(pageManager.homePage().textOnPage, driver).isDisplayed());
    }

    protected void scrollTo(WebDriver driver, WebElement element) {
        ((JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollIntoView();", element);
    }

    @When("The user searches for {string}")
    public void searchesForProduct(final String searchTerm) {
        pageManager.homePage().searchTerm(searchTerm);
    }

    @Then("The user is redirected to results page")
    public void ResultsPageGlasses() {
        logger.info("Verifying text on page");
        Assert.assertTrue(waitToBeVisible(pageManager.resultsPage().resultsPageText, driver).isDisplayed());
    }

    @When("User adds first item to the cart")
    public void addFirstItemToTheCart() throws InterruptedException {
        pageManager.resultsPage().acceptTheCookies();
        pageManager.resultsPage().acceptCountryCookies();
        waitToBeVisible(pageManager.resultsPage().selectedGlassesProduct,driver);
        pageManager.resultsPage().clickOnTheFirstGlassesProduct();
        waitToBeVisible(pageManager.productPage().addToCart,driver);
        pageManager.productPage().addItemToCart();
    }

    @Then("Cart icon status on the nav bar is changed")
    public void cartIconStatusWithProduct() {
        Assert.assertTrue(waitToBeVisible(pageManager.productPage().cartStatusOnIcon, driver).isDisplayed());
    }
}