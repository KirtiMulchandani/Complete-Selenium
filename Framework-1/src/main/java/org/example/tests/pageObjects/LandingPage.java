package org.example.tests.pageObjects;

import org.AbstractComponents.AbstractComponent;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage extends AbstractComponent {
    WebDriver driver;
    public LandingPage(WebDriver driver){
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(id = "userEmail")
    WebElement userEmail;

    @FindBy(id = "userPassword")
    WebElement password;

    @FindBy(id = "login")
    WebElement submit;

    @FindBy(css="[class*='flyInOut']")
    WebElement errorMessage;

    By homePage = By.cssSelector(".col-lg-4");

    public void goTo(){
        driver.get("https://rahulshettyacademy.com/client");
    }

    public ProductCatalogue loginActions(String useremail, String pwd){
        userEmail.sendKeys(useremail);
        password.sendKeys(pwd);
        submit.click();
//        waitForElementToAppear(homePage);
        return new ProductCatalogue(driver);
    }

    public String getErrorMessage(){
        waitForWebElementToAppear(errorMessage);
        return errorMessage.getText();
    }

}
