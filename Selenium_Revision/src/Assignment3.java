import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment3 {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        // Launching browser and hitting desired URL
        driver.get("https://rahulshettyacademy.com/loginpagePractise");

        // Entering Log-in details
        driver.findElement(By.id("username")).sendKeys("rahulshettyacademy");
        driver.findElement(By.id("password")).sendKeys("learning");

        driver.findElement(By.cssSelector("input[value='user']")).click();

        // waiting until the modal section appears
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("modal-content")));

        driver.findElement(By.id("okayBtn")).click();

        // Selecting Consultant from the static dropdown
        WebElement element = driver.findElement(By.tagName("select"));
        Select dropdown = new Select(element);
        dropdown.selectByValue("consult");

        // Clicking on Agree to the T&C
        driver.findElement(By.id("terms")).click();

        // Clicking on Sign In button
        driver.findElement(By.id("signInBtn")).click();

        // Waiting until the home page is getting loaded properly
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.tagName("app-card-list")));

        // Capturing all the Web Elements containing Add to Cart Button
        List<WebElement> buttons = driver.findElements(By.xpath("//app-card-list/app-card/div/div[@class='card-footer']/button"));

        //Adding all the products to the card
        for (WebElement btn : buttons){
            btn.click();
        }

        // Clicking on Checkout button
        driver.findElement(By.xpath("//a[contains(text(),'Checkout')]")).click();

        // Waiting until the 3rd page is getting loaded
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[text()='Total']")));

        // Closing the browser window
        driver.close();
    }
}
