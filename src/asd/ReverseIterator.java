package asd;

public class ReverseIterator extends ListIterator
{
    public ReverseIterator( Element elem )
    {
        super( elem );
    }

    protected Element step()
    {
        return current.getPred();
    }

}
