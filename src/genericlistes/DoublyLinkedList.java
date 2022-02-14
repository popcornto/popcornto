package genericlistes;

public class DoublyLinkedList<T> {
    private Element first, last;
    private int size;

    public DoublyLinkedList() {
        first = last = null;
        size = 0;
    }
    public DoublyLinkedList(DoublyLinkedList list, int n){
        if(list.size == n){
            first = list.first;
            last = list.last;
            size = list.size;
            list.last = list.first = null;
        }if(list.size() > n){
            Element current = list.first;
            int counter = n;
            while(counter > 0){
                Element add = new Element(current.getContent());
                if (isEmpty()){
                    first = last = add;
                    size++;
                }else{
                    Element current1 = first;
                    current1.connectAsSucc(add);
                    last = current1.getSucc();
                    size++;
                }
                current = current.getSucc();
                current.disconnectPred();
                list.first = current;
                list.size--;
                counter--;
            }
        }
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

    public void removeUnequalToFirst() {
        if (!isEmpty() && first.getContent() != null) {
            Element current = first.getSucc();
            while (current != null) {
                if (!first.getContent().equals(current.getContent())) {
                    if (current.hasPred() && current.hasSucc()) {
                        Element next = current.getSucc();
                        Element pred = current.getPred();
                        pred.disconnectSucc();
                        pred.connectAsSucc(next);
                        current = pred;
                        size--;
                    } else {
                        if (!first.getContent().equals(current.getContent())) {
                            if (!current.hasSucc()) {
                                current.disconnectSucc();
                                last = current;
                                size--;
                            }
                        }

                    }
                }
                current = current.getSucc();
            }
        }
    }

    public void delete(T p1, T p2) {

        if (!isEmpty()) {

            Element p1Index = first;

            int countp1Index = 0;
            while (p1Index != null && !p1Index.getContent().equals(p1)) {
                p1Index = p1Index.getSucc();
                countp1Index++;
            }
            Element p2Index = first;
            int countp2Index = 0;
            while (p2Index != null && !p2Index.getContent().equals(p2)) {
                p2Index = p2Index.getSucc();
                countp2Index++;
            }
            if (countp1Index > countp2Index) {
                Element current = p2Index;
                while (current != null && current.hasPred() && !current.getContent().equals(current.getPred().getContent())) {
                    if (current.getSucc().hasSucc()) {
                        Element succSucc = current.getSucc().getSucc();
                        current.disconnectSucc();
                        current.connectAsSucc(succSucc);
                        current = current.getSucc();

                    }
                }

            } else if (countp1Index < countp2Index) {
                Element current = p1Index;
                while (current != null && current.hasPred()) {
                    if (current.hasSucc() && current.getSucc().hasSucc()) {
                        if (current.getContent().equals(p2Index.getPred().getContent())) {
                            Element succSucc = current.getSucc().getSucc();
                            current.disconnectSucc();
                            current.connectAsSucc(succSucc);
                            current = current.getSucc();
                            showAll();
                        } else {
                            current = current.getSucc();
                        }
                    } else {
                        current = current.getSucc();
                    }
                }
            }
        }
    }

    public boolean notIn(T[] test) {
        if (isEmpty() || test.length <= 0) {
            return true;
        } else {
            Element current = first;
            while (current != null) {
                for (int i = 0; i < test.length; i++) {
                    if (current.getContent().equals(test[i])) {
                        return false;
                    }
                }
                current = current.getSucc();
            }
        }
        return true;
    }

    public void prepend(T[] toPrep) {
        if (toPrep.length > 0) {
            Element current = first;
            for (int i = toPrep.length - 1; i >= 0; i--) {
                Element add = new Element(toPrep[i]);
                current.connectAsPred(add);
                first = current.getPred();
                current = current.getPred();
                size++;

            }

        }
    }

    public DoublyLinkedList<T> sub(T p) {
        DoublyLinkedList<T> newlist = new DoublyLinkedList<>();
        Element current = first;
        int countIndexoffirst = 0;
        while (current != null && !current.getContent().equals(p)) {
            current = current.getSucc();
            countIndexoffirst++;
        }
        Element next = current.getSucc();
        int countIndexofnext = 0;
        while (next != null && !next.getContent().equals(p)) {
            next = next.getSucc();
            countIndexofnext++;
        }

        while (countIndexofnext > 0) {
            if (current.getSucc().hasSucc()) {
                Element currentsucctoadd = current.getSucc();

                Element e = new Element(currentsucctoadd.getContent());
                if (newlist.isEmpty()) {
                    newlist.first = newlist.last = e;
                } else {
                    newlist.last.connectAsSucc(e);
                    newlist.last = e;
                }
                newlist.size++;
                Element currentsucc = current.getSucc().getSucc();


                current.disconnectSucc();
                current.connectAsSucc(currentsucc);
                size--;
                countIndexofnext--;
            }
        }
        return newlist;
    }

    public void packs() {
        Element current = first;
        while (current != null) {

            while (current.hasSucc() && current.getSucc().getContent().equals(current.getContent())) {

                if (current.getSucc().hasSucc()) {
                    Element newnext = current.getSucc().getSucc();
                    current.disconnectSucc();
                    current.connectAsSucc(newnext);
                    size--;
                } else if (!current.hasSucc()) {
                    current.disconnectSucc();
                    last = current;
                    size--;
                } else {
                    current.disconnectSucc();
                    last = current;
                    size--;
                }
            }


            current = current.getSucc();
        }
    }

    public void reverse() {
        Element up = first;
        Element down = last;

        for (int i = 0; i < size / 2; i++) {
            if (i == 0) {
                Element tempup = new Element(up.getContent());
                Element tempdown = new Element(down.getContent());
                up = up.getSucc();
                up.disconnectPred();
                up.connectAsPred(tempdown);
                up = up.getPred();
                first = up;
                down = down.getPred();
                down.disconnectSucc();
                down.connectAsSucc(tempup);
                down = down.getSucc();
                last = down;
                down = down.getPred();
                up = up.getSucc();
            } else {
                Element tempup = new Element(up.getContent());
                Element tempdown = new Element(down.getContent());
                up = up.getSucc();
                up.disconnectPred();
                up.connectAsPred(tempdown);
                up = up.getPred();
                down = down.getPred();
                down.disconnectSucc();
                down.connectAsSucc(tempup);
                down = down.getSucc();
                down = down.getPred();
            }
        }
    }

    public void deleteNext(T content) {
        Element current = first;
        boolean found = false;
        while (current != null) {
            if (current.getContent().equals(content)) {
                found = true;
                break;
            }
            current = current.getSucc();
        }
        if (found) {
            if (current.getSucc().hasSucc()) {
                Element currentnext = current.getSucc().getSucc();
                current.disconnectSucc();
                current.connectAsSucc(currentnext);
                size--;
            } else {
                current.disconnectSucc();
                size--;
            }
        } else {

        }
    }

    public int equalHead(DoublyLinkedList<T> other) {
        if (!isEmpty() && !other.isEmpty()) {
            int count = 0;
            Element current = first;
            Element othercurrent = other.first;

            while (current != null && othercurrent != null) {
                if (current.hasSucc() && othercurrent.hasSucc()) {
                    if (current.getContent().equals(current.getSucc().getContent()) && othercurrent.getContent().equals(othercurrent.getSucc().getContent()) && current.getContent().equals(othercurrent.getContent()) && current.getSucc().getContent().equals(othercurrent.getSucc().getContent())) {
                        count++;
                    }
                }
                othercurrent = othercurrent.getSucc();
                current = current.getSucc();
            }
            return count;
        } else {
            return 0;
        }

    }

    public boolean asymmetric(){
        Element up = first;
        Element down = last;

        for (int i = 0; i < size/2; i++) {
            if (up.getContent().equals(down.getContent())){
                return false;
            }else{
                up = up.getSucc();
                down = down.getPred();
            }
        }
        return true;
    }


}







