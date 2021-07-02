package io.testsmith.webdriver;

import io.testsmith.webdriver.pages.HomePage;
import io.testsmith.webdriver.pages.SearchForVisaPage;
import io.testsmith.webdriver.pages.VisaApplicationPage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;


public class Exercises extends TestBase {

    @Test
    public void applyForVisa() throws InterruptedException {

        new HomePage(getDriver())
                .acceptCookies()
                .selectMenuItem("Visa");

        new SearchForVisaPage(getDriver())
                .setCountryOfOriginTo("American Samoa")
                .setCountryOfVisitTo("United States")
                .setVisitDateTo("01-09-2021")
                .submitVisa();
//                .setVisaTotal("American Samoa","United States","01-09-2021");

        new VisaApplicationPage(getDriver())
            .setVisaFields("Annie", "May","Annie@outlook.com","Annie@outlook.com","777","1-12-2021");
        String actualString = getDriver().findElement(By.name("first_name")).getText();
        Assert.assertTrue(actualString.contains("Annie"));
        new VisaApplicationPage(getDriver())
                .sumbitForm();

        Assert.assertTrue(getDriver().findElement(By.id("submi")).isDisplayed());

        Thread.sleep(5000);

        new VisaApplicationPage(getDriver());

        System.out.println(actualString);
    }
    @Test
    public static void main() {
        org.joda.time.LocalDate localDate = new org.joda.time.LocalDate();
        System.out.println("localDate : " + localDate.toString());
           }

}
