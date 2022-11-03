package com.catalog;

public class City {
    private final String name;
    private final String region;
    private final String district;
    private final String foundation;
    private final String population;

    public City(String name, String region, String district, String population, String foundation){
        this.name = name;
        this.region = region;
        this.district = district;
        this.population = population;
        this.foundation = foundation;
    }
    @Override
    public String toString(){
        return "City {Name: " + this.name + "; Region: " + this.region + "; District: " + this.district +
                "; Population: " + this.population + "; Foundation: " + this.foundation + "}";
    }
}