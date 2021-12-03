public class Testat
{
    public static int apply( int[] arr, int i ) {
        if (arr.length <= i) {
            return 0;
        }
        if (i < 0){
            return 0;
        }

        if (arr[i] < 4 && arr[i] > -4) {

            return 1+apply(arr,i-1);
        }


            return apply(arr,i-1);
    }
}
