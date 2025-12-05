package systementor.cidemo1;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public interface CountryApiClient {
    public Country fetchCountryByName(String name);
}
