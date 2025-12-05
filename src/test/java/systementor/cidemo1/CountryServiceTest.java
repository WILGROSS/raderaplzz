package systementor.cidemo1;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.when;

@ExtendWith({MockitoExtension.class})
public class CountryServiceTest {

    CountryApiClient notMockedApiClient = new CountryApiClient();
    CountryService notMockedCountryservice = new CountryService(notMockedApiClient);

    @Mock
    CountryApiClient apiClient;

    @InjectMocks
    CountryService countryService;

    private final static Logger logger = Logger.getLogger(CountryServiceTest.class.getName());

    private static final Country LATVIA = new Country(
            "Latvia",
            "Republic of Latvia",
            "Latvija",
            "Latvijas Republikas",
            "Riga",
            "Europe",
            "Northern Europe",
            Map.of(
                    "lav", "Latvian",
                    "eng", "English"
            ),
            List.of("EST", "LTU", "RUS", "BLR"),
            1829000,
            64559.0,
            "https://goo.gl/maps/iQpUkH7ghq31ZtXe9"
    );


    @Test
    void getSortedLanguagesReturnsAlphabeticallySortedLangues() {
        logger.info("Starting test getSortedLanguagesReturnsAlphabeticallySortedLangues...");

        var result = notMockedCountryservice.getSortedLanguages("Sweden");
        logger.info("Result from getSortedLanguages: " + result);

        assertEquals(List.of("English", "Swedish"), result);
    }


    @Test
    void getSortedBordersReturnsAlphabeticallySortedNeighbouringCountries() {
        logger.info("Starting test getSortedBorders returns alphabetically sorted bordering countries");
        when(apiClient.fetchCountryByName("Latvia"))
                .thenReturn(LATVIA);

        var result = countryService.getSortedBorders("Latvia");

        logger.info("Result from getSortedBorders: " + result.toString());
        assertEquals(List.of("BLR", "EST", "LTU", "RUS"), result);
    }

    @Test
    void isHighlyPopulatedReturnsFalseWhenPopulationIsBelowTenMillion() {
        logger.info("Starting test isHighlyPopulatedReturnsFalseWhenPopulationIsBelowTenMillion");

        when(apiClient.fetchCountryByName("Latvia"))
                .thenReturn(LATVIA);

        var result = countryService.isHighlyPopulated("Latvia");

        logger.info("Result from isHighlyPopulated: " + result);
        assertFalse(result);
    }

    @Test
    void getPopulationDensityReturnsCorrectValue() {
        logger.info("Starting test getPopulationDensityReturnsCorrectValue");
        when(apiClient.fetchCountryByName("Latvia"))
                .thenReturn(LATVIA);

        var result = countryService.getPopulationDensity("Latvia");

        logger.info("Result from getPopulationDensity: " + result);
        assertEquals(LATVIA.getPopulation() / LATVIA.getArea(), result);
    }


    @Test
    void getGoogleMapsUrlReturnsCorrectGoogleMapsUrl() {
        logger.info("Starting test getGoogleMapsUrl returns correct GoogleMapsUrl");
        when(apiClient.fetchCountryByName("Latvia"))
                .thenReturn(LATVIA);

        var result = countryService.getGoogleMapsUrl("Latvia");
        logger.info("Result from getGoogleMapsUrl: " + result);

        assertEquals(LATVIA.getGoogleMapsUrl(), result);
    }

}
