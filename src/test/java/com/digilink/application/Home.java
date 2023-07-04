package com.digilink.application;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class Home {

    private WebDriver driver = Test.driver;

    @FindBy(xpath = "//span[contains(text(), 'Men')]")
    WebElement menCategory;

    @FindBy(xpath = "//*[@id=\"ui-id-17\"]/span[2]")
    WebElement topsCategory;

    @FindBy(xpath = "//*[@id=\"ui-id-21\"]/span")
    WebElement teesCategory;

    public void navigateToTees() throws InterruptedException {
        Actions actions = new Actions(driver);
        Thread.sleep(2000);
        actions.moveToElement(menCategory).perform();
        Thread.sleep(2000);
        actions.moveToElement(topsCategory).perform();
        Thread.sleep(2000);
        teesCategory.click();
    }

}
