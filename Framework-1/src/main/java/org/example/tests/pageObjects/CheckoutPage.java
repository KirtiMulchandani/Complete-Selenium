package org.example.tests.pageObjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CheckoutPage extends AbstractComponent {
    WebDriver driver;
    public CheckoutPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    By products = By.cssSelector(".items");
    By checkOutBtn = By.cssSelector("button");

    @FindBy(css = ".items")
    List<WebElement> cartAddedProducts;

    public List<WebElement> getProductList(){
        waitForElementToAppear(products);
        return cartAddedProducts;
    }

    public boolean verifyProductInCart(String prodName){
        return cartAddedProducts.stream().anyMatch(prodduct->prodduct.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(prodName));
    }

    public PlaceOrderPage checkOut(String prodName){
        WebElement cartItem = cartAddedProducts.stream().filter(prodduct->prodduct.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(prodName)).findFirst().orElse(null);
        cartItem.findElement(checkOutBtn).click();
        PlaceOrderPage placeOrderPage = new PlaceOrderPage(driver);
        return placeOrderPage;
    }


}
