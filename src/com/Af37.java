package com;

public class Af37 {
    public static void main(String[] args) {
        int[] zahlen = {3,3,3,3,3,3};
        //System.out.println(positiveMinimum(zahlen,5));
        //System.out.println(number(zahlen,5,3));
        Polymorphie.main.run();
    }

    public static int positiveMinimum(int[] arr, int limit) {
        if (limit < 0 || limit >= arr.length) {
            throw new RuntimeException();
        } else {
            if (limit == 0) {
                return arr[0];
            } else {
                int min = positiveMinimum(arr, limit - 1);
                if (arr[limit] > 0 && min < 0 || arr[limit] < min && min > 0 && arr[limit] > 0) {
                    return arr[limit];
                } else {
                    if (min < 0) {
                        return -1;
                    } else return min;
                }
            }
        }
    }

    public static int number(int[] arr, int limit, int val){
        if(limit >= 0 && limit <= arr.length){
            if(limit == 0){
                if(arr[0]==val){
                    return 1;
                } else return 0;
            } else {
                if(arr[limit] == val){
                    return 1 + number(arr,limit-1,val);
                } else return number(arr,limit-1,val);
            }
        } else throw new IllegalStateException();
    }
}
