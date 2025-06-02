package post_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class Post02 extends JsonPlaceHolderBaseUrl {

  /*
    Given
       1) https://jsonplaceholder.typicode.com/todos
       2)  {
             "userId": 55,
             "title": "Tidy your room",
             "completed": false
           }

        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            Status code 201 olmalı
        And
            Response şu şekilde olmalı:
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

        // 2- Set the expected data / payload => Beklenen datayi ayarlayın
        /*
        String kullanmak ta bir yöntemdir ama assertion icin bu kullanimi tavsiye etmiyoruz

                String payload="{\n" +
                "             \"userId\": 55,\n" +
                "             \"title\": \"Tidy your room\",\n" +
                "             \"completed\": false\n" +
                "           }";
         */

        //json formatina en yakin data type olarak Map kullaniyoruz
        Map<String,Object> payload = new HashMap<>();
        payload.put("userId",55);
        payload.put("title","Tidy your room");
        payload.put("completed",false);
        System.out.println("payload = " + payload);
        // payload = {completed=false, title=Tidy your room, userId=55}


        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec)
                .body(payload)
                .when()
                .post("{first}");
        response.prettyPrint();

        /*
        Serialization : Java datalarinin JSON datalarina dönüstürülmesi islemidir
        De- Serialization : JSON datalarinin Java datalarina dönüstürülmesi islemidir
        pom.xml icerisine ekledigimiz Jackson databind gibi kutuphaneler serialization ve
        de-serialization islemlerini otomatik olarak yapar, bizim extra bir sey yapmamiza gerek kalmaz
         */

        // 4- Do assertion => response tan doğrulamalar yapin
        JsonPath jsonPath = response.jsonPath();
        Assert.assertEquals(jsonPath.getInt("userId"),payload.get("userId"));
        Assert.assertEquals(jsonPath.getString("title"),payload.get("title"));
        Assert.assertEquals(jsonPath.getBoolean("completed"),payload.get("completed"));
    }
}