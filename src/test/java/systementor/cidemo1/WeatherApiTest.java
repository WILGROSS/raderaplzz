package systementor.cidemo1;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WeatherApiTest {

    @Test
    void getForecastShouldReturn200() {

        Response response = RestAssured
                .given()
                .get("GET https://api.thingspeak.com/update?api_key=ASDF1234&field1=0");

        assertEquals(200, response.statusCode(),
                "Expected API to return 200 OK");

        System.out.println("Response status: " + response.statusCode());
        System.out.println("Body preview: " + response.body().asString());
    }
}