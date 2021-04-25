package io.testsmith.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPageBase {
    protected WebDriver driver;

    public AbstractPageBase(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

}
