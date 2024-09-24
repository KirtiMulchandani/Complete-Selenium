import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

public class RelativeLocators {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/angularpractice/");

        WebElement emailLabel = driver.findElement(By.xpath("//label[text()='Email']"));

        //above
        System.out.println(driver.findElement(with(By.tagName("label")).above(emailLabel)).getText());

        //below
        System.out.println(driver.findElement(with(By.tagName("label")).below(emailLabel)).getText());

        WebElement studentLabel = driver.findElement(By.xpath("//label[text()='Student']"));

        // leftOf
        System.out.println(driver.findElement(with(By.tagName("label")).toLeftOf(studentLabel)).getText());

        // rightOf
        System.out.println(driver.findElement(with(By.tagName("label")).toRightOf(studentLabel)).getText());


    }
}
