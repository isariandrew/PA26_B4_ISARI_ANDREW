package model;

import enums.LocationType;

public final class City extends Location{
    private int population;

    public City(String name, LocationType newLocation, int coordX, int coordY, int population) {
        super(name, newLocation, coordX, coordY);
        this.population = population;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }
}
