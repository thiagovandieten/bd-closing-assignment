package io.testsmith.webdriver;

import io.testsmith.webdriver.pages.HomePage;
import io.testsmith.webdriver.pages.SearchForVisaPage;
import io.testsmith.webdriver.pages.VisaApplicationPage;
import org.joda.time.*;
import java.time.LocalDate;
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

        Thread.sleep(5000);

        new VisaApplicationPage(getDriver());
    }
    @Test
    public static void main() {
//        LocalDate localDate = new LocalDate();
        DateTime dateTime = new DateTime();

//        System.out.println("localDate : " + localDate.toString());
        System.out.println("dateTime : " + dateTime.toString());
           }

}
