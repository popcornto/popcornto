package huffman;

public class CharacterSearchTree {
    private HuffmanTriple content;
    private CharacterSearchTree leftChild, rightChild;


    public CharacterSearchTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    public CharacterSearchTree(char[] arr) {
        CharacterSearchTree current = this;

        for (int i = 0; i < arr.length; i++) {
            iterativeAdd(arr[i]);
        }
    }

    public static void main(String[] args) {

        char[] arr = {'b', 'a', 'a', 'c', 'd', 's', 'a', 'b'};
        CharacterSearchTree current = new CharacterSearchTree(arr);
        //firstTreeTest();
        //secondTreeTest();
        //current.show();
        current.add('t', 5, "sheesh");
        current.show();

    }

    public static void firstTreeTest() {
        String s = "halloween";

        CharacterSearchTree hal = new CharacterSearchTree();
        for (int i = 0; i < s.length(); i++) {
            hal.add(s.charAt(i));
        }
        System.out.println("binary tree: ");
        System.out.println("--------------------------");
        hal.show();
    }

    public static void secondTreeTest() {
        String s = "Die Würde des Menschen ist unantastbar. Sie zu achten " +
                "und zu schützen ist Verpflichtung aller staatlichen Gewalt. " +
                "Das Deutsche Volk bekennt sich darum zu unverletzlichen und " +
                "unveräußerlichen Menschenrechten als Grundlage jeder menschlichen " +
                "Gemeinschaft, des Friedens und der Gerechtigkeit in der Welt. ";
        CharacterSearchTree gg = new CharacterSearchTree();
        for (int i = 0; i < s.length(); i++) {
            gg.add(s.charAt(i));
        }
        System.out.println("binary tree: ");
        System.out.println("--------------------------");
        gg.show();
    }

    public HuffmanTriple getContent() {
        if (!isEmpty()) {
            return content;
        } else {
            throw new IllegalStateException();
        }
    }

    //Knoten ist leer
    public boolean isEmpty() {
        return content == null;
    }

    //ist ein Blatt
    public boolean isLeaf() {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    //addiert einen blatt mit dem token t und wenn es schon existiert dann wird nur die Anzahl der Buchstaben erhöht
    public void add(char t) {
        if (isEmpty()) {
            content = new HuffmanTriple(t);
            leftChild = new CharacterSearchTree();
            rightChild = new CharacterSearchTree();
        } else {
            if (content.getToken() > t) {
                leftChild.add(t);
            } else if (content.getToken() < t) {
                rightChild.add(t);
            } else {
                content.incrementQuantity();
            }
        }
    }

    //gibt die größe des Baumes zurück
    public int size() {
        if (isEmpty()) {
            return 0;
        } else {
            return leftChild.size() + rightChild.size() + 1;
        }
    }

    //gibt den content in TExt aus
    public void show() {
        if (!isEmpty()) {
            leftChild.show();
            System.out.println(content.toString());
            rightChild.show();
        }
    }

    //
    public HuffmanTriple[] toArray() {

        if (!isEmpty()) {
            HuffmanTriple[] collector = new HuffmanTriple[size()];
            toArray(collector, 0);
            return collector;
        }
        return new HuffmanTriple[0];

    }

    private int toArray(HuffmanTriple[] collector, int index) {
        if (!isEmpty()) {
            index = leftChild.toArray(collector, index);
            collector[index] = content;
            index = rightChild.toArray(collector, index + 1);
        }
        return index;
    }

    public void iterativeAdd(char t) {
        CharacterSearchTree current = this;
        while (!current.isEmpty() && current.content.getToken() != t) {
            if (current.content.getToken() > t) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        if (current.isEmpty()) {
            current.content = new HuffmanTriple(t);
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        } else {
            current.content.incrementQuantity();
        }
    }

    public void add(char t, int q, String c) {
        CharacterSearchTree current = this;
        while (!current.isEmpty() && current.content.getToken() != t) {
            if (current.content.getToken() > t) {
                current = current.leftChild;
            } else {
                current = current.rightChild;
            }
        }
        if (!current.isEmpty() && current.content.getToken() == t) {
            current.content.incrementQuantity();
            current.content.setCode(c);
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        }if(current.isEmpty()){
            current.content = new HuffmanTriple(t, q);
            current.content.setCode(c);
            current.leftChild = new CharacterSearchTree();
            current.rightChild = new CharacterSearchTree();
        }
    }


}
