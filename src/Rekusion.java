public class Rekusion {
    public static int fakul(int n){

if (n<= 2){
    return n;
}


return n*fakul(n-1);
    }
    public static int DigitSum(int n ){
        int count  = 1;
        int Sum = 0;
        while(count <= n){
            count *= 10;
        }
        if (count >= n){
            return n ;
        }

        return n%count + DigitSum(n)%count;
    }

    public static void main(String[] args) {
        int var = fakul(10);
        int var1  = DigitSum(15);
        System.out.println(var);
        System.out.println(var1);
    }
}
