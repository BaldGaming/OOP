package cities;

public class City {
    private String name;
    private Road[] roads;
    private int numRoads;

    public City(String name) {
        this.name = name;
        this.roads = new Road[10];
        this.numRoads = 0;
    }

    public void connect(Road r) {
        if (numRoads < 10) {
            roads[numRoads] = r;
            numRoads++;
        }
    }

    public City nearestCity() {
    if (numRoads == 0) // No roadss
        return null;

    // Assume the first road is the shortest
    Road shortestRoad = roads[0];

    // Find the shortest
    for (int i = 1; i < numRoads; i++) {
        if (roads[i].getLength() < shortestRoad.getLength()) {
            shortestRoad = roads[i];
        }
    }

    // Return the "not" 'this.'
    if (shortestRoad.getCity1() == this)
        return shortestRoad.getCity2();

    else
        return shortestRoad.getCity1();
    }

    public String toString() {
        return name;
    }
}
