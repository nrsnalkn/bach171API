package gmi_bank;

import baseUrl.GmiBankBaseUrl;
import gmi_pojo.CountryPojo;
import gmi_pojo.StatesPojo;
import io.restassured.response.Response;
import org.junit.Test;


import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

public class Postcountry extends GmiBankBaseUrl {
    /*
Given
    https://gmibank.com/api/tp-countries
And
    {
      "name": "Muz Cumhuriyeti",
      "states": [
        {
          "id": 1,
          "name": "Elma"
        },
        {
          "id": 2,
          "name": "Armut"
        },
        {
          "id": 3,
          "name": "Portakal"
        }
      ]
    }
When
    Kullanıcı POST Request gönderir
Then
    Status Code: 201
And
    {
        "id": 194115,
        "name": "Muz Cumhuriyeti",
        "states": [
            {
                "id": 1,
                "name": "Elma",
                "tpcountry": null
            },
            {
                "id": 2,
                "name": "Armut",
                "tpcountry": null
            },
            {
                "id": 3,
                "name": "Portakal",
                "tpcountry": null
            }
        ]
    }
*/

    @Test
    public void postCountry() {
        //set the url
        spec.pathParams("first", "api", "second", "tp-countries");
        //set the expected
        StatesPojo state1 = new StatesPojo("Elma", 1);
        StatesPojo state2 = new StatesPojo("Armut", 2);
        StatesPojo state3 = new StatesPojo("Portakal", 3);
        List<StatesPojo> statesList = new ArrayList<>();
        statesList.add(state1);
        statesList.add(state2);
        statesList.add(state3);
        //2.yol
        List<StatesPojo> statesList2 = List.of(new StatesPojo("elma", 1), new StatesPojo("Armut", 2),
                new StatesPojo("Armut", 3));

        CountryPojo payLoad = new CountryPojo("Muz Cumhuriyeti", statesList);

        //set the request and get the responsa
        Response response = given(spec).body(payLoad).when().post("{first}/{second}");
        response.prettyPrint();
        //do assertion
        CountryPojo acutalData = response.as(CountryPojo.class);
        assertEquals(201, response.statusCode());
        assertEquals(payLoad.getName(), acutalData.getName());
        assertEquals(state1.getId(), acutalData.getStates().get(0).getId());
        assertEquals(state1.getName(), acutalData.getStates().get(0).getName());
        assertEquals(state2.getId(), acutalData.getStates().get(1).getId());
        assertEquals(state2.getName(), acutalData.getStates().get(1).getName());
        assertEquals(state3.getId(), acutalData.getStates().get(2).getId());
        assertEquals(state3.getName(), acutalData.getStates().get(2).getName());


    }
}
