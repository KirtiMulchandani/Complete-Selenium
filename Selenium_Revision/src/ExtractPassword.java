import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class ExtractPassword {
    public static void main(String [] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.linkText("Forgot your password?")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        String pwdText = driver.findElement(By.cssSelector("form p")).getText();

        String[] pwdTextArray = pwdText.split("'");

        driver.findElement(By.cssSelector("button[class*='go']")).click();

        Thread.sleep(1000); // to avoid intercept exception
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Kirti");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(pwdTextArray[1]);
        driver.findElement(By.name("chkboxOne")).click();
        driver.findElement(By.className("submit")).click();

    }
}
