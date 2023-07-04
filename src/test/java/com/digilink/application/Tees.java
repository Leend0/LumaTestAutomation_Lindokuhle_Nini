package com.digilink.application;

import dev.failsafe.internal.util.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import static org.testng.Assert.assertTrue;

public class Tees {

    private WebDriver driver = Test.driver;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]/div/a/span/span/img")
    WebElement threeStartTee;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[3]/ol/li[3]/div/div/div[4]/div/div[1]/form/button/span")
    WebElement addToCartBtn;

    @FindBy(xpath = "//div[contains(text(), 'You need to choose options for your item.')]")
    WebElement warningText;

    public void addToCart() throws InterruptedException {
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", threeStartTee);
        Thread.sleep(2000);
        actions.moveToElement(threeStartTee).perform();
        Thread.sleep(2000);
        addToCartBtn.click();
        Thread.sleep(6000);
        assertTrue(warningText.isDisplayed());
    }
}
