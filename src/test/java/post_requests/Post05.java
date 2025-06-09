package post_requests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.HerOkuAppBookingDatesPojo;
import pojos.HerOkuAppGetResponsePojo;
import pojos.HerOkuAppPostResponsePojo;

import static io.restassured.RestAssured.given;

public class Post05 extends HerOkuAppBaseUrl {

      /*
        Given
          1)  https://restful-booker.herokuapp.com/booking
          2) {
                "firstname": "Ali",
                "lastname": "Can",
                "totalprice": 999,
                "depositpaid": true,
                "bookingdates": {
                    "checkin": "2021-09-21",
                    "checkout": "2021-12-21"
                 },
                 "additionalneeds": "Breakfast"
              }
        When
            I send POST Request to the URL
        Then
            Status code is 200
        And
            Response body is like
                 {
                    "bookingid": 16,
                    "booking" :{
                        "firstname": "Ali",
                        "lastname": "Can",
                        "totalprice": 999,
                        "depositpaid": true,
                        "bookingdates": {
                            "checkin": "2021-09-21",
                            "checkout": "2021-12-21"
                        },
                        "additionalneeds": "Breakfast"
                     }
                  }
     */


    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParam("first", "booking");

        // 2- Set the expected data / payload => Beklenen datayi ayarlayın
        HerOkuAppBookingDatesPojo bookingDatesPojo = new HerOkuAppBookingDatesPojo("2021-09-21", "2021-12-21");
        HerOkuAppGetResponsePojo payload = new HerOkuAppGetResponsePojo("Ali", "Can", 999, true, bookingDatesPojo, "Breakfast");

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).body(payload).when().post("{first}");

        // 4- Do assertion => response tan doğrulamalar yapin
        HerOkuAppPostResponsePojo actualData = response.as(HerOkuAppPostResponsePojo.class);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(actualData.getBooking().getFirstname(), payload.getFirstname());
        Assert.assertEquals(actualData.getBooking().getLastname(), payload.getLastname());
        Assert.assertEquals(actualData.getBooking().getTotalprice(), payload.getTotalprice());
        Assert.assertEquals(actualData.getBooking().getDepositpaid(), payload.getDepositpaid());
        Assert.assertEquals(actualData.getBooking().getBookingdates().getCheckin(), bookingDatesPojo.getCheckin());
        Assert.assertEquals(actualData.getBooking().getBookingdates().getCheckout(), bookingDatesPojo.getCheckout());
        Assert.assertEquals(actualData.getBooking().getAdditionalneeds(), payload.getAdditionalneeds());

    }
}