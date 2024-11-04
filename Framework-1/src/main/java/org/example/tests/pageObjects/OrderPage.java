package org.example.tests.pageObjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OrderPage extends AbstractComponent {
    WebDriver driver;
    public OrderPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "td:nth-child(3)")
    List<WebElement> prodList;

    public boolean verifyProductDisplay(String prodName){
        return prodList.stream().anyMatch(prodduct->prodduct.getText().equalsIgnoreCase(prodName));
    }


}
