import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://qaclickacademy.com/practice.php");

        driver.findElement(By.id("checkBoxOption1")).click();
        String label = driver.findElement(By.xpath("//input[@id='checkBoxOption1']/parent::label")).getText();

        WebElement selectElement = driver.findElement(By.id("dropdown-class-example"));

        Select dropdown = new Select(selectElement);
        dropdown.selectByVisibleText(label);

        driver.findElement(By.id("name")).sendKeys(label);
        driver.findElement(By.id("alertbtn")).click();

        String text = driver.switchTo().alert().getText();

//        if(text.contains(label)) System.out.println("Present");
//        else System.out.println("Not present");

        Assert.assertTrue(text.contains(label));

        driver.switchTo().alert().accept();

        driver.close();

    }
}
