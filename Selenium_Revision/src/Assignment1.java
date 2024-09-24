import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Assignment1 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        //Will launch the browser and open the URL
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Will locate the checkbox and check it
        driver.findElement(By.id("checkBoxOption1")).click();

        // Will verify whether the checkbox has successfully checked or not
        Assert.assertTrue(driver.findElement(By.id("checkBoxOption1")).isSelected());
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());

        // Will locate the checkbox and uncheck it
        driver.findElement(By.id("checkBoxOption1")).click();

        // Will verify whether the checkbox has successfully unchecked or not
        Assert.assertFalse(driver.findElement(By.id("checkBoxOption1")).isSelected());
        System.out.println(driver.findElement(By.id("checkBoxOption1")).isSelected());

        // Will print the Count of number of check boxes present in the page on console
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());

        // Will close the browser
        driver.close();
    }
}
