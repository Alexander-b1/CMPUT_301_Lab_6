package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City>{
    private String city;
    private String province;

    City (String city, String province){
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return The name of the city
     */
    String getCityName(){
        return city;
    }

    /**
     * Gets the province name
     * @return The name of the province
     */
    String getProvinceName(){
        return province;
    }

    @Override
    /**
     * This method compares cities
     * @return -1
     */
    public int compareTo(City c) {
        return this.city.compareTo(c.getCityName()); // this.city refers to the city name
    }

    @Override
    /**
     * Checks whether the province names, city names, and hash codes are equal
     * @param o The object being that this city is being compared to
     * @return A boolean value depending on if this City equals the provided City
     */
    public boolean equals(Object o){
        City city = (City) o;
        return this.city.equals(city.getCityName()) &&
                this.province.equals(city.getProvinceName()) &&
                this.hashCode() == city.hashCode();
    }

    @Override
    /**
     * Returns a hash code of the city and the province.
     * @return A hash code of the city, combined with the province
     */
    public int hashCode(){

        return city.hashCode() + province.hashCode();
    }
}
