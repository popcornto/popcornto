package genericlistes;

public class GenericsTest
{
    public static void main(String[] args)
    {
        DoublyLinkedList<String> ints = new DoublyLinkedList<>();
        ints.add("1");
        ints.add("2");
        ints.add("3");
        ints.add("4");
        ints.add("7");
        ints.showAll();
        DoublyLinkedList<String> intsm = new DoublyLinkedList<>();

        intsm.add("4");
        intsm.add("4");
        intsm.add("4");
        intsm.add("4");
        intsm.add("4");
        /*ints.positions();
        for (int elemnt: ints.positions()
             ) {
            System.out.println(elemnt);
        }*/
        //ints.appendFirst();
        //ints.showAll();

        /*DoublyLinkedList<Double> doubles = new DoublyLinkedList<Double>();
        doubles.add( 14.1 ); doubles.add( 7.4 ); doubles.add( 2.3 ); doubles.add( 5.0 );
        doubles.showAll();
        doubles.appendFirst();
        doubles.showAll();*/

        ints.intject(intsm, 2);
        ints.showAll();

    }
    
    public static void test()
    {
        DoublyLinkedList<Integer> ints = new DoublyLinkedList<Integer>();
        ints.add(5);
        ints.add(6);
        ints.add(7);
        ints.add(8);
        ints.showAll();
        System.out.println();
        Iterator<Integer> i = ints.iterator();
        while ( i.hasNext() )
        {
            System.out.print( i.next() + " " );
        }
        System.out.println();
        DoublyLinkedList<Double> doubles = new DoublyLinkedList<Double>();
        doubles.add( 14.1 ); doubles.add( 7.4 ); doubles.add( 2.3 ); doubles.add( 5.0 );
        Iterator<Double> it = doubles.iterator();
        double sum = 0.0;
        while ( it.hasNext() )
        {
            sum += it.next();
        }
        System.out.println( "sum: " + sum );
        
    }
}
