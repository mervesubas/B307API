package delete_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Delete01 extends JsonPlaceHolderBaseUrl {
    /*
       Given
           https://jsonplaceholder.typicode.com/todos/198
       When
           I send DELETE Request to the Url
       Then
           Status code is 200
       And Response body is { }
   */
    @Test
    public void test01() {
        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParams("first", "todos", "second", 198);

        // 2- Set the expected data => Beklenen datayi ayarlayın
        Map<String, Object> expectedData = new HashMap<>();

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).when().delete("{first}/{second}");

        // 4- Do assertion => response tan doğrulamalar yapin
        response.then().statusCode(200);

        //1. yol
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(actualData, expectedData);

        //2. yol
        assertEquals(actualData.size(), 0);

        //3. yol
        assertTrue(actualData.isEmpty());
    }
}