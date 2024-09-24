package ChromeOptionsClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DeleteCookies {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        // So, in order to add, delete cookies, manage() method will be used
        // cookies are deleted once the browser is launched, though this scenario is rarely used in real time
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies(); // will be used to delete all the stored cookies

        // if we want to delete any particular cookie (which is basically done when we hve to test the scenario
        // of deleting the session cookie in order to validate whether the user is logged out  and navigated to the
        // home page of the site)
        driver.manage().deleteCookieNamed("sessionKey");

        // in order to add the cookie (again very rare scenario)
        // driver.manage().addCookie("cookieName");
        driver.get("https://www.google.com/");
    }
}
