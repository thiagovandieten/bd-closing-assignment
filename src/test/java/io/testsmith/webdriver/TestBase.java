package io.testsmith.webdriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.testsmith.webdriver.utils.Browser;
import io.testsmith.webdriver.utils.Environment;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public abstract class TestBase {

    private static final String DOCKER_SELENIUM_HUB_URL = "http://localhost:4444/wd/hub";
    protected ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public WebDriver getDriver() {
        return driver.get();
    }

    @BeforeMethod
    @Parameters(value = {"seleniumBrowser", "environment"})
    public void setup(@Optional("chrome") String browser, @Optional("local") String environment) throws MalformedURLException {
        if (Environment.valueOf(environment.toUpperCase()).equals(Environment.LOCAL)) {
            switch (Browser.valueOf(browser.toUpperCase())) {
                case CHROME:
                    WebDriverManager.chromedriver().setup();
                    driver.set(new ChromeDriver());
                    break;
                case FIREFOX:
                    WebDriverManager.firefoxdriver().setup();
                    driver.set(new FirefoxDriver());
                    break;
                case EDGE:
                    WebDriverManager.edgedriver().setup();
                    driver.set(new EdgeDriver());
                    break;
                case OPERA:
                    WebDriverManager.operadriver().setup();
                    driver.set(new OperaDriver());
                    break;
                case INTERNET_EXPLORER:
                    WebDriverManager.iedriver().setup();
                    driver.set(new InternetExplorerDriver());
                    break;
                case CHROME_HEADLESS:
                    WebDriverManager.chromedriver().setup();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--headless");
                    driver.set(new ChromeDriver(options));
                    break;
            }
        } else if (Environment.valueOf(environment.toUpperCase()).equals(Environment.DOCKER)) {
            DesiredCapabilities dc = new DesiredCapabilities();
            switch (Browser.valueOf(browser.toUpperCase())) {
                case CHROME:
                    dc.setBrowserName("chrome");
                    dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    break;
                case FIREFOX:
                    dc.setBrowserName("firefox");
                    break;
                case EDGE:
                    dc.setBrowserName("edge");
                    break;
            }
            driver.set(new RemoteWebDriver(new URL(DOCKER_SELENIUM_HUB_URL), dc));
        }
        getDriver().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        getDriver().manage().window().maximize();
        getDriver().get("http://phptravels.net/home");
    }

    @AfterMethod
    public void teardown() {
        if (getDriver() != null) {
            getDriver().quit();
        }
    }

}
