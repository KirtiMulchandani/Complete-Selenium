import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class AutomateSignUpPage {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        // Will be providing implicit wait in order to handle 'No such element found error'
        // In order to do, we will set timeout, if the selenium isn't able to locate our element
        // it will wait till specified to let it appear, and even then, it doesn't, it will throw
        // an error

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        driver.get("https://rahulshettyacademy.com/locatorspractice/");

        driver.findElement(By.id("inputUsername")).sendKeys("Kirti");
        driver.findElement(By.name("inputPassword")).sendKeys("Kirti");
        driver.findElement(By.className("submit")).click();

        // Hard-coding the wait
//        Thread.sleep(5000);

        System.out.println(driver.findElement(By.cssSelector("p.error")).getText());

        driver.findElement(By.linkText("Forgot your password?")).click();

        Thread.sleep(1000); // to avoid intercept exception

        // Note: Intercept Exception occurs in case of single page application i.e., when a window is on changing state,
        // sometimes selenium isn't able to perform the desired actions on a particular object/web element, so in
        // such, giving some explicit wait is good practice to avoid this Exception

        driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("Kirti");
        driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("Kirti@xyz.com");
        driver.findElement(By.xpath("//input[@placeholder='Phone Number']")).sendKeys("43535454543");

        driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
        System.out.println(driver.findElement(By.cssSelector("form p")).getText());

        // xpath using regular expression i.e., it will search for the class having name starting from "go"
        driver.findElement(By.cssSelector("button[class*='go']")).click();

        Thread.sleep(1000); // to avoid intercept exception
        driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Kirti");
        driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("rahulshettyacademy");

        driver.findElement(By.name("chkboxOne")).click();

        driver.findElement(By.className("submit")).click();

        System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());
        System.out.println("You are successfully logged in.".equals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText()));

        driver.findElement(By.xpath("//div[@class='login-container']/button")).click();




    }
}
