package pages;

import config.BrowserLaunch;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class GoogleSearch extends BrowserLaunch {

    private By searchBar = By.name("q");

    public void enterGoogleSearchUrl(String url) {
        driver.get(url);
    }

    public void entersTextInSearchBox(String searchText) {
        driver.findElement(searchBar).sendKeys(searchText);
    }

    public void entersKey() {
        driver.findElement(searchBar).sendKeys(Keys.ENTER);
    }

    public String valiadteResults() {
        System.out.println("Title "+driver.getTitle());
        return driver.getTitle();
    }
}
