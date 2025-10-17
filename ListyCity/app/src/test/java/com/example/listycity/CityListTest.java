package com.example.listycity;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;


class CityListTest {
    private CityList mockCityList() {
        CityList cityList = new CityList();
        cityList.add(mockCity());
        return cityList;
    }
    private City mockCity() {
        return new City("Edmonton", "Alberta");
    }

    @Test
    void testAdd() {
        CityList cityList = mockCityList();
        assertEquals(1, cityList.getCities().size());
        City city = new City("Regina", "Saskatchewan");
        cityList.add(city);
        assertEquals(2, cityList.getCities().size());
        assertTrue(cityList.getCities().contains(city));
    }

    @Test
    void testAddException() {
        CityList cityList = mockCityList();
        City city = new City("Yellowknife", "Northwest Territories");
        cityList.add(city);
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.add(city);
        });
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();
        // This line checks if the first city in the cityList (retrieved by cityList.getCities().get(0))
        // is the same as the city returned by mockCity()
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));
        // This pushes down the original city
        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);
        // Now the original city should be at position 1
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }


    @Test
    void testHasCity() {
        CityList cityList = mockCityList();

        // Creates a new city
        City city = new City("Charlottetown", "Prince Edward Island");

        // Confirms we do not have the city
        assertFalse(cityList.hasCity(city));

        // Adds the city, and checks whether it has been added
        cityList.add(city);
        assertTrue(cityList.hasCity(city));
    }

    @Test
    void testDelete() {
        CityList cityList = mockCityList();

        City city = new City("Charlottetown", "Prince Edward Island");

        // Adds the city, and checks whether it has been added
        cityList.add(city);

        // Checks that we have the city, then deletes it
        assertTrue(cityList.hasCity(city));
        cityList.delete(city);

        // Confirms city has been deleted, and then confirms the function throws an error when
        // the function cannot delete the city
        assertFalse(cityList.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(city);
        });


    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        // Creates three cities
        City city1 = new City("Charlottetown", "Prince Edward Island");
        City city2 = new City("Victoria", "BC");
        City city3 = new City("Calgary", "Alberta");

        // Confirms we only have 1 city
        assertEquals(1,cityList.countCities());

        // Confirms we have 2 once one is added
        cityList.add(city1);
        assertEquals(2,cityList.countCities());

        // Confirms we have 3 when another is added
        cityList.add(city2);
        assertEquals(3,cityList.countCities());

        // Confirms we have 4 when another is added
        cityList.add(city3);
        assertEquals(4,cityList.countCities());

        // Confirms we have 3 when one ir removed
        cityList.delete(city3);
        assertEquals(3,cityList.countCities());
    }

}