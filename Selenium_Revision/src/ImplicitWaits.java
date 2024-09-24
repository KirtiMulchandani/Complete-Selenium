import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.HashSet;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class ImplicitWaits {
    public static void main(String[] args){

        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        // Pros of giving implicit wait:
        // code becomes readable
        // Cons is that it doesn't assess the performance of each element as every element is being given the
        // implicit wait of 5 sec, so those element which usually don't take much time to be displayed,
        // if by any chance they are taking 5 secs of time, then we'll not be able to get to know

        HashSet<String> veggiesNeeded = new HashSet<>();

        veggiesNeeded.add("Cauliflower");
        veggiesNeeded.add("Carrot");
        veggiesNeeded.add("Potato");
        veggiesNeeded.add("Tomato");

        driver.get("https://rahulshettyacademy.com/seleniumPractise");

        addItems(driver, veggiesNeeded);

        //Clicking on Cart-Icon
        driver.findElement(By.cssSelector("img[alt='Cart']")).click();

        //Clicking on Proceed to checkout
        driver.findElement(By.xpath("//button[contains(text(), 'PROCEED TO CHECKOUT')]")).click();

        //Filling the promo code
        driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");

        //Clicking on Apply button
        driver.findElement(By.cssSelector("button.promoBtn")).click();

        //Capturing Applied Message
        System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());

    }

    public static void addItems(WebDriver driver, HashSet<String> veggiesNeeded){
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



