package pageObject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class SearchResult extends BasePage {

    private static final Logger logger = LogManager.getLogger(SearchResult.class.getSimpleName());

    @FindBy(xpath = "//*[@class='_1c7YnTu' and text()='Your search results for:']")
    public WebElement resultsPageText;

    @FindBy(xpath = "//*[@aria-label='ASOS DESIGN metal aviator fashion glasses in rose gold with clear lens; Price: £12.00']")
    public WebElement selectedGlassesProduct;

    @FindBy(xpath = "//a[@aria-label='Garmin unisex vivoactive 4S 40mm smart watch in grey 010-02172-02; Price: £239.99']")
    public WebElement selectedWatchesProduct;

    @FindBy(xpath = "//button[@type and text()]")
    public WebElement acceptCookiesButton;

    @FindBy(xpath = "//span[@class='_1cZV-7Z -rhP1cz gBrrjX4 _2nHArcS']")
    public WebElement acceptCountryCookiesButton;

    @FindBy(xpath = "//span[@class='heartPrimary']")
    public WebElement saveTheProduct;

    @FindBy(xpath = "//h2[contains(text(),'NOTHING MATCHES YOUR SEARCH')]")
    public WebElement noResultsText;


    public SearchResult (WebDriver driver){
        super(driver);
    }

    @Step("Click on the first item that was listed")
    public SearchResult clickOnTheFirstGlassesProduct() {
        logger.info("Select product from glasses results");
        clickOnElement(waitToBeClickable(selectedGlassesProduct, driver));
        return this;
    }
    @Step("Click on the first item that was listed")
    public SearchResult clickOnTheFirstWatchesProduct() {
        logger.info("Select product from watches results");
        clickOnElement(waitToBeClickable(selectedWatchesProduct, driver));
        return this;
    }

    @Step("Accept cookies on results page")
    public SearchResult acceptTheCookies() {
        logger.info("Accept the cookies on results page");
        clickOnElement(waitToBeClickable(acceptCookiesButton, driver));
        return this;
    }
    @Step("Accept country cookies on results page")
    public SearchResult acceptCountryCookies() {
        logger.info("Accept country the cookies on results page");
        clickOnElement(waitToBeClickable(acceptCountryCookiesButton, driver));
        return this;
    }
    @Step("Click on the save product icon")
    public SearchResult saveTheProductForLater() {
        logger.info("Add product to saved");
        clickOnElement(waitToBeClickable(saveTheProduct, driver));
        return this;
    }
}