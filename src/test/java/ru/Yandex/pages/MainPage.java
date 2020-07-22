package ru.Yandex.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage{

    String inputSearchSelector = "input#text.input__control.input__input.mini-suggest__input";
    String submitToSearch = ".button_theme_websearch";
    String listLocator = ".serp-list_left_yes";

    public MainPage(WebDriver driver) {

        super(driver);
    }
    @Step
    public void toFind(String searchQuery) {
        WebElement inputSearch = driver.findElement(By.cssSelector(inputSearchSelector));
        inputSearch.click();
        inputSearch.clear();
        inputSearch.sendKeys(searchQuery);
        clickToElem(submitToSearch);
        isElementPresent(listLocator);
    }

}
