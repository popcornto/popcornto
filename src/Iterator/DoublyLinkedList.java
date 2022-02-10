package Iterator;

public class DoublyLinkedList
{
    private Element first, last;
    private int size;

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
            throw new IllegalStateException();
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
            throw new IllegalStateException();
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
            throw new IllegalStateException();
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

    // Iterator

    public Iterator iterator()
    {
        return new ForwardIterator(); 
    }

    private abstract class ListIterator extends Iterator
    {
        Element current;

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

    private class ForwardIterator extends ListIterator
    {
        ForwardIterator() 
        { 
            current = first; 
        }
        
        Element step()
        {
            return current.getSucc();
        }

    }

    private class ReverseIterator extends ListIterator
    {
        ReverseIterator() 
        { 
            current = last; 
        }
        
        Element step()
        {
            return current.getPred(); 
        }

    }

    // Element
    
    private class Element
    {
        private Object content;
        private Element pred, succ;

        Element( Object c )
        {
            content = c;
            pred = succ = null;
        }

        Object getContent()
        {
            return content;
        }

        void setContent( Object c )
        {
            content = c;
        }

        boolean hasSucc()
        {
            return succ != null;
        }

        Element getSucc()
        {
            return succ;
        }

        void disconnectSucc()
        {
            if ( hasSucc() ) 
            {
                succ.pred = null;
                succ = null;
            }
        }

        void connectAsSucc( Element e)
        {
            disconnectSucc();
            if ( e != null ) 
            {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }

        boolean hasPred()
        {
            return pred != null;
        }

        Element getPred()
        {
            return pred;
        }

        void disconnectPred()
        {
            if ( hasPred() )
            {
                pred.succ = null;
                pred = null;

            }
        }

        void connectAsPred( Element e )
        {
            disconnectPred();
            if ( e != null )
            {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }

    }
}    
