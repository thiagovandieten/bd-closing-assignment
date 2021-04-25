package io.testsmith.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPageBase {

    @FindBy(xpath = "//button[text()='Got it!']")
    private WebElement buttonAcceptCookies;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public HomePage acceptCookies() {
        buttonAcceptCookies.click();
        return this;
    }

    public HomePage selectMenuItem(String menuItem) {
        driver.findElement(By.xpath(String.format("//a[@data-name='%s']", menuItem.toLowerCase()))).click();
        return this;
    }
}
