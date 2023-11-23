package get_requests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;


public class Get02 {
    @Test
    public void get02() {
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
        1.set the url
        2.set the expected data
        3.Send the request and get the response
        4.do assertion
         */
        //  1.set the url

        RestAssured.baseURI="https://petstore.swagger.io/v2";
        RestAssured.basePath="/pet/0";

        //2.set the expected data Post,Put gibi body gerektiren sorgularda ve
        // Get,Delete gibi response'tan bekledigimiz datayi biliyorsak kullaniriz

        //3.Send the request and get the response
     Response response = given().when().get();
     response.prettyPrint();
     //4. do assertion
        response
                .then().assertThat().statusCode(404)
                .statusLine("HTTP/1.1 404 Not Found")
                .body(containsString("Pet not found"))
                .body(not(containsString("TechProEd"))).header("server","Jetty(9.2.9.v20150224)");

    }
}
