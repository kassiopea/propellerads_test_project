package ru.Yandex.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage{

    String headersLocator = ".organic__url-text";
    String linkHeadersLocator = "a.link.organic__url";
    String linksLocator = "a.link.link_theme_outer.path__item.i-bem";
    String advertising = "yandex.ru";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @Step
    public void relevantHeadersLinks(String expectedText) {
        List<WebElement> listHeaders = driver.findElements(By.cssSelector(headersLocator));
        List<WebElement> listLinksHeaders = driver.findElements(By.cssSelector(linkHeadersLocator));

        for (int i = 0; i < listLinksHeaders.size(); i++) {

            String currentHref = listLinksHeaders.get(i).getAttribute("href");

            if (!currentHref.contains(advertising)) {
                String currentHeader = listHeaders.get(i).getText().toLowerCase();
                Assert.assertTrue(currentHeader + ". Заголовок не релевантен запросу",
                        currentHeader.contains(expectedText));
            }
        }
    }
    @Step
    public void isUrlPresent(String expectedUrl) {
        List<WebElement> listUrls = driver.findElements(By.cssSelector(linksLocator));

        for (WebElement listUrl : listUrls) {
            String url = listUrl.getAttribute("href");
            if (url.equals(expectedUrl)) {
                return;
            }
        }

    }
}
