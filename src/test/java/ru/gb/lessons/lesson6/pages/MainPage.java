package ru.gb.lessons.lesson6.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MainPage extends BasePage {
    public MainPage(WebDriver webDriver) {
        super(webDriver);
    }
    public MainPage login(String login, String password){
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[4]/header/div[3]/ul/li[3]")).click();
        WebElement authPopup = webDriver.findElement(By.xpath("//*[@id=\"login\"]"));
        authPopup.findElement(By.name("username")).sendKeys(login);
        authPopup.findElement(By.name("password")).sendKeys(password);
        authPopup.findElement(By.xpath("//*[@id=\"login\"]/div/div[4]/button")).click();
        return new MainPage(webDriver);
    }
}
