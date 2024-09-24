import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");

        int rows = driver.findElements(By.cssSelector("div[class='left-align'] table tr")).size();
        int cols = (driver.findElements(By.cssSelector("div[class='left-align'] table th")).size() +
                    driver.findElements(By.cssSelector("div[class='left-align'] table td")).size()) / rows;
        System.out.println("Number of rows: " + rows);
        System.out.println("Number of cols: " + cols);

        System.out.println(driver.findElement(By.cssSelector("div[class='left-align'] table tr:nth-child(3)")).getText());


    }
}
