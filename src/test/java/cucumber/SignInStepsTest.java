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

public class SignInStepsTest {

    WebDriver driver = CucumberSteps.getInstance().getDriver();
    PageManager pageManager = CucumberSteps.getInstance().getPageManager();
    private static final Logger logger = LogManager.getLogger( SignInStepsTest.class.getSimpleName());


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

    @When("User clicks on the my account button")
    public void clickOnTheMyAccountButton() {
        logger.info("Verifying text on page");
        waitToBeVisible(pageManager.homePage().myAccountIcon,driver);
        pageManager.homePage().clickOnMyAccountIcon();
    }

    @And("User select My Account from drop down list")
    public void selectMyAccount() {
        logger.info("Verifying text on page");
        waitToBeVisible(pageManager.homePage().myAccountFromDropDown,driver);
        pageManager.homePage().clickOnMyAccountToSignIn();
    }

    @Then("User is redirected to the sign in form")
    public void checkSignInFormText() {
        logger.info("Verifying text on page");
        Assert.assertTrue(waitToBeVisible(pageManager.signIn().sigInPageText, driver).isDisplayed());
    }

    @When("User try to sign in by empty form")
    public void sendEmptySignInForm() {
        logger.info("Sending empty sign in form");
        waitToBeVisible(pageManager.signIn().sigInFormButton,driver);
        pageManager.signIn().clickOnThSignInFormPageButton();
    }

    @Then("The error message is visible about empty fields")
    public void checkErrorMessageAboutEmptyFields() {
        logger.info("Verifying text on page");
        Assert.assertTrue(waitToBeVisible(pageManager.signIn().signInFormError, driver).isDisplayed());
    }
}