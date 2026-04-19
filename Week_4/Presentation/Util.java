public class Util {

    public static void print(Object[] arr) {
        for (Object obj : arr)
            System.out.print(obj, toString());

        System.out.println();
    }
    public static void main(String[] args) {
        String[] arr = {"Gal", "Moran", "Itay"};
        print(arr);
    }
}
