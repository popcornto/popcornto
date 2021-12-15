package huffman;

public class HuffmanTree {
    private HuffmanTriple content;
    private HuffmanTree leftChild, rightChild;

    public static void main(String[] args) {
        HuffmanTriple[] tokens1 = {new HuffmanTriple( 'a', 30 ),
                        new HuffmanTriple( 'b', 20 ),
                        new HuffmanTriple( 'c', 10 ),
                        new HuffmanTriple( 'd', 15 ),
                        new HuffmanTriple( 'e', 80 )};
        HuffmanCoding hc = new HuffmanCoding(tokens1);
        hc.showCodeTable();
    }
    //leerer Baum
    public HuffmanTree(){
        content = null;
        leftChild = null;
        rightChild = null;
    }

    //Blatt
    public HuffmanTree(HuffmanTriple t){
        content = t;
        leftChild = new HuffmanTree();
        rightChild = new HuffmanTree();
    }

    public HuffmanTree(HuffmanTree lc, HuffmanTree rc){
        content = new HuffmanTriple(' ', lc.getContent().getQuantity() + rc.getContent().getQuantity());
        leftChild = lc;
        rightChild = rc;
    }
    public boolean isEmpty(){
        return content == null;
    }
    public boolean isLeaf(){
        return !isEmpty() && leftChild.isEmpty() && rightChild.isEmpty();
    }
    public HuffmanTriple getContent(){
        if (!isEmpty()){
            return content;
        }else {
            throw new IllegalArgumentException();
        }
    }
    public int compareTo(HuffmanTree other){
        if (!isEmpty() && !other.isEmpty()){
            return content.compareTo(other.content);
        }else {
            throw new IllegalArgumentException();
        }

    }
    public void generateCodes(){
        if(!isEmpty() && !isLeaf()){
            leftChild.content.setCode(content.getCode() + "0");
            rightChild.content.setCode(content.getCode() + "1");
            leftChild.generateCodes();
            rightChild.generateCodes();
        }
    }
    public void showCodes(){
        if (!isEmpty()){
            if (isLeaf()){
                System.out.println(content.toString());
            }
            else{
                leftChild.showCodes();
                rightChild.showCodes();
            }
        }
    }

}
