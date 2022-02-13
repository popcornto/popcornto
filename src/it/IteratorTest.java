package it;



import java.util.*;

public class IteratorTest {
    public static void main( String[] args )
    {
        //test();
        int[] arr = {1,2,3,4,5,6,7};

        List<Iterable<Integer>> intsmsad = new ArrayList<>();
        intsmsad.add(new ArrayIterable(arr));
        List<Integer> num = new LinkedList<>();
        num.add(2);
        num.add(2);
        num.add(2);
        num.add(4);
        num.add(2);
        num.add(2);
        num.add(0);
        Iterable<Integer> it = num;
        System.out.println(size(intsmsad));

        System.out.println(hasSmaller(num, new Integer(1)));


    }

    private static <F> void printViaIterator( Iterator<F> it )
    {
        while ( it.hasNext() )
        {
            System.out.println( it.next() );
        }
    }
    public static <T extends Comparable<T>> boolean hasSmalle(Iterable<T> all, T obj){
        Iterator<T> current = (Iterator<T>) all.iterator();
        int count = 0;
        while (current.hasNext()){

            if (obj.compareTo(current.next()) < 0){
                count++;
                break;
            }
        }
        if (count >= 1){
            return true;
        }else {
            return false;
        }
    }

    public static <T> int size(List<Iterable<T>> structures){
        int count = 0;
        for (Iterable<T> it:structures) {
            for (T t:it
                 ) {
                count++;
            }

        }
        return count;
    }
    public static <T extends Comparable<T>> boolean hasSmaller(Iterable<T> arr, T obj){
        Iterator<T> it = arr.iterator();
        int count = 0;
        while(it.hasNext()){
            if (obj.compareTo(it.next()) > 0 ){
                count++;
            }
        }
        if (count == 1){
            return true;
        }else {
            return false;
        }
    }

}

