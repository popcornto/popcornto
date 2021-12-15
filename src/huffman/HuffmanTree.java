package huffman;

public class HuffmanTree {
    private HuffmanTriple content;
    private HuffmanTree leftChild, rightChild;

    //leerer Baum
    public HuffmanTree() {
        content = null;
        leftChild = null;
        rightChild = null;
    }

    //Blatt
    public HuffmanTree(HuffmanTriple t) {
        content = t;
        leftChild = new HuffmanTree();
        rightChild = new HuffmanTree();
    }

    //Knoten
    public HuffmanTree(HuffmanTree lc, HuffmanTree rc) {
        content = new HuffmanTriple(' ', lc.getContent().getQuantity() + rc.getContent().getQuantity());
        leftChild = lc;
        rightChild = rc;
    }

    public static void main(String[] args) {
        HuffmanTriple[] tokens1 = {new HuffmanTriple('i', 30),
                new HuffmanTriple('u', 20),
                new HuffmanTriple('n', 10),
                new HuffmanTriple('d', 15),
                new HuffmanTriple('g', 80), new HuffmanTriple('a' , 88)};
        HuffmanCoding hc = new HuffmanCoding(tokens1);
        //hc.showCodeTable();
        System.out.println(hc.getTrees().decode("1011110101011010011110"));
    }


    //ist ein leere Konten oder Blatt oder Wurzel
    public boolean isEmpty() {
        return content == null;
    }

    //ist ein Blatt was leere Konten besitzt
    public boolean isLeaf() {
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }

    //gibt den inhalt zurück
    public HuffmanTriple getContent() {
        if (!isEmpty()) {
            return content;
        } else {
            throw new IllegalArgumentException();
        }
    }

    // vergleicht den inhalt von nicht leeren Bäumen mit anderen nicht leeren Bäumen
    public int compareTo(HuffmanTree other) {
        if (!isEmpty() && !other.isEmpty()) {
            return content.compareto(other.content);
        } else {
            throw new IllegalArgumentException();
        }

    }

    //generiert die dazu gehörigen Codes der einzelnen Blätter
    public void generateCodes() {
        if (!isEmpty() && !isLeaf()) {
            leftChild.content.setCode(content.getCode() + "0");
            rightChild.content.setCode(content.getCode() + "1");
            leftChild.generateCodes();
            rightChild.generateCodes();
        }
    }

    // wandelt den Inhalt in Text um
    public void showCodes() {
        if (!isEmpty()) {
            if (isLeaf()) {
                System.out.println(content.toString());
            } else {
                leftChild.showCodes();
                rightChild.showCodes();
            }
        }
    }


    public String decode(String encoded) {

        HuffmanTree current = this;
        String word = "";


        for (int i = 0; i < encoded.length(); i++) {

            if (encoded.charAt(i) == '0' && !current.leftChild.isEmpty()) {
                current = current.leftChild;
                if (current.isLeaf()) {
                    word = word + current.getContent().getToken();
                    current = this;
                }
            } else if (encoded.charAt(i) == '1' && !current.rightChild.isEmpty() ) {
                current = current.rightChild;
                if (current.isLeaf()) {
                    word = word + current.getContent().getToken();
                    current = this;
                }
            }
        }
        return word;
    }

}
