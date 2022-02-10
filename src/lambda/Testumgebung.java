package lambda;

public class Testumgebung {
    public static void main(String[] args) {
        IntIntPairs testPairs = new IntIntPairs(17);
        testPairs.put(7, 3);
        testPairs.put(4, 3);
        testPairs.put(1, -9);
        testPairs.put(6, 6);
        testPairs.put(2, 8);
        testPairs.put(41, 12);
        testPairs.put(9, -11);
        testPairs.put(8, 12);
        testPairs.put(5, -60);
        testPairs.put(14, 18);
        testPairs.put(0, 12);
        testPairs.put(-9, -16);
        IntIntPairs bro = new IntIntPairs(3);
        bro.put(0, 0);
        bro.put(17, 32);
        bro.put(1, 1);


        System.out.println("Beispiel: " + testPairs.accumulate((k, v) -> {
            if (k == 0) {
                return v;
            } else {
                return 0;
            }
        }));

        System.out.print("Beispiel: " + sumUp(testPairs));
        System.out.println();
        System.out.println(geradeInt(testPairs));
        //deleteSix(testPairs);
        //testPairs.show();
        //addTen(testPairs);
        //testPairs.show();
        //System.out.println(unEven(testPairs));
        //System.out.println(biggerThanTen(testPairs));
        //removeNegativs(testPairs);
        //testPairs.show();
        //doubleTheValue(testPairs);
        //testPairs.show();
        //System.out.println(addValues(testPairs));
        //System.out.println(biggerThanFive(testPairs));
        //addNToValue(testPairs, 7);
        //testPairs.show();
        //System.out.println(uniqueKey(testPairs, 19));
        testPairs.show();
        //doubleGreaterN(testPairs, 5);
        //testPairs.show();
        bro.show();
        //testPairs.combine(bro);
        testPairs.show();
        doubleGreaterN(testPairs, 5);
        testPairs.show();


    }

    public static int sumUp(IntIntPairs pairs) {
        return pairs.accumulate((k, v) -> {
            if (k == 0) {
                return v;
            } else {
                return 0;
            }
        });
    }

    public static int geradeInt(IntIntPairs pairs) {
        return pairs.accumulate((k, v) -> {
            if (k % 2 == 0) {
                return 1;
            } else {
                return 0;
            }
        });
    }

    public static void deleteSix(IntIntPairs pairs) {
        pairs.remove((k, v) -> (k == 6));
    }

    public static void addTen(IntIntPairs pairs) {
        pairs.manipulate((k, v) -> (k + 10), (k, v) -> (v));
    }

    public static IntIntPairs unEven(IntIntPairs pairs) {
        return pairs.extract((k, v) -> (v % 3 == 0));
    }

    public static int biggerThanTen(IntIntPairs pairs) {
        return pairs.accumulate((k, v) -> {if (v > 10) {return 1;} else {return 0;}});
    }

    public static void ifValueBiggerThenThree(IntIntPairs pairs) {
        pairs.manipulate((k, v) -> {if (v > 3) {return k + 5;} else {return k;}}, (k, v) -> v);
    }
    public static void removeNegativs(IntIntPairs pairs){
        pairs.remove((k,v) -> v<0);
    }
    public static void doubleTheValue(IntIntPairs pairs){
        pairs.manipulate((k,v) -> k,(k,v) -> v*2 );
    }
    public static IntIntPairs clone(IntIntPairs pairs){
        return pairs.extract((k,v)-> true);
    }
    public static void deleteEqauls(IntIntPairs pairs){
        pairs.remove((k,v) -> k == v);
    }
    public static int addValues(IntIntPairs pairs){
        return pairs.accumulate((k,v) -> v);
    }
    public static IntIntPairs biggerThanFive(IntIntPairs pairs){
        return pairs.extract((k,v) -> v>5);
    }
    public static void addNToValue( IntIntPairs pairs, int n )
    {
        pairs.manipulate( (k,v) -> k, (k,v) -> v+n);
    }
    public static boolean uniqueKey( IntIntPairs pairs, int n )
    {
        int count = pairs.accumulate((k,v) -> {if (n == v){return 1;}else return 0;});
        if (count > 1){return false;}else {return true;}
    }

    public static void doubleGreaterN( IntIntPairs pairs, int n )
    {
        if(pairs.uncomplete()){
            pairs.manipulate((k,v)->k,(k,v)->{if(k>n){pairs.put(k,v*2); return v;}else {return v;}});
        }
    }

    public static void addValue(){

    }
     public static IntIntPairs concat(IntIntPairs first, IntIntPairs second)
     {
         first.combine(second);

         return first;
     }
}

