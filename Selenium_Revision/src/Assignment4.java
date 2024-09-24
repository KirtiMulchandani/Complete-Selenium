import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class Assignment4 {
    public static void main(String[] args) {

        System.setProperty("webdriver.chromedriver.driver", "./chrome.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://the-internet.herokuapp.com/");
        driver.manage().window().maximize();
        driver.findElement(By.linkText("Multiple Windows")).click();
        driver.findElement(By.linkText("Click Here")).click();

        Set<String> windows = driver.getWindowHandles();

        Iterator<String> it = windows.iterator();

        String parentID = it.next();
        String childID = it.next();

        driver.switchTo().window(childID);

        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

        driver.switchTo().window(parentID);

        System.out.println(driver.findElement(By.xpath("//div[@class='example']/h3")).getText());

        driver.quit();
    }
}
