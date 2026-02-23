import java.util.Objects;

public class Location {
    private String name;
    private LocationType locationType;
    private int coordX, coordY;

    public Location(String name, LocationType newLocation, int coordX, int coordY) {
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

    public int getCoordX() {
        return coordX;
    }

    public void setCoordX(int coordX) {
        this.coordX = coordX;
    }

    public int getCoordY() {
        return coordY;
    }

    public void setCoordY(int coordY) {
        this.coordY = coordY;
    }

    public String locationTypeToString() {
        switch(locationType) {
            case City:
                return "City";
            case Airport:
                return "Airport";
            case GasStation:
                return "Gas Station";
            default:
                return "[ERROR] Unknown location type, please add location [ERROR]";
        }
    }

    @Override
    public String toString(){
        return String.format("Location Name: %s, LocationType: %s, Coordinates: X -> %d; Y -> %d", name, locationTypeToString(), coordX, coordY);
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

        if (!(Objects.equals(this.coordX, other.coordX) && Objects.equals(this.coordY, other.coordY))) {
            return false;
        }

        return true;
    }

}
