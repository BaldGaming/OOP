package cities;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Country implements Comparable<Country> {
    private Set<City> cities;
    private String name;

    public Country(String name) {
        this.name = name;

        this.cities = new TreeSet<City>();
    }

    public void addCity(City city) {
        if (!city.getCountry().toString().equals(this.toString()))
            throw new IllegalArgumentException("This city does not belong to " + this.toString());

        cities.add(city);
    }

    public int population() {
        int sum = 0;

        for (City c : cities) {
            sum += c.getPopulation();
        }

        return sum;
    }

    @Override
    public String toString() {
        return name;
    }

    public List<City> smallCities(int under) {
        List<City> small = new ArrayList<>();

        for (City c : cities)
            if (c.getPopulation() < under)
                small.add(c);

        return small;
    }

    public String report() {
        boolean firstCity = true;

        String res = name + "(" + population() + ") : ";

        for (City c : cities) {
            if (!firstCity)
                res += ", ";

            res += c.getName() + "(" + c.getPopulation() + ")";

            firstCity = false;
        }

        return res;
    }

    @Override
    public int compareTo(Country other) {
        return this.toString().compareTo(other.toString());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof Country))
            return false;

        Country other = (Country) obj;

        return this.toString().equals(other.toString());
    }
}
