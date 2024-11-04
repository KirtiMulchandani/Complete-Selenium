package org.example.tests;

import org.example.TestComponents.BaseTest;
import org.example.tests.pageObjects.*;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

public class SubmitOrderTest extends BaseTest {

    @Test(dataProvider = "getData")
    public void submitOrderTest(HashMap<String, String> input) throws IOException {
        ProductCatalogue productCatalogue = landingPage.loginActions(input.get("email"), input.get("password"));
        WebElement prod = productCatalogue.getProduct(input.get("prodName"));
        CheckoutPage checkoutPage = productCatalogue.addToCart(prod);

        checkoutPage.landOnCheckoutPage();
        checkoutPage.getProductList();
        boolean match = checkoutPage.verifyProductInCart(input.get("prodName"));
        Assert.assertTrue(match);
        PlaceOrderPage placeOrderPage = checkoutPage.checkOut(input.get("prodName"));

        placeOrderPage.enterCountryName("India");
        placeOrderPage.selectCountry();
        placeOrderPage.placeOrder();
        placeOrderPage.verifyOrderPlacedMsg();
        Assert.assertEquals(placeOrderPage.verifyOrderPlacedMsg(), "Thankyou for the order.".toUpperCase());
    }

    @Test(dataProvider = "getData", dependsOnMethods = {"submitOrderTest"})
    public void orderHistoryTest(HashMap<String, String> input){
        ProductCatalogue productCatalogue = landingPage.loginActions(input.get("email"), input.get("password"));
        OrderPage orderPage = productCatalogue.landOnOrdersPage();
        Assert.assertTrue(orderPage.verifyProductDisplay(input.get("prodName")));
    }

//    @DataProvider
//    public Object[][] getData(){
//        return new Object[][] {{"test.user@test.com", "TestUser@1234", "IPHONE 13 PRO"}, {"test2.user2@test.com", "TestUser2@1234", "ZARA COAT 3"}};
//    }

//    @DataProvider
//    public Object[][] getData(){
//        HashMap<String, String> map1 = new HashMap<String, String>();
//        map1.put("email", "test.user@test.com");
//        map1.put("password", "TestUser@1234");
//        map1.put("prodName", "IPHONE 13 PRO");
//
//        HashMap<String, String> map2 = new HashMap<String, String>();
//        map2.put("email", "test2.user2@test.com");
//        map2.put("password", "TestUser2@1234");
//        map2.put("prodName", "ZARA COAT 3");
//
//        return new Object[][] {{map1}, {map2}};
//    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data= getDataJsonToMap(System.getProperty("user.dir") + "\\src\\test\\java\\org\\example\\data\\PurchaseOrder.json");
        return new Object[][] {{data.get(0)}, {data.get(1)}};
    }

}
