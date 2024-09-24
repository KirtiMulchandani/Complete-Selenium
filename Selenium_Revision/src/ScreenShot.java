import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.io.IOException;
public class ScreenShot {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://commons.apache.org/proper/commons-io/apidocs/org/apache/commons/io/FileUtils.html");
            File src = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File dest = new File("C:\\Users\\KirtiMulchandani\\Pictures\\Screenshots\\png1.png");
            // Ensure destination directory exists
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            FileUtils.copyFile(src, dest);
            System.out.println("Screenshot captured successfully!");
        } catch (IOException e) {
            System.out.println("IOException while saving screenshot: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            driver.quit();
        }
    }
}