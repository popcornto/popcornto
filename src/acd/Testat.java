package acd;

import Arrrays.Fraction;

public class Testat
{
    public static Fraction apply(Fraction[] arr, int i){

        if(i<0 || i>=arr.length){
            return new Fraction(-1);
        }
        if (i > 0 && arr[i].toDouble() >= 0 && arr[i].toDouble() <= 1){
            return arr[i].add(apply(arr, i-1)) ;
        }if (arr[i].toDouble() >= 0 && arr[i].toDouble() <= 1){
        return arr[i];} else if(i ==0)
        {
            return new Fraction(0);
        }

        return apply(arr, i-1);
    }
}
