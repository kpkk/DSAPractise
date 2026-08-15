package week8;

public class FindMiddleNode {

    class Node{
        int data;
        Node next;

        public Node(int ele){
            data=ele;
            next=null;
        }
    }

    public Node head;

    public FindMiddleNode(){
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

    public Node findMiddleNode(Node node){
        Node temp= node;
        Node slow=node;
        Node fast=node;
        while (fast !=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }


    public static void main(String[] args) {
        FindMiddleNode rrl = new FindMiddleNode();
        rrl.insertAtHead(4);
        rrl.insertAtHead(3);
        rrl.insertAtHead(2);
        rrl.insertAtHead(1);
        rrl.printList(rrl.head);
        System.out.println("-----------------");
        Node middleNode = rrl.findMiddleNode(rrl.head);
        rrl.printList(middleNode);
    }
}
