import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;

public class AddToCart {
    public static void main(String[] args){
//        System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        HashSet<String> veggiesNeeded = new HashSet<>();

        veggiesNeeded.add("Cauliflower");
        veggiesNeeded.add("Carrot");
        veggiesNeeded.add("Potato");
        veggiesNeeded.add("Tomato");

        driver.get("https://rahulshettyacademy.com/seleniumPractise");

        List<WebElement> listOfProducts = driver.findElements(By.cssSelector(".product-name"));
        int cnt = 0;
        int totalItemsNeeded = veggiesNeeded.size();

        for(int i = 0; i < listOfProducts.size() && cnt < totalItemsNeeded; i++){
            String product = listOfProducts.get(i).getText().split("-")[0].trim();
            if(veggiesNeeded.contains(product)){
                System.out.println(product);
                driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
                cnt++;
            }
        }

    }
}
