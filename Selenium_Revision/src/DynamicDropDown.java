import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicDropDown {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(2000);
//        driver.findElement(By.xpath("(//a[@value='BLR'])[2]")).click();

        // There is another way of doing the same, like in case when we are getting the two elements with respect to
        // an xpath, so one way of handling it is indexing but sometimes people don't want you to hardcode the index
        // and that is the reason we have to look for an alternative. So, we can use parent-child relationship
        // locator to identify the element uniquely. eg.,

        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

    }
}
