public class Aufageb {
    public static int Harshad(int z){
        int summe=0;
        int rest= z;
        int sum;
        int first=0;
        boolean teilbar;
        for (int i = 1;z>=i;i=i*10){
            System.out.println("i: "+ i);
            sum=rest%10;
            System.out.println("summ: " + sum);
            rest=rest/i;
            System.out.println("rest: " + rest);
            summe=summe+sum+first;

        }


        return summe;
    }
    public static void compute(int n){
        System.out.println(Harshad(n));
    }
    public static void main(String[] args) {
        compute(1823);
    }
}
