package get_requests;

import baseurl.PetStoreBaseUrl;
import io.restassured.http.ContentType;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Get05 extends PetStoreBaseUrl {
    /*
    Given
        https://petstore.swagger.io/v2/pet/findByStatus?status=available
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
    And
        Listede id değeri 313 olan bir eleman olmalı
    And
        Listede name değeri "ELMAS" olan bir eleman olmalı
    And
        Listede name değerleri "ELMAS", "doggie", "fish" olan elemanlar olmalı
    And
        Listede en az 200 tane eleman olmalı
    And
        Listede 500'den az eleman olmalı
    And
        Listenin ilk elemanının category - id değeri 0 olmalı
    And
        Listenin ilk elemanının photoUrls değeri "string" olmalı
    And
        Listenin ilk elemanının tags - id değeri 0 olmalı
 */

    @Test
    public void test01() {
        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParams("first", "pet", "second", "findByStatus")
                .queryParam("status", "available");

        // 2- Set the expected data => Beklenen datayi ayarlayın
        // 3- Send request get response => isteği gönderin ve cevabi alin
        given(spec)
                .when()
                .get("{first}/{second}")
                .then() // 4- Do assertion => response tan doğrulamalar yapin
                .statusCode(200)
                .contentType(ContentType.JSON)
                //bu method response body deki tum json datalirn id field larinda 313 degeri varmi yokmu diye kontrol eder
                .body("id", Matchers.hasItem(313))
                .body("name", Matchers.hasItem("ELMAS"))
                .body("name", Matchers.hasItems("ELMAS", "doggie", "fish"))
                //response body deki id field larin sayisinin boyutunun 200 den buyuk olup olmadigini test ediyoruz
                .body("id", hasSize(greaterThan(200)))
                //response body deki id field larin sayisinin boyutunun 500 den kücük olup olmadigini test ediyoruz
                .body("id", hasSize(lessThan(500)))
                .body("[0].category.id",Matchers.equalTo(0))
                .body("[0].photoUrls[0]",Matchers.equalTo("string"))
                .body("[0].tags[0].id",Matchers.equalTo(0))
                .log().body();

    }
}