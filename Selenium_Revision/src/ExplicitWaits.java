import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ExplicitWaits {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        //Pros of using Explicit wait is that, it is only applicable for target elements, help in to assess the performance of rest of the elements
        // Cons is that the code becomes unreadable sometimes as we have to put it for each element which
        // are prone to be visible late.

        HashSet<String> veggiesNeeded = new HashSet<>();

        veggiesNeeded.add("Cauliflower");
        veggiesNeeded.add("Carrot");
        veggiesNeeded.add("Potato");
        veggiesNeeded.add("Tomato");

        driver.get("https://rahulshettyacademy.com/seleniumPractise");

        addItems(driver, veggiesNeeded);

        //Clicking on Cart-Icon
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        //Clicking on Proceed to checkout
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));

        //Filling the promo code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        //Clicking on Apply button
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));

        //Capturing Applied Message
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }

    public static void addItems(WebDriver driver, HashSet<String> veggiesNeeded) {
        List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".product-name"));
        int cnt = 0;
        int totalItemsNeeded = veggiesNeeded.size();

        for (int i = 0; i < listOfProducts.size() && cnt < totalItemsNeeded; i++) {
            String product = listOfProducts.get(i).getText().split("-")[0].trim();
            if (veggiesNeeded.contains(product)) {
                System.out.println(product);
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                cnt++;
            }
        }
    }
}
