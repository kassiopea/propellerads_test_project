package ru.Yandex;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.remote.BrowserType;
import ru.Yandex.pages.ApplicationManager;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager(BrowserType.FIREFOX);

    @BeforeEach
    public void start(){
        app.init();
    }

    @AfterEach
    public void stop() {
        app.stop();
    }
}

