package io.testsmith.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class VisaApplicationConfirmPage extends AbstractPageBase {

    //
    @FindBy(id = "submi")
    private WebElement VisaSubmitted;

    public VisaApplicationConfirmPage(WebDriver driver) {
        super(driver);
    }

    public boolean getVisibilityConfirmPage() {
        return VisaSubmitted.isDisplayed();
    }
}
