package XO;

public class Turn {
    private boolean myturn;

    public Turn(boolean myturn) {
        this.myturn = myturn;
    }

    public boolean isMyturn() {
        return myturn;
    }


    public void setMyturn(boolean myturn) {
        this.myturn = myturn;
    }
    public boolean swapTurn(){
        return !myturn;
    }

    public static void main(String[] args) {
        Turn turn = new Turn(true);
        System.out.println(turn.isMyturn());
        System.out.println(turn.swapTurn());
    }
}
