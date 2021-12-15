package huffman;

public class HuffmanCoding {
    private HuffmanTree[] trees;


    //initialiesiert einen geordneten Baum und generiert die Codes die jedes Blatt besitzt
    public HuffmanCoding(HuffmanTriple[] input){
        if (input.length > 1){
            initializeTrees(input);
            buildTree();
            trees[trees.length-1].generateCodes();
        }
        else{
            throw new IllegalStateException();
        }
    }
    //initialisiert einen Baum
    public void initializeTrees(HuffmanTriple[] input){
        trees = new HuffmanTree[input.length];
        for (int i = 0; i < input.length; i++){
            trees[i] = new HuffmanTree(input[i]);
        }

    }
    //baut einen geordneten Huffmantree auf
    private void buildTree(){
        for (int i= 0; i+1 < trees.length; i++){
            insertionSort(i);
            trees[i+1] = new HuffmanTree(trees[i], trees[i+1] );
        }
    }
    //Sortiert den Baum indem es geordnete Konten alleine lässt und
    private void insertionSort(int start){
        for (int i = start+1; i < trees.length; i++){
            shiftTrees(i);
        }
    }

    private void shiftTrees(int start){
        if (start < trees.length){
            HuffmanTree toInsert = trees[start];
            int i = start;
            while (i > 0 && trees[i-1].compareTo(toInsert) > 0){
                trees[i] = trees[i-1];
                i--;
            }
            trees[i] = toInsert;
        }
    }
    public void showCodeTable(){
        trees[trees.length-1].showCodes();
    }

    public HuffmanTree getTrees() {
        return trees[trees.length-1];
    }
}

