package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationGMIBank {

    public static String generateToken(){//token alma
        String body = "{\n" +
                "  \"password\": \"Mark.123\",\n" +
                "  \"rememberMe\": true,\n" +
                "  \"username\": \"mark_twain\"\n" +
                "}";
      Response response= given()
                .body(body)
                .contentType(ContentType.JSON).when().post("https://gmibank.com/api/authenticate");
      return response.jsonPath().getString("id_token");
    }
}
