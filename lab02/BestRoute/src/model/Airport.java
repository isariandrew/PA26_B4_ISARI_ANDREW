package model;

import enums.LocationType;

public final class Airport extends Location{
    private int numberOfTerminals;

    public Airport(String name, LocationType newLocation, int coordX, int coordY, int numberOfTerminals) {
        super(name, newLocation, coordX, coordY);
        this.numberOfTerminals = numberOfTerminals;
    }

    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }

    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }
}
