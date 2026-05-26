package shop;

public abstract class Instrument {

    private static int counter = 0;
    private int price, serial;
    private String company;

    public Instrument(String company, int price) {
        this.company = company;
        this.price = price;

        this.serial = counter;
        counter++;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    public int getSerial() {
        return serial;
    }

}
