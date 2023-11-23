package baseUrl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class PetsStoreBaseUrl {
  protected   RequestSpecification spec;
    @Before
    public void setUp() {
         spec = new RequestSpecBuilder()
                .setBaseUri("https://petstore.swagger.io/v2")
                 .setContentType(ContentType.JSON)
                .build();

    }
}
