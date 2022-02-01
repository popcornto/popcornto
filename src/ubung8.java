public class ubung8 {
    public static void main(String[] args) {
        System.out.println('1' + 3);
        run();
    }
    public static void m( char p ) { System.out.print( "X" );}
    public static void m( long p ) { System.out.print( "L" );}
    public static void m( double p ) { System.out.print( "D" );}

    public static void run()
    {
        m( 'a' );
        m( new Integer( 2 ) + 2 );
        m( 8.1 / 2.0 );
        m( 2 + 10 );
        m( 8L / 2.0 );
        m( '1' / new Integer( 3 ) );
    }
    //XLDLLD
}
