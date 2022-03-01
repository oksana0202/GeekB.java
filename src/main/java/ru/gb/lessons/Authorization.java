package ru.gb.lessons;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;

public class Authorization
{
    public static void main( String[] args ) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");

        WebDriver webDriver = WebDriverManager.chromedriver().create();
        webDriver.get("https://www.yves-rocher.ru/");
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        webDriver.findElement(By.xpath("//*[@id=\"js-modal-page\"]/div[4]/header/div[3]/ul/li[3]")).click();
        WebElement authPopup = webDriver.findElement(By.xpath("//*[@id=\"login\"]"));
        webDriver.findElement(By.name("username")).sendKeys("test.testovich.88@list.ru");
        webDriver.findElement(By.name("password")).sendKeys("Parol-2222");
        webDriver.findElement(By.xpath("//*[@id=\"login\"]/div/div[4]/button")).click();

        webDriver.quit();

    }
}
