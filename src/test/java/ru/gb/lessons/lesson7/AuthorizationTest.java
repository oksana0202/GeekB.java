package ru.gb.lessons.lesson7;

import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.BaseTest;
import ru.gb.lessons.lesson6.pages.MainPage;

@DisplayName("Авторизация")
public class AuthorizationTest extends BaseTest {
    private WebDriver webDriver;
    public AuthorizationTest(WebDriver webDriver) {
        super(webDriver);
    }

    @Test
    @DisplayName("Успешная Авторизация")
    @Description("Успешная авторизация под существующим юзером")
    @Feature("Авторизация на сайте")
    void Authorization() {
        new MainPage(webDriver)
                .login(LOGIN, PASSWORD);
    }
}
