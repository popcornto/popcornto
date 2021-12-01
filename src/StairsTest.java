public class StairsTest
{
    public static void main( String[] args )
    {
        long start = System.currentTimeMillis();
        System.out.println( StairsOfOH14.routesToTop(45) );
        System.out.println( "Duration (recursive): " + (System.currentTimeMillis() - start ));
        start = System.currentTimeMillis();
        System.out.println( StairsOfOH14.iterativRoutesToTop(45) );
        System.out.println( "Duration (iterativ): " + (System.currentTimeMillis() - start ));
    }
}
