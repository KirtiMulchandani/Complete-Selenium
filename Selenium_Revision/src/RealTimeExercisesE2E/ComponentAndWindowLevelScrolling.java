package RealTimeExercisesE2E;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ComponentAndWindowLevelScrolling {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // In order to scroll in both of these cases (Window level or Component Level(horizontal/Vertical), we have to
        // use JavaScriptExecutor as selenium implicitly doesn't support scrolling

        JavascriptExecutor js = (JavascriptExecutor) driver;

        // window level scrolling
        js.executeScript("window.scrollBy(0, 500)"); // and inside this method we are going to provide JS script to scroll

        // component level scrolling
        js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");

    }
}
