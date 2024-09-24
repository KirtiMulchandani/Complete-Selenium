import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropDownsWhichHasSelectTag {
    public static void main(String [] args){
//        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
        WebElement element = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

        Select dropdown = new Select(element);

        // Now we can select the option by: index, visibleText, Value
        dropdown.selectByIndex(1);
        // We can verify where the element present at index 1 has been selected or not
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByVisibleText("AED");
        System.out.println(dropdown.getFirstSelectedOption().getText());

        dropdown.selectByValue("USD");
        System.out.println(dropdown.getFirstSelectedOption().getText());
    }
}
