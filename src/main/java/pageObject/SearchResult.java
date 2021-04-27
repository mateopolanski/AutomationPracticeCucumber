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

    @FindBy(xpath = "//a[@aria-label=\"Tommy Hilfiger leather mini wallet with coin and cardholder pockets with logo in black; Price: £50.00\"]/div[1]/img")
    public WebElement selectedWalletProduct;

    @FindBy(xpath = "//p[text()=\"Levi's oversized utility denim jacket in black\"]")
    public WebElement selectedJacketProduct;

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

    @Step("Click on the item that was listed")
    public SearchResult clickOnTheFirstWalletProduct() {
        logger.info("Select product from wallet results");
        clickOnElement(waitToBeClickable(selectedWalletProduct, driver));
        return this;
    }
    @Step("Click on the item that was listed")
    public SearchResult clickOnTheFirstJacketProduct() {
        logger.info("Select product from watches results");
        clickOnElement(waitToBeClickable(selectedJacketProduct, driver));
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