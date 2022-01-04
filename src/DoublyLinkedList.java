public class DoublyLinkedList
{
    private Element first, last;
    private int size;


    public static void main(String[] args) {
        //Same shit

        //Integer a = 6;
        //Integer a = new Integer(6);
        //int b = a.intValue();
        //int b = a;
        //Boolean a = new Boolean(true);
        //Boolean b = a.booleanValue();
        //System.out.println(b);
    }
    public static int[] reverse(int[] arr){
        int[] swap = new int[arr.length];
        int j = 0;
        for (int i = arr.length-1; i >= 0;i--){
            swap[j] = arr[i];
            j++;
        }
        return swap;
    }


    public static int[] palindrom(int[] arr){
        int[] swap = arr;
        int j = 0;
        for (int i = arr.length-1; i >= 0;i--){
            swap[j] = arr[i];
            j++;
        }
        return swap;
    }

    public DoublyLinkedList()
    {
        first = last = null;
        size = 0;
    }

    public int size()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    public void add( Object content )
    {
        Element e = new Element( content );
        if ( isEmpty() )
        {
            first = last = e;
        }
        else
        {
            last.connectAsSucc( e );
            last = e;
        }
        size++;
    }

    public void addFirst( Object content )
    {
        Element e = new Element( content );
        if ( isEmpty() )
        {
            first = last = e;
        }
        else
        {
            first.connectAsPred( e );
            first = e;
        }
        size++;
    }

    public Object getFirst()
    {
        if ( !isEmpty() )
        {
            return first.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object get( int index )
    {
        if ( index >= 0 && index < size )
        {
            Element current = first;
            for ( int i = 0; i < index; i++ )
            {
                current = current.getSucc();
            }
            return current.getContent();
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public Object removeFirst()
    {
        if ( !isEmpty() )
        {
            Object result = first.getContent();
            if ( first.hasSucc() )
            {
                first = first.getSucc();
                first.disconnectPred();
            }
            else
            {
                first = last = null;
            }
            size--;
            return result;
        }
        else
        {
            throw new RuntimeException();
        }
    }

    public void showAll()
    {
        Element current = first;
        while ( current != null )
        {
            System.out.print( current.getContent().toString() );
            if ( current != last )
            {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }
}
