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

    String getCityName(){
        return city;
    }

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
     * Checks whether
     */
    public boolean equals(Object o){
        City city = (City) o;
        return this.city.equals(city.getCityName()) &&
                this.province.equals(city.getProvinceName()) &&
                this.hashCode() == city.hashCode();
    }

    /**
     * Returns a hashed city and province
     * @return
     */
    public int hashCode(){
        return city.hashCode() + province.hashCode();
    }
}
