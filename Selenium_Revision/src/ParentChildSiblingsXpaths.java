import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentChildSiblingsXpaths {
    public static void main(String [] args){
//        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://en.wikipedia.org/wiki/Main_Page");

        WebElement element = driver.findElement(By.xpath("//div[@class='tfa-recent']/div/ul/li[1]/following-sibling::li[1]"));
        System.out.println(element.getText());
        element.click();

        System.out.println(driver.findElement(By.xpath("//div[@class='tfa-recent']/div/parent::div")).getText());

    }
}
