package ru.Yandex.tests;
import org.junit.Test;
import ru.Yandex.TestBase;

public class CurrentSiteFromOutput extends TestBase{
    String searchText = "propellerads";
    String expectedUrl = "https://propellerads.com/";
    String expectedHeader = "Built for Performance";
    String expectedTitleSite = "PropellerAds - Display and Mobile Advertising Network";

    @Test
    public void getCurrentSiteFromOutput() {
        app.goToYandexRu();
        app.getMainPage().toFind(searchText);

        app.getSearchPage().goToTheSite(expectedUrl);
//        app.getSearchPage().urlEquals(expectedUrl);
//        app.getSearchPage().isHeaderEquals(expectedHeader);
//        app.getSearchPage().titleEquals(expectedTitleSite);
//        app.getSearchPage().isHeaderEquals(expectedHeader);
    }
}
