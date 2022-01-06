package XO;

public class Player {
    private String name;
    private boolean turn;
    private char symbol;

    public Player(String name, boolean turn, char symbol) {
        this.name = name;
        this.turn = turn;
        this.symbol = symbol;
    }



    public void setChar(char x){
        this.symbol = x;
    }

    public void setName(String name) {
        this.name = name;
    }

}
