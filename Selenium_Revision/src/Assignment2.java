import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment2 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        // Will launch the browser and open the URL
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // Defined variables to pass them as sendKeys in respective input fields of the form
        String name = "Kirti Mulchandani", email = "kirti@xyz.com", password = "3235da", dob = "12-13-2002";

        driver.findElement(By.cssSelector("div[class='form-group'] input[name='name']")).sendKeys(name);
        driver.findElement(By.name("email")).sendKeys(email);
        driver.findElement(By.id("exampleInputPassword1")).sendKeys(password);
        driver.findElement(By.id("exampleCheck1")).click();

        WebElement element = driver.findElement(By.id("exampleFormControlSelect1"));
        Select dropdown = new Select(element);
        dropdown.selectByVisibleText("Female");

        driver.findElement(By.id("inlineRadio1")).click();
        driver.findElement(By.name("bday")).sendKeys(dob);

        driver.findElement(By.cssSelector("input[type='submit']")).click();

        // Will capture the success msg
        String s = driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
        String[] arr =  s.split("×");
        System.out.println(arr[1].trim());

        // Will close the browser
//        driver.close();

    }
}
