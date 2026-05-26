public class Guitar extends Instrument {

    private String company;
    private int price;
    private Type type;

    public enum Type {
        ACOUSTIC, ELECTRIC, CLASSICAL;

        @Override
        public String toString() {
            switch (this) {
                case ACOUSTIC:
                    return "Acoustic";
                case ELECTRIC:
                    return "Electric";
                case CLASSICAL:
                    return "Classical";
                default:
                    return super.toString();
            }
        }
    }

    public Guitar(String company, int price, Guitar.Type type) {
        super(company, price);
        this.type = type;
    }

    public String getCompany() {
        return company;
    }

    public int getPrice() {
        return price;
    }

    public Type getType() {
        return type;
    }

    public int getSerial() {}

    @Override
    public String toString() {
        return "Guitar(" + type + ") " + company + "(" + getSerial() + ")" + ", price = " + price;
    }
}
