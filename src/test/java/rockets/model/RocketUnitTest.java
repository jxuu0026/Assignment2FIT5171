package rockets.model;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;


public class RocketUnitTest {

    private Rocket rocket;

    private String nameRocket = "" ;

    private String countryRocket = "" ;

    private LaunchServiceProvider mockLSP;

    private RocketFamily mockFamily;

    private LaunchServiceProvider manufacturerRocket   = new LaunchServiceProvider("SpaceX", 2002, "USA");;





    @BeforeEach
    public void setUp() {

        mockFamily = mock(RocketFamily.class);
        mockLSP = mock(LaunchServiceProvider.class);
        rocket = new Rocket(nameRocket, countryRocket, manufacturerRocket);
    }


    @DisplayName("should throw exception when pass null to setmasstoleo function")
    @Test
    public void shouldThrowExceptionWhenSetmasstoleoToNull() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> rocket.setMassToLEO(null));
        assertEquals("masstoleo cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass not numbers to setmasstoleo function")
    @Test
    public void shouldThrowExceptionWhenSetNotNumbersToMassToLeo() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rocket.setMassToLEO("abc"));
        assertEquals("Ratio should be numbers", exception.getMessage());
    }


    @DisplayName("should throw exception when pass a empty string to setMassToLeo")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetEmptyToSetMassToLeo(String masstoleo) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rocket.setMassToLEO(masstoleo));
        assertEquals("masstoleo cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setmasstogto function")
    @Test
    public void shouldThrowExceptionWhenSetMassToGTO() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> rocket.setMassToGTO(null));
        assertEquals("masstogto cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass not numbers to setmasstogto function")
    @Test
    public void shouldThrowExceptionWhenSetNotNumbersToMassToGto() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rocket.setMassToLEO("abc"));
        assertEquals("Ratio should be numbers", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty string to setMassToGto")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetMassToGeoToEmpty(String masstogto) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rocket.setMassToLEO(masstogto));
        assertEquals("masstoleo cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass null to setmasstoother function")
    @Test
    public void shouldThrowExceptionWhenSetMassToOther() {
        NullPointerException exception = assertThrows(NullPointerException.class, () -> rocket.setMassToOther(null));
        assertEquals("masstoother cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass a empty string to setMassToOther")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "  "})
    public void shouldThrowExceptionWhenSetMassToGeoToOther(String masstoother) {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rocket.setMassToOther(masstoother));
        assertEquals("masstoother cannot be null or empty", exception.getMessage());
    }

    @DisplayName("should throw exception when pass not numbers to setmasstoOther function")
    @Test
    public void shouldThrowExceptionWhenSetNotNumbersToMassToOther() {
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> rocket.setMassToLEO("abc"));
        assertEquals("Ratio should be numbers", exception.getMessage());
    }

    @DisplayName("should return true when two rockets equals")
    @Test
    public void shouldReturnTrueWhenTwoRocketsEquals() {
        nameRocket = "Jingshuai";
        countryRocket = "China";
        manufacturerRocket =  new LaunchServiceProvider("SpaceX", 2002, "USA");
        Rocket anotherRocket = new Rocket("Jingshuai","China", manufacturerRocket);
        rocket = new Rocket(nameRocket, countryRocket, manufacturerRocket);
        assertTrue(rocket.equals(anotherRocket));

    }

    @DisplayName("should return false when two rockets not equals")
    @Test
    public void shouldReturnTrueWhenTwoRocketsNotEquals() {
        nameRocket = "Jingshuai";
        countryRocket = "China";
        manufacturerRocket = new LaunchServiceProvider("SpaceX", 2002, "USA");
        Rocket anotherRocket = new Rocket("JingshuaiXu","China",manufacturerRocket);
        rocket = new Rocket(nameRocket, countryRocket, manufacturerRocket);
        assertFalse(rocket.equals(anotherRocket));

    }

    @DisplayName("should harsh infor correctly")
    @Test
    public void shouldHarshInforCorrectly() {
        String name = "Jingshuai";
        String country = "China";
        LaunchServiceProvider manufacturer  = new LaunchServiceProvider("SpaceX", 2002, "USA");
        Rocket anotherRocket = new Rocket(name,country,manufacturer);

        assertEquals(786787962,anotherRocket.hashCode());
    }

    @DisplayName("should return string correctly")
    @Test
    public void shouldReturnStringCorrectly() {
        String name = "Jingshuai";
        String country = "China";
        LaunchServiceProvider manufacturer  = new LaunchServiceProvider("SpaceX", 2002, "USA");
        String massToLEO = "111";
        String massToGTO = "222";
        String massToOther = "333";

        Rocket anotherRocket = new Rocket(name,country,manufacturer);
        anotherRocket.setMassToLEO(massToLEO);
        anotherRocket.setMassToGTO(massToGTO);
        anotherRocket.setMassToOther(massToOther);

        String manu = manufacturer.toString();
        assertEquals("Rocket{" +
                "name='" + "Jingshuai" + '\'' +
                ", country='" + "China" + '\'' +
                ", manufacturer='" + manu + '\'' +
                ", massToLEO='" + "111" + '\'' +
                ", massToGTO='" + "222" + '\'' +
                ", massToOther='" + "333" + '\'' +
                '}',anotherRocket.toString());
    }


    @DisplayName("should set setServiceProvider and getServiceProvider correctly using mock Rocket class")
    @Test
    public void shouldsetServiceProviderMockClass() {

        rocket.setLaunchServiceProvider(mockLSP);

        assertEquals(mockLSP,rocket.getManufacturer());

    }
}