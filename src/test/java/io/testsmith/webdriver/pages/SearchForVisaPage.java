package io.testsmith.webdriver.pages;

import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
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
//6.1
    public SearchForVisaPage setCountryOfOriginTo(String countryOfOrigin) {
        dropdownFromCountry.click();
        textfieldFromCountry.sendKeys(countryOfOrigin);
        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", countryOfOrigin))).click();
        return this;
    }
//6.2
    public SearchForVisaPage setCountryOfVisitTo(String countryOfVisit) {
        dropdownToCountry.click();
        textfieldToCountry.sendKeys(countryOfVisit);
        driver.findElement(By.xpath(String.format("//li/em[text()='%s']", countryOfVisit))).click();
        return this;
    }
//6.3?
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
//6.4
    public SearchForVisaPage setVisitDateTo(String visitDate) {
        textfieldDate.sendKeys(visitDate);
        return this;
    }
//6.5 moet current date worden
    public static void setSystemDatePlusOne() {
        org.joda.time.LocalDate date = org.joda.time.LocalDate.now();
        DateTimeFormatter fmt = DateTimeFormat.forPattern("dd-MM-yyyy");
        date = date.plusDays(1);
        String str = date.toString(fmt);
        System.out.println(str);
    {
//6.6
    public SearchForVisaPage submitVisa() {
        buttonSubmit.click();
        return this;
    }
}