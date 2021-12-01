public class Rekusion {
   static int index = 0;
   static int result = 0;
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
    public static int power(int a, int n){
        if (n <= 1){
            return a;
        }
       return  a * power(a,n-1);
    }

public  static int sumNegatives(int[] arr, int n){

        if(index == n){
            return result;
        }
        if (arr[index]<0){
            result += arr[index];
        }
        index++;

        return sumNegatives(arr,n);
}
    public static void main(String[] args) {
        int var = fakul(10);
        int var1  = DigitSum(15);
        System.out.println(var);
        System.out.println(var1);
        System.out.println(power(2,4));
        System.out.println(sumNegatives(new int[]{-1,-2,-3,-4},4 ));
    }
}
