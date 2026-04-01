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

    public City nearestCity(){
        Road nearest = roads[0];

        if ()
            

        else
            return null;
    }

    public String toString() {
        return name;
    }
}
