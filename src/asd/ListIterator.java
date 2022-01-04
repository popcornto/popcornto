package asd;

public abstract class ListIterator
{
    Element current;

    ListIterator( Element elem )
    {
        current = elem;
    }

    public boolean hasNext()
    {
        return current != null;
    }
    
    public Object next()
    {
        if ( hasNext() )
        {
            Object content = current.getContent();
            current = step();
            return content;
        }
        else
        {
            throw new IllegalStateException();
        }
    }

    abstract Element step();
}