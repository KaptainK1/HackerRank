package LinkedList;

public class LinkedList {
    private Node head;

    public LinkedList(){
        //head = new Node();
    }

    public void insert(int data){
        if (head == null){
            this.head = new Node(data);
        } else {
            Node node = head;
            while(node != null){
                node = node.next;
            }
            Node addedNode = new Node(data);
            node.next = addedNode;
        }
    }

    public void print(){
        Node node = head;
        while(node != null){
            System.out.print(node.data);
            node = node.next;
        }
    }


}
