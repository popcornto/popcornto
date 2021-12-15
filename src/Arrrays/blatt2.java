package Arrrays;

public class blatt2 {


    public static void main(String[] args) {
        //System.out.println(countPairs(new int[]{1, 3, 3, 1, 2, 2, 2, 1, 1, 1}));
        //System.out.println(writtenBoth(new int[]{1, 3, 3, 1, 2, 2, 2, 3, 1, 1}, new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 7}));
        //System.out.println(notWrittenBoth(new int[]{1, 3, 3, 1, 2, 2, 2, 3, 1, 1}, new int[]{9, 9, 9, 9, 9, 9, 9, 9, 9, 9}));
        //System.out.println(countWrittenboth(new int[]{ 7, 8, 5, 2, 3, 6,45,23,76}, new int[]{1,2,3,4,5,6,7,8,9}));
        System.out.println(biggerThan(new int[]{ 9, 9, 9, 9, 9, 9,45,4,76}, new int[]{1,2,3,4,9,6,7,8,6}));
        //System.out.println(isSquare(new int[][]{ {9, 9, 9},{9, 9, 9,45,4},{76}}));

    }

    public static int greatestproperDividor(int n) {
        int count = 0;
        for (int z = 1; z < n; z++) {
            if (n % z == 0 & n != z) {
                count = z;
            }

        }

        return count;
    }

    public static int countPairs(int[] arr) {
        int count = 0;
        int next;
        for (int i = 0; i < arr.length - 1; i++) {
            next = i + 1;

            if (arr[i] != arr[next]) {
                i = next;
            } else {
                count++;
            }


        }
        return count;
    }

    /*public static boolean writtenBoth(int[] exam1, int[] exam2) {
        boolean haswrittenboth = false;
        if (exam2.length <= exam1.length) {
            for (int element1 : exam2) {
                for (int element2 : exam1) {
                    if (exam1[element1] == exam2[element2]) {
                        haswrittenboth = true;return haswrittenboth;
                    }
                }
            }
        }
        else if (exam1.length <= exam2.length) {
            for (int element1 : exam1
            ) {
                for (int element2 : exam2
                ) {
                    if (exam1[element1] == exam2[element2]) {
                        haswrittenboth = true;return haswrittenboth;
                    }
                }
            }
*/
    public static boolean writtenBoth(int[] exam1, int[] exam2) {
        boolean haswrittenboth = false;

        for (int i = 0; i<exam1.length;i++){
            for (int j = 0; j < exam2.length;j++){
            if (exam1[i]==exam2[j]){
                haswrittenboth = true;
            }
            }
        }
        return haswrittenboth;
    }
    public static boolean notWrittenBoth(int[] exam1 , int[] exam2){
        boolean hasntwrittenboth=true;
        for (int i = 0; i<exam1.length;i++){
            for (int j = 0; j < exam2.length;j++){
                if (exam1[i]==exam2[j]){
                    hasntwrittenboth = false;
                }
            }
        }

    return hasntwrittenboth;}
    public static int countWrittenboth(int[] exam1 , int[] exam2){
        int count=0;

        for (int i = 0; i<exam1.length;i++){
            for (int j = 0; j < exam2.length;j++){
                if (exam1[i]==exam2[j]){
                    count++;
                }
            }
        }

        return count;
    }
    public static boolean biggerThan(int[] exam1 , int[] exam2){
        boolean arebigger = true;

        for (int i = 0; i<exam1.length;i++){
            for (int j = 0; j < exam2.length;j++){
                if (exam1[i]<exam2[j]){
                    arebigger = false;
                }
            }
        }

        return arebigger;
    }
/*public static boolean isSquare(int[][] matrix){
        boolean isequal = true;
        for (int i =0; i<matrix.length-1; i++){
            if (matrix[i][i] != matrix[i][i]) {
                isequal = false;
            }
        }
        return isequal;
}*/

}

