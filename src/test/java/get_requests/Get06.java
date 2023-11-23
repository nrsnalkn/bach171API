package get_requests;

import baseUrl.ContactListBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.*;

public class Get06 extends ContactListBaseUrl {
    @Test
    public void get06() {
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
        //set the url
        spec.pathParam("first","contacts");
        //set the expected data

        //send the request and get the response
        Response response= given(spec)
                .when().get("{first}");
        response.prettyPrint();
        //do assertion
        response.then().statusCode(200).contentType(ContentType.JSON);



    }


}
