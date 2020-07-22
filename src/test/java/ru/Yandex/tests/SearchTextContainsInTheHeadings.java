package ru.Yandex.tests;

import io.qameta.allure.Description;
import org.junit.Test;
import ru.Yandex.TestBase;

public class SearchTextContainsInTheHeadings extends TestBase {
    String searchText = "propellerads";

    @Description("Проверить наличие искомого слова во всех заголовках выдачи на первой странице")
    @Test
    public void isSearchTextContains() {
        app.goToYandexRu();
        app.getMainPage().toFind(searchText);
        app.getSearchPage().relevantHeadersLinks(searchText);
    }

}
