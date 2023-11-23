package delet_requests;

import baseUrl.JsonPlaceHolderBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class Delet01 extends JsonPlaceHolderBaseUrl {
     /*
        Given
            https://jsonplaceholder.typicode.com/todos/198
        When
            I send DELETE Request to the Url
        Then
            Status code is 200
        And Response body is { }
    */

    @Test
    public void delete01() {
        //set the url
        spec.pathParams("first", "todos", "second", 198);

        //set the expected data
        Map<String, String> expectedData = new HashMap<>();

        //set the request and get the response

        Response response = given(spec).when().delete("{first}/{second}");
        response.prettyPrint();

        //do assertion
        assertEquals(200, response.statusCode());
        Map<String, Object> actualData = response.as(HashMap.class);
        //1. yol
        assertEquals(expectedData, actualData);
        //2.yol
        assertTrue(actualData.isEmpty());
        //3.yol
        assertEquals(0, actualData.size());

    }
}
