public class Quicksort {
    public static int partition(int arr[], int begin, int end) {
        int pivot = arr[end];
        int i = begin-1;

        for (int j = begin; j < end; j++) {
            if (arr[j] <= pivot) {
                i++;

                int swapTemp = arr[i];
                arr[i] = arr[j];
                arr[j] = swapTemp;
            }
        }

        int swapTemp = arr[i+1];
        arr[i+1] = arr[end];
        arr[end] = swapTemp;

        return i+1;
    }

    public static void quickSort(int arr[], int begin, int end) {
        if (begin < end) {
            int partitionIndex = partition(arr, begin, end);

            quickSort(arr, begin, partitionIndex-1);
            quickSort(arr, partitionIndex+1, end);
        }
    }
    public static   void printSorted(int[] arr){
        int first = 0;
        int last = arr.length-1;
        quickSort(arr,first,last);
        for (int i = 0; i<arr.length; i++){
            if (i == arr.length-1){
                System.out.print(arr[i]);
            }else{
                System.out.print(arr[i] + "-");
            }
        }
    }
    public static void main(String[] args) {
        int[] arr = {4, 9, 3, 5, 2, 0, 1, 8};
        System.out.println(arr.length);
        quickSort(arr,0,arr.length-1);
        printSorted(arr);
        }

    }

