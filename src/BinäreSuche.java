public class BinäreSuche {
    /* boolean binarySearchIterative(int[] arr, int x) {
         int half = arr.length / 2;
         if (arr.length % 2 == 0) {

         }

     }

     boolean binarySearchRecursive(int[] sorted, int candidate) {
         //exeptions
         if (sorted.length == 0) {
             throw new IllegalArgumentException();
         }
         //Abbruchbedingung
         if (sorted[sorted.length / 2] == candidate || sorted[sorted.length + 1] == candidate) {
             return true;
         } else {
             return false;
         }
         if (binarySearchRecursive(sorted, candidate) == candidate) {

         }


     }*/
    public static void main(String[] args) {
        int[] arr = {10, -2, 5, 5, -11};
        int[] arr2 = {8, -8, 14, 22, 28, -1};
        int[] arr69 = {7, 9, -3, -17, 2, -2};
        int[] ar = {1,2,4,4};
        //System.out.println(appry(arr2, 5));
        //System.out.println(add(ar, ar.length-1));
        //System.out.println(addit(ar));
        //System.out.println(compare(ar,ar.length-1,0));
        System.out.println(app(ar, ar.length-1));
    }

    public static int appry(int[] arr, int i) {

        //exeptions
        if (i < 0 || i >= arr.length || arr == null) {
            return 0;
        }

        if ( i % 2 != 0 && arr[i] < 0 ){
            return arr[i] + appry(arr, i-1);
        }

            return appry(arr, i-1);


    }
    public static int add(int[] arr, int i){
        if (i<0)return 0;
        return arr[i] + add(arr, i-1);
    }

    public static int addit(int[] arr){
        int count =0;
        for (int i = 0; i<arr.length;i++){
            count = count + arr[i];
        }
        return count;
    }
public static int compare(int[] arr, int i ,int result){
        if (arr.length % 2 == 0 && i==0){
            return 0;
        }
        if (arr[i] + arr[arr.length-i-1] > arr[i-1] + arr[arr.length-i]){
           return  compare(arr,i-1,i + arr.length-i-1);
        }
        else
            return i+compare(arr, i-1, i-1 + arr.length-i);
}
public static int app(int[] arr, int i){
        if (i < 0 || i >= arr.length || arr == null){
            return 0;
        }
    if (arr[i] % 2 == 0 && arr[i] != 10) {
        return arr[i] + app(arr, i-1);
    }
    return app(arr, i-1);
}
    }


