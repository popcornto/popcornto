public class hamood {
    public static int remainder( int dividend, int divisor){
        return ((divisor * (dividend / divisor) - (dividend))*-1);
    }
    public static int remainder1(int dividend, int divisor){
        return dividend - dividend / divisor * divisor;
    }

public static int is0dd(int value){
        return (value*remainder(value, 2))/value;
        //return (2*(-1*(remainder(-1*(2*value),2))/2)-value)*-1/value
        //return remainder(value, 2);
}
public static int isEven(int value){
    return 1-remainder(value, 2);
}
public static int isDivisible(int dividend, int divisor1,int divisor2){
        return remainder(dividend, divisor1)+remainder(dividend,divisor2);
}
/*
    public static int is0dd2(int value){
        if ((value - (value/2)*2)==0){
            return 0;

        } else return 1;
    }
    public static int is0dd3(int value){
        return (((value+1)/2)*2)/(value+1);
    }
*/
    public static void main(String[] args){
        System.out.println(remainder(7, 2));
        System.out.println(remainder1(7,4));
        System.out.println(is0dd(1));
        System.out.println(isEven(4));
        System.out.println(isDivisible(6,3,3));

        
    }

}
