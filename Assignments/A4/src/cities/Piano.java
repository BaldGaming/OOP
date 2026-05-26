public class Piano extends Instrument {

    private String company;
    private int price, octaves;

    public Piano(String company, int price, int octaves) {
        super(company, price); 
        
        this.octaves = octaves;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    public int getOctaves() {
        return octaves;
    }

    public int getSerial(){
        return this.getSerial();
    }

    @Override
    public String toString() {
        return "Piano(" + octaves + " octaves) " + company + "(" + getSerial() + ")" + ", price = " + price;
    }
}
