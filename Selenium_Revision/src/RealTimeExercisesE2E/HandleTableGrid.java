package RealTimeExercisesE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class HandleTableGrid {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 600)");

        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

        List<WebElement> listOf4thCol = driver.findElements(By.xpath("//div[@class='tableFixHead']/table/tbody/tr/td[4]"));

        int sum = 0;

        for (int i = 0; i < listOf4thCol.size(); i++) {
            sum += Integer.parseInt(listOf4thCol.get(i).getText());
        }

        System.out.println(sum);

        int total = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());

        Assert.assertEquals(sum, total);

    }
}
