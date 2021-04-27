package pageObject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {

    private static final String HOME_PAGE_URL = "https://www.asos.com/";
    private static final Logger logger = LogManager.getLogger(HomePage.class.getSimpleName());

    @FindBy(xpath = "//*[@data-testid='miniBagIcon' and @aria-label='Bag 0 items']")
    public WebElement cartButton;

    @FindBy(xpath = "//*[@class='empty-bag-title' and text()='Your bag is empty']")
    public WebElement textOnPage;

    @FindBy(xpath = "//a[@href='https://marketplace.asos.com?ctaref=Global%20nav']")
    public WebElement marketplaceButton;

    @FindBy(xpath = "//input[@type='search']")
    public WebElement searchField;

    @FindBy(xpath = "//*[@type='button' and @aria-label='My Account']")
    public WebElement myAccountIcon;

    @FindBy(xpath = "//*[@data-testid='myaccount-link' and text()='My Account']")
    public WebElement myAccountFromDropDown;

    public HomePage(WebDriver driver){
        super(driver);
    }

    @Step("Navigate to home page")
    public HomePage open() {
        logger.info("Navigate to home page");
        openWebPage(HOME_PAGE_URL);
        return this;
    }
    @Step("Click on the cart button")
    public HomePage clickOnTheCartButton() {
        logger.info("Click on the cart button");
        cartButton.click();
        return this;
    }
    @Step("Search the product")
    public HomePage searchTerm(String searchTerm) {
        logger.info("Search the product");
        enterTextIntoField(searchField, searchTerm);
        pressKey(Keys.ENTER);
        return this;
    }
    @Step("Click on the my account icon on nav bar")
    public HomePage clickOnMyAccountIcon() {
        logger.info("Click on the my account icon on nav bar");
        myAccountIcon.click();
        return this;
    }
    @Step("Click on the my account icon")
    public HomePage clickOnMyAccountToSignIn() {
        logger.info("Click on the my account icon on list to sign in");
        myAccountFromDropDown.click();
        return this;
    }
    @Step("Go to the Marketplace")
    public HomePage clickOnMarketplaceButton() {
        logger.info("Click on the marketplace button on the home page");
        marketplaceButton.click();
        return this;
    }
}