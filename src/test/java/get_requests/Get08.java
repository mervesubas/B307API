package get_requests;

import baseurl.JsonPlaceHolderBaseUrl;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class Get08 extends JsonPlaceHolderBaseUrl {
    /*
    Given
       https://jsonplaceholder.typicode.com/todos
    When
       Kullanıcı URL'e bir GET request gönderir
    Then
        Status code 200 olmalı
        "Id"leri 190 dan büyük olanları konsola yazdırın
        "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
 */

    @Test
    public void test01() {

        // 1- Set the url =>API in end pointi ayarlayin
        spec.pathParam("first", "todos");

        // 2- Set the expected data => Beklenen datayi ayarlayın
        // 3- Send request get response => isteği gönderin ve cevabi alin
        Response response = given(spec).when().get("{first}");
        response.prettyPrint();
        System.out.println("========================================");

        // 4- Do assertion => response tan doğrulamalar yapin

        JsonPath jsonPath = response.jsonPath();
        List<Object> idList = jsonPath.getList("id");
        System.out.println("idList = " + idList);
        System.out.println("========================================");


        List<Object> titleList = jsonPath.getList("title");
        System.out.println("titleList = " + titleList);
        System.out.println("========================================");


        List<Object> completedList = jsonPath.getList("completed");
        System.out.println("completed = " + completedList);
        System.out.println("========================================");
        //================assertion=============================
        // Status code 200 olmalı
        response.then().statusCode(200);

        // "Id"leri 190 dan büyük olanları konsola yazdırın
        List<Object> idsi190danbuyukolanlar = jsonPath.getList("findAll{it.id>190}");
        System.out.println("idsi190danbuyukolanlar = " + idsi190danbuyukolanlar);
        /*
        idsi190danbuyukolanlar =
        [{userId=10, id=191, title=temporibus atque distinctio omnis eius impedit tempore molestias pariatur, completed=true},
        {userId=10, id=192, title=ut quas possimus exercitationem sint voluptates, completed=false},
        {userId=10, id=193, title=rerum debitis voluptatem qui eveniet tempora distinctio a, completed=true},
        {userId=10, id=194, title=sed ut vero sit molestiae, completed=false},
        {userId=10, id=195, title=rerum ex veniam mollitia voluptatibus pariatur, completed=true},
        {userId=10, id=196, title=consequuntur aut ut fugit similique, completed=true},
        {userId=10, id=197, title=dignissimos quo nobis earum saepe, completed=true},
        {userId=10, id=198, title=quis eius est sint explicabo, completed=true},
        {userId=10, id=199, title=numquam repellendus a magnam, completed=true},
        {userId=10, id=200, title=ipsam aperiam voluptates qui, completed=false}]
         */

        // "Id"si 190 dan büyük 10 adet veri olduğunu doğrulayın
        Assert.assertEquals(idsi190danbuyukolanlar.size(), 10);

        // "Id"si 5 den küçük olan tüm kullanıcıların "userid"lerini yazdırın
        List<Object> idsi5tenkucukolanlar = jsonPath.getList("findAll{it.id<5}");
        System.out.println("idsi5tenkucukolanlar = " + idsi5tenkucukolanlar);
        /*
        idsi5tenkucukolanlar =
        [{userId=1, id=1, title=delectus aut autem, completed=false},
        {userId=1, id=2, title=quis ut nam facilis et officia qui, completed=false},
        {userId=1, id=3, title=fugiat veniam minus, completed=false},
        {userId=1, id=4, title=et porro tempora, completed=true}]
         */
        List<Object> userIdList = jsonPath.getList("findAll{it.id<5}.userId");
        System.out.println("userIdList = " + userIdList);//userIdList = [1, 1, 1, 1]

        // "Id"si 5 den küçük olan 4 kullanıcı olduğunu doğrulayın
        Assert.assertEquals(userIdList.size(), 4);

        // "Id" si 5 ten küçük tüm kullanıcıların "title" larını yazdırın
        List<Object> idsi5tenkucukolanlarintitlelari = jsonPath.getList("findAll{it.id<5}.title");
        System.out.println("idsi5tenkucukolanlarintitlelari = " + idsi5tenkucukolanlarintitlelari);

        /*
        idsi5tenkucukolanlarintitlelari =
        [delectus aut autem, quis ut nam facilis et officia qui, fugiat veniam minus, et porro tempora]
         */

        // "delectus aut autem" başlığının, id numarası 5 den küçük bir kullanıcıya ait olduğunu doğrulayın
        Assert.assertTrue(idsi5tenkucukolanlarintitlelari.contains("delectus aut autem"));
    }
}