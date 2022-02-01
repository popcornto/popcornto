package P6;

public class Testumgebung
{
    public static void main( String[] args )
    {
        testDoublyLinkedList();
    }
        
    public static void testDoublyLinkedList()
    {
        DoublyLinkedList integers = new DoublyLinkedList();
        integers.add( 1 );
        integers.add( 2 );
        integers.add( 3 );
        integers.add( 4 );
        integers.add( 6 );
        integers.add( 0 );
        integers.add( 8 );
        integers.add( 3);
        integers.showAll();
        //integers.clear();
        //integers.showAll();
        //System.out.println(integers.getLast());
        //System.out.println(integers.contains(0));
        //System.out.println(integers.count(4));
        //System.out.println(integers.allEqual());
        System.out.println(integers.containsDouble());
        integers.insert(0, 5);
        integers.showAll();


    }
}
