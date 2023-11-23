package post_requests;

import baseUrl.PetsStoreBaseUrl;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class Post01 extends PetsStoreBaseUrl {
    /*
        Given
            https://petstore.swagger.io/v2/pet
        And
            {
                "id": 0,
                "category": {
                    "id": 0,
                    "name": "Köpek"
                },
                "name": "Pamuk",
                "photoUrls": [
                    "string"
                ],
                "tags": [
                    {
                        "id": 0,
                        "name": "Sibirya Kurdu"
                    }
                ],
                "status": "available"
            }
        When
            Kullanıcı URL'e bir POST request gönderir
        Then
            HTTP Status Code 200 olmalı
        And
            Content Type "application/json" olmalı
     */

    @Test
    public void post01() {
        //set the url
        spec.pathParam("first","pet");
        //set the expected data(payload)
        String payload ="{ \n" +
                "                \"id\": 0, \n" +
                "                \"category\": { \n" +
                "                    \"id\": 0, \n" +
                "                    \"name\": \"Köpek\" \n" +
                "                }, \n" +
                "                \"name\": \"Pamuk\", \n" +
                "                \"photoUrls\": [ \n" +
                "                    \"string\" \n" +
                "                ], \n" +
                "                \"tags\": [ \n" +
                "                    { \n" +
                "                        \"id\": 0, \n" +
                "                        \"name\": \"Sibirya Kurdu\" \n" +
                "                    } \n" +
                "                ], \n" +
                "                \"status\": \"available\" \n" +
                "            }";
        //set the request and get the respons
     Response response= given(spec).body(payload).when().post("{first}");
     response.prettyPrint();

     //do assertion
        response.then().statusCode(200).contentType(ContentType.JSON);

    }
}
