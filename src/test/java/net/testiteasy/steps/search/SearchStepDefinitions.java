package net.testiteasy.steps.search;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.testiteasy.screens.search.SearchScreen;
import net.testiteasy.screens.search.SearchScreenObjectFactory;

// TODO -->
// -- This step for the Search screen should be changed and finished in courses.
// -- You need to think over the logic of using this Search screen.
public class SearchStepDefinitions {

    private final SearchScreen searchScreen = SearchScreenObjectFactory.get();

    @When("user type in search line {string}")
    public void userTypeInSearchLine(String searchInput) {
        searchScreen.clickOnSearchField();
        searchScreen.typeSearchQuery(searchInput);
    }

    @When("user selects search result {string}")
    public void userSelectsSearchResult(String result) {
        searchScreen.selectSearchResult(result);
    }

    @Then("article {string} is opened")
    public void articleIsOpened(String title) {
        searchScreen.checkArticleOpened(title);
    }

    @When("user press back")
    public void userPressBack() {
        searchScreen.pressBack();
    }

    @Then("search results contain {string}")
    public void searchResultsContain(String text) {
        searchScreen.checkSearchResultsContain(text);
    }

    @And("user select first search result {string}")
    public void userSelectFirstSearchResult(String itemText) {
        searchScreen.selectFirstSearchResult(itemText);
    }

    @And("user go back")
    public void userGoBack() {
        searchScreen.clickNavigateUp();
    }
}
