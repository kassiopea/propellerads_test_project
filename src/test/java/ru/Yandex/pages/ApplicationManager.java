package ru.Yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    public WebDriverWait wait;

    private MainPage mainPage;
    private SearchPage searchPage;

    private String browser;

    public ApplicationManager(String browser) {
        this.browser = browser;
    }

    public void init() {
        if (browser.equals(BrowserType.CHROME)){
            driver = new ChromeDriver();
//            for non-standard location
//            options.setBinary("/usr/local/bin/chromedriver");
//            ChromeOptions options = new ChromeOptions();
        }else {
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);

        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);
    }

    public void stop() {
        driver.quit();
    }

    public void goToYandexRu() {
        driver.get("https://yandex.ru/");
        String url = driver.getCurrentUrl();
        Assert.assertEquals("https://yandex.ru/", url);
    }

    public MainPage getMainPage() {
        return mainPage;
    }

    public SearchPage getSearchPage() {
        return searchPage;
    }
}
