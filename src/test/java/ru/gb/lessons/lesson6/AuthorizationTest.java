package ru.gb.lessons.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.pages.MainPage;

public class AuthorizationTest extends BaseTest{
    public AuthorizationTest(WebDriver webDriver) {
        super(webDriver);
    }

    @Test
    void Authorization() {
        new MainPage(webDriver)
        .login(LOGIN, PASSWORD);
    }
}