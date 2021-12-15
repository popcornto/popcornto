package Arrrays;

public class Aufgabenblatt5 {
public int findMinimum(int[] arr){
    int min = 0;
    for (int i = 0; i< arr.length;i++){
        if (min > arr[i]){
            min = arr[i];
        }
    }
    return min;

}



}
