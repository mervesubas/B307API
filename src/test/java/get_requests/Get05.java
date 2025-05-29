package get_requests;

import org.testng.annotations.Test;

public class Get05 {
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
        // 2- Set the expected data => Beklenen datayi ayarlayın
        // 3- Send request get response => isteği gönderin ve cevabi alin
        // 4- Do assertion => response tan doğrulamalar yapin
    }
}