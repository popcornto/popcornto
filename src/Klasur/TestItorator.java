package Klasur;

public class TestItorator {
    public static void main(String[] args) {
        //testIterator();
        DoublyLinkedList ints = new DoublyLinkedList();
        ints.add( 5 );
        ints.add( 6 );
        ints.add( 9 );
        ints.showAll();


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

        Iterator studsIterator = studs.iterator();
        while ( studsIterator.hasNext() )
        {
            System.out.print(studsIterator.next().toString());
        }
        System.out.println();


        DoublyLinkedList ints = new DoublyLinkedList();
        ints.add( 5 );
        ints.add( 6 );
        ints.add( 9 );
        ints.showAll();

        Iterator intsIterator = ints.iterator();
        while ( intsIterator.hasNext() )
        {
            System.out.println( intsIterator.next().toString() );
        }

    }
}
