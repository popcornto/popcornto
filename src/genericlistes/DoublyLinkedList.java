package genericlistes;

public class DoublyLinkedList<T> {
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

    public void add(T content) {
        Element e = new Element(content);
        if (isEmpty()) {
            first = last = e;
        } else {
            last.connectAsSucc(e);
            last = e;
        }
        size++;
    }

    public void addFirst(T content) {
        Element e = new Element(content);
        if (isEmpty()) {
            first = last = e;
        } else {
            first.connectAsPred(e);
            first = e;
        }
        size++;
    }

    public T getFirst() {
        if (!isEmpty()) {
            return first.getContent();
        } else {
            throw new IllegalStateException();
        }
    }

    public T get(int index) {
        if (index >= 0 && index < size) {
            Element current = first;
            for (int i = 0; i < index; i++) {
                current = current.getSucc();
            }
            return current.getContent();
        } else {
            throw new IllegalStateException();
        }
    }

    public T removeFirst() {
        if (!isEmpty()) {
            T result = first.getContent();
            if (first.hasSucc()) {
                first = first.getSucc();
                first.disconnectPred();
            } else {
                first = last = null;
            }
            size--;
            return result;
        } else {
            throw new IllegalStateException();
        }
    }

    public void showAll() {
        Element current = first;
        while (current != null) {
            System.out.print(current.getContent().toString());
            if (current != last) {
                System.out.print(", ");
            }
            current = current.getSucc();
        }
        System.out.println();
    }


    // Iterator

    public Iterator<T> iterator() {
        return new ForwardIterator();
    }

    private abstract class ListIterator extends Iterator<T> {
        Element current;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            if (hasNext()) {
                T content = current.getContent();
                current = step();
                return content;
            } else {
                throw new IllegalStateException();
            }
        }

        abstract Element step();

    }

    private class ForwardIterator extends ListIterator {
        public ForwardIterator() {
            current = first;
        }

        Element step() {
            return current.getSucc();
        }
    }


    // strategies

    public static abstract class SubstitutionStrategy<E> {
        public abstract E substitute(E ref);
    }

    public void substituteAll(SubstitutionStrategy<T> s) {
        Element current = first;
        while (current != null) {
            current.setContent(s.substitute(current.getContent()));
            current = current.getSucc();
        }
    }

    public static abstract class InspectionStrategy<E> {
        public abstract void inspect(E ref);
    }

    public void inspectAll(InspectionStrategy<T> s) {
        Element current = first;
        while (current != null) {
            s.inspect(current.getContent());
            current = current.getSucc();
        }
    }

    public static abstract class DeletionStrategy<E> {
        public abstract boolean select(E ref);
    }

    public void deleteSelected(DeletionStrategy<T> s) {
        Element current = first;
        while (current != null) {
            Element candidate = current;
            current = current.getSucc();
            if (s.select(candidate.getContent())) {
                remove(candidate);
            }
        }
    }

    private void remove(Element e) {
        if (e != null) {
            if (e.hasSucc() && e.hasPred()) {
                e.getPred().connectAsSucc(e.getSucc());
            } else if (e == first && e.hasSucc()) {
                first = first.getSucc();
                first.disconnectPred();
            } else if (e == last && e.hasPred()) {
                last = last.getPred();
                last.disconnectSucc();
            } else {
                first = last = null;
            }
            size--;
        }
    }

    // Element

    private class Element {
        private T content;
        private Element pred, succ;

        public Element(T c) {
            content = c;
            pred = succ = null;
        }

        public T getContent() {
            return content;
        }

        public void setContent(T c) {
            content = c;
        }

        public boolean hasSucc() {
            return succ != null;
        }

        public Element getSucc() {
            return succ;
        }

        public void disconnectSucc() {
            if (hasSucc()) {
                succ.pred = null;
                succ = null;
            }
        }

        public void connectAsSucc(Element e) {
            disconnectSucc();
            if (e != null) {
                e.disconnectPred();
                e.pred = this;
            }
            succ = e;
        }

        public boolean hasPred() {
            return pred != null;
        }

        public Element getPred() {
            return pred;
        }

        public void disconnectPred() {
            if (hasPred()) {
                pred.succ = null;
                pred = null;

            }
        }

        public void connectAsPred(Element e) {
            disconnectPred();
            if (e != null) {
                e.disconnectSucc();
                e.succ = this;
            }
            pred = e;
        }
    }

    public int[] positions() {
        Element current = first;
        int index = 0;
        int count = 0;
        int[] result = new int[size];
        while (!isEmpty() && current.hasSucc()) {
            if (current.getContent() == null) {
                result[count] = index;
                count++;
            }
            current = current.getSucc();
            index++;
        }
        return result;
    }

    public void appendFirst() {
        if (size >= 2) {
            Element fiestnext = first.getSucc();
            last.connectAsSucc(first);
            last = first;
            first.getSucc().disconnectPred();
            first = fiestnext;
        }
    }

    public void intject(DoublyLinkedList<T> into, int p) {
        Element current = first;
        int count = 0;
        if (p <= size + 1) {
            while (current != null && !isEmpty() && count <= p) {
                if (p == count) {
                    Element currentInto = into.first;
                    for (int i = 0; i < into.size; i++) {
                        if (current.hasSucc() && currentInto != null) {
                            current.disconnectPred();
                            current.connectAsSucc(currentInto);
                            currentInto = currentInto.getSucc();
                        } else if (!into.isEmpty() && currentInto != null) {
                            current.connectAsSucc(currentInto);
                            currentInto = currentInto.getSucc();
                        }
                    }
                    Element currnext = current.getSucc();
                    if (currentInto.getSucc() == null) {
                        currentInto.connectAsSucc(currnext);
                    }
                }
                current = current.getSucc();
            }
        }
    }

    public DoublyLinkedList<T> cutInFrontOf(T obj) {
        if (!isEmpty()) {
            boolean contains = false;
            Element current = first;
            while (current != null) {
                if (current.getContent().equals(obj)) {
                    contains = true;
                    break;
                }
                current = current.getSucc();
            }
            if (contains) {
                current = first;
                DoublyLinkedList<T> newList = new DoublyLinkedList<>();
                if (current.hasSucc()) {
                    while (current != null && !current.getContent().equals(obj)) {
                        newList.add(current.getContent());
                        current = current.getSucc();
                    }
                }
                current = first;
                if (current.hasSucc()) {
                    while (current != null && !current.getContent().equals(obj)) {
                        current = current.getSucc();
                        size--;
                    }
                    if (current.hasPred()) {
                        current.disconnectPred();
                    }
                    first = current;
                    return newList;
                }
            }
        }
        return new DoublyLinkedList<>();
    }

    public int countA(int a) {
        int count = 0;
        if (!isEmpty()) {
            if (size >= a) {
                Element current = first;
                DoublyLinkedList<T> listOfDoubles = new DoublyLinkedList<>();
                while (current != null) {
                    int counter = 0;
                    Element next = first;
                    boolean existsPreviosly = false;
                    while (next != null) {

                        if (current.getContent().equals(next.getContent())) {
                            counter++;
                        }

                        next = next.getSucc();
                    }
                    Element currentNew = listOfDoubles.first;
                    while (!listOfDoubles.isEmpty() && currentNew != null) {
                        if (currentNew.getContent().equals(current.getContent())) {
                            existsPreviosly = true;
                        }
                        currentNew = currentNew.getSucc();
                    }
                    if (counter == a && !existsPreviosly) {
                        listOfDoubles.add(current.getContent());
                        count++;
                    }
                    current = current.getSucc();
                }
            }
        }
        return count;
    }

    public int countdoubles() {
        int result = 0;
        Element current = first;
        while (current != null) {
            Element current1 = first;
            int count = 0;
            while (current != null) {
                if (current.getContent().equals(current1.getContent())) {
                    count++;
                }
                current1 = current1.getSucc();
            }
            if (count == 2) {
                result++;
            }
            current = current.getSucc();
        }
        return result / 2;
    }

    public int longestSequence() {
        if (!isEmpty()) {
            int longest = 1;
            int tempLongest = 1;
            int count = 1;
            Element current = first;
            while (current != null && current.hasSucc()) {
                if (current.getContent().equals(current.getSucc().getContent())) {
                    count++;
                } else if (!current.getContent().equals(current.getSucc().getContent())) {
                    count = 1;
                }
                tempLongest = count;
                if (tempLongest > longest) {
                    longest = tempLongest;
                }
                current = current.getSucc();
            }
            return longest;
        } else {
            return 0;
        }
    }

    public boolean allEqual(DoublyLinkedList<T> d) {
        if (!isEmpty()) {
            Element c1 = first;
            Element c2 = d.first;
            while (c1 != null && c2 != null && c1.getContent().equals(c2.getContent())) {
                if (c1.getContent().equals(d.last.getContent()) && c2.getContent().equals(last.getContent())) {
                    return true;
                }
                c1 = c1.getSucc();
                c2 = c2.getSucc();
            }
        }
        return false;
    }

    public void moveToHead(int n) {
        if (!isEmpty()) {
            Element current = last;
            while (n >= 0 && current != null) {
                System.out.println(current.getContent().toString());
                current = current.getPred();
                n--;
            }
            Element currenttemp = current;
            currenttemp.disconnectPred();
            current.disconnectSucc();
            last = current;
            Element start = first;
            while (currenttemp != null) {
                currenttemp = currenttemp.getSucc();
            }
            while (currenttemp != null) {
                start.connectAsPred(currenttemp);
                currenttemp = currenttemp.getPred();
            }


        }
    }

    public boolean unequals(DoublyLinkedList param) {
        if (!isEmpty() && !param.isEmpty()) {
            Element ref1 = first;
            Element ref2 = param.first;
            if (size() > param.size()) {
                while (ref1 != null && ref2 != null && !ref1.getContent().equals(ref2.getContent())) {
                    if (!last.getContent().equals(ref2) && !param.last.getContent().equals(ref1)) {
                        return true;
                    }
                    ref1 = ref1.getSucc();
                    ref2 = ref2.getSucc();
                }
            }
        }
        return false;
    }

    public void pack() {
        Element current = first;
        while (current != null) {
            int count = 1;
            Element currenttemp = current.getSucc();
            while (currenttemp != null && currenttemp.getContent().equals(currenttemp.getSucc().getContent())) {
                count++;
                current.disconnectSucc();
                currenttemp = currenttemp.getSucc();
                current = current.getSucc();
            }
            current = current.getSucc();
        }
    }

    /*
        public DoublyLinkedList middel(int n) {
            if (!isEmpty()){
                DoublyLinkedList newList = new DoublyLinkedList();
                Element current = first;
                int half = size()/2;
                if (size() < n+2 ){
                    throw new IllegalStateException();
                }else{
                    if (size() % 2 == 0){
                        half++;
                    }

                    while (current != null && half > 0 ){
                        current = current.getSucc();
                    }
                }




            }*/
    public boolean cutRange(int pos1, int pos2) {
        if (pos1 >= 0 && pos1 < size() && pos2 >= 0 && pos2 < size()) {
            if (pos1 > pos2) {
                int posH = pos1;
                pos1 = pos2;
                pos2 = posH;
            }
            int count = 0;
            Element delFirst;
            Element delLast;
            Element current = first;
            while (count != pos1) {
                count++;
                current = current.getSucc();
            }
            delFirst = current;
            while (count != pos2) {
                count++;
                current = current.getSucc();
            }
            delLast = current;
            boolean countdeleted = false;
            if (pos1 + 1 < pos2) {
                if (delFirst.getPred() != null && delLast.getSucc() != null) {
                    Element delFirstPred = delFirst.getPred();
                    Element delLastSucc = delLast.getSucc();
                    delFirstPred.disconnectSucc();
                    delLastSucc.disconnectPred();
                    delFirstPred.connectAsSucc(delLastSucc);
                    countdeleted = true;
                    size = size - (pos2 - pos1);
                } else if (!delFirst.hasPred() && delLast.hasSucc()) {
                    Element delLastSucc = delLast.getSucc();
                    delLastSucc.disconnectPred();
                    first = delLastSucc;
                    size = size - pos2;
                    countdeleted = true;
                } else if (delFirst.getPred() != null && !delLast.hasSucc()) {
                    Element delFirstPred = delFirst.getPred();
                    delFirstPred.disconnectSucc();
                    last = delFirstPred;
                    size = size - pos2;
                    countdeleted = true;
                } else if (!delFirst.hasPred() && !delLast.hasSucc()) {
                    first = last = null;
                    size = 0;
                    countdeleted = true;
                }
            }
            if (countdeleted) {
                return countdeleted;
            }
        }
        return false;
    }
    public void removeUnequalToFirst(){
        if (!isEmpty() && first.getContent() != null){
            Element current = first.getSucc();
            while (current != null){
                if (!first.getContent().equals(current.getContent())){
                    if (current.getSucc() != null && current.getSucc().getSucc() != null){
                        Element afternext = current.getSucc().getSucc();
                        current.disconnectSucc();
                        afternext.disconnectPred();
                        current.connectAsSucc(afternext);
                        current = current.getSucc();
                    }else{
                        if (!first.getContent().equals(current.getContent())){
                            if (current.getSucc() != null && current.getSucc().getSucc() == null){
                                current.disconnectSucc();
                                last = current;
                            }
                        }

                    }
                }else{

                }
                current = current.getSucc();
            }
        }
    }
}


