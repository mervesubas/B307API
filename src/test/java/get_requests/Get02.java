package get_requests;

import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get02 {
     /*
        Given
            https://petstore.swagger.io/v2/pet/0
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status code 404 olmalı
        And
            Status Line "HTTP/1.1 404 Not Found" olmalı
        And
            Response body "Pet not found" içermeli
        And
            Response body "TechProEd" içermemeli
        And
            Server değeri "Jetty(9.2.9.v20150224)" olmalı
*/

    /*
    4xx lü kodlarda response ta HttpResponseException hatasi almamak icin
    pom.xml dosyasindaki properties tagi icerisine bu kodu eklemeliyiz
    <argLine>-Duser.language=en</argLine>
     */
    @Test
    public void test01() {
        //set the url
        String url ="https://petstore.swagger.io/v2/pet/0";

        //set the expected data / payload
        //send request get response
        //do assertion
        given()
                .when()
                .get(url)
                .then()
                .statusCode(404);

    }
}
