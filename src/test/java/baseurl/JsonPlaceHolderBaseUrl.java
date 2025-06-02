package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

public class JsonPlaceHolderBaseUrl {

    /*
    Her test ten önce calisarak ihtiyac duyabileceğimiz cesitli configurasyonlari tamamlamaktir
    Mesela Baseurl, content type, authorization gibi yapilandirmalari tek bir merkezden güncellemeyi saglar
    böylece testlerin bakimi daha kolay olur
     */
    protected RequestSpecification spec;
    @BeforeMethod
    public void setUp() {
        spec = new RequestSpecBuilder()
                .setBaseUri("https://jsonplaceholder.typicode.com")
                .setContentType(ContentType.JSON)
                .build();
    }


}