package ChromeOptionsClass;

import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;

public class HandlingSSLCertificates {
    public static void main(String[] args) {
        // So, before invoking the Chrome browser, we can define how the automation browser should behave
        // upon launching like, it can have extension installed, proxies configured, enabled to block pop-up
        // windows and enabled to handle SSL Certificates

        // Handle SSL Certificate
        ChromeOptions options = new ChromeOptions();
        options.setAcceptInsecureCerts(true); // Marking it true so that it can move to the sites don't have HTTPS

        Proxy proxy = new Proxy();
        proxy.setHttpProxy("myhttpproxy:3337");

        // Enabling the proxies
        options.setCapability("proxy", proxy); // setCapability() helps you to set the proxies, but it accepts the proxy
        // object which contains the IP/port number (which will be given by IT team)

        // Adding extension
        options.addExtensions(new File("C:\\Users\\KirtiMulchandani\\eclipse-workspace\\Selenium_Revision\\SelectorsHubcrx.crx"));

        WebDriver driver = new ChromeDriver(options); // Pass option as the argument so that the launched browser can incorporate the behaviour accordingly
        // otherwise it will launch and have default behavior

        driver.get("https://expired.badssl.com/");
        System.out.println(driver.getTitle());



    }
}
