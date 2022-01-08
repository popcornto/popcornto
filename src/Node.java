// Java code to Find maximum (or minimum) in
// Binary Tree

// A binary tree node
class Node {
    Student data;
    Node left, right;

    public Node(Student data)
    {
        this.data = data;
        left = right = null;
    }

    //Knoten ist leer
    public boolean isEmpty() {
        return this.data == null;
    }

    //ist ein Blatt
    public boolean isLeaf() {
        return !isEmpty() && left.isEmpty() && right.isEmpty();
    }
}

class BinaryTree {
    Node root;

    // Returns the max value in a binary tree
    static int findMax(Node node)
    {
        if (node == null)
            return Integer.MIN_VALUE;

        int res = node.data;
        int lres = findMax(node.left);
        int rres = findMax(node.right);

        if (lres > res)
            res = lres;
        if (rres > res)
            res = rres;
        return res;
    }

    /* Driver code */
    public static void main(String args[])
    {
        BinaryTree tree = new BinaryTree();
        tree.root = new Node(2);
        tree.root.left = new Node(7);
        tree.root.right = new Node(5);
        tree.root.left.right = new Node(6);
        tree.root.left.right.left = new Node(1);
        tree.root.left.right.right = new Node(11);
        tree.root.right.right = new Node(9);
        tree.root.right.right.left = new Node(4);

        // Function call
        System.out.println("Maximum element is " + tree.findMax(tree.root));
    }

}

// This code is contributed by Kamal Rawal