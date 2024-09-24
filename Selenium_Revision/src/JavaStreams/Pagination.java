package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.stream.Collectors;

public class Pagination {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
        driver.findElement(By.xpath("//tr/th[1]")).click();

        List<String> price;

        do {
            List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

            price = elementsList.stream().filter(e -> e.getText().contains("Rice")).map(s -> getPrice(s)).collect(Collectors.toList());

            price.stream().forEach(x-> System.out.println(x));

            if(price.size() == 0){
                driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
            }

        }while(price.size() == 0);


    }
    private static String getPrice(WebElement element){
        return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
