package week8;

public class ReverseLinkedList {

    class Node{
        int data;
        Node next;

        public Node(int ele){
            data=ele;
            next=null;
        }
    }

    public Node head;

    public ReverseLinkedList(){
        head=null;
    }

    public void insertAtHead(int value){
        // create a node
        Node newNode = new Node(value);
        // link it with the elements
        newNode.next=head;
        head=newNode;
    }

    public void printList(Node head){
        Node temp= head;
        while (temp!=null){
            System.out.println(temp.data);
            temp=temp.next;
        }
    }

    public Node reverseLL(Node node){
        Node temp= node;
        Node nxt=null;
        Node prev=null;
        while (temp!=null){
            nxt= temp.next; // 1 2 3 4 -> next-> 2 3 4
            temp.next=prev;
            prev=temp;
            temp=nxt;
        }
        return prev;
    }

    public static void main(String[] args) {

        ReverseLinkedList rrl = new ReverseLinkedList();
        rrl.insertAtHead(4);
        rrl.insertAtHead(3);
        rrl.insertAtHead(2);
        rrl.insertAtHead(1);
        rrl.printList(rrl.head);
        Node revNode = rrl.reverseLL(rrl.head);
        System.out.println("------------------");
        rrl.printList(revNode);

    }
}
