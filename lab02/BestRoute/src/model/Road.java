package model;

import enums.RoadType;

import java.util.Objects;

public class Road {
    private RoadType roadType;
    private int length;
    private int speedLimit;

    public Road(RoadType roadType, int length, int speedLimit) {
        this.roadType = roadType;
        this.length = length;
        this.speedLimit = speedLimit;
    }

    public RoadType getRoadType() {
        return roadType;
    }

    public void setRoadType(RoadType roadType) {
        this.roadType = roadType;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSpeedLimit() {
        return speedLimit;
    }

    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }

    public String roadTypeToString() {
        switch(roadType) {
            case RoadType.Country:
                return "Country model.Road";
            case RoadType.Highway:
                return "Highway";
            case RoadType.Express:
                return "Express model.Road";
            default:
                return "[ERROR] Unknown road type, please add road type to the list [ERROR]";
        }
    }

    public String toString() {
        return String.format("model.Road Type: %s, Length (meters): %d, Speed Limit: %d", roadTypeToString(), length, speedLimit);
    }

    @Override
    public boolean equals(Object obj) {

        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        final Road other = (Road) obj;
        if (!Objects.equals(this.roadType, other.roadType)) {
            return false;
        }

        if (!Objects.equals(this.length, other.length)) {
            return false;
        }

        if (!Objects.equals(this.speedLimit, other.speedLimit)) {
            return false;
        }

        return true;
    }


}
