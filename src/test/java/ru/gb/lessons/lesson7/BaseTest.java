package ru.gb.lessons.lesson7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseTest {
    protected WebDriver webDriver;
    public final String LOGIN = "test.testovich.88@list.ru";
    public final String PASSWORD = "Parol-2222";
    public BaseTest(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @BeforeEach
    void setUp() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--blink-setting=imagesEnabled=false");
        webDriver = WebDriverManager.chromedriver().capabilities(chromeOptions).create();
        webDriver.get("https://www.yves-rocher.ru/");
        String productName = "Цветной Корректор - Желтый - против темных кругов под глазами";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.yves-rocher.ru/");
        webDriver.findElement(By.xpath("//*[@id=\"popup_add-to-cart\"]/div[1]/div/div/div/div[3]/a[2]")).click();
        if (!"Товар добавлен в корзину".equals(StringUtils.capitalize("Товар добавлен в корзин")))
            throw new AssertionError("Тест успешен");
        webDriver.quit();
    }
    @AfterEach
    void tearDown(){
        webDriver.quit();
    }
}
