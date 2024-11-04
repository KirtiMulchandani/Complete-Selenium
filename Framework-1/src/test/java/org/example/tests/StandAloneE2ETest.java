package org.example.tests;

import org.example.tests.pageObjects.LandingPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StandAloneE2ETest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String prodName = "IPHONE 13 PRO";
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/client");
        driver.manage().window().maximize();

        LandingPage landingPage = new LandingPage(driver);

        driver.findElement(By.id("userEmail")).sendKeys("test.user@test.com");
        driver.findElement(By.id("userPassword")).sendKeys("TestUser@1234");
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".col-lg-4")));
        List<WebElement> prod = driver.findElements(By.cssSelector(".col-lg-4"));
        WebElement ele = prod.stream().filter(product->product.findElement(By.cssSelector("h5")).getText().equalsIgnoreCase(prodName)).findFirst().orElse(null);
        ele.findElement(By.cssSelector(".btn.w-10.rounded:last-of-type")).click();
        Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("toast-container")));
        driver.findElement(By.xpath(".//button[contains(text(),'  Cart ')]")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".items")));
        List<WebElement> cartAddedProducts = driver.findElements(By.cssSelector(".items"));
        boolean flag = cartAddedProducts.stream().anyMatch(prodduct->prodduct.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(prodName));
        Assert.assertTrue(flag);
        WebElement cartItem = cartAddedProducts.stream().filter(prodduct->prodduct.findElement(By.cssSelector("h3")).getText().equalsIgnoreCase(prodName)).findFirst().orElse(null);
        cartItem.findElement(By.cssSelector("button")).click();
        Actions a = new Actions(driver);
        a.sendKeys(driver.findElement(By.cssSelector("input[placeholder='Select Country']")), "india").build().perform();
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(1011, 600)");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ta-results")));
        driver.findElement(By.xpath("//button[contains(@class,'ta-item')][2]")).click();
        Thread.sleep(2000);
        driver.findElement(By.cssSelector(".btnn.action__submit.ng-star-inserted")).click();
        String msg = driver.findElement(By.cssSelector(".hero-primary")).getText();
        Assert.assertEquals(msg, "Thankyou for the order.".toUpperCase());

    }
}
