package io.testsmith.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class VisaApplicationPage extends AbstractPageBase {

    @FindBy(name = "first_name")
    private WebElement textfieldFirstName;
    @FindBy(name = "last_name")
    private WebElement textfieldLastName;
    @FindBy(name = "email")
    private WebElement textfieldEmail;
    @FindBy(name = "confirmemail")
    private WebElement textfieldConfirmEmail;
    @FindBy(name = "phone")
    private WebElement textfieldContactNumber;
    @FindBy(name = "date")
    private WebElement textfieldDate;
    @FindBy(id = "sub")
    private WebElement buttonSubmit;


    public VisaApplicationPage(WebDriver driver) {
        super(driver);
    }

    public VisaApplicationPage setVisaFields(String firstName, String lastName, String email, String confirmEmail, String contactNumber, String date) {
        textfieldDate.clear();
        textfieldFirstName.sendKeys(firstName);
        textfieldLastName.sendKeys(lastName);
        textfieldEmail.sendKeys(email);
        textfieldConfirmEmail.sendKeys(confirmEmail);
        textfieldContactNumber.sendKeys(contactNumber);
        textfieldDate.sendKeys(date);
        return this;
    }

    public VisaApplicationPage sumbitForm() {
        buttonSubmit.click();
        return this;
    }
}