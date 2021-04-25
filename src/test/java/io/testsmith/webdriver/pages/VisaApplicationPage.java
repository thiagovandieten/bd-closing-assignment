package io.testsmith.webdriver.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class VisaApplicationPage extends AbstractPageBase {

    @FindBy(name = "first_name")
    private WebElement textfieldFirstName;

    public VisaApplicationPage(WebDriver driver) {
        super(driver);
    }

    public VisaApplicationPage setFirstName(String firstName) {
        textfieldFirstName.sendKeys(firstName);
        return this;
    }
}