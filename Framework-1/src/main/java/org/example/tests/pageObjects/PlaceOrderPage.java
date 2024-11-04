package org.example.tests.pageObjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlaceOrderPage extends AbstractComponent {
    WebDriver driver;
    public PlaceOrderPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "input[placeholder='Select Country']")
    WebElement country;

    @FindBy(xpath = "//button[contains(@class,'ta-item')][2]")
    WebElement desiredCountry;

    @FindBy(css = ".btnn.action__submit.ng-star-inserted")
     WebElement placeOrderBtn;

    @FindBy(css = ".hero-primary")
    WebElement orderPlacedMsg;

    By countryList = By.cssSelector(".ta-results");
    public void enterCountryName(String countryName){
        Actions a = new Actions(driver);
        a.sendKeys(country, countryName).build().perform();
    }

    public void selectCountry(){
        scrollWindowBy(1011, 600);
        waitForElementToAppear(countryList);
        desiredCountry.click();
    }

    public void placeOrder(){
        placeOrderBtn.click();
    }

    public String verifyOrderPlacedMsg(){
        String msg = orderPlacedMsg.getText();
        return msg;
    }

}
