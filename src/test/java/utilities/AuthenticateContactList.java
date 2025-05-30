package utilities;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticateContactList {
    /*
    Bu classin amaci Contact list api inda request yaparken ihtiyac duyacağımız
    token i dynamic olarak olusturmak ve bunu baseurl classina göndermektir
     */

    public static String generateToken() {
        //set the url
        String url = "https://thinking-tester-contact-list.herokuapp.com/users/login";

        //set the payload
        String payload = "{\n" +
                "    \"email\": \"mehmet@can.an\",\n" +
                "    \"password\": \"1234567\"\n" +
                "}";

        //send request get response
        Response response = given()
                .body(payload)
                .contentType(ContentType.JSON)
                .when()
                .post(url);

        return response.jsonPath().getString("token");
    }


}