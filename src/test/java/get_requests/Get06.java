package get_requests;

import baseurl.HerOkuAppBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Get06 extends HerOkuAppBaseUrl {
    /*
        Given
            https://restful-booker.herokuapp.com/booking/4096
        When
            User send a GET request to the URL
        Then
            HTTP Status Code should be 200
        And
            Response content type should contain "application/json"
        And
            Response body should be like;
                {
                    "firstname": "Jim",
                    "lastname": "Brown",
                    "totalprice": 111,
                    "depositpaid": true,
                    "bookingdates": {
                        "checkin": "2018-01-01",
                        "checkout": "2019-01-01"
                    },
                    "additionalneeds": "Breakfast"
                }
     */

    @Test
    public void test01() {
        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParams("first", "booking", "second", 2921);

        // 2- Set the expected data => Beklenen datayi ayarlayın
        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec)
                .when()
                .get("{first}/{second}");

        /*
        HOMEWORK HAMCREST MATCHER İLE TESTİ YAPALİM
         */

        // 4- Do assertion => response tan doğrulamalar yapin
        response.prettyPrint();


        /*=========jsonpath=============*/
        //response.jsonPath()==>response un body kısmını jsonpath objectine dönüstürür

        JsonPath jsonPath = response.jsonPath();
        String firstname = jsonPath.getString("firstname");
        System.out.println("firstname = " + firstname);

        int totalprice = jsonPath.getInt("totalprice");
        System.out.println("totalprice = " + totalprice);

        boolean depositpaid = jsonPath.getBoolean("depositpaid");
        System.out.println("depositpaid = " + depositpaid);
        /*=========jsonpath=============*/

        assertEquals(jsonPath.getString("firstname"),"Jim");
        assertEquals(jsonPath.getString("lastname"),"Brown");
        assertEquals(jsonPath.getInt("totalprice"),111);
        assertTrue(jsonPath.getBoolean("depositpaid"));
        assertEquals(jsonPath.getString("bookingdates.checkin"),"2018-01-01");
        assertEquals(jsonPath.getString("bookingdates.checkout"),"2019-01-01");
        assertEquals(jsonPath.getString("additionalneeds"),"Breakfast");
    }
}