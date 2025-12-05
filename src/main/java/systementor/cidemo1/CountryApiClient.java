package systementor.cidemo1;

import java.util.List;
import java.util.Map;

public interface CountryApiClient {
    public default Country fetchCountryByName(String name){

        Country SWEDEN = new Country(
                "Sweden",
                "Kingdom of Sweden",
                "Sverige",
                "Sveriges konungarike",
                "Sthlm",
                "Europe",
                "Northern Europe",
                Map.of(
                        "sve", "Swedish",
                        "eng", "English"
                ),
                List.of("NOR", "FIN"),
                12345,
                678910,
                "https://goo.gl/maps/iQpUkH7ghq31ZtXe9"
        );

        return SWEDEN;
    }
}
