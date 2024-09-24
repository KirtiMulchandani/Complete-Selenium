import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlingAlertsOfJS {
    public static void main(String[] args){
//        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice");

        String name = "Kirti";

        driver.findElement(By.id("name")).sendKeys(name);
        driver.findElement(By.id("alertbtn")).click();

        // So, upon clicking on the alert button, we'll get JS alert.
        // So, in order to handle it, we have to switch that alert window and for that we have one class call "alert()"

        System.out.println(driver.switchTo().alert().getText()); // will capture the text of alert
        driver.switchTo().alert().accept(); // it will accept the alert (click on Ok)

        // In JS, we can have 2 kinds of alerts:
        // 1. having only ok button
        // 2. having ok/Yes and Cancel/No buttons
        // So, in order to handle negative ones (Cancel/No), we have dismiss functionality to do it

        driver.findElement(By.id("confirmbtn")).click();
        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();

    }
}
