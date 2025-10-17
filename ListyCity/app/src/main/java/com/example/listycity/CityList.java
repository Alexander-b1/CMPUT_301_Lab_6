package com.example.listycity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This is a class that keeps a list of the city objects.
 */
public class CityList {
    private List<City> cities = new ArrayList<>();


    /**
     * This adds a city to the list if the city does not exist in the CityList
     * @param city This is a candidate city to add
     */
    public void add(City city) {
        if (cities.contains(city)) {
            throw new IllegalArgumentException();
        }
        cities.add(city);
    }


    /**
     * This returns a sorted list of cities
     * @return
     * Return the sorted list
     */
    public List<City> getCities() {
        List<City> list = cities;
        Collections.sort(list);
        return list;
    }

    // Might need to override equals in city

    /**
     * Returns a boolean value depending on whether the provided city
     * is in the CityList
     * @param city The city being searched for
     * @return true if the CityList has the input city, else false
     */
    public boolean hasCity(City city){

        return cities.contains(city);
    }


    /**
     * Deletes a city from the CityList. If the City is not in the City list,
     * this function will throw an Exception
     * @param city The city being deleted
     */
    public void delete(City city){

        // If the city is not successfully removed, then it is not in the list, and
        // an error must be thrown.
        if (!cities.remove(city)){
            throw new IllegalArgumentException();
        }
    }

    /**
     * Returns the number of cities in the CityList
     * @return the size of the CityList
     */
    public int countCities(){

        return cities.size();
    }

}
