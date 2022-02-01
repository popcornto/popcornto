package XO;

import java.util.Scanner;

public class Tiktak {
    private Grid grid;          //done
    private Player player;      //done
    private Turn turn;          //done
    Scanner scanner;            //done
    private winCondition win;   //done

    public static void main(String[] args) {
        Player[] player = {new Player(), new Player()};
        Turn turn = new Turn(true);
        Grid grid = new Grid();
        grid.setCap(3);
        winCondition win = new winCondition();
        Scanner scanner = new Scanner(System.in);
        System.out.println("What is your name?");
        player[0].setName(scanner.next());
        System.out.println("Which symbol do you want to choose?");
        player[0].setSymbol(scanner.next().charAt(0));
        System.out.println("What is your name?");
        player[1].setName(scanner.next());
        System.out.println("Which symbol do you want to choose?");
        player[1].setSymbol(scanner.next().charAt(0));
        grid.PrintArray();
        while (true) {

            if (turn.isMyturn()) {
                String name = "It is " + player[0].getName() + " s turn";
                String wrngSymbol = "select where you want to place your symbol";

                System.out.println(name);
                System.out.println(wrngSymbol);
                int i = scanner.nextInt();
                int j = scanner.nextInt();

                while (true) {
                    if (grid.isValid(grid, i, j)) {
                        grid.setSymbol(i, j, player[0].getSymbol());
                        turn.setMyturn(turn.swapTurn());
                        break;
                    }else {
                        System.out.println("try Again this was invalid");
                        int i1 = scanner.nextInt();
                        int j1 = scanner.nextInt();
                        if (grid.isValid(grid, i1, j1)) {
                            grid.setSymbol(i1, j1, player[0].getSymbol());
                            turn.setMyturn(turn.swapTurn());
                            break;
                        }
                    }

                }

                grid.PrintArray();
                System.out.println(win.checkIfElse(grid, player[0]));
                if (win.checkIfElse(grid, player[0])) {
                    System.out.println(player[0].getName() + " won!");
                    break;
                }
            } else {

                System.out.println("It is " + player[1].getName() + " s turn");
                System.out.println("select where you want to place your symbol");
                int i = scanner.nextInt();
                int j = scanner.nextInt();

                while (true) {
                    if (grid.isValid(grid, i, j)) {
                        grid.setSymbol(i, j, player[1].getSymbol());
                        turn.setMyturn(turn.swapTurn());
                        break;
                    } else {
                        System.out.println("try Again this was invalid");
                        int i1 = scanner.nextInt();
                        int j1 = scanner.nextInt();
                        if (grid.isValid(grid, i1, j1)) {
                            grid.setSymbol(i1, j1, player[1].getSymbol());
                            turn.setMyturn(turn.swapTurn());
                            break;
                        }
                    }

                }

                grid.PrintArray();
                System.out.println(win.checkIfElse(grid, player[1]));
                if (win.checkIfElse(grid, player[1])) {
                    System.out.println(player[1].getName() + " won!");
                    break;
                }
            }
        }

    }

}


