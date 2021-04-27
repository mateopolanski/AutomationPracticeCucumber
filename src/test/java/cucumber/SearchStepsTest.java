package cucumber;

import drivers.PageManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utility.*;

import java.time.Duration;

public class SearchStepsTest {

    WebDriver driver = CucumberSteps.getInstance().getDriver();
    PageManager pageManager = CucumberSteps.getInstance().getPageManager();
    private static final Logger logger = LogManager.getLogger( SearchStepsTest.class.getSimpleName());


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


    @Then("The user is redirected to page with results for search")
    public void pageWithResultsForSearchText() {
        logger.info("Verifying text on page");
        Assert.assertTrue(waitToBeVisible(pageManager.resultsPage().resultsPageText, driver).isDisplayed());
    }

    @Then("The user save the product")
    public void saveTheProduct() {
        logger.info("Verifying text on page");
        waitToBeVisible(pageManager.resultsPage().saveTheProduct,driver);
        pageManager.resultsPage().saveTheProductForLater();
    }

    @When("The user go to saved products")
    public void clickOnSavedProducts() {
        logger.info("Verifying text on page");
        waitToBeVisible(pageManager.productPage().savedProductsIcon,driver);
        pageManager.productPage().goToSavedProducts();
    }

    @Then("The user is redirected to page with saved products")
    public void PageWithSavedProductsStatus() {
        logger.info("Verifying text on page");
        Assert.assertTrue(waitToBeVisible(pageManager.addToFavourites().savedProductsSortBy, driver).isDisplayed());
    }

    @And("The user go to the first product page")
    public void goToTheFirstProductPage() {
        logger.info("Verifying text on page");
        pageManager.resultsPage().acceptTheCookies();
        pageManager.resultsPage().acceptCountryCookies();
        waitToBeVisible(pageManager.resultsPage().selectedWalletProduct,driver);
        pageManager.resultsPage().clickOnTheFirstWalletProduct();
    }

    @And("The user go to the first product from watches result page")
    public void goToTheFirstProductFromJacketsResultPage() {
        logger.info("Verifying text on page");
        pageManager.resultsPage().acceptTheCookies();
        pageManager.resultsPage().acceptCountryCookies();
        waitToBeVisible(pageManager.resultsPage().selectedJacketProduct,driver);
        pageManager.resultsPage().clickOnTheFirstJacketProduct();
    }

    @When("The user delete the products from saved")
    public void deleteTheProductsFromSaved() {
        logger.info("Verifying text on page");
        waitToBeVisible(pageManager.productPage().deleteFromSavedProducts,driver);
        pageManager.productPage().deleteProductFromSaved();
    }

    @Then("There the saved section is empty")
    public void savedSectionEmptyText() {
        logger.info("Verifying text on page");
        Assert.assertTrue(waitToBeVisible(pageManager.addToFavourites().savedProductsSectionEmpty, driver).isDisplayed());
    }

    @Then("Search form can handle special character and no results message is visible")
    public void NoResultsPageText() {
        logger.info("Verifying text on page");
        Assert.assertTrue(waitToBeVisible(pageManager.resultsPage().noResultsText, driver).isDisplayed());
    }

    @When("The user navigate to Marketplace")
    public void navigateToMarketplace() {
        logger.info("Verifying text on page");
        pageManager.resultsPage().acceptTheCookies();
        waitToBeVisible(pageManager.homePage().marketplaceButton,driver);
        pageManager.homePage().clickOnMarketplaceButton();
    }

    @And("The user select the category and subcategory")
    public void selectTheCategoryAndSubcategory() {
        logger.info("Verifying text on page");
        waitToBeVisible(pageManager.categoryPage().newInMarketplace,driver);
        pageManager.categoryPage().clickOnNewInCategory();
        waitToBeVisible(pageManager.categoryPage().viewAllInMarketplace,driver);
        pageManager.categoryPage().clickOnViewAllMarketplace();
    }

    @Then("The user is redirected to page with results for Marketplace")
    public void pageWithResultsForMarketplaceSearchText() {
        logger.info("Verifying text on page");
        Assert.assertTrue(waitToBeVisible(pageManager.categoryPage().categoryPageMarketplaceText, driver).isDisplayed());
    }
}