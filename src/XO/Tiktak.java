package XO;

import java.util.Scanner;

public class Tiktak extends Player{
    private char[][] grid = new char[2][2];
    private Scanner choose;
    int xAxis;
    int yAxis;


    public Tiktak(String name, boolean turn, char x) {
        super(name, turn, x);
    }

    public Tiktak(String name, boolean turn, char x, char[][] grid) {
        super(name, turn, x);
        this.grid = grid;
    }

    public char[][] getGrid() {
        return grid;
    }

    public char location(char[][] grid, int xAxis, int yAxis, char x){
        char[][] arr = getGrid();
        return arr[xAxis][yAxis] = setchar(x);
    }
    public void rules(char[][] grid){
        grid = getGrid();

        if (grid[0][0] == 'X' && grid[1][1] == 'X' && grid[2][2] == 'X' ){
            System.out.println("");
        }
    }

}
