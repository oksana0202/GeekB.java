package ru.gb.lessons.lesson6.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.gb.lessons.lesson6.AddProductToCartTest;

public class ProductPage extends BasePage {
    public ProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
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
