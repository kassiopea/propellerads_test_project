package ru.Yandex.tests;
import org.junit.Test;
import ru.Yandex.TestBase;


public class RelevantIssueOutput extends TestBase {

    String searchText = "propellerads";
    String expectedUrl = "https://propellerads.com/";

    @Test
    public void getEqualsUrlForTheList() {
        app.goToYandexRu();
        app.getMainPage().toFind(searchText);
        app.getSearchPage().urlContains(searchText);
        app.getSearchPage().titleContains(searchText);
        app.getSearchPage().isUrlPresent(expectedUrl);
    }


}
