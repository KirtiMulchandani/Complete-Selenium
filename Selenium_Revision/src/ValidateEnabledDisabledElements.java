import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class ValidateEnabledDisabledElements {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        // This below line sometimes doesn't work while disabled or enabled elements because of modern design of the website
        //System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_view_date2")).isEnabled());

        // So, ideal way of doing is identify that attribute which is getting changed while this transition
        // So, in case of disabled, this style attribute 0.5 opacity
        // So, if the element contains the the style attribute having 0.5 opacity we'll consider it to be disabled otherwise enabled

        if(driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")){
            System.out.println("Disabled");
            Assert.assertFalse(false);
        }
        else{
            System.out.println("Enabled");
            Assert.assertTrue(true);
        }

    }
}
