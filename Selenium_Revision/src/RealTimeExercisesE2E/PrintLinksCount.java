package RealTimeExercisesE2E;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class PrintLinksCount {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");

        // Print the count of all the links present on the page
        System.out.println(driver.findElements(By.tagName("a")).size());

        // Print the count of all the links present inside footer
        System.out.println(driver.findElements(By.cssSelector("#gf-BIG a")).size());

        // The above was one way of doing it.
        // There is another way of doing it, we can limit/minimize the scope of this driver and then
        // with the help of minimized driver we can locate all the anchor tags and find it's total count
        // And this concept is called "Limiting webDriver scope"

        WebElement footerDriver = driver.findElement(By.cssSelector("#gf-BIG"));

        System.out.println(footerDriver.findElements(By.tagName("a")).size());

        // Now our next purpose is to count all the links available on the first column
        WebElement colDriver = footerDriver.findElement(By.xpath("//table/tbody/tr/td/ul"));

        System.out.println(colDriver.findElements(By.tagName("a")).size());

        // Now we want to click each of the links available on the first column to see
        // whether each one of them is opening or not
        // But there is problem if we go with the traditional approach by iterating each one of them
        // from the list and clicking on them, as this will lead to stale element exception (read more about it)
        // As if first link of the col gets opened, then it will navigate us to different page right
        // and then our selenium driver will not be able to get the next link webElement to be clicked
        // and in order to let our selenium driver locate rest of the links we hve come back to the original from
        // the page opened by the link, and we want to capture the title of each page opened by link
        // then this approach is going to take a lot of time
        // So, the optimized way of doing it is that we can open each one of the links in the new tabs
        // and then by using getWindowHandles methods we can keep track of the counts and print the titles also of
        // each page opened by the links

        for(int i = 1; i < colDriver.findElements(By.tagName("a")).size(); i++){
            String clickOnLinkTab = Keys.chord(Keys.CONTROL, Keys.ENTER);
            colDriver.findElements(By.tagName("a")).get(i).sendKeys(clickOnLinkTab);
            Thread.sleep(5000);
        }

//        Set<String> windowHandles = driver.getWindowHandles();
//        Iterator<String> it = windowHandles.iterator();
//
//        while(it.hasNext()){
//            driver.switchTo().window(it.next());
//            System.out.println(driver.getTitle());
//        }

        for(String w : driver.getWindowHandles()){
            driver.switchTo().window(w);
            System.out.println(driver.getTitle());
        }

    }
}
