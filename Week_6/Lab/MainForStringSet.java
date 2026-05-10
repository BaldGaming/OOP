package Week_6.Lab;

import java.util.Scanner;

public class MainForStringSet {

    public static void main(String[] args) {
        StringSet set = new StringSet(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            String str = sc.next();
            if (str.equals("Done"))
                break;
            else
                try {
                    set.add(str);
                } catch (StringSetFullException e) {
                    System.err.println(e.getMessage());
                    break;
                } catch (Exception e) {
                    System.err.println("must enter text:");
                }
        }
        sc.close();
    }
}
