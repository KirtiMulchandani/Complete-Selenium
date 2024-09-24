import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class HandleWindows {
    public static void main(String[] args) {
        System.setProperty("webdriver.chromedriver.driver", "./chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/loginpagePractise/");
        driver.manage().window().maximize();

        driver.findElement(By.cssSelector(".blinkingText")).click();

        // Getting all the active windows
        Set<String>  windowHandles = driver.getWindowHandles(); // this getWindowHandles method is going to return ID's of all the opened (associated) tabs/windows
                                                                // in our case, this is going to return 2 windows {parentID, childID}
        Iterator<String> it = windowHandles.iterator(); // in order to get these ID's we have to iterate in this set

        String parentID = it.next();
        String childID = it.next();

        // now switch to that child(newly opened) window
        driver.switchTo().window(childID);

        System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText());

        // Getting the email address to be entered into the username field available on parent window
        String username = driver.findElement(By.cssSelector(".im-para.red")).getText().split(" ")[4];

        // Switching back to the parent window
        driver.switchTo().window(parentID);

        driver.findElement(By.id("username")).sendKeys(username);



    }
}
