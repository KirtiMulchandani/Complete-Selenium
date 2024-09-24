import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class checkList {
    public static void main(String[] args){
//        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // to check whether the checkbox was selected or not
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
        System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());


        // Get the number of total checkbox present on the page
        System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
        Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);


    }
}
