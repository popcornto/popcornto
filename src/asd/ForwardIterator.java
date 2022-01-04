package asd;

public class ForwardIterator extends ListIterator
{
    public ForwardIterator( Element elem )
    {
        super( elem );
    }

    protected Element step()
    {
        return current.getSucc();
    }

}
