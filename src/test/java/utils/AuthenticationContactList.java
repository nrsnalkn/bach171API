package utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class AuthenticationContactList {

    public static String generateToken(){//token alma
        String body = "{\n" +
                "    \"email\": \"valen.nicco@free2ducks.com\",\n" +
                "    \"password\": \"123456Ab!\"\n" +
                "}";
      Response response= given()
                .body(body)
                .contentType(ContentType.JSON).when().post("https://thinking-tester-contact-list.herokuapp.com/users/login");
      return response.jsonPath().getString("token");
    }
}
