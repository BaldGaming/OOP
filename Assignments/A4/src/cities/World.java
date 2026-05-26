package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class World {

    private Map<String, Country> countries;

    public World() {
        this.countries = new TreeMap<>();
    }

    public void addCountry(String name) {
        countries.put(name, new Country(name));
    }

    public void addCity(String name, String countryName, int population) throws IllegalArgumentException {
        if (!countries.containsKey(countryName))
            throw new IllegalArgumentException("Country " + countryName + " does not exist!");

        Country country = countries.get(countryName);

        City newCity = new City(name, country, population);

        country.addCity(newCity);
    }

    public int population() {
        int sum = 0;

        for (Country c : countries.values())
            sum += c.population();

        return sum;
    }

    public List<City> smallCities(int under) {
        List<City> allSmallCities = new ArrayList<>();

        // Loop through every Country object in order
        for (Country c : countries.values()) {
            // Get the pre-filtered list of small cities from that country
            List<City> countrySmallCities = c.smallCities(under);

            // Put them all into the first list
            allSmallCities.addAll(countrySmallCities);
        }

        return allSmallCities;
    }

    public String report() {
        String res = "";

        for (Country c : countries.values()) {
            res += c.report() + "\n";
        }

        res += "Total population is " + population() + "\n";

        return res;
    }
}