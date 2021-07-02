package io.testsmith.webdriver.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.time.LocalDate;

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

    public SearchForVisaPage setCountryOfVisitTo(String countryOfVisit) {
        dropdownToCountry.click();
        textfieldToCountry.sendKeys(countryOfVisit);
        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", countryOfVisit))).click();
        return this;
    }

    public SearchForVisaPage setVisitDateTo(String visitDate) {
        textfieldDate.sendKeys(visitDate);
        return this;
    }

    public SearchForVisaPage submitVisa() {
        buttonSubmit.click();
        return this;
    }
    public SearchForVisaPage setVisaTotal(String countryOfOrigin, String countryOfVisit, String visitDate) {
        dropdownFromCountry.click();
        textfieldFromCountry.sendKeys(countryOfOrigin);
        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", countryOfOrigin))).click();
        dropdownToCountry.click();
        textfieldToCountry.sendKeys(countryOfVisit);
        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", countryOfVisit))).click();
        textfieldDate.sendKeys(visitDate);
        buttonSubmit.click();
        return this;
    }
}