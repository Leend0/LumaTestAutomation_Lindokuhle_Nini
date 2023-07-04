package com.digilink.application;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Hoodies {

    private WebDriver driver = Test.driver;

    @FindBy(xpath = "//*[@id=\"search\"]")
    WebElement searchBar;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/a/span/span/img")
    WebElement hoodie;

    @FindBy(xpath = "//*[@id=\"maincontent\"]/div[3]/div[1]/div[2]/div[2]/ol/li[1]/div/div/div[4]/div/div[1]/form/button/span")
    WebElement addToCartBtn;

    @FindBy(id = "product-addtocart-button")
    WebElement addToCartBtn2;

    @FindBy(xpath = "//*[@id=\"option-label-size-143-item-167\"]")
    WebElement sizeSmall;

    @FindBy(xpath = "//*[@id=\"option-label-color-93-item-56\"]")
    WebElement color;

    public void searchProduct() throws InterruptedException {
        searchBar.click();
        Thread.sleep(2000);
        searchBar.sendKeys("Miko Pullover Hoodie");
        Thread.sleep(2000);
        searchBar.submit();
        Thread.sleep(2000);
    }

    public void addToCart() throws InterruptedException {
        Actions actions = new Actions(driver);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", hoodie);
        Thread.sleep(2000);
        actions.moveToElement(hoodie).perform();
        Thread.sleep(5000);
        sizeSmall.click();
        Thread.sleep(5000);
        color.click();
        Thread.sleep(2000);
        addToCartBtn.click();
    }

}
