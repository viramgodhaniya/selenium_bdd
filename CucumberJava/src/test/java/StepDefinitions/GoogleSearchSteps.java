package StepDefinitions;

import config.BrowserLaunch;
import io.cucumber.java.en.*;
import pages.GoogleSearch;
import static org.junit.Assert.assertEquals;

public class GoogleSearchSteps extends BrowserLaunch{

	GoogleSearch googleSearch = new GoogleSearch();

	@Given("browser window is open")
	public void browser_is_open() {
		if (!driver.toString().isEmpty()) {
			System.out.println("Browser is open");
		}
	}

	@And("hits enter")
	public void hits_enter() throws InterruptedException {
		googleSearch.entersKey();
	}

	@Then("user is navigated to search results")
	public void user_is_navigated_to_search_results() {
		//assertTrue("automation step by step - Google Search", googleSearch.valiadteResults());
		assertEquals("automation step by step - Google Search", googleSearch.valiadteResults());
	}

	@And("user is on google {string} search page")
	public void userIsOnGoogleSearchPage(String googleSearchUrl) {
		googleSearch.enterGoogleSearchUrl(googleSearchUrl);
	}

	@When("user enters {string} text in search box")
	public void userEntersTextInSearchBox(String searchText) {
		googleSearch.entersTextInSearchBox(searchText);
	}
}
