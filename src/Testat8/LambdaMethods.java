package Testat8;

public class LambdaMethods
{

    public static int makeInt( IntIntPairs p )
    {
       return p.accumulate((k, v) -> v);
 
    }
    
    public static IntIntPairs  makePairs( IntIntPairs p )
    {
        return p.extract((k, v) -> {
            if (v < 0){
                return true;
            }else{
                return false;
            }
        });


    }
        
    public static void apply( IntIntPairs p )
    {
        p.manipulate((k, v) -> k/3,(k, v) -> v/3);

    }

}
