import java.time.Instant;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;
import java.time.Duration;
import java.util.Collections;
public class Quicksort2 {

    public static int partition(int[] data, int l, int r)
    {
        int pivot = data[l];
        int i = l;
        int j = r;
        while (i < j)
        {
            while (i < j && data[j] >= pivot)
                j--;
            data[i] = data[j];
            while (i < j && data[i] <= pivot)
                i++;
            data[j] = data[i];
        }
        data[i] = pivot;
        return i;
    }
    public static void quicksort2(int[] a, int l, int r) {
        if (l >= r) {
            return;
        }
        int m1 = partition(a, l, r);
        quicksort2(a, l, m1 - 1);
        quicksort2(a, m1 + 1, r);
    }

    public static boolean isSorted(int[] data) {
        for (int i = 0; i < data.length - 1; i++) {
            if (data[i] > data[i + 1]) {
                return false;
            }
        }
        return true;
    }
    static int CalculatePower (int num, int pow) {
        if (pow == 0)
            return 1;
        else
            return num * CalculatePower(num, pow - 1);
    }
    private static int[] shuffleArray(int[] arr)
    {
        int index, temp;
        Random random = new Random();
        for (int i = arr.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            temp = arr[index];
            arr[index] = arr[i];
            arr[i] = temp;
        }
        return arr;

    }

    public static void main(String[] args) {
        float median = 0;
        for (int j = 0; j < 5; j++) {


            int a = CalculatePower(2, 24);
            int[] dat = new int[a];
            for (int i = 0; i < dat.length; i++) {
                dat[i] = i;
            }
            int[] data = shuffleArray(dat);
            Instant start = Instant.now();
            quicksort2(data, 0, data.length - 1);
            assert isSorted(data);
            Instant finish = Instant.now();
            double time = Duration.between(start, finish).toMillis();

            System.out.println("Time: " + time / 1000 + " seconds");
            median += time/1000;


        }
        System.out.println("Median: " + median / 5 + " seconds");
    }

}
