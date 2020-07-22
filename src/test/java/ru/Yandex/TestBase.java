package ru.Yandex;

import org.junit.After;
import org.junit.jupiter.api.BeforeEach;
import ru.Yandex.pages.ApplicationManager;

public class TestBase {
    protected final ApplicationManager app = new ApplicationManager();

    @BeforeEach
    public void start() throws Exception{
        app.init();
    }

    @After
    public void stop() {
        app.stop();
    }
    public ApplicationManager getApp() {
        return app;
    }
}

