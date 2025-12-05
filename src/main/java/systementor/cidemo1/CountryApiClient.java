package systementor.cidemo1;

import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CountryApiClient {
    private static final Country SWEDEN = new Country(
            "Latvia",
            "Republic of Latvia",
            "Latvija",
            "Latvijas Republikas",
            "Riga",
            "Europe",
            "Northern Europe",
            Map.of(
                    "sve", "Swedish",
                    "eng", "English"
            ),
            List.of("NOR", "FIN"),
            1829000,
            64559.0,
            "https://goo.gl/maps/iQpUkH7ghq31ZtXe9"
    );

    private static final Country GERMANY = new Country(
            "Deutschland",
            "Deutschland",
            "Germany",
            "Germany",
            "Berlin",
            "Europe",
            "Central Europe",
            Map.of(
                    "deu", "German",
                    "eng", "English"
            ),
            List.of("POL", "BEL", "LUX", "CZH","FRA"),
            123456,
            6789113,
            "https://goo.gl/maps/iQpUkH7ghq31ZtXe9"
    );
    public Country fetchCountryByName(String name){

        if(Objects.equals(name, "Sweden")){
            return SWEDEN;
        }

        return GERMANY;
    }
}
