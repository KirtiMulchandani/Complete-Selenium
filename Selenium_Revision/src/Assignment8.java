import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class Assignment8 {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        driver.manage().window().maximize();

            String country = "Australia";
        driver.findElement(By.id("autocomplete")).sendKeys(country.substring(0, 3));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#ui-id-1 li")));

        List<WebElement> options = driver.findElements(By.cssSelector("#ui-id-1 li"));

        int i = -1;

        do{
            i++;
            driver.findElement(By.id("autocomplete")).sendKeys(Keys.DOWN);
        }while (i < options.size() && !options.get(i).getText().equalsIgnoreCase(country));

        System.out.println(driver.findElement(By.id("autocomplete")).getAttribute("value"));

    }
}
