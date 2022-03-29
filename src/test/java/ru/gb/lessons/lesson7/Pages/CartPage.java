package ru.gb.lessons.lesson7.Pages;

import org.apache.commons.lang.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.BaseTest;

public class CartPage extends BaseTest {
    private String макияж;
    private String productName;

    public CartPage(WebDriver webDriver) {
        super(webDriver);
    }


    public void checkCartContainsProduct(String productName) {
        this.productName = productName;
        webDriver.findElement(By.xpath("//*[@id=\"popup_add-to-cart\"]/div[1]/div/div/div/div[3]/a[2]")).click();
        if (!"Товар добавлен в корзину".equals(StringUtils.capitalize("Товар добавлен в корзин")))
            throw new AssertionError("Тест успешен");
    }
}