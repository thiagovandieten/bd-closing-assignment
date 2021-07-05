package io.testsmith.webdriver;

import io.testsmith.webdriver.pages.HomePage;
import io.testsmith.webdriver.pages.SearchForVisaPage;
import io.testsmith.webdriver.pages.VisaApplicationPage;
import io.testsmith.webdriver.utils.Date;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.testsmith.webdriver.utils.Date.Tomorrow;


public class Exercises extends TestBase {

    @Test
    public void applyForVisa() throws InterruptedException {

        new HomePage(getDriver())
                .acceptCookies()
                .selectMenuItem("Visa");

        //6.7
        new SearchForVisaPage(getDriver())
                .setCountryOfOriginTo("American Samoa")
                .setCountryOfVisitTo("United States")
                .setVisitDateTo(Tomorrow()) //6.5
                .submitVisa();

        //6.10
        new VisaApplicationPage(getDriver())
                .setVisaFields("Annie", "May", "Annie@outlook.com", "Annie@outlook.com", "777", "1-12-2021");
        String actualString = getDriver().findElement(By.name("first_name")).getAttribute("value");
        Assert.assertTrue(actualString.contains("Annie"));
        new VisaApplicationPage(getDriver())
                .sumbitForm();

        Assert.assertTrue(getDriver().findElement(By.id("submi")).isDisplayed());

        Thread.sleep(5000);

        new VisaApplicationPage(getDriver());
    }
}
