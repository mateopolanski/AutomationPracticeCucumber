package pageObject;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AddToFavourites extends BasePage {

    private static final Logger logger = LogManager.getLogger(AddToFavourites.class.getSimpleName());

    @FindBy(xpath = "//select[@id='sortBy' and @aria-label='Sort by']")
    public WebElement savedProductsSortBy;

    @FindBy(xpath = "//*[@class='noItemsPrompt_1TiQf' and text()='You have no Saved Items']")
    public WebElement savedProductsSectionEmpty;

    public AddToFavourites(WebDriver driver){
        super(driver);
    }
}