package com.digilink.application;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class Checkout {

    private WebDriver driver = Test.driver;

    @FindBy(id = "top-cart-btn-checkout")
    WebElement goToCheckout;

    @FindBy(xpath = "/html/body/div[1]/header/div[2]/div[1]/a")
    WebElement topCartBtn;

    @FindBy(xpath = "//input[contains(@name, \"company\")]")
    WebElement company;

    @FindBy(xpath = "//input[contains(@name, \"street[0]\")]")
    WebElement streetName;

    @FindBy(xpath = "//input[contains(@name, \"street[1]\")]")
    WebElement suburb;

    @FindBy(xpath = "//input[contains(@name, \"city\")]")
    WebElement city;

    @FindBy(xpath = "//select[contains(@name, \"region_id\")]")
    WebElement provinceDropdown;

    @FindBy(xpath = "//input[contains(@name, \"postcode\")]")
    WebElement postalCode;

    @FindBy(xpath = "//select[contains(@name, \"country_id\")]")
    WebElement countryDropdown;

    @FindBy(xpath = "//input[contains(@name, \"telephone\")]")
    WebElement phone;

    @FindBy(xpath = "//*[@id=\"checkout-shipping-method-load\"]/table/tbody/tr[1]/td[1]/input")
    WebElement shippingMethod;

    @FindBy(xpath = "//*[@id=\"shipping-method-buttons-container\"]/div/button/span")
    WebElement nextBtn;

    @FindBy(xpath = "//span[contains(text(), \"Place Order\")] ")
    WebElement placeOrderBtn;

    public void fillForm() throws InterruptedException {
        Thread.sleep(5000);
        company.sendKeys("Digilink");
        Thread.sleep(2000);
        streetName.sendKeys("2 Long Street");
        Thread.sleep(2000);
        suburb.sendKeys("CBD");
        Thread.sleep(2000);
        city.sendKeys("Cape Town");
        Thread.sleep(2000);

        Select select = new Select(provinceDropdown);
        select.selectByVisibleText("California");
        Thread.sleep(2000);

        postalCode.sendKeys("7925");
        Thread.sleep(2000);

        Select selectCountry = new Select(countryDropdown);
        selectCountry.selectByVisibleText("South Africa");
        Thread.sleep(2000);

        phone.sendKeys("0755156211");
        Thread.sleep(2000);

        shippingMethod.click();
        Thread.sleep(2000);

        nextBtn.click();
    }

    public void checkout() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", topCartBtn);
        Thread.sleep(2000);
        topCartBtn.click();
        Thread.sleep(2000);
        goToCheckout.click();
        this.fillForm();
        Thread.sleep(3000);
        placeOrderBtn.click();
    }
}
