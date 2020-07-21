package ru.Yandex.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    public WebDriver driver;
    public WebDriverWait wait;

    public static ThreadLocal<WebDriver> lcDriver = new ThreadLocal<>();

    private MainPage mainPage;
    private SearchPage searchPage;

    public void init() {
        if (lcDriver.get() != null) {
            driver = lcDriver.get();
            wait = new WebDriverWait(driver, 30);
            return;
        }

        ChromeOptions options = new ChromeOptions();
//        for non-standard location
//        options.setBinary("/path/to/other/chrome/binary");
        driver = new ChromeDriver(options);
        lcDriver.set(driver);

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);

        mainPage = new MainPage(driver);
        searchPage = new SearchPage(driver);

        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            driver.quit(); driver = null;}));
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
