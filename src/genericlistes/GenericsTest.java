package genericlistes;



public class GenericsTest
{
    public static void main(String[] args)
    {
        DoublyLinkedList<String> ints = new DoublyLinkedList<>();
        String four = "4";
        String two = "2";
        ints.add("3");
        ints.add("2");
        ints.add("36");
        ints.add("37");
        ints.add("4");
        ints.add("4");
        //DoublyLinkedList<String> ites = new DoublyLinkedList<>(ints, 1);
        ints.showAll();
        //ites.showAll();




        //ints.showAll();
        String[] arr = {"11", "10", "13", "3"};
        DoublyLinkedList<String> intsm = new DoublyLinkedList<>();
        intsm.add("3");
        intsm.add("2");
        intsm.add("3");
        intsm.add("3");
        intsm.add("3");
        intsm.add("4");
        intsm.add("9");
        //intsm.showAll();
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

        //ints.intject(intsm, 2);
        //ints.showAll();
        //ints.cutInFrontOf("0").showAll();
        //ints.showAll();
        //System.out.println(ints.size());
        //System.out.println(intsm.countDoubles());
        //System.out.println(intsm.longestSequence());
        //System.out.println(ints.allEqual(intsm));
        //ints.moveToHead(3);
        //ints.showAll();
        //System.out.println(ints.unequals(intsm));
        //ints.pack();
        //ints.showAll();
        //ints.removeUnequalToFirst();
        //ints.delete("3", four);
        //System.out.println(ints.notIn(arr));
        //ints.packs();
        //ints.reverse();
        //System.out.println(ints.asymmetric());
        //intsm.showAll();
        //System.out.println(ints.cutRange(5, ints.size()-1));
        //ints.showAll();
        //ints.inForntof("36", "6");
        //ints.deleteRepeated();
        //ints.deleteNexts("2");
        ints.singelton(3).showAll();
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
