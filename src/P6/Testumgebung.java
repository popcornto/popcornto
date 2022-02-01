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
        Object[] arr = new Object[9];
        Object five = 5;
        integers.add( 1 );
        integers.add( 5 );
        integers.add( 5 );
        integers.add( 4 );
        integers.add( 6 );
        integers.add( 5 );
        integers.add( 8 );
        integers.add( 3);
        //integers.showAll();
        //integers.clear();
        //integers.showAll();
        //System.out.println(integers.getLast());
        //System.out.println(integers.contains(0));
        //System.out.println(integers.count(4));
        //System.out.println(integers.allEqual());
        //System.out.println(integers.containsDouble());
        //integers.insert(0, 5);
        //integers.showAll();
        /*integers.toArray(arr);
        for (Object element:arr
             ) {
            System.out.print(element);
        }*/
        //integers.flip().showAll();
        //integers.remove(0);
        integers.showAll();
        integers.remove(five);
        integers.showAll();
    }
}
