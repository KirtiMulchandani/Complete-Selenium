import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class IntroToSelenium {
    public static void main(String[] args){
//        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
//        WebDriver driver = new ChromeDriver();

        System.setProperty("webdriver.edge.driver", "./msedgedriver.exe");
        WebDriver driver = new EdgeDriver();

        // Open the provided URL in the browser
        driver.get("https://www.youtube.com/");

        // Get title of the webpage
        System.out.println(driver.getTitle());

        //Get URL of the web page
        System.out.println(driver.getCurrentUrl());

        //Verify whether you are getting the same URL that you provided
        System.out.println(driver.getCurrentUrl().equals("https://www.youtube.com/"));

        // Close the Browser
        driver.close(); // closes the current window only, if the browser is having multiple tabs, it will close the one which was originally opened by it

        // driver.quit(); // closes all the associate tabs
    }
}
