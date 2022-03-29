package ru.gb.lessons.lesson7.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.gb.lessons.lesson6.pages.BasePage;
import ru.gb.lessons.lesson6.pages.ProductPage;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }

    public ru.gb.lessons.lesson6.pages.MainPage login(String login, String password) {
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[4]/header/div[3]/ul/li[3]")).click();
        WebElement authPopup = webDriver.findElement(By.xpath("//*[@id=\"login\"]"));
        authPopup.findElement(By.name("username")).sendKeys(login);
        authPopup.findElement(By.name("password")).sendKeys(password);
        authPopup.findElement(By.xpath("//*[@id=\"login\"]/div/div[4]/button")).click();
        return new ru.gb.lessons.lesson6.pages.MainPage(webDriver);
    }

    public ProductPage goToProductPage(String макияж) {
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[5]/nav/ul/li[4]/a")).click();
        return new ProductPage(webDriver);
    }

    private ru.gb.lessons.lesson6.pages.MainPage logout() {
        webDriver.findElement(By.xpath("//*[@id=\"ajax-wrapper\"]/div/div/nav/div/div/div/div/div/div/ul/li[7]/form/button")).click();
        return new ru.gb.lessons.lesson6.pages.MainPage(webDriver);
    }
}
