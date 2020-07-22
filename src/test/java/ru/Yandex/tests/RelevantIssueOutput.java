package ru.Yandex.tests;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Test;
import ru.Yandex.TestBase;


public class RelevantIssueOutput extends TestBase {

    String searchText = "propellerads";
    String expectedUrl = "https://propellerads.com/";

//    @Step
    @Description("Проверить, что в выдаче есть искомое слово")
    @Test
    public void getEqualsUrlForTheList() {
        app.goToYandexRu();
        app.getMainPage().toFind(searchText);
        app.getSearchPage().urlContains(searchText);
        app.getSearchPage().titleContains(searchText);
        app.getSearchPage().isUrlPresent(expectedUrl);
    }
}
