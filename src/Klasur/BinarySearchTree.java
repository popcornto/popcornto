package Klasur;

public class BinarySearchTree<T extends Comparable<T>>
implements Iterable<T>
{
    // --- Loesungen ---

    private class PreOrderIterator implements Iterator<T>
    {
        private Stack<BinarySearchTree<T>> nodes;

        public PreOrderIterator()
        {
            nodes = new Stack<BinarySearchTree<T>>();
            if (!isEmpty() )
            {
                nodes.push( BinarySearchTree.this );
            }
        }

        public boolean hasNext() 
        {
            return !nodes.isEmpty();
        }

        public T next()
        {
            if ( hasNext() )
            {
                BinarySearchTree<T> result = nodes.pop();
                if ( !result.rightChild.isEmpty() )
                {
                    nodes.push( result.rightChild );
                }
                if ( !result.leftChild.isEmpty() )
                {
                    nodes.push( result.leftChild );
                }
                return result.getContent();
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public Iterator<T> preorderiterator()
    {
        return new PreOrderIterator();
    }

    private class BreadthFirstIterator implements Iterator<T>
    {
        private DoublyLinkedList<BinarySearchTree<T>> nodes;

        public BreadthFirstIterator()
        {
            nodes = new DoublyLinkedList<BinarySearchTree<T>>();
            nodes.add( BinarySearchTree.this );
        }

        public boolean hasNext() 
        {
            return !nodes.isEmpty();
        }

        public T next()
        {
            if ( hasNext() )
            {
                BinarySearchTree<T> result = nodes.removeFirst();
                if ( !result.leftChild.isEmpty() )
                {
                    nodes.add( result.leftChild );
                }
                if ( !result.rightChild.isEmpty() )
                {
                    nodes.add( result.rightChild );
                }
                return result.getContent();
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public Iterator<T> breadthfirstiterator()
    {
        return new BreadthFirstIterator();
    }

    
    // --- Vorgaben ---

    private T content;
    private BinarySearchTree<T> leftChild, rightChild;

    public BinarySearchTree() 
    {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public T getContent()
    {
        if (!isEmpty() )
        {
            return content;
        } else {
            throw new RuntimeException();
        }
    }

    public boolean isEmpty() 
    {
        return content == null;
    }

    public boolean isLeaf() 
    {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    public void add( T t )
    {
        if ( isEmpty() ) 
        {
            content = t;
            leftChild = new BinarySearchTree<T>();
            rightChild = new BinarySearchTree<T>();
        }
        else
        {
            if ( content.compareTo( t ) > 0 )
            {
                leftChild.add( t );
            }
            else if ( content.compareTo( t ) < 0 )
            {
                rightChild.add( t );
            }
        }
    }

    public boolean contains( T t )
    {
        if ( isEmpty() ) 
        {
            return false;
        }
        else
        {
            if ( content.compareTo( t ) > 0 )
            {
                return leftChild.contains( t );
            }
            else if ( content.compareTo( t ) < 0 )
            {
                return rightChild.contains( t );
            } 
            return true;
        }
    }

    public int size() 
    {
        if ( isEmpty() ) 
        {
            return 0;
        }
        else
        {
            return 1 + leftChild.size() + rightChild.size();
        }       
    }

    public void show()
    {
        if ( !isEmpty() ) 
        {
            leftChild.show();
            System.out.println( content );
            rightChild.show();
        }
    } 

    public Iterator<T> listBasedIterator()
    {
        DoublyLinkedList<T> list = new DoublyLinkedList<T>();
        toList( list );
        return list.iterator();
    }

    private void toList( DoublyLinkedList<T> list )
    {
        if ( !isEmpty() ) 
        {
            leftChild.toList( list );
            list.add( content );
            rightChild.toList( list );
        }
    }

    private class StackBasedIterator implements Iterator<T>
    {
        private Stack<BinarySearchTree<T>> nodes;

        public StackBasedIterator()
        {
            nodes = new Stack<BinarySearchTree<T>>();
            descendLeftAndPush( BinarySearchTree.this );
        }

        public T next() 
        {
            if ( hasNext() ) {
                T content = nodes.peek().getContent();
                descendLeftAndPush( nodes.pop().rightChild ); 
                return content;
            } else {
                throw new IllegalStateException();
            }
        }

        public boolean hasNext()
        {
            return !nodes.isEmpty();
        } 

        private void descendLeftAndPush( BinarySearchTree<T> root )
        {
            BinarySearchTree<T> current = root;
            while ( !current.isEmpty() )
            {
                nodes.push( current );
                current = current.leftChild;
            }
        }

    }

    public Iterator<T> iterator()
    {
        return new StackBasedIterator();
    }
}