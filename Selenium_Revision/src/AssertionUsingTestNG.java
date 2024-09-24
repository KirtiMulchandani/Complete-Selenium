import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import org.testng.Assert;

public class AssertionUsingTestNG {
    public static void main(String [] args){

        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String name = "kirti";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://rahulshettyacademy.com/locatorspractice/");
        driver.findElement(By.id("inputUsername")).sendKeys(name);
        driver.findElement(By.name("inputPassword")).sendKeys("rahulshettyacademy");
        driver.findElement(By.className("submit")).click();
        System.out.println(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText());

        // To validate the msg shown on browser using TestNG. So, Assert is being used for putting assertions as we
        // already know that TestNG is primarily used for putting Assertions and Assert.assertEquals is one of the methods
        // for achieving the same. So, basically, it is comparing the string captured from the browser and with
        // provided string and making the scenario passed if they match or failed otherwise without even looking for it in the console manually
        Assert.assertEquals(driver.findElement(By.xpath("//div[@class='login-container']/p")).getText(), "You are successfully logged in.");

        System.out.println(driver.findElement(By.xpath("//div[contains(@class, 'login')]//h2")).getText());

        Assert.assertEquals(driver.findElement(By.xpath("//div[contains(@class, 'login')]//h2")).getText(), "Hello " + name + ",");

        // we can identify any element based upon the text it has. eg.,
        driver.findElement(By.xpath("//button[text()='Log Out']")).click();
        // we could have written the above xpath this way also:
        // driver.findElement(By.xpath("//*[text()='Log Out']")).click();
        // but it will only recognize the element uniquely when there is a single element present in the browser
        // having the text 'Log Out', otherwise it will identify all the elements having the text as 'Log Out'
        // Since we have only one element called button having the text 'Log Out', it will identify the same uniquely.

        driver.close();




    }
}
