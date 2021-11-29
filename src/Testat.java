public class Testat {
    public static int[] apply(int[] arr, int x){

        int count=0;
        for (int i =0;i< arr.length;i++){
            if(arr[i]==x)count++;
        }
         int[] neuesfeld=new int[arr.length-count];
        int index = 0;
        for (int i = 0;i< arr.length;i++){
            if (arr[i]!= x){
                {neuesfeld[index] = arr[i];
                    index++;}
            }

        }
        return neuesfeld;}
    public static void main(String[] args) {
        for (int elment : apply(new int[]{1, 2, 3, 4, 5, 6, 7}, 5)) {
            System.out.print(elment);
        }

    }
 }

