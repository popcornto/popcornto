package fun;

import java.util.Scanner;

public class Boom {
    public static void main(String[] args) {
        System.out.println(Guess("Ass"));
    }
    public static String Guess(String word){
        Scanner scanner = new Scanner(System.in);
        String password = word;
        int count = 3;
        char[] arr = new char[3];
        int j = 0;
        String increment = "";

        System.out.println("Guess the Password or GO BOOM");

        while (count > 0) {

            System.out.println("You hava " + count + " tries before Boom!!");
            if (count == 1) {
                if (word.length() > 5){
                for (int i = password.length()-3; i < password.length(); i++)
                {
                    arr[j] = password.charAt(i);
                    j++;
                }
                for (char element:arr) {
                    increment += element;
                }
                System.out.println("I Giva you tIPp. It Starts with " + password.charAt(0)+  " and ends with " + increment);}
                else {
                    System.out.println("I Giva you tIPp. It Starts with " + password.charAt(0)+  " and ends with " + password.charAt(password.length()-1));
                }
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
