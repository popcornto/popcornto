package Arrrays;

public class bro {
    public static String digitSum(int x) {
        String space = "-";
        String addStrings = "";
        String man;
        if (x < 0) {
            x = x * -1;
            addStrings =addStrings + "minus"+space;
        }//wenn die zahl minus ist dann, positiv
        int sum=0;
        int summe = 0;
        int i;
        int r;
//die for schleife dient dazu, dass die acd.zahlen durch 10 zu teilen und die letzte zahl mit sum zu ermittlen
        for (i = 1; x >= i; i=i*10) {
            r = x / i;
            sum = r % 10;
            //falls der Rest der zahl 0 ist dann wandle den binde strich zu ein leeren String
            if(r/10==0){space = "";}
            addStrings = addStrings+ zahlen.digitToString(sum)+space;
            }
            //summe = summe + sum;
        return addStrings;
    }
    public static void main(String[] args) {
        System.out.print(digitSum(1000));
    }
}
