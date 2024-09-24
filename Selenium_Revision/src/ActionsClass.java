import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.in/");
        driver.manage().window().maximize();

        WebElement target = driver.findElement(By.id("nav-link-accountList"));

        Actions a = new Actions(driver);

        // Hover over the element
        a.moveToElement(target).build().perform();

        // Enter the text into the search box in caps (composite actions)
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown(Keys.SHIFT).sendKeys("kirti").build().perform();

        driver.findElement(By.id("twotabsearchtextbox")).clear();

        // Select the provided text in the search box
        a.moveToElement(driver.findElement(By.id("twotabsearchtextbox"))).click().keyDown((Keys.SHIFT)).sendKeys("kirti").doubleClick().build().perform();

        // Right-click (contextClick) on the web page
        a.moveToElement(target).contextClick().build().perform();
    }
}
