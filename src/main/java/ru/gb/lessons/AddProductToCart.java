package ru.gb.lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

public class AddProductToCart {
    public static void main(String[] args) {
        String productName = "Цветной Корректор - Желтый - против темных кругов под глазами";
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.yves-rocher.ru/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[5]/nav/ul/li[4]")).click();
        webDriver.findElement(By.xpath("//*[@id=\"ajax-wrapper\"]/div/main/section/div[2]/div[1]/article/div/a/h3")).click();
        webDriver.findElement(By.xpath("//*[@id=\"pdp\"]/section[1]/aside/div/div/div[2]/form/div[2]/div/button")).click();
        webDriver.findElement(By.xpath("//*[@id=\"popup_add-to-cart\"]/div[1]/div/div/div/div[3]/a[2]")).click();
        webDriver.quit();
    }
}

