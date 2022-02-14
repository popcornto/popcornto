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
        num.add(2);
        num.add(2);
        num.add(0);

        List<Integer> nums = new LinkedList<>();
        nums.add(4);
        nums.add(4);
        nums.add(4);
        nums.add(2);
        nums.add(4);
        nums.add(4);
        nums.add(4);
        nums.add(4);

        Iterable<Integer> it = nums;
        System.out.println(size(intsmsad));

        System.out.println(hasSmaller(nums, new Integer(1)));
        System.out.println(quantity(nums, 2));
        System.out.println(disjointed(num, nums));


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

    public static int quantity(Iterable<Integer> s, int w){
        int q = 0;
        for (Integer i : s) {
            if (i == w){
                q++;
            }
        }
        return q;
    }
    public static <X> boolean disjointed(Iterable<X> p1, Iterable<X> p2){
        Iterator<X> it1 = p1.iterator();
        while(it1.hasNext()){
            X item = it1.next();
            Iterator<X> it2 = p2.iterator();
            while(it2.hasNext()){
                if (item.equals(it2.next())){
                    return false;
                }
            }
        }
        return true;
    }
}

