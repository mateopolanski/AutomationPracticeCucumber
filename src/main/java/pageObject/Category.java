package pageObject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Category extends BasePage {

    private static final Logger logger = LogManager.getLogger(Category.class.getSimpleName());

    @FindBy(xpath = "//span[text()='New In']")
    public WebElement newInMarketplace;

    @FindBy(xpath = "//a[contains(text(),'View all')]")
    public WebElement viewAllInMarketplace;

    @FindBy(xpath = "//h1[contains(text(),'NEW IN')]")
    public WebElement categoryPageMarketplaceText;


    public Category (WebDriver driver) {
        super(driver);
    }

    @Step("Go to New In on category page")
    public Category clickOnNewInCategory() {
        logger.info("Click on the New In category");
        newInMarketplace.click();
        return this;
    }
    @Step("View All subcategory on category page")
    public Category clickOnViewAllMarketplace() {
        logger.info("Click on the View All Subcategory");
        viewAllInMarketplace.click();
        return this;
    }
}