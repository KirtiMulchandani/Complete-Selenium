import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDrop {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://jqueryui.com/droppable/");

        // Get to know how many frames are present on the web page
        System.out.println(driver.findElements(By.tagName("iframe")).size());

        // Switching to iFrame can be done in 3 ways:
        // through iFrame id/name
        // through iFrame WebElement
        // through iFrame index and by default the index starts from 0
        // but using index is not ideal, as if someone adds new iFrame on the webpage anywhere
        // So, there are chances that your code gets broken

        // Now switching to iframe
        driver.switchTo().frame(driver.findElement(By.cssSelector("iframe.demo-frame")));

        // Once switched to the frame, in order to perform drag and drop, Actions class will be used

        Actions a = new Actions(driver);

        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));

        // dragAndDrop() method will be used
        a.dragAndDrop(source, target).build().perform();

        // if we want to the switch back to our default window, switchTo().defaultContent() wil be used
        driver.switchTo().defaultContent();

    }
}
