package com.example.simpleparadox.listycity;

import org.junit.jupiter.api.Test;


import java.util.ArrayList;
import java.util.List;

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

        assertEquals(1, cityList.countCities());

        cityList.add(new City("Regina", "Saskatchewan"));

        assertEquals(2, cityList.countCities());
        assertTrue(cityList.hasCity(new City("Regina", "Saskatchewan")));
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
    void testHasCity() {
        CityList cityList = mockCityList();

        assertTrue(cityList.hasCity(mockCity()));
    }

    @Test
    void testGetCities() {
        CityList cityList = mockCityList();

        assertEquals(0, mockCity().compareTo(cityList.getCities().get(0)));

        City city = new City("Charlottetown", "Prince Edward Island");
        cityList.add(city);

        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
        assertEquals(0, mockCity().compareTo(cityList.getCities().get(1)));
    }

    @Test
    void testDeleteCity() {
        CityList cityList = mockCityList();

        City city = new City("Victoria", "British Columbia");
        cityList.add(city);

        assertEquals(2, cityList.countCities());

        cityList.delete(mockCity());

        assertEquals(1, cityList.countCities());
        assertEquals(0, city.compareTo(cityList.getCities().get(0)));
    }

    @Test
    void testDeleteException() {
        CityList cityList = mockCityList();

        cityList.delete(mockCity());

        assertThrows(IllegalArgumentException.class, () -> {
            cityList.delete(mockCity());
        });
    }

    @Test
    void testCountCities() {
        CityList cityList = mockCityList();

        assertEquals(1, cityList.countCities());
    }

    @Test
    void testAddAll() {
        CityList cityList = mockCityList();

        int APPEND_SIZE = 5;
        List<City> cities = new ArrayList<>();
        for (int i = 0; i < APPEND_SIZE; i++) {
            City city = new City("Test_city_" + i, "Test_PV_" + i);
            cities.add(city);
        }

        cityList.addAll(cities);
        assertEquals(1 + APPEND_SIZE, cityList.countCities());
    }
}