package ru.Yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class SearchPage extends BasePage{

    String headersLocator = ".organic__url-text";
    String linkHeadersLocator = "a.link.organic__url";
    String linksLocator = "a.link.link_theme_outer.path__item.i-bem";
    String advertising = "yandex.ru";

    String h1Locator = "h1.vc_custom_heading.head-tagline";

    public SearchPage(WebDriver driver) {
        super(driver);
    }

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

    public void isUrlPresent(String expectedUrl) {
        List<WebElement> listUrls = driver.findElements(By.cssSelector(linksLocator));

        for (WebElement listUrl : listUrls) {
            String url = listUrl.getAttribute("href");
            if (url.equals(expectedUrl)) {
                return;
            }
        }
    }

    public void goToTheSite(String expectedUrl) {
        List<WebElement> listUrls = driver.findElements(By.cssSelector(linksLocator));

        for (WebElement listUrl : listUrls) {
            String url = listUrl.getAttribute("href");
            if (url.equals(expectedUrl)) {
                listUrl.click();

                ArrayList<String> tabs2 = new ArrayList<String> (driver.getWindowHandles());
                driver.switchTo().window(tabs2.get(1));
//                String header = driver.findElement(By.cssSelector(h1Locator)).getText();
//                System.out.println(header);
//                wait.until(ExpectedConditions.visibilityOfElementLocated((By.cssSelector(h1Locator))));
                String currentHeader  = driver.findElement(By.cssSelector(h1Locator)).getText();

                isHeaderEquals(currentHeader,"Built for Performance");
//                WebElement header = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(h1Locator)));
//                isHeaderEquals(header.getText(), "Built for Performance");
            }
        }

    }
}
