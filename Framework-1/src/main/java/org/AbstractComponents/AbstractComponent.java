package org.AbstractComponents;

import org.example.tests.pageObjects.OrderPage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AbstractComponent {
    WebDriver driver;
    WebDriverWait wait;
    JavascriptExecutor js;
    public AbstractComponent(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        js = (JavascriptExecutor) driver;
    }

    @FindBy(css = "[routerlink*='cart']")
    WebElement cartBtn;

    @FindBy(css = "[routerlink*='myorders']")
    WebElement orderHistoryPage;
    public void waitForElementToAppear(By findBy){
        wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
    }

    public void waitForWebElementToAppear(WebElement ele){
        wait.until(ExpectedConditions.visibilityOf(ele));
    }
    public void waitForElementToDisappear(WebElement element){
        wait.until(ExpectedConditions.invisibilityOf(element));
    }

    public void scrollWindowBy(int x, int y){
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    public void landOnCheckoutPage(){
        cartBtn.click();
    }

    public OrderPage landOnOrdersPage(){
        orderHistoryPage.click();
        OrderPage orderPage = new OrderPage(driver);
        return orderPage;
    }

}
