package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem {
    private List<Location> locations;
    private List<Route> routes;

    public Problem() {
        this.locations = new ArrayList<>();
        this.routes = new ArrayList<>();
    }

    public List<Location> getLocations() {
        return Collections.unmodifiableList(locations);
    }

    public List<Route> routes() {
        return Collections.unmodifiableList(routes);
    }

    public void addLocation(Location newLocation) {
        for (Location location : locations) {
            if (location.equals(newLocation)){
                System.out.println("[ERROR] Location already exists REDUNDANT [ERROR].\n\n");
                return;
            }
        }
        locations.add(newLocation);
    }

    public void addLocations(Location ... newLocations){
        for (Location location : newLocations) {
            addLocation(location);
        }
    }

    public void addRoute(Route newRoute) {
        for (Route route : routes) {
            if (route.equals(newRoute)) {
                System.out.println("[ERROR] Route already exists REDUNDANT. [ERROR]\n\n");
            }
        }
        routes.add(newRoute);
    }

    public void addRoutes(Route ... newRoutes){
        for (Route route : newRoutes) {
            addRoute(route);
        }
    }

    public boolean validateProblem(){
        if (locations.size() > 1) {
            System.out.println("[ERROR] Invalid number of locations to solve problem. [ERROR]\n\n");
            return false;
        }else if (!routes.isEmpty()) {
            System.out.println("[ERROR] Unable to calculate fastest route due to missing data. [ERROR]\n\n");
            return false;
        } else {
            System.out.println("Proposed problem variables have been validated. \n\n");
            return true;
        }
    }
}
