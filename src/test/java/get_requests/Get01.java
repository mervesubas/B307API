package get_requests;

import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get01 {
          /*
        Given
            https://petstore.swagger.io/v2/pet/5
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
        And
            Status Line "HTTP/1.1 200 OK" olmalı
    */

    @Test
    public void test01() {
        //1- Set the url
        String url = "https://petstore.swagger.io/v2/pet/5";
        //2- Set the expected data / payload
        //3- Send request get response
        Response response = given().when().get(url);
        response.prettyPrint();

        //4- Do assertion
        response.then().assertThat().statusCode(200)//status codun 200 oldugunu doğrular
                .and().assertThat().contentType("application/json")//content type in application/json oldugunu doğrular
                .and().assertThat().statusLine("HTTP/1.1 200 OK");//status line in "HTTP/1.1 200 OK" oldugunu doğrular
    }


    //ikinci yol
    @Test
    public void test02() {
        //1- Set the url
        String url = "https://petstore.swagger.io/v2/pet/5";
        //2- Set the expected data / payload
        //3- Send request get response
        Response response = given().when().get(url);
        response.prettyPrint();

        //4- Do assertion
        response.
                then().
                statusCode(200).//status codun 200 oldugunu doğrular
                contentType("application/json").//content type in application/json oldugunu doğrular
                statusLine("HTTP/1.1 200 OK").//status line in "HTTP/1.1 200 OK" oldugunu doğrular
                //log().body()//tıpkı prettyprint() gibi response body kısmını console a yazdirir
                        log().all();//response taki body ve headerin hepsini console a yazdirir

    }


}