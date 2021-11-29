//Aref Jazmati


public class Testat {
    public static int[] apply(int[] arr, int x) {
        int[] neuesfeld = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 1) {
                arr[i] = x;
                neuesfeld[i]= arr[i];
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (i % 2 == 0) {
                arr[i] = arr[i] * x;
                neuesfeld[i] = arr[i];
            }
        }
        return neuesfeld;
    }

    public static void main(String[] args) {
        for (int element: apply(new int[]  {2,2,7,4,5,2}, 5)) {
            System.out.println(element);
        }
    }
}
