package ru.gb.lessons.lesson6;

import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.openqa.selenium.By;
import ru.gb.lessons.lesson6.pages.MainPage;

public class ExitFromCartTest extends BaseTest{

    @ParameterizedTest
    void ExitFromCart(String ProductName){
        new MainPage(webDriver);
        .goToPersonalAccount();
        .logout();



        assert "Выход".equals(StringUtils.capitalize("Выход")) : "Вы вышли из личного кабинета";
        webDriver.quit();
    }

    public ExitFromCartTest logout() {
        webDriver.findElement(By.xpath("//*[@id=\"ajax-wrapper\"]/div/div/nav/div/div/div/div/div/div/ul/li[7]/form/button")).click();
        return this;
    }

    public Object goToPersonalAccount(Object MainPage) {
        webDriver.findElement(By.xpath("///*[@id=\"js-modal-page\"]/div[4]/header/div[3]/ul/li[3]")).click();
        return MainPage;
    }
}
}
