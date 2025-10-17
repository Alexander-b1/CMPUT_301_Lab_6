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
     * This adds a city to the list if the city does not exist
     * @param city: This is a candidate city to add
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
     * When given a city returns whether or not a city
     * is in the list
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }


    public void delete(City city){
        if (!cities.remove(city)){
            throw new IllegalArgumentException();
        }
    }

    public int countCities(){
        return cities.size();
    }

}
