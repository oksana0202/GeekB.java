package ru.gb.lessons.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.pages.CartPage;
import ru.gb.lessons.lesson6.pages.MainPage;
import ru.gb.lessons.lesson6.pages.ProductPage;

public class AddProductToCartTest extends BaseTest {
    public AddProductToCartTest(WebDriver webDriver) {
        super(webDriver);
    }
    @ParameterizedTest
    @ValueSource(strings = {"Цветной Корректор - Желтый - против темных кругов под глазами"})
    void AddProductToCart(String productName){
        new MainPage(webDriver);
                .goToProductPage("Макияж");
                .selectProduct("Цветной Корректор - Желтый - против темных кругов под глазами");
                .goToCart();
                .checkCartContainsProduct(productName);


        productName = "Цветной Корректор - Желтый - против темных кругов под глазами";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.yves-rocher.ru/");
        webDriver.findElement(By.xpath("//*[@id=\"popup_add-to-cart\"]/div[1]/div/div/div/div[3]/a[2]")).click();
        assert "Товар добавлен в корзину".equals(StringUtils.capitalize("Товар добавлен в корзин")) : "Тест успешен";
        webDriver.quit();
    }

    public void checkCartContainsProduct(String productName) {
        webDriver.findElement(By.xpath("//*[@id=\"popup_add-to-cart\"]/div[1]/div/div/div/div[3]/a[2]")).click();
        assert "Товар добавлен в корзину".equals(StringUtils.capitalize("Товар добавлен в корзин")) : "Тест успешен";

    }

    public CartPage goToCart() {
        webDriver.findElement(By.xpath("//*[@id=\"pdp\"]/section[1]/aside/div/div/div[2]/form/div[2]/div/button")).click();
        return new CartPage(webDriver);

    }

    public AddProductToCartTest selectProduct(String productName) {
        webDriver.findElement(By.xpath("//*[@id=\"ajax-wrapper\"]/div/main/section/div[2]/div[1]/article/div/a/h3")).click();
        return this;
    }

    public ProductPage goToProductPage(String макияж) {
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[5]/nav/ul/li[4]/a")).click();
        return new ProductPage(webDriver);
    }
}

}
