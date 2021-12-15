package mans;

public class Node {
    int data;
    Node next;

    Node(int data){
        this.data = data;
    }

    public static void main(String[] args) {
        Node head = new Node (4);
        Node nodeb = new Node( 5);
        Node nodec = new Node(9);
        Node noded = new Node(5);

        head.next = nodeb;
        nodeb.next= nodec;
        nodec.next= noded;
        System.out.println(Countnodes(head));
    }
   static int Countnodes(Node head){
        int count =0;
        while (head != null){
            count++;
            head= head.next;
        }
            return  count;
    }

}
