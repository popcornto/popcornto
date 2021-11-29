public class GameOfLife {
    /*public boolean[][] population;
    public boolean lebt= true;
    public boolean tot= false;

public GameOfLife(){
    lebt = lebt;
    tot = tot;
}
    public boolean nextState(int i, int j) {
        boolean tot = false;
        boolean lebt = true;
        int whole;
        int count = 0;




        //Chug jug
        if (population[i][j] == tot && population[i][j + 1] == lebt && population[i][j] == tot & population[i + 1][j] && population[i][j] == tot && population[i+1][j+1]) {
            //wenn die Zelle die alleine oben links ist, dann lebt sie wenn rechts von ihr und untere Zelle am leben sind
            population[i][j] = lebt;}

        else if (population[population.length][population.length] == tot && population[population.length][j - 1] == lebt && population[population.length][population.length] == tot && population[i-1][population.length] == lebt && population[population.length][population.length] == tot && population[i-1][j-1] == lebt ) {
            //wenn die Zelle die alleine unten rechts ist, dann lebt sie wenn links von ihr und obere Zelle am leben sind
            population[population.length][population.length] = lebt;}

        //wenn die
        else if (population[i][j] != population[population.length][population.length] || population[i][j] != population[0][0]) {
            //wenn die linke und die obere  oder untere Zelle leben dann lebt die mittlere
            if (population[i - 1][j] == lebt && population[i][j - 1] == lebt || population[i][j + 1] == lebt) {
                population[i][j] = lebt;}

            //wenn die untere oder obere und die rechte leben dann lebt die mittlere
            else if (population[i + 1][j] == lebt && population[i][j + 1] == lebt || population[i][j - 1] == lebt) {
                population[i][j] = lebt;}

            //wenn die rechte und die linke zelle am leben sind dann lebt die mittlere
            else if (population[i + 1][j] = lebt && population[i - 1][j]) {
                population[i][j] = lebt;
            } else if() 
        }
    }
*/

}
