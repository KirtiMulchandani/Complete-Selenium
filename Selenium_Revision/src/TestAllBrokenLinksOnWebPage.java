import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class TestAllBrokenLinksOnWebPage {
    public static void main(String[] args) throws IOException {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // To verify whether each link present on the web page is opening or not (broken links)
        // There are two ways of doing it that either we can check it manually by clicking on each one
        // or there is another way if we could get the status response code of each one
        // if any of the link's status code is greater than 400 that means it's broken
        // So, in Java there are methods which help us to get the response codes of URL
        // and by checking each one of these response code we can get to know of the same

        List<WebElement> links = driver.findElements(By.cssSelector("li.gf-li a"));

        SoftAssert softAssert = new SoftAssert();

        for(WebElement link : links){
            String url = link.getAttribute("href");
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");
            conn.connect();

            int responseCode = conn.getResponseCode();

            // So, here after getting the responseCode we can put if/else condition but it's not suggested right
            // then we can put assertions??

            // Think of it....
            // See, if we are putting assertion directly, then we in between any of the links is found to
            // broken then our test will fail and will stop at that point itself right.
            // we won't be able to verify further links which was our primary objective.
            // So, this is where soft assertions come into the play

            System.out.println(responseCode);

            softAssert.assertTrue(responseCode < 400, link.getText() + " is broken, returned " + responseCode + " response code");
        }


        softAssert.assertAll();

        // SoftAssert will not immediately fail the test, instead it keeps track of the failures and fails
        // at the end of the execution of test, upon putting assertAll(). That means we don't put assertAll()
        // then it won't let us know whether it has found some failures in between

    }
}
