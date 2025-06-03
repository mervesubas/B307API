package patch_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Patch01 extends JsonPlaceHolderBaseUrl {
     /*
    Given
        1) https://jsonplaceholder.typicode.com/todos/198
        2) {
              "title": "Wash the dishes"
           }
    When
      I send PATCH Request to the Url
    Then
          Status code is 200
          And response body is like
              {
                "userId": 10,
                "title": "Wash the dishes",
                "completed": true,
                "id": 198
              }
     */

    @Test
    public void test01() {
        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParams("first","todos","second",198);

        // 2- Set the expected data / payload => Beklenen datayi ayarlayın
        //bu bir patch request oldugu icin degistirmek istedigimiz kısmı yazmamiz yeterli
        Map<String,Object> payload = new HashMap<>();
        payload.put("title","Wash the dishes");
//       payload.put("userId",313);
//       payload.put("completed",false);

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response =
                given(spec)
                        .body(payload)
                        .when()
                        .patch("{first}/{second}");

        // 4- Do assertion => response tan doğrulamalar yapin
        /*
        bu bir patch request oldugu icin payloada sadece güncellemek istedigimiz datayi ekleyip gönderdik
        burada ise set the expected data adimina devam ettik
         */
        payload.put("userId", 10);
        payload.put("completed", true);

        Map<String,Object> actualData = response.as(HashMap.class);
        assertEquals(response.statusCode(),200);
        assertEquals(actualData.get("userId"),payload.get("userId"));
        assertEquals(actualData.get("title"),payload.get("title"));
        assertEquals(actualData.get("completed"),payload.get("completed"));

    }
}