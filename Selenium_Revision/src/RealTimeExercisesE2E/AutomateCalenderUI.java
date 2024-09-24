package RealTimeExercisesE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import java.util.List;

public class AutomateCalenderUI {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.manage().window().maximize();

        String month = "6";
        String date = "15";
        String year = "2027";

        String[] expected = {month, date, year};

        driver.findElement(By.className("react-date-picker__inputGroup")).click();

        driver.findElement(By.className("react-calendar__navigation__label")).click();

        driver.findElement(By.className("react-calendar__navigation__label")).click();

        driver.findElement(By.xpath("//button[text()='" + year + "']")).click();

        driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();

        driver.findElement(By.xpath("//abbr[text()='" + date + "']")).click();

        List<WebElement> list = driver.findElements(By.cssSelector(".react-date-picker__inputGroup__input"));

        for (int i = 0; i < list.size(); i++){
            String v = list.get(i).getAttribute("value");
            System.out.println(v);
            Assert.assertEquals(v, expected[i]);
        }


    }
}
