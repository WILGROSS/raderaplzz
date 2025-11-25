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
                .get("https://api.open-meteo.com/v1/forecast" +
                        "?latitude=52.52" +
                        "&longitude=13.41" +
                        "&current=temperature_2m,wind_speed_10m" +
                        "&hourly=temperature_2m,relative_humidity_2m,wind_speed_10m");

        // förväntan
        assertEquals(200, response.statusCode(),
                "Expected API to return 200 OK");

        // debug-logg (visas i Actions)
        System.out.println("Response status: " + response.statusCode());
        System.out.println("Body preview: " + response.body().asString());
    }
}