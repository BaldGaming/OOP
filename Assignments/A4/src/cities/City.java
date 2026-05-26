package cities;

public class City implements Comparable<City> {
    private String name;
    private Country country;
    private int population;

    public City(String name, Country country, int population) {
        this.name = name;
        this.country = country;
        this.population = population;
    }

    public String getName() {
        return name;
    }

    public Country getCountry() {
        return country;
    }

    public int getPopulation() {
        return population;
    }

    @Override
    public String toString() {
        return name + " (of " + country + ")";
    }

    @Override
    public int compareTo(City other) {
        int countryCompare = this.getCountry().toString().compareTo(other.getCountry().toString());

        if (countryCompare != 0)
            return countryCompare;

        return this.getName().compareTo(other.getName());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;

        if (!(obj instanceof City))
            return false;

        City other = (City) obj;

        return this.getName().equals(other.getName()) &&
                this.getCountry().toString().equals(other.getCountry().toString());
    }
}
