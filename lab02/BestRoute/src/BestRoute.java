public class BestRoute {
    public static void main(String[] args) {
        Location city1 = new Location("Bucharest", LocationType.City, 0, 0);
        Location city2 = new Location("Cluj-Napoca", LocationType.City, 300, 400);
        Location airport = new Location("Henri Coanda Airport", LocationType.Airport, 10, 15);
        Location gasStation = new Location("Petrom Station", LocationType.GasStation, 150, 200);

        System.out.println("=== Locations ===");
        System.out.println(city1);
        System.out.println(city2);
        System.out.println(airport);
        System.out.println(gasStation);

        Road highway = new Road(RoadType.Highway, 550, 130);
        Road expressRoad = new Road(RoadType.Express, 600, 100);
        Road countryRoad = new Road(RoadType.Country, 700, 50);

        System.out.println("\n=== Roads ===");
        System.out.println(highway);
        System.out.println(expressRoad);
        System.out.println(countryRoad);
    }
}