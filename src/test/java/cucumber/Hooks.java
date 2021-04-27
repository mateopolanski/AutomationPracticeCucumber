package cucumber;

import drivers.DriverManager;
import drivers.PageManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import utility.*;

public class Hooks {

    @Before
    public void setup() {
        CucumberSteps.getInstance().setDriver(DriverManager.getDriver("Chrome"));
        CucumberSteps.getInstance().setPageManager(new PageManager(CucumberSteps.getInstance().getDriver()));
    }

    @After
    public void cleanUp() {
        CucumberSteps.getInstance().getDriver().quit();
    }
}