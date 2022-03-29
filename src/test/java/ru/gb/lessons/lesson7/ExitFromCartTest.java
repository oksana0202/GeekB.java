package ru.gb.lessons.lesson7;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.BaseTest;
import ru.gb.lessons.lesson6.pages.MainPage;

import javax.security.auth.login.LoginException;

@DisplayName("Выход из личного кабинета")
public class ExitFromCartTest extends BaseTest {
    public ExitFromCartTest(WebDriver webDriver) {
        super(webDriver);
    }

    @ParameterizedTest(name = "Выход из корзины")
    void ExitFromCart(String ProductName) throws LoginException {
        new MainPage(webDriver)
                .goToPersonalAccount()
                .logout();
    }
}
