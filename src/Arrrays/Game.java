package Arrrays;

import java.util.ArrayList;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        int a = 0, b = 0, c = 0;


        Scanner in = new Scanner(System.in);
        while (true) {
            System.out.print("rps?\n ");
            String move = in.nextLine();
            String cMove = Character.toString("rps".charAt((int) (Math.random() * 3)));


            if (move.equals(cMove)) {
                System.out.println("Opponent: " + cMove);
                c++;
                System.out.println("Tie!");
                System.out.println(c);
            } else if ((move.equals("r") && cMove.equals("s")) || (move.equals("s") && cMove.equals("p")) || (move.equals("p") && cMove.equals("r"))) {
                System.out.println("Opponent: " + cMove);
                a++;
                System.out.println("Win!");
                System.out.println(a);
            } else if(!move.equals("total"))  {
                b++;
                System.out.println("Lose!");
                System.out.println(b);


            }
            if (move.equals("total")) {

            System.out.println("Wins: " + a);
            System.out.println("loses: " + b);
            System.out.println("Ties: " + c);
        }
            }
        }
    }

