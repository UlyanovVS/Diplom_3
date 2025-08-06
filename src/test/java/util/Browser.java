package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Browser {
    public static WebDriver getWebDriver() throws IOException {
        Properties props = new Properties();
        props.load(new FileInputStream("src/test/resources/browser.properties"));
        BrowserType type = BrowserType.valueOf(props.getProperty("testBrowser").trim());

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-dev-shm-usage");

        switch (type) {
            case CHROME:
                io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
                return new ChromeDriver(options);

            case YANDEX:
                String driverPath = props.getProperty("chromedriverPath").trim();
                System.setProperty("webdriver.chrome.driver", driverPath);

                options.setBinary(props.getProperty("yandexBrowserBinaryPath"));

                return new ChromeDriver(options);

            default:
                throw new RuntimeException("Unsupported browser: " + type);
        }
    }

    public enum BrowserType {CHROME, YANDEX}
}