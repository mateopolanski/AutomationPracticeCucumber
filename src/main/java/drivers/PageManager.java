package drivers;

import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PageManager {

    public WebDriver driver;
    private HomePage homePage;
    private Product product;
    private SearchResult searchResult;
    private Category category;
    private AddToFavourites addToFavourites;
    private SignIn signIn;

    public PageManager(WebDriver driver) {
        this.driver = driver;
    }

    public HomePage homePage() {
        if (homePage == null)
            homePage = new HomePage(driver);
        return homePage;
    }

    public Product productPage() {
        if (product == null)
            product = new Product(driver);
        return product;
    }

    public SearchResult resultsPage() {
        if (searchResult == null)
            searchResult = new SearchResult(driver);
        return searchResult;
    }

    public Category categoryPage() {
        if (category == null)
            category = new Category(driver);
        return category;
    }
    public AddToFavourites addToFavourites() {
        if (addToFavourites == null)
            addToFavourites = new AddToFavourites(driver);
        return addToFavourites;
    }

    public SignIn signIn() {
        if (signIn == null)
            signIn = new SignIn(driver);
        return signIn;
    }

}