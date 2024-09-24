import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class E2E {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();

        driver.findElement(By.xpath("//a[@value='MAA']")).click();
        Thread.sleep(2000);

        driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='BLR']")).click();

        driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

        driver.findElement(By.id("divpaxinfo")).click();

        Thread.sleep(2000);
        for (int i = 1; i <= 3; i++){
            driver.findElement(By.id("hrefIncAdt")).click();
        }
        driver.findElement(By.id("btnclosepaxoption")).click();
        System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

        WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
        Select dropdown = new Select(element);
        dropdown.selectByValue("USD");

        driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();

        driver.findElement(By.cssSelector("#ctl00_mainContent_btn_FindFlights")).click();


    }
}
