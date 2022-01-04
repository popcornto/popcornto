package XO;

public class Player {
    private String name;
    private boolean turn;
    private char X;

    public Player(String name, boolean turn, char x) {
        this.name = name;
        this.turn = turn;
        X = x;
    }



    public char setchar(char x){
        x= X;
        return x;
    }


    public void setName(String name) {
        this.name = name;
    }


    public char setX(char x) {
        x = X;
        return x;
    }
}
