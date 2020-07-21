package ru.Yandex.tests;

import org.junit.Test;
import ru.Yandex.TestBase;

public class SearchTextContainsInTheHeadings extends TestBase {
    String searchText = "propellerads";

    @Test
    public void isSearchTextContains() {
        app.goToYandexRu();
        app.getMainPage().toFind(searchText);
        app.getSearchPage().relevantHeadersLinks(searchText);
    }

}
