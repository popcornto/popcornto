public class Rekusion {

    public static int fakul(int n) {

        if (n <= 2) {
            return n;
        }


        return n * fakul(n - 1);
    }

    public static int DigitSum(int n) {
        int count = 1;
        int Sum = 0;
        while (count <= n) {
            count *= 10;
        }
        if (count >= n) {
            return n;
        }

        return n % count + DigitSum(n) % count;
    }

    public static int power(int a, int n) {
        if (n <= 1) {
            return a;
        }
        return a * power(a, n - 1);
    }

    /*public  static int sumNegatives(int[] arr, int n){

            if(index == n){
                return result;
            }
            if (arr[index]<0){
                result += arr[index];
            }
            index++;

            return sumNegatives(arr,n);
    }*/
   /* public static int countPositives(int[] arr, int n) {
        if (index >= arr.length) {
            return result;
        }
        if (arr[index] >= 0) {
            result++;
        }
        index++;
        return countPositives(arr, n - 1);
    }*/

    /*public static int countPositivesLimited(int[] arr, int d, int t) {
        if (d == t+1 && t+1 != arr.length-1) {
            return result;
        }
        if (arr[d] >= 0) {
            result++;
        }
        d++;
        return countPositivesLimited(arr, d,t);
    }*/
public static int maximum(int[] arr, int i){

        


        return maximum(arr, i-1);
}
public static void hi(){
    System.out.println("HI");
    hi();
}
public static int add(int n){
    if(n == 0){
        return n;
    }else{
        return n + add(n-1);
    }

}
public static int grid(int n, int m){
    if(n==1 || m ==1 ) {
        return 1;
    }
    if(n >= 2){
        return m;
    }else if (m >= 2){
        return n;
    }
    return grid(n-1, m-1);
}
public static boolean isSorted(int[] arr, int i ){
    boolean k = true;
    if (i == 1){
        return k;
    }
    if(arr[i] < arr[i-1]){
        return false;

    }else{
        k = true;
        return isSorted(arr, i-1);
    }
}
public static boolean contains(int[] arr, int i, int x){
    boolean cont = false;
    if(arr[i] == x){
        return  true;
    }else if(arr[i] == 1){return false; }else{
        return contains(arr,i-1,x);
    }

}
public static boolean contentCheck(char[] arr1, char[] arr2, int i){
    if(arr1[i] == arr2[i]){

    }
}
    public static void main(String[] args) {
        int [] Arr = {1,2,4,0,5,6,7,3,4,5,6,7,5};
        int var = fakul(10);
        int var1 = DigitSum(15);
        //System.out.println(var);
        //System.out.println(var1);
        //System.out.println(power(2, 4));
        //System.out.println(sumNegatives(new int[]{-1,-2,-3,-4},4 ));
        // System.out.println(countPositives(new int[]{1, -2, -3, 4, 3, 4, 3, 4}, 4));
        //System.out.println(countPositivesLimited(new int[]{1, -2, 3, 4, 3, 4, 3, 4,1,2,3,4}, 0,11));
        //System.out.println(maximum(Arr,3));
        //hi();
        //System.out.println(add(4));
        //System.out.println(grid(3,2));
        //System.out.println(isSorted(Arr, 3));
        //System.out.println(contains(Arr,3,3));

    }

}
