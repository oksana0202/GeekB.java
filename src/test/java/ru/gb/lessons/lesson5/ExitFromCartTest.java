package ru.gb.lessons.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.util.concurrent.TimeUnit;

public class ExitFromCartTest {

    @Test
    void ExitFromCart(){
            System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

            WebDriver webDriver = WebDriverManager.chromedriver().create();
            webDriver.get("https://www.yves-rocher.ru/");
            webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[4]/header/div[3]/ul/li[3]")).click();
            webDriver.findElement(By.xpath("//*[@id=\"ajax-wrapper\"]/div/div/nav/div/div/div/div/div/div/ul/li[7]/form/button")).click();
            assert "Выход".equals(StringUtils.capitalize("Выход")) : "Вы вышли из личного кабинета";

            webDriver.quit();

        }
}
