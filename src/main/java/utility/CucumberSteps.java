package utility;

import drivers.PageManager;
import org.openqa.selenium.WebDriver;

public class CucumberSteps {
    private static CucumberSteps instance;
    protected static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    PageManager pageManager;

    private CucumberSteps() {
    }

    public static CucumberSteps getInstance() {
        if (instance == null)
            instance = new CucumberSteps();
        return instance;
    }

    public WebDriver getDriver() {
        return driver.get();
    }

    public void setDriver(WebDriver driver) {
        CucumberSteps.driver.set(driver);
    }

    public PageManager getPageManager() {
        return pageManager;
    }

    public void setPageManager(PageManager pageManager) {
        this.pageManager = pageManager;
    }
}
