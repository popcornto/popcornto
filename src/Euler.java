public class Euler {
    public static double euler(int n) {
        double summe=1;
        double count=1;

        for (int i = 1; i <= n; i++) {
            summe= summe+(1/(i*count));
            count=count*i;
            System.out.println(summe);
        }
            return summe;
        }
        public static void main (String[]args){
            System.out.println(euler(9));
        }
    }
