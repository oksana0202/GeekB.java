package ru.gb.lessons.lesson7;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.BaseTest;
import ru.gb.lessons.lesson6.pages.MainPage;
import ru.gb.lessons.lesson6.pages.ProductPage;

@DisplayName("Корзина")
public class AddProductToCartTest extends BaseTest {
    public AddProductToCartTest(WebDriver webDriver) {
        super(webDriver);
    }
    @ValueSource(strings = {"Цветной Корректор - Желтый - против темных кругов под глазами"})
    @ParameterizedTest(name = "Добавление товара {0} в корзину")
    @DisplayName("Добавление товара в корзину")
    void AddProductToCart(String productName) {
        Allure.parameter("Название продукта", productName);
        new MainPage(webDriver);
                .goToProductPage("Макияж")
                .selectProduct("Цветной Корректор - Желтый - против темных кругов под глазами")
                .goToCart()
                .checkCartContainsProduct(productName);
    }
    @Test
    @DisplayName("Переход на страницу продукта")
    public ProductPage goToProductPage(String макияж) {
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[5]/nav/ul/li[4]/a")).click();
        return new ProductPage(webDriver);
    }
}


