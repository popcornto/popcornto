public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {4, 9, 3, 5, 2, 0, 1, 8};
        System.out.println(isSortedrek(arr, 7));
        System.out.println(isSorted(arr));
        for (int elemnt : BubbaSorst(arr, 7)
        ) {
            System.out.println(elemnt);
        }
    }

    public static boolean isSorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    public static boolean isSortedrek(int[] arr, int i) {
        if (i >= 1) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
            else if (i == 1) {
                return true;
            }
        }
        return isSortedrek(arr, i - 1);
    }

    public static int[] BubbaSorst(int[] arr, int i) {
        int full = arr.length;
        if (i >= 1) {
            int swapfirst = arr[i];
            int swapsecond = arr[i - 1];


            if (isSortedrek(arr, arr.length-1) == true) {
                return arr;
            }

            if (arr[i - 1] > arr[i]) {
                arr[i - 1] = swapfirst;
                arr[i] = swapsecond;
                return BubbaSorst(arr, i - 1);
            }
            if (arr[i] > arr[i - 1]) {
                return BubbaSorst(arr, i - 1);
            }
        }
        return BubbaSorst(arr, full-1);
    }
}
