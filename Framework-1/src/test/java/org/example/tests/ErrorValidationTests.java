package org.example.tests;

import org.example.TestComponents.BaseTest;
import org.example.tests.pageObjects.CheckoutPage;
import org.example.tests.pageObjects.ProductCatalogue;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;

public class ErrorValidationTests extends BaseTest {

    @Test(groups = {"ErrorHandling"})
    public void LoginErrorValidation() throws IOException {
        String prodName = "IPHONE 13 PRO";
        landingPage.loginActions("test1.user@test.com", "TestUser@1234");
        Assert.assertEquals("Incorrect email or password.", landingPage.getErrorMessage());
    }

    @Test
    public void ProductErrorValidation() throws IOException {
        String prodName = "IPHONE 13 PRO";
        ProductCatalogue productCatalogue = landingPage.loginActions("test.user@test.com", "TestUser@1234");
        WebElement prod = productCatalogue.getProduct(prodName);
        CheckoutPage checkoutPage = productCatalogue.addToCart(prod);

        checkoutPage.landOnCheckoutPage();
        checkoutPage.getProductList();
        boolean match = checkoutPage.verifyProductInCart("IPHONE 13 PRO Max");
        Assert.assertFalse(match);
    }

}
