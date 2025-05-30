package get_requests;

import baseurl.ContactListBaseUrl;
import io.restassured.http.ContentType;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class Get07 extends ContactListBaseUrl {
/*
    Given
        https://thinking-tester-contact-list.herokuapp.com/contacts
    When
        Kullanıcı URL'e bir GET request gönderir
    Then
        HTTP Status Code 200 olmalı
    And
        Content Type "application/json" olmalı
 */
    @Test
    public void test01() {
       // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParam("first","contacts");

       // 2- Set the expected data => Beklenen datayi ayarlayın
       // 3- Send request get response => isteği gönderin ve cevabi alin
        given(spec)
               // .header("Authorization","eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJfaWQiOiI2ODJmNDIzNWY3YTgwMTAwMTVjN2QzMWEiLCJpYXQiOjE3NDg1NDcwNDV9.UuGNR40k97WNfkcjIyexwdm-JnIMGFT3q1BKVsbN-LM")
                .when()
                .get("{first}")
                .then() // 4- Do assertion => response tan doğrulamalar yapin
                .statusCode(200)
                .contentType(ContentType.JSON);

    }
}
