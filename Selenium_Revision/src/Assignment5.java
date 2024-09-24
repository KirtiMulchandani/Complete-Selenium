import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");

        driver.findElement(By.cssSelector("a[href*='nested_frames']")).click();

        // Switching to the top frame inside which the middle frame is embedded
        driver.switchTo().frame("frame-top");

        // Now switching to the middle frame
        driver.switchTo().frame("frame-middle");

        // Printing the text present on the middle frame
        System.out.println(driver.findElement(By.id("content")).getText());

        driver.close();

    }
}
