package org.example.tests.pageObjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AbstractComponent {
    WebDriver driver;
    public ProductCatalogue(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = ".col-lg-4")
    List<WebElement> products;

    @FindBy(css = ".ng-animating")
    WebElement spinner;

    By toastMsg = By.id("toast-container");

    By addToCartBtnLocator = By.cssSelector(".btn.w-10.rounded:last-of-type");

    public WebElement getProduct(String prodName){
        return products.stream().filter(product->product.findElement(By.cssSelector("h5")).getText().equalsIgnoreCase(prodName)).findFirst().orElse(null);
    }

    public CheckoutPage addToCart(WebElement product){
        product.findElement(addToCartBtnLocator).click();
        waitForElementToAppear(toastMsg);
        waitForElementToDisappear(spinner);
        CheckoutPage checkoutPage = new CheckoutPage(driver);
        return checkoutPage;
    }


}
