package io.testsmith.restassured;

import io.restassured.http.ContentType;
import io.testsmith.restassured.models.Booking;
import io.testsmith.restassured.models.BookingDates;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Exercises {

    @Test
    public void getBooking_checkStatusCode_shouldReturnHttp200() {

        /**
         * Perform a GET to https://restful-booker.herokuapp.com/booking/<your_booking_id>
         * and check that the status code equals 200
         */

        given().when().then();
    }

    @Test
    public void getBooking_checkAdditionalNeeds_shouldReturnBreakfast() {

        /**
         * Perform a GET to https://restful-booker.herokuapp.com/booking/<your_booking_id>
         * and check that the value of the JSON response body element
         * 'additionalneeds' equals 'Breakfast'
         */

        given().when().then();
    }

    @Test
    public void getBooking_deserializeResponse_checkFirstName() {

        /**
         * Perform a GET to https://restful-booker.herokuapp.com/booking/<your_booking_id>.
         * Deserialize the JSON response to an instance of the Booking class.
         * You don't need to create or modify the Booking class yourself
         * Use a JUnit assertion to check that the value of the 'firstname' element
         * is equal to your supplied first name.
         */

        Booking booking =

                given()
                        .when()
                        .get("https://restful-booker.herokuapp.com/booking/23")
                        .as(Booking.class);

        Assert.assertEquals("Roy", booking.getFirstName());
    }

    @Test
    public void createBooking_extractId_retrieveBooking_checkLastName() {

        Booking booking = new Booking();
        BookingDates bookingDates = new BookingDates();

        bookingDates.setCheckIn("01-01-2020");
        bookingDates.setCheckOut("01-01-2021");

        booking.setFirstName("Roy");
        booking.setLastName("de Kleijn");
        booking.setTotalPrice(500);
        booking.setBookingDates(bookingDates);
        booking.setAdditionalNeeds("Breakfast");

        /**
         * Perform a POST to https://restful-booker.herokuapp.com/booking,
         * using the booking object created above as the payload.
         * Don't remove the call to contentType(), otherwise it will not work :)
         *
         * Extract and store the generated bookingid as an integer.
         */

        int bookingId =

                given()
                        .contentType(ContentType.JSON)
                        .when().post().then().extract().path("");

        /**
         * Use that value as a path
         * parameter to retrieve the booking once again, and check that the last name is equal
         * to the value you set before. Either deserialize the response like in the previous exercise,
         * or use body("", equalTo("")) directly.
         *
         * You don't need to create or modify the Booking class yourself
         */

        given().when().then();

    }
}
