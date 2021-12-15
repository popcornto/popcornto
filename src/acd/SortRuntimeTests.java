package acd;

import java.util.Random;

public class SortRuntimeTests
{
/*
    // iterations runs with capacity unsorted acd.Students objects
    private static void randomTests( int capacity, int iterations )
    {
        mans.LectureWithSortAlgorithms forInsertion;
        mans.LectureWithSortAlgorithms forSelection;
        mans.LectureWithSortAlgorithms forQuick;
        Random generator = new Random();
        int regNo = 0;
        long timeInsertion = 0;
        long timeSelection = 0;
        long timeQuick = 0;
        long start = 0;
        long end = 0;

        for ( int run = 0; run < iterations; run++ )
        {
            forInsertion = new mans.LectureWithSortAlgorithms( "ins", capacity );
            forSelection = new mans.LectureWithSortAlgorithms( "sel", capacity );
            forQuick = new mans.LectureWithSortAlgorithms( "qck", capacity );
            for ( int stud = 0; stud < capacity; stud++)
            {
                regNo = generator.nextInt();
                forInsertion.add( new acd.Students( " ", " ", regNo ) );
                forSelection.add( new acd.Students( " ", " ", regNo ) );
                forQuick.add( new acd.Students( " ", " ", regNo ) );
            }
            start = System.currentTimeMillis();
            forInsertion.insertionSortByNumber();
            forInsertion.isSorted();
            end = System.currentTimeMillis();
            timeInsertion += end - start;
            start = System.currentTimeMillis();
            forSelection.selectionSortByNumber();
            forSelection.isSorted();
            end = System.currentTimeMillis();
            timeSelection += end - start;
            start = System.currentTimeMillis();
            forQuick.quickSortByNumber();
            forQuick.isSorted();
            end = System.currentTimeMillis();
            timeQuick += end - start;
        }
        System.out.println(); System.out.println();
        System.out.println( "   " + iterations + " tests with " + capacity + " unsorted acd.Students objects:" );
        System.out.println( "      average acd.time - insertion sort: " + timeInsertion/iterations );
        System.out.println( "      average acd.time - selection sort: " + timeSelection/iterations );
        System.out.println( "      average acd.time - quick sort: " + timeQuick/iterations );
    }

    // one run with capacity acd.Students objects in ascending order
    private static void ascendingTest( int capacity )
    {
        mans.LectureWithSortAlgorithms forInsertion;
        mans.LectureWithSortAlgorithms forSelection;
        mans.LectureWithSortAlgorithms forQuick;
        long timeInsertion = 0;
        long timeSelection = 0;
        long timeQuick = 0;
        long start = 0;
        long end = 0;
        forInsertion = new mans.LectureWithSortAlgorithms( "ins", capacity );
        forSelection = new mans.LectureWithSortAlgorithms( "sel", capacity );
        forQuick = new mans.LectureWithSortAlgorithms( "qck", capacity );
        for ( int i = 0; i < capacity; i++)
        {
            forInsertion.add( new acd.Students( " ", " ", i ) );
            forSelection.add( new acd.Students( " ", " ", i ) );
            if ( capacity < 3001 ) { forQuick.add( new acd.Students( " ", " ", i ) ); } //verhindert stack overflow
        }
        start = System.currentTimeMillis();
        forInsertion.insertionSortByNumber();
        forInsertion.isSorted();
        end = System.currentTimeMillis();
        timeInsertion = end - start;
        start = System.currentTimeMillis();
        forSelection.selectionSortByNumber();
        forSelection.isSorted();
        end = System.currentTimeMillis();
        timeSelection = end - start;
        start = System.currentTimeMillis();
        forQuick.quickSortByNumber();
        forQuick.isSorted();
        end = System.currentTimeMillis();
        timeQuick = end - start;

        System.out.println();
        System.out.println( "   test with " + capacity + " acd.Students objects in ascending order:" );
        System.out.println( "      acd.time - insertion sort (best case): " + timeInsertion );
        System.out.println( "      acd.time - selection sort: " + timeSelection );
        System.out.println( "      acd.time - quick sort: " + (capacity>3001 ? "overflow" : ""+timeQuick) ); // verhindert falsche Ausgabe
    }

    // one run with capacity acd.Students objects in downward order
    private static void downwardTest( int capacity )
    {
        mans.LectureWithSortAlgorithms forInsertion;
        mans.LectureWithSortAlgorithms forSelection;
        mans.LectureWithSortAlgorithms forQuick;
        long timeInsertion = 0;
        long timeSelection = 0;
        long timeQuick = 0;
        long start = 0;
        long end = 0;
        forInsertion = new mans.LectureWithSortAlgorithms( "ins", capacity );
        forSelection = new mans.LectureWithSortAlgorithms( "sel", capacity );
        forQuick = new mans.LectureWithSortAlgorithms( "qck", capacity );
        for ( int i = capacity; i > 0; i--)
        {
            forInsertion.add( new acd.Students( " ", " ", i ) );
            forSelection.add( new acd.Students( " ", " ", i ) );
            if ( capacity < 3001 ) { forQuick.add( new acd.Students( " ", " ", i ) ); } //verhindert stack overflow
        }
        start = System.currentTimeMillis();
        forInsertion.insertionSortByNumber();
        forInsertion.isSorted();
        end = System.currentTimeMillis();
        timeInsertion = end - start;
        start = System.currentTimeMillis();
        forSelection.selectionSortByNumber();
        forSelection.isSorted();
        end = System.currentTimeMillis();
        timeSelection = end - start;
        start = System.currentTimeMillis();
        forQuick.quickSortByNumber();
        forQuick.isSorted();
        end = System.currentTimeMillis();
        timeQuick = end - start;

        System.out.println();
        System.out.println( "   test with " + capacity + " acd.Students objects in downward order:" );
        System.out.println( "      acd.time - insertion sort (worst case): " + timeInsertion );
        System.out.println( "      acd.time - selection sort: " + timeSelection );
        System.out.println( "      acd.time - quick sort: " + (capacity>3001 ? "overflow" : ""+timeQuick) ); // verhindert falsche Ausgabe
    }


    public static void main( String[] args )
    {
//         randomTests( 10000, 50 );
//         randomTests( 20000, 50 );
//         randomTests( 30000, 50 );
//         randomTests( 40000, 50 );

        ascendingTest( 1000 );
        ascendingTest( 2000 );
        ascendingTest( 3000 );
        ascendingTest( 10000 );
        ascendingTest( 20000 );
        ascendingTest( 30000 );
        ascendingTest( 40000 );

        downwardTest( 1000 );
        downwardTest( 2000 );
        downwardTest( 3000 );
        downwardTest( 10000 );
        downwardTest( 20000 );
        downwardTest( 30000 );
        downwardTest( 40000 );

    }*/
}
