package JavaStreams;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class FindCorrespondingColValueInWebTable {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

        List<WebElement> elementsList = driver.findElements(By.xpath("//tr/td[1]"));

        // Through Loop
        for (int i = 0; i < elementsList.size(); i++) {
            if(elementsList.get(i).getText().equalsIgnoreCase("rice")){
                System.out.println(elementsList.get(i).findElement(By.xpath("following-sibling::td[1]")).getText());
            }
        }

        // Through stream

        elementsList.stream().filter(e->e.getText().contains("Rice")).map(s->getPrice(s)).forEach(x-> System.out.println(x));



    }
    private static String getPrice(WebElement element){
        return element.findElement(By.xpath("following-sibling::td[1]")).getText();
    }
}
