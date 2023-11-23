package get_requests;

import baseUrl.PetsStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get04 extends PetsStoreBaseUrl {
 /*
        Given
            https://petstore.swagger.io/v2/pet/9898
        When
            Kullanıcı URL'e bir GET request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
    */

    @Test
    public void get04() {
        // Set the URL
        spec.pathParams("first", "pet", "second", 1213);
        // Set the expected data
        // Send the request and get the response
        Response response=  given(spec).when().get("{first}/{second}");
        response.prettyPrint();

        // Do assertion
        response
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON);
    }
}
