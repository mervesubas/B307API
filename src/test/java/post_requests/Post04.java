package post_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;
import pojos.JsonPlaceHolderPayloadPojo;

import static io.restassured.RestAssured.given;

public class Post04  extends JsonPlaceHolderBaseUrl {
     /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }
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
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParam("first","todos");

        // 2- Set the expected data => Beklenen datayi ayarlayın
        JsonPlaceHolderPayloadPojo payload = new JsonPlaceHolderPayloadPojo(55,"Tidy your room",false);

        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).body(payload).when().post("{first}");

        // 4- Do assertion => response tan doğrulamalar yapin
        JsonPlaceHolderPayloadPojo actualData = response.as(JsonPlaceHolderPayloadPojo.class);
        Assert.assertEquals(response.statusCode(),201);
        Assert.assertEquals(actualData.getUserId(),payload.getUserId());
        Assert.assertEquals(actualData.getTitle(),payload.getTitle());
        Assert.assertEquals(actualData.getCompleted(),payload.getCompleted());


    }
}