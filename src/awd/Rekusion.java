package awd;

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
    /*public static int maximum(int[] arr, int i) {
        if ()
    }*/
/*public static int maximum(int[] arr) {
    int mans.max = 0;

    for (int i = 0; i < arr.length; i++) {
        if (mans.max < arr[i]) {
            mans.max = arr[i];
        }
    }
    return mans.max;
}*/
    public static int maximum(int[] arr, int i) {
        if (i == 0) {
            return arr[i];
        }

        int maximum = maximum(arr, i - 1);
        if (maximum < arr[i]) {
            maximum = arr[i];
        }
        return maximum;
    }

    public static void hi() {
        System.out.println("HI");
        hi();
    }

    public static int add(int n) {
        if (n == 0) {
            return n;
        } else {
            return n + add(n - 1);
        }

    }

    public static int grid(int n, int m) {
        if (n == 1 || m == 1) {
            return 1;
        }
        if (n >= 2) {
            return m;
        } else if (m >= 2) {
            return n;
        }
        return grid(n - 1, m - 1);
    }

    public static boolean isSorted(int[] arr, int i) {
        boolean k = true;
        if (i == 1) {
            return k;
        }
        if (arr[i] < arr[i - 1]) {
            return false;

        } else {
            k = true;
            return isSorted(arr, i - 1);
        }
    }

    public static boolean contains(int[] arr, int i, int x) {
        boolean cont = false;
        if (arr[i] == x) {
            return true;
        } else if (arr[i] == 1) {
            return false;
        } else {
            return contains(arr, i - 1, x);
        }

    }

    public static boolean contentCheck(char[] arr1, char[] arr2, int i) {
        if (arr1[i] == arr2[i] && i == 1) {
            return true;
        }
        if (arr1[i] != arr2[i]) {
            return false;
        }

        return contentCheck(arr1, arr2, i - 1);
    }

    public static int getIndex(int[] arr, int i, int x) {
        if (arr[arr.length - i] == x) {
            return i;
        } else if (arr[arr.length - i] != x) {
            if (i == 1) {
                return 0;
            } else

                return getIndex(arr, i - 1, x);
        }
        return getIndex(arr, i - 1, x);
    }

    public static int sum(int k) {
        if (k > 0) {
            System.out.println(k);
            return k + sum(k - 1);
        } else {
            return 0;
        }
    }

    public static int sum(int start, int end) {
        if (end > start) {
            return end + sum(start, end - 1);
        } else {
            return end;
        }
    }

    public static void main(String[] args) {
        int[] Arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 10};
        System.out.println(Arr.length - 1);
        int[] arrr = {5, 5, 5, 5};
        char[] arr1 = {'a', 'b', 'c'};
        char[] arr2 = {'a', 'b', 'c'};
        char[] arr3 = {'r', 'a', 'f', 'e', 'c', 'a', 'r'};
        char[] arr4 = {'a', 'c', 'c', 'a'};
        int var = fakul(10);
        int var1 = DigitSum(15);
        //System.out.println(var);
        //System.out.println(var1);
        //System.out.println(power(2, 4));
        //System.out.println(sumNegatives(new int[]{-1,-2,-3,-4},4 ));
        // System.out.println(countPositives(new int[]{1, -2, -3, 4, 3, 4, 3, 4}, 4));
        //System.out.println(countPositivesLimited(new int[]{1, -2, 3, 4, 3, 4, 3, 4,1,2,3,4}, 0,11));
        //System.out.println(maximum(Arr, Arr.length-1));
        //hi();
        //System.out.println(add(4));
        //System.out.println(grid(3,2));
        //System.out.println(isSorted(Arr, 3));
        //System.out.println(contains(Arr,3,3));
        //System.out.println(contentCheck(arr1, arr2, 2));
        //System.out.println(palindrumCheck(arr3, arr3.length-1));
        //System.out.println(getIndex(Arr, Arr.length,4 ));
        //System.out.println(sum(3));
        //System.out.println(isPossib(arrr, arrr.length - 1, 0));
        //System.out.println(binarySearchRekursiv(Arr, 8, 0, Arr.length-1));
    }

    public static boolean palindrumCheck(char[] arr, int i) {
        int hälfte = arr.length / 2;
        int first = arr.length - i;
        if (arr[i] != arr[arr.length - i - 1]) {
            return false;
        }
        if (arr.length % 2 == 1) {
            if (arr.length - i <= hälfte && i >= hälfte)
                if (arr[arr.length - i + 1] == arr[i]) {
                    if (i == hälfte + 1) {
                        return true;
                    }
                }
        } else if (arr.length % 2 == 0) {
            if (arr[arr.length - i] == arr[i]) {
                if (i == hälfte) {
                    return true;
                }
            }
        }
        return palindrumCheck(arr, i - 1);
    }

    public static boolean isPossib(int[] arr, int i, int result) {
        //Ausnahmen
        if (arr == null || i < 0 || i >= arr.length) {
            throw new IllegalArgumentException();
        }
        //Abbruchbedingung
        if (i == 0) {
            if (result + arr[i] == 0 || result - arr[i] == 0) {

                return true;
            } else {

                return false;
            }
            //problem kleiner machen
        } else {

            if (isPossib(arr, i - 1, result + arr[i])) {

                return true;
            } else if (isPossib(arr, i - 1, result - arr[i])) {
                return true;
            }

            return false;

        }
    }

    public static boolean binarySearchRekursiv(int[] arr, int x, int start, int end) {

        if (start == end) {
            if (arr[start] == x) {
                return true;
            } else {
                return false;
            }
        }
        int mid = (end - 1) / 2;
        if (arr[mid] == x) {
            return true;
        } else if (binarySearchRekursiv(arr, x, start + 1, end)) {
            return true;
        } else if (binarySearchRekursiv(arr, x, start, end - 1)) {
            return true;
        }
        return false;
    }


}


