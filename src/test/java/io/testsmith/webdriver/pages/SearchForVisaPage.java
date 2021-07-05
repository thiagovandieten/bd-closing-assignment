package io.testsmith.webdriver.pages;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Map;

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

    private final Map<String, WebElement> fromElements = Map.of(
            "dropdown", dropdownFromCountry,
            "textfield", textfieldFromCountry);


    private final Map<String, WebElement> toElements = Map.of(
            "dropdown", dropdownToCountry,
            "textfield", textfieldToCountry);

    public SearchForVisaPage(WebDriver driver) {
        super(driver);
    }
//6.1
    public SearchForVisaPage setCountryOfOriginTo(String countryOfOrigin) {
        setCountryOnDropdown(countryOfOrigin, fromElements);
        return this;
    }
//6.2
    public SearchForVisaPage setCountryOfVisitTo(String countryOfVisit) {
        setCountryOnDropdown(countryOfVisit, toElements);
        return this;
    }
//6.3
    /**
     *
     * @param country Het land dat in de visa's textveld moet komen, of het nou from of to is.
     * @param countryElement Een map element die de bijbehorende dropdown en textfield WebElements bevat van een veld.
     *
     */
    private void setCountryOnDropdown(String country, Map<String, WebElement> countryElement) {
        countryElement.get("dropdown").click();
        countryElement.get("textfield").sendKeys(country);
        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", country))).click();
    }
//6.4
    public SearchForVisaPage setVisitDateTo(String visitDate) {
        textfieldDate.sendKeys(visitDate);
        return this;
    }

//6.6
    public SearchForVisaPage submitVisa() {
        buttonSubmit.click();
        return this;
    }
}