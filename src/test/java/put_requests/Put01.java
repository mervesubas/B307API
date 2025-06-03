package put_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Put01 extends JsonPlaceHolderBaseUrl {
    /*
        Given
            1) https://jsonplaceholder.typicode.com/todos/198
            2) {
                 "userId": 21,
                 "title": "Wash the dishes",
                 "completed": false
               }
        When
            Kullanıcı URL'e bir PUT request gönderir
        Then
           Status code 200 olmalı
           Response şu şekilde olmalı:
           {
                "userId": 21,
                "title": "Wash the dishes",
                "completed": false
                "id": 198
           }
     */

    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParams("first", "todos", "second", 198);

        // 2- Set the expected data /payload => Beklenen datayi ayarlayın

        /*String payload ="{\n" +
                "                 \"userId\": 21,\n" +
                "                 \"title\": \"Wash the dishes\",\n" +
                "                 \"completed\": false\n" +
                "               }";*/
        Map<String, Object> payload = new HashMap<>();
        payload.put("userId", 21);
        payload.put("title", "Wash the dishes");
        payload.put("userId", false);

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).body(payload).when().put("{first}/{second}");

        // 4- Do assertion => response tan doğrulamalar yapin
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(response.statusCode(),200);
        assertEquals(actualData.get("userId"),payload.get("userId"));
        assertEquals(actualData.get("title"),payload.get("title"));
        assertEquals(actualData.get("completed"),payload.get("completed"));


    }
}