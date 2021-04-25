package io.testsmith.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchForVisaPage extends AbstractPageBase {

    @FindBy(css = "select[name='nationality_country'] + div")
    private WebElement dropdownFromCountry;

    @FindBy(css = "select[name='nationality_country'] + div input")
    private WebElement textfieldFromCountry;

    @FindBy(css = "select[name='destination_country'] + div")
    private WebElement dropdownToCountry;

    @FindBy(css = "select[name='destination_country'] + div input")
    private WebElement textfieldToCountry;

    @FindBy(name = "date")
    private WebElement textfieldDate;

    @FindBy(xpath = "//button[text()='Submit']")
    private WebElement buttonSubmit;

    public SearchForVisaPage(WebDriver driver) {
        super(driver);
    }

    public SearchForVisaPage setCountryOfOriginTo(String countryOfOrigin) {
        dropdownFromCountry.click();
        textfieldFromCountry.sendKeys(countryOfOrigin);
        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", countryOfOrigin))).click();
        return this;
    }
}