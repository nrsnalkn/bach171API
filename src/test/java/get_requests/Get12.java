package get_requests;

import baseUrl.HerokuAppBaseUrl;
import io.restassured.response.Response;
import org.junit.Test;
import pojos.herokuapp.BookingDatesPojo;
import pojos.herokuapp.BookingPojo;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Get12 extends HerokuAppBaseUrl {
    /*
     Given
         https://restful-booker.herokuapp.com/booking/535
     When
         I send GET Request to the URL
     Then
         Status code is 200
     And
         Response body is like:
             {
    "firstname" : "John",
    "lastname" : "Smith",
    "totalprice" : 111,
    "depositpaid" : true,
    "bookingdates" : {
        "checkin" : "2018-01-01",
        "checkout" : "2019-01-01"
    },
    "additionalneeds" : "Extra pillows please"
}
  */

    @Test
    public void get12() {
        //set the url
        spec.pathParams("first","booking","second",249);

        //set the expected data
        BookingDatesPojo bookingDates = new BookingDatesPojo("2018-01-01","2019-01-01");
        BookingPojo expecdetData = new BookingPojo("John","Smith",111,true,bookingDates,"Breakfast");

        //set the request and get the response
     Response response = given(spec).when().get("{first}/{second}");//serialization
     response.prettyPrint();

     //do assertion
        BookingPojo actualData = response.as(BookingPojo.class);//de serialization
        assertEquals(200,response.statusCode());

        assertEquals(expecdetData.getFirstname(),actualData.getFirstname());
        assertEquals(expecdetData.getLastname(),actualData.getLastname());
        assertEquals(expecdetData.getTotalprice(),actualData.getTotalprice());
        assertEquals(expecdetData.getDepositpaid(),actualData.getDepositpaid());
        assertEquals(expecdetData.getAdditionalneeds(),actualData.getAdditionalneeds());
        assertEquals(expecdetData.getBookingdates().getCheckin(),actualData.getBookingdates().getCheckin());
        assertEquals(expecdetData.getBookingdates().getCheckout(),actualData.getBookingdates().getCheckout());


    }
}
