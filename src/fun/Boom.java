package fun;

import java.util.Scanner;

public class Boom {
    public static void main(String[] args) {
        System.out.println(Guess("Sheesh"));
    }
    public static String Guess(String word){
        Scanner scanner = new Scanner(System.in);
        String password = word;
        int count = 3;

        System.out.println("Guess the Password or GO BOOM");

        while (count > 0) {

            System.out.println("You hava " + count + " tries before Boom!!");
            if (count == 1) {
                System.out.println("I Giva you tIPp. It Starts with N and ends with ger");
            }
            String wo = scanner.next();
            if (wo.equals(password)) {
               return "YOU Are Lucky my friend";
            }
            count--;
        }
        return "BOOOOOM You is DeD BIcH";
    }
}
