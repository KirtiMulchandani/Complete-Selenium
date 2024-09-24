import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashSet;
import java.util.List;

public class Checkout {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();

        HashSet<String> veggiesNeeded = new HashSet<>();

        veggiesNeeded.add("Cauliflower");
        veggiesNeeded.add("Carrot");
        veggiesNeeded.add("Potato");
        veggiesNeeded.add("Tomato");

        driver.get("https://rahulshettyacademy.com/seleniumPractise");

        // Clicking on cart icon
        driver.findElement(By.xpath("//a[@class='cart-icon']")).click();

        // Proceed to Checkout
        driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

        Thread.sleep(2000);
        //Place Order
        driver.findElement(By.xpath("//button[text()='Place Order']")).click();

        //Selecting Country
        WebElement element = driver.findElement(By.tagName("select"));

        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("India");

        driver.findElement(By.className("chkAgree")).click();

        driver.findElement(By.xpath("//button[text()='Proceed']")).click();

    }
}
