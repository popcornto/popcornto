package P6;

public class DoublyLinkedList {
    private Element first, last;
    private int size;

    public DoublyLinkedList() {
        first = last = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(Object content) {
        Element e = new Element(content);
        if (isEmpty()) {
            first = last = e;
        } else {
            last.connectAsSucc(e);
            last = e;
        }
        size++;
    }

    public void addFirst(Object content) {
        Element e = new Element(content);
        if (isEmpty()) {
            first = last = e;
        } else {
            first.connectAsPred(e);
            first = e;
        }
        size++;
    }

    public Object getFirst() {
        if (!isEmpty()) {
            return first.getContent();
        } else {
            throw new RuntimeException();
        }
    }

    public Object get(int index) {
        if (index >= 0 && index < size) {
            Element current = first;
            for (int i = 0; i < index; i++) {
                current = current.getSucc();
            }
            return current.getContent();
        } else {
            throw new RuntimeException();
        }
    }

    public Object removeFirst() {
        if (!isEmpty()) {
            Object result = first.getContent();
            if (first.hasSucc()) {
                first = first.getSucc();
                first.disconnectPred();
            } else {
                first = last = null;
            }
            size--;
            return result;
        } else {
            throw new RuntimeException();
        }
    }

    public void showAll() {
        Element current = first;
        while (current != null) {
            System.out.print(current.getContent());  // impliziter Aufruf von toString, falls != null
            if (current != last) {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }

    public void clear() {
        if (!isEmpty()) {
            first = last = null;
            size = 0;
        }
    }

    public Object getLast() {
        if (!isEmpty()) {
            return last.getContent();
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean contains(Object obj) {
        Element current = first;
        while (!isEmpty() && current != null) {
            if (current.getContent() == obj) {
                return true;
            } else {
                current = current.getSucc();
            }
        }
        return false;
    }

    public int count(Object obj) {
        int count = 0;
        Element current = first;
        while (!isEmpty() && current != null) {
            if (current.getContent() == obj) {
                count++;
                current = current.getSucc();
            } else {
                current = current.getSucc();
            }
        }
        return count;
    }

    public boolean allEqual() {
        Element current = first;
        while (!isEmpty() && current.hasSucc()) {
            if (current.getContent() != current.getSucc().getContent()) {
                return false;
            } else {
                current = current.getSucc();
            }
        }
        return true;
    }

    public boolean containsDouble() {
        Element current = first;
        Element next = current.getSucc();
        while (!isEmpty() && current != null) {
            for (int i = 0; i < size; i++){
                if (current.getContent() == next.getContent()) {
                    return true;
                } else if(next.hasSucc()) {
                    next = next.getSucc();
                }}
            current = current.getSucc();
        }
        return false;
    }


    public void insert(int n, Object obj){
        Element current = first;
        Element neu = new Element(obj);
        if(!isEmpty() && n != 0){
            for (int i = 0; i <= n;i++ ){
                if (current.hasSucc()){
                current = current.getSucc();
            }
            }
            Element prede = current.getPred();
            current.disconnectPred();
            neu.connectAsPred(prede);
            current.connectAsPred(neu);
            size++;
        }else {
            neu.connectAsSucc(current);
            current.connectAsPred(neu);
            first = neu;
            size++;
        }
    }
}
