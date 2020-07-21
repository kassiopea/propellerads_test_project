package ru.Yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {

        this.driver = driver;
    }

    public void clickToElem(String elemSelector) {

        driver.findElement(By.cssSelector(elemSelector)).click();
    }

    public void titleContains(String searchQuery) {
        Assert.assertTrue(driver.getTitle().contains(searchQuery));
    }

    public void urlContains(String searchQuery) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(searchQuery));
    }

    public void urlEquals(String expectedUrl) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertEquals(currentUrl, expectedUrl);
    }

    public void isElementPresent(String locator) {
        try {
            driver.findElement(By.cssSelector(locator));
        }catch (NoSuchElementException ignored){
        }
    }

    public void isHeaderEquals(String currentHeader, String expectedHeader) {
//        String currentH1 = driver.findElement(By.cssSelector("h1")).getText();
        Assert.assertEquals(currentHeader, expectedHeader);
    }

    public void titleEquals(String expectedTitle) {
        Assert.assertEquals(driver.getTitle(), expectedTitle);
    }

    public void waitVisibilityElement(String locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(locator)));
    }
}
