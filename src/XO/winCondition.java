package XO;

public class winCondition {

    public boolean checkIfElse(Grid grid, Player player){
        //r to l diagonal
        if (grid.getArr()[0][0] == player.getSymbol() && grid.getArr()[1][1] == player.getSymbol() && grid.getArr()[2][2] == player.getSymbol()){
            return true;
        }//first row vertikal
        else if (grid.getArr()[0][0] == player.getSymbol() && grid.getArr()[0][1] == player.getSymbol() && grid.getArr()[0][2] == player.getSymbol()){
            return true;
        }//second row vertikal
        else if (grid.getArr()[1][0] == player.getSymbol() && grid.getArr()[1][1] == player.getSymbol() && grid.getArr()[1][2] == player.getSymbol()){
            return true;
        }//thrird row vertical
        else if (grid.getArr()[2][0] == player.getSymbol() && grid.getArr()[2][1] == player.getSymbol() && grid.getArr()[2][2] == player.getSymbol()){
            return true;
        }//first row horizontal
        else if (grid.getArr()[0][0] == player.getSymbol() && grid.getArr()[1][0] == player.getSymbol() && grid.getArr()[2][0] == player.getSymbol()){
            return true;
        }//second row horitontal
        else if (grid.getArr()[0][1] == player.getSymbol() && grid.getArr()[1][1] == player.getSymbol() && grid.getArr()[2][1] == player.getSymbol()){
            return true;
        }//third row horizontal
        else if (grid.getArr()[0][2] == player.getSymbol() && grid.getArr()[1][2] == player.getSymbol() && grid.getArr()[2][2] == player.getSymbol()){
            return true;
        }//l to r diagonal
        else if (grid.getArr()[2][0] == player.getSymbol() && grid.getArr()[1][1] == player.getSymbol() && grid.getArr()[0][2] == player.getSymbol()){
            return true;
        }

        return false;

    }
    /*public boolean check(Grid grid, Player player){



        //r to l diagonal
        for (int i = 0; i < grid.getLength() - 1; i++) {
            for (int j = 0; j < grid.getLength() - 1; j++) {
                if (grid.getSymbol(i,j,grid) == player.getSymbol() && grid.getSymbol(i+1 , j+1, grid) == player.getSymbol()) {
                    Grid grid1;
                    for (int k = 0; k < ; k++) {

                    }
                }
            }

        }
        //l to r diagonal
        for (int i = grid.getLength() - 1; i > 1; i--) {
            for (int j = 0; j < grid.getLength()-1; j++) {
                if (grid.getSymbol(i,j,grid) == grid.getSymbol(i - 1,j + 1,grid)) {
                    return true;
                }else break;
            }
        }
        //first row horizontal
        for (int i = 0; i < grid.getLength() - 1; i++) {
            int j = 0;
            if (grid.getSymbol(i,j,grid) == grid.getSymbol(i + 1,j,grid)) {
                return true;
            }else break;
        }

        //second row horizontal
        for (int i = 0; i < grid.getLength() - 1; i++) {
            int j = 1;
            if (grid.getSymbol(i,j,grid) == grid.getSymbol(i + 1,j,grid)) {
                return true;
            }else break;
        }
        //third row horizontal
        for (int i = 0; i < grid.getLength() - 1; i++) {
            int j = 2;
            if (grid.getSymbol(i,j,grid) == grid.getSymbol(i + 1,j,grid)) {
                return true;
            }else break;
        }

        //first row vertival
        for (int i = 0; i < grid.getLength() - 1; i++) {
            int j = 0;
            if (grid.getSymbol(j,i,grid) == grid.getSymbol(j,i + 1,grid)) {
                return true;
            }else break;
        }
        //second row vertival
        for (int i = 0; i < grid.getLength() - 1; i++) {
            int j = 1;
            if (grid.getSymbol(j,i,grid) == grid.getSymbol(j,i+1,grid)) {
                return true;
            }else break;
        }
        //third row vertival
        for (int i = 0; i < grid.getLength() - 1; i++) {
            int j = 2;
            if (grid.getSymbol(j,i,grid) == grid.getSymbol(j,i+1,grid)) {
                return true;
            }else break;
        }



        return false;
    }*/
}

