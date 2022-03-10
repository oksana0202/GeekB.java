package ru.gb.lessons.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;
import static org.assertj.core.api.Assertions.assertThat;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AuthorizationTest {

    @Test
    void Authorization() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.yves-rocher.ru/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[4]/header/div[3]/ul/li[3]")).click();
        WebElement authPopup = webDriver.findElement(By.xpath("//*[@id=\"login\"]"));
        authPopup.findElement(By.name("username")).sendKeys("test.testovich.88@list.ru");
        authPopup.findElement(By.name("password")).sendKeys("Parol-2222");
        authPopup.findElement(By.xpath("//*[@id=\"login\"]/div/div[4]/button")).click();
        webDriver.quit();

    }

    @Test
    void IncorrectPasswordTest() {
        System.setProperty("webDriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.yves-rocher.ru/");
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[4]/header/div[3]/ul/li[3]")).click();
        WebElement authPopup = webDriver.findElement(By.xpath("//*[@id=\"login\"]"));
        authPopup.findElement(By.name("username")).sendKeys("test.testovich.88@list.ru");
        authPopup.findElement(By.name("password")).sendKeys("incorrect_password");
        authPopup.findElement(By.xpath("//*[@id=\"login\"]/div/div[4]/button")).click();
        assertThat(new WebDriverWait(webDriver,5).until(ExpectedConditions.presenceOfElementLocated)(By.xpath("//*[@class=\"p-t_S bold\"]")))
            .getText()).isEqualTo("Email не зарегистрирован или пароль содержит ошибки");
        // так этот метод и не нашелся в библиотеке

        webDriver.quit();
    }
}





