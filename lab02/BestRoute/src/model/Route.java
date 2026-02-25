package model;

import enums.RoadType;

public class Route {
    private Location firstLocation;
    private Location secondLocation;
    private Road road;

    public Route(Location firstLocation, Location secondLocation, RoadType roadType, int speedLimit) {
        this.firstLocation = firstLocation;
        this.secondLocation = secondLocation;

        double dx = firstLocation.getCoordX() - secondLocation.coordX;
        double dy = firstLocation.getCoordY() - secondLocation.coordY;

        long length = Math.round(Math.sqrt((dx * dx + dy * dy)));
        this.road = new Road(roadType, length, speedLimit);
    }

    public Location getFirstLocation() {
        return firstLocation;
    }

    public void setFirstLocation(Location firstLocation) {
        this.firstLocation = firstLocation;
    }

    public Location getSecondLocation() {
        return secondLocation;
    }

    public void setSecondLocation(Location secondLocation) {
        this.secondLocation = secondLocation;
    }

    public Road getRoad() {
        return road;
    }

    public void setRoad(Road road) {
        this.road = road;
    }

    @Override
    public String toString() {
        return String.format("Location #1: %s, Location #2: %s, Road Info: \n\n %s", firstLocation.getName(), secondLocation.getName(), road.toString());
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Route other = (Route) obj;
        if (!this.firstLocation.equals(other.firstLocation)){
            return false;
        }
        if (!this.secondLocation.equals(other.secondLocation)){
            return false;
        }
        return this.road.equals(other.road);
    }
}
