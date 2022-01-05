package asd;

public class IteratorTest
{

    public static void main( String[] args )
    {
        testIterator();
    }
    
    public static void testIterator()
    {
        DoublyLinkedList studs = new DoublyLinkedList();
        studs.add( new Student( "A", "Inf", 123456 ) );
        studs.add( new Student( "B", "Inf", 123457 ) );
        studs.add( new Student( "C", "Inf", 123458 ) );
        studs.add( new Student( "D", "Inf", 123459 ) );
        studs.add( new Student( "E", "Inf", 123460 ) );
        studs.showAll();

        ForwardIterator studsIterator = studs.iterator();
        while ( studsIterator.hasNext() )
        {
            System.out.println( studsIterator.next().toString() );
        }
        System.out.println();
        
      
        DoublyLinkedList ints = new DoublyLinkedList();
        ints.add( 5 );
        ints.add( 6 );
        ints.add( 9 );
        ints.showAll();
        
        ForwardIterator intsIterator = ints.iterator();
        while ( intsIterator.hasNext() )
        {
            System.out.println( intsIterator.next().toString() );
        }

     }
}
