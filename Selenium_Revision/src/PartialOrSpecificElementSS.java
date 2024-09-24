import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

public class PartialOrSpecificElementSS {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        driver.switchTo().newWindow(WindowType.TAB);

        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        driver.switchTo().window(childWindowId);

        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

        driver.switchTo().window(parentWindowId);

        WebElement element = driver.findElement(By.name("name"));
        element.sendKeys(courseName);

        // Once we have stored the webElement, then we can use the same webElement to take the partial ss
        File file = element.getScreenshotAs(OutputType.FILE);

        FileUtils.copyFile(file, new File("element.png"));

        driver.quit();

    }
}
