import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Scanner;

public interface AutoSuggestiveDropdown {
    public static void main(String[] args) throws InterruptedException {
//        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/dropdownsPractise/");

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the few characters of name of country in which you wanna go... ");
        String s = sc.nextLine();

        driver.findElement(By.id("autosuggest")).sendKeys(s);
        Thread.sleep(3000);
        List<WebElement> list = driver.findElements(By.cssSelector("ul[id='ui-id-1'] li"));

        for (WebElement e : list){
            if(e.getText().equalsIgnoreCase("Austria")){
                e.click();
                break;
            }
        }

    }
}
