package systementor.cidemo1;



public class CountryServiceTest {

    @Test
    void getSortedLaungagesReturnsAlphabeticallySortedLangues() {
        when(countryApiClient.fetchCountryByName("Latvia"))
            .thenReturn(LATVIA);

        var result = countryService.getSortedBorders("Latvia");

        assertEquals(List.of("English", "Latvian"), result);
    }

}
