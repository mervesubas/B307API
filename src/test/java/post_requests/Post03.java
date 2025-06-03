package post_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import utilities.ReUsableMethods;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Post03 extends JsonPlaceHolderBaseUrl {
     /*
        Given
            1) https://jsonplaceholder.typicode.com/todos
            2) {"userId": 55,"title": "Tidy your room","completed": false}
        When
            I send POST Request to the Url
        Then
            Status code is 201
        And
            response body is like
            {
                "userId": 55,
                "title": "Tidy your room",
                "completed": false,
                "id": 201
            }
     */

    @Test
    public void test01() throws JsonProcessingException {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParam("first", "todos");

        // 2- Set the expected data => Beklenen datayi ayarlayın
        String json = "{\"userId\": 55,\"title\": \"Tidy your room\",\"completed\": false}";
        ObjectMapper objectMapper = new ObjectMapper();
        Map<String, Object> payload = objectMapper.readValue(json, HashMap.class);
        System.out.println("payload = " + payload);
        /*
        ObjectMapper classinda bulunan readvalue methodu sayesinde uzun yoldan map olusturamya gerek kalmaz
        bu method bizden string olarak json datayi alir ve Map a dönüstürür
        import com.fasterxml.jackson.databind.ObjectMapper;
         */

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).body(payload).when().post("{first}");

        // 4- Do assertion => response tan doğrulamalar yapin
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(response.statusCode(), 201);
        assertEquals(actualData.get("userId"), payload.get("userId"));
        assertEquals(actualData.get("title"), payload.get("title"));
        assertEquals(actualData.get("completed"), payload.get("completed"));
    }

    //object mapper reusable method usage
    @Test
    public void test02() throws JsonProcessingException {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParam("first", "todos");

        // 2- Set the expected data => Beklenen datayi ayarlayın
        String json = "{\"userId\": 55,\"title\": \"Tidy your room\",\"completed\": false}";
        Map<String, Object> payload = ReUsableMethods.jsonToMap(json);

        /*
        ObjectMapper classinda bulunan readvalue methodu sayesinde uzun yoldan map olusturamya gerek kalmaz
        bu method bizden string olarak json datayi alir ve Map a dönüstürür
        import com.fasterxml.jackson.databind.ObjectMapper;
         */

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).body(payload).when().post("{first}");

        // 4- Do assertion => response tan doğrulamalar yapin
        Map<String, Object> actualData = response.as(HashMap.class);
        assertEquals(response.statusCode(), 201);
        assertEquals(actualData.get("userId"), payload.get("userId"));
        assertEquals(actualData.get("title"), payload.get("title"));
        assertEquals(actualData.get("completed"), payload.get("completed"));
    }
}