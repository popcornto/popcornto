package XO;


public class Grid {
    private char[][] arr = new char[3][3];
    private int cap;

    public void setCap(int cap) {
        char[][] copy = new char[cap][cap];
        this.arr = copy;
    }

    public int getLength() {
        return arr.length;
    }

    public int getCap() {
        return cap;
    }

    public void setSymbol(int X, int Y, char symbol) {
        arr[X][Y] = symbol;
    }
    public boolean isValid(Grid grid , int X, int Y){
        if (arr[X][Y] == Character.MIN_VALUE){
            return true;
        }
        else {
            return false;
        }
    }


    public char getSymbol(int X, int Y, Grid grid) {
        return grid.getArr()[X][Y];
    }

    public char[][] getArr() {
        return arr;
    }

    public void PrintArray() {
        for (int i = 0; i < this.arr.length; i++) {
            for (int j = 0; j < this.arr.length; j++) {
                if (i != this.arr.length) {
                    if (j == 2) {
                        System.out.println(this.arr[i][j] + " ");
                    } else {
                        System.out.print(this.arr[i][j] + " ");
                    }
                } else {
                    if (j == 2) {
                        System.out.println(this.arr[i][j]);
                    } else {
                        System.out.print(this.arr[i][j]);
                    }
                }

            }
        }

    }
}
