package pageObject;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignIn extends BasePage {

    private static final Logger logger = LogManager.getLogger(SignIn.class.getSimpleName());

    @FindBy(xpath = "//div[contains(text(),'Sign in')]")
    public WebElement sigInPageText;

    @FindBy(xpath = "//input[@value='Sign in' and @id='signin']")
    public WebElement sigInFormButton;

    @FindBy(xpath = "//span[@id='EmailAddress-error']")
    public WebElement signInFormError;


    public SignIn(WebDriver driver) {
        super(driver);
    }

    @Step("Submit the sign in form")
    public SignIn clickOnThSignInFormPageButton() {
        logger.info("Click on the sign in button");
        sigInFormButton.click();
        return this;
    }
}