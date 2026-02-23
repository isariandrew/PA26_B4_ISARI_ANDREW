package model;

public class Route {
    private Location firstLocation;
    private Location secondLocation;
    private Road road;

    public Route(Location firstLocation, Location secondLocation, Road road) {
        this.firstLocation = firstLocation;
        this.secondLocation = secondLocation;
        this.road = road;
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
        if (!this.road.equals(other.road)){
            return false;
        }

        return true;
    }
}
