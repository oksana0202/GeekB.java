package ru.gb.lessons.lesson7.Pages;

import org.openqa.selenium.WebDriver;

public class BasePages {
    protected WebDriver webDriver;

    public BasePages(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
}