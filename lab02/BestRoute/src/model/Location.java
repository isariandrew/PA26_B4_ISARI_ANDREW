package model;

import enums.LocationType;

import java.util.Objects;

abstract sealed class Location permits City, Airport, GasStation{
    protected String name;
    protected LocationType locationType;
    protected double coordX, coordY;

    public Location(String name, LocationType newLocation, double coordX, double coordY) {
        this.name = name;
        this.locationType = newLocation;
        this.coordX = coordX;
        this.coordY = coordY;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocationType getLocationType() {
        return locationType;
    }

    public void setLocationType(LocationType locationType) {
        this.locationType = locationType;
    }

    public double getCoordX() {
        return coordX;
    }

    public void setCoordX(double coordX) {
        this.coordX = coordX;
    }

    public double getCoordY() {
        return coordY;
    }

    public void setCoordY(double coordY) {
        this.coordY = coordY;
    }

    public String locationTypeToString() {
        return switch (locationType) {
            case LocationType.City -> "City";
            case LocationType.Airport -> "Airport";
            case LocationType.GasStation -> "Gas Station";
            default -> "[ERROR] Unknown location type, please add location [ERROR]";
        };
    }

    @Override
    public String toString(){
        return String.format("model.Location Name: %s, enums.LocationType: %s, Coordinates: X -> %d; Y -> %d", name, locationTypeToString(), coordX, coordY);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Location other = (Location) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }

        if (!Objects.equals(this.locationType, other.locationType)) {
            return false;
        }

        return Objects.equals(this.coordX, other.coordX) && Objects.equals(this.coordY, other.coordY);
    }

}
