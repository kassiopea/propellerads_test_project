package ru.Yandex.pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;

public class BasePage {
    public WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    public void clickToElem(String elemSelector) {
        driver.findElement(By.cssSelector(elemSelector)).click();
    }
    @Step
    public void titleContains(String searchQuery) {
        Assert.assertTrue(driver.getTitle().contains(searchQuery));
    }

    @Step
    public void urlContains(String searchQuery) {
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue(currentUrl.contains(searchQuery));
    }

    @Step
    public void isElementPresent(String locator) {
        try {
            driver.findElement(By.cssSelector(locator));
        }catch (NoSuchElementException ignored){
        }
    }
}
