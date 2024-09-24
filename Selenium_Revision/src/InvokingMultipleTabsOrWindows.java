import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class InvokingMultipleTabsOrWindows {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/angularpractice/");

        // once we have launched the above URL, we will open new tab/window in order to get another URL opened
        driver.switchTo().newWindow(WindowType.TAB);

        // once we have opened the new tab/window, we have to switch to that newly opened tab/window
        Set<String> windowHandles = driver.getWindowHandles();
        Iterator<String> it = windowHandles.iterator();
        String parentWindowId = it.next();
        String childWindowId = it.next();

        driver.switchTo().window(childWindowId);

        driver.get("https://rahulshettyacademy.com/");
        String courseName = driver.findElements(By.cssSelector("a[href*='https://courses.rahulshettyacademy.com/p']")).get(1).getText();

        driver.switchTo().window(parentWindowId);

        driver.findElement(By.name("name")).sendKeys(courseName);

        driver.quit();

    }
}
