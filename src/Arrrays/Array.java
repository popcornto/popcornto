package Arrrays;

import java.util.Arrays;
import java.util.Collection;

public class Array {
    public static int countNegatives(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] asdffg = {8, 6, 88, 4, 3, 5};
        int[] aref = {80,2,0};
        int[] ass = {66, 8, 99, 6, 6, 6, 6, 6, 6, 6, 6, 1, 77, 2, 4};
        //System.out.println(sumUpNegatives(new int[]{-1,1,-2,3,-4}));
        //System.out.println(countNegatives(new int[]{1,6,9,5,4,6,8,5,3}));
        //System.out.println(maximum(new int[]{1,6,9,3,6,2,4}));
        //System.out.println(countmaximum(new int[]{1,6,3,3,6,2,4}));
        //System.out.println(issorted(new int[]{1,2,1,4,5,9}));
        //System.out.println(checkArray(new int[]{5 ,17 ,88,88 ,17 ,5}));
        /*increaseArray(asdffg,10);
        for(int i = 0; i<asdffg.length; i++){
            System.out.println(asdffg[i]);}
        for (int element : doubleifcontainspositive(Arrrays.aref)) {
            System.out.println(element);

        //System.out.println(toString(new int[]{5, 17, 88, 88, 17, 5}));
        for (int element: copyStartingValues(Arrrays.aref)) {
            System.out.println(element);
        }
        for (int element: selectnegatives(new int[]{-1,1,-2,3,-4})) {
            System.out.println(element);
        }
        for (int element : addArrays(Arrrays.aref ,ass)) {
            System.out.println(element);
        }*/

        //System.out.println(countSequences(Arrrays.aref));
        //System.out.println(towtimes(aref));

        //System.out.println(BiggerThan(ass, 5));
        //Arrays.asList(aref);
        //System.out.println(between(aref, 2));
        System.out.println(elemsBetween(asdffg));
    }

    //System.out.println(doubleifcontainspositive(new int[]{1,6,3,3,6,2,4}));

        /*doubleifcontainspositive(Arrrays.aref);
        for (int i = 0; i < Arrrays.aref.length; i++) {
            System.out.println(Arrrays.aref[i]);
        }

    }*/

    public static int sumUpNegatives(int[] arr) {
        int summe = 0;
        int zahl;
        for (int i = 0; i < arr.length; i++) {
            zahl = arr[i];
            if (arr[i] < 0) {
                summe = summe + zahl;
            }
        }
        return summe;
    }

    public static int maximum(int[] arr) {
        int maximum = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (maximum < arr[i]) {
                maximum = arr[i];
            }
        }
        return maximum;
    }

    public static int countmaximum(int[] arr) {
        int count = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == maximum(arr)) {
                count++;
            }
        }

        return count;
    }

    public static boolean issorted(int[] arr) {
        boolean sorted = true;
        int next = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (next <= arr[i]) {
                sorted = true;
                next = arr[i];
            } else if (next > arr[i]) {
                sorted = false;
                break;
            }
        }

        return sorted;
    }

    public static boolean checkArray(int[] arr) {
        int next = arr[0];
        boolean isplam = true;
        for (int i = 1; i < arr.length; i++) {
            if (next == arr[arr.length - i]) {
                isplam = true;
                next = arr[i];


            } else if (next != arr[arr.length - 1]) {
                isplam = false;
                break;
            }
        }
        return isplam;
    }

    public static int[] increaseArray(int[] arr, int z) {


        for (int i = 0; i < arr.length; i++) {
            arr[i] = arr[i] + z;
        }
        return arr;
    }

    public static int[] doubleifcontainspositive(int[] arr) {
        int next = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 0) {
                for (int i1 = 0; i1 < arr.length; i1++) {
                    arr[i1] = arr[i1] * 2;
                }
                break;
            }
        }
        return arr;
    }

    static int[] doubleIfContainsPositive(int[] arr) {
        if (countNegatives(arr) < arr.length) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] *= 2;
            }
        }
        return arr;
    }

    public static String toString(int[] arr) {
        String toWords = "";
        String seperate = ",";
        for (int i = 0; i < arr.length; i++) {
            if (i != arr.length - 1) {
                toWords = toWords + arr[i] + seperate;
            } else
                toWords = toWords + arr[i];
        }
        return toWords;
    }

    public static int[] copyStartingValues(int[] arr) {
        int[] neufeld = new int[3];
        if (arr.length > 2) {
            for (int i = 0; i <= 3; i++) {
                for (int j = 0; j < neufeld.length; j++) {
                    neufeld[j] = arr[j];
                }
            }
        } else if (arr.length < 3) {
            return arr;
        }
        return neufeld;

    }

    public static int[] selectnegatives(int[] arr) {
        int[] neuFeld;
        int count = 0;
        int j = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                count++;
            }
        }
        neuFeld = new int[count];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                neuFeld[j] = arr[i];
                j++;
            }
        }
        return neuFeld;
    }

    public static int[] copyandinvert(int[] arr1) {
        int[] neuFLed = new int[arr1.length];
        int z = arr1.length - 1;
        for (int i = 0; i < arr1.length; i++) {
            if (z >= 0) {
                neuFLed[z] = arr1[i];
                z--;
            }
        }
        return neuFLed;
    }

    public static int[] addArrays(int[] arr1, int[] arr2) {
        int[] addiertesfeld = {};
        if (arr1.length == arr2.length) {
            addiertesfeld = new int[arr1.length];
            for (int i = 0; i < arr1.length; i++) {
                addiertesfeld[i] = arr1[i] + arr2[i];
            }
        } else return addiertesfeld;
        return addiertesfeld;
    }

    public static int countSequences(int[] arr) {
        int up = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                up++;
            } else if (arr[i] == arr.length) {
                up++;
            }
        }
        return up;
    }

    public static boolean towtimes(int[] arr) {
        int count = 0;
        int[] copyarray = arr;
        boolean two = false;

        if (arr.length >= 2) {
            two = true;
        }


        if (two) {
            for (int i = 0; i < arr.length; i++) {
                for (int j = 1; j < copyarray.length - 1; j++) {
                    if (copyarray[j] == arr[i]) {
                        count++;
                    }
                }
                count = 0;
            }
            if (count > 2 | count == 1) {
                two = false;
            } else two = true;


        }
        return two;
    }

    public static int BiggerThan(int[] arr, int p) {
        boolean exists = false;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == p) {
                exists = true;
                break;

            }
        }
        if (exists == true) {
            int biggerThan = 0;
            int k = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > p) {
                    biggerThan++;
                }
            }
            int[] newArray = new int[biggerThan];
            for (int j = 0; j < newArray.length; j++) {
                while (k < arr.length) {
                    if (arr[k] > p) {
                        newArray[j] = arr[k];
                        k++;
                        break;
                    } else {
                        k++;
                    }
                }
            }
            int min = newArray[0];
            for (int i = 0; i < newArray.length - 1; i++) {
                if (newArray[i] < min) {
                    min = newArray[i];
                } else if (newArray[i + 1] < min) {
                    min = newArray[i + 1];
                }
            }
            return min;
        } else {
            throw new IllegalStateException();
        }
    }
    public static int between(int[] arr, int n){
        int count = 0;
        int maxIndex = 0;
        int max = arr[0];
        int minIndex = 0;
        int min = arr[0];
        //Index von max bestimmen

        System.out.println(Arrays.stream(arr).max().stream());
        for (int i = 0;i<arr.length;i++){
            if (max < arr[i]){
                max = arr[i];
                maxIndex = i;
            }
        }
        //Index von min bestimmen
        for (int i = 0;i<arr.length;i++){
            if (min > arr[i]){
                min = arr[i];
                minIndex = i;
            }
        }
        //wenn max kleiner ist als min fangen wir bei max an
        if (maxIndex < minIndex){
            for (int i = maxIndex+1; i<minIndex;i++){
                if (arr[i] == n){
                    count++;
                }
            }
            //wenn min kleiner ist als min fangen wir bei min an
        }else if (maxIndex > minIndex){
            for (int i = maxIndex+1; i<minIndex;i++){
                if (arr[i] == n){
                    count++;
                }
            }
        }
        return count;
    }
    public static int elemsBetween(int[] all){
        int count = 0;
        int firstmaxIndex = 0;
        int firstmax = all[0];
        int secondmaxIndex = 0;
        int secondmax = all[0];
        
        for (int i = 0; i<all.length;i++){
            if (firstmax<all[i]){
                firstmaxIndex = i;
                firstmax = all[i];
            }
        }
        for (int i = 0; i < all.length; i++) {
            if (secondmax < all[i] && all[i] < firstmax){
                secondmaxIndex = i;
                secondmax = all[i];
            }
        }
        if (firstmaxIndex > secondmaxIndex){
        for (int i = secondmaxIndex; i < firstmaxIndex-1; i++) {
            count++;
        }}else if (firstmaxIndex < secondmaxIndex){
            for (int i = firstmaxIndex; i < secondmaxIndex-1; i++) {
                count++;
            }
        }
        return count;
    }
}
