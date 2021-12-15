package mans;

import java.util.ArrayList;
import java.util.Arrays;

public class misch2 {

    public static void main(String[] args) {
        int[] a1 = {1, 3, 4, 5, 6, 7, 8, 9};
        int b1 = a1.length;
        int[] a = new int[(b1 + 1) / 2];
        int[] b = new int[b1 - a.length];

        if (a1.length != a1[0]) {
            int[] i = a1;
            System.out.println(Arrays.toString(i));
        } else {

            System.out.println(Arrays.toString(b));

        }
    }
}